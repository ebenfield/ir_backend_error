package uk.co.telesense.callback

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.sendBlocking
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

interface CallbackBasedApi<T> {
    fun register(callback: Callback<T>)
    fun unregister(callback: Callback<T>)
}

interface Callback<T> {
    fun onNextValue(value: T)
    fun onApiError(cause: Throwable)
    fun onCompleted(): Boolean
}

@ExperimentalCoroutinesApi
fun <T> flowFrom(api: CallbackBasedApi<T>): Flow<T> = callbackFlow {
    val callback = object : Callback<T> { // Implementation of some callback
        // interface
        override fun onNextValue(value: T) {
            // To avoid blocking you can configure channel capacity using
            // either buffer(Channel.CONFLATED) or buffer(Channel.UNLIMITED) to avoid overfill
            try {
                sendBlocking(value)
            } catch (e: Exception) {
                // Handle exception from the channel: failure in flow or premature closing
            }
        }
        override fun onApiError(cause: Throwable) {
            cancel(CancellationException("API Error", cause))
        }
        override fun onCompleted() = channel.close()
    }
    api.register(callback)

    /*
     * Suspends until either 'onCompleted'/'onApiError' from the callback is invoked
     * or flow collector is cancelled (e.g. by 'take(1)' or because a collector's coroutine was cancelled).
     * In both cases, callback will be properly unregistered.
     */
    awaitClose { api.unregister(callback) }
}

