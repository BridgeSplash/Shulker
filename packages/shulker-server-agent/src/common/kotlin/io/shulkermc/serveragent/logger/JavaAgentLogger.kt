package io.shulkermc.serveragent.logger

import java.util.logging.Level
import java.util.logging.Logger

class JavaAgentLogger(private val logger: Logger) : AgentLoggerInterface {
    override fun info(message: String) {
        logger.info(message)
    }

    override fun warning(message: String) {
        logger.warning(message)
    }

    override fun severe(message: String) {
        logger.severe(message)
    }

    override fun severe(message: String, exception: Throwable) {
        logger.log(Level.SEVERE, message, exception)
    }

    override fun debug(message: String) {
        logger.fine(message)
    }
}
