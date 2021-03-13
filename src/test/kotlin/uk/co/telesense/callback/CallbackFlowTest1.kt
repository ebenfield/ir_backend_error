package uk.co.telesense.callback

import junit.framework.Assert.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

object CallbackBasedReceiver : CallbackBasedApi<Boolean> {
    var callback: Callback<Boolean>? = null

    fun onReceive(value: Boolean) {
        callback?.onNextValue(value)?:throw Error("Receiver not registered")
    }

    override fun register(callback: Callback<Boolean>) {
        this.callback = callback
    }

    override fun unregister(callback: Callback<Boolean>) {
        this.callback = null
    }
}

@ExperimentalCoroutinesApi
class CallbackFlowTest1 {

    @Test
    fun foo() {
        val callbackFlow: Flow<Boolean> = flowFrom(CallbackBasedReceiver)
        runBlockingTest {
        val callbacks: MutableList<Boolean> = mutableListOf()
            val job = launch {
                callbackFlow.collect {
                    callbacks.add(it)
                }
            }
            assertTrue(callbacks.isEmpty())
            CallbackBasedReceiver.onReceive(true)
            assertTrue(callbacks == listOf(true))
            CallbackBasedReceiver.onReceive(false)
            assertTrue(callbacks == listOf(true, false))
            job.cancel()
        }
    }
}