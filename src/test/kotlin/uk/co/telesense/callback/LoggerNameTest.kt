package uk.co.telesense.callback

import org.junit.Test
import uk.co.telesense.logging.loggerName

class LoggerNameTest {

    @Test
    fun loggerName() {
        assert(loggerName("uk.co.telesense.management.Loggable\$Companion") == "Loggable")
        assert(loggerName("uk.co.telesense.common.DebugReporter") == "DebugReporter")
        assert(loggerName("Foo") == "Foo")
        assert(loggerName(".Foo") == "Foo")
        assert(loggerName("Companion") == "Companion")
        var name = "\$Companion"
        assert(loggerName(name) == "Companion")
    }
}