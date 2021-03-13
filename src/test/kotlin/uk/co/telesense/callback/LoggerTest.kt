package uk.co.telesense.callback

import org.junit.Test
import org.slf4j.LoggerFactory
import uk.co.telesense.logging.logger

class LoggerTest {

    private val log by logger()

    @Test
    fun slf4jLogging() {
        val log = LoggerFactory.getLogger(LoggerTest::class.java)
        log.debug("LoggerFactory logger is working")
    }

    @Test
    fun loggerTest() {
        log.debug("logger() is working")
    }
}