package io.shulkermc.serveragent.logger

interface AgentLoggerInterface {

    fun info(message: String)

    fun warning(message: String)

    fun severe(message: String)

    fun severe(message: String, exception: Throwable)

    fun debug(message: String)



}
