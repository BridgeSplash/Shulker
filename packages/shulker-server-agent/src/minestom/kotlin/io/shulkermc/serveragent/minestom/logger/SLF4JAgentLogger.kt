package io.shulkermc.serveragent.minestom.logger

import io.shulkermc.serveragent.logger.AgentLoggerInterface
import org.slf4j.Logger

class SLF4JAgentLogger(private val logger: Logger): AgentLoggerInterface {


    override fun info(message: String) {
        logger.info(message)
    }

    override fun warning(message: String) {
        logger.warn(message)
    }

    override fun severe(message: String) {
        logger.error(message)
    }

    override fun severe(message: String, exception: Throwable) {
        logger.error(message, exception)
    }

    override fun debug(message: String) {
        logger.debug(message)
    }
}
