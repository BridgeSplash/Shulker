package io.shulkermc.serveragent.minestom

import io.shulkermc.serveragent.ShulkerServerAgentCommon
import io.shulkermc.serveragent.minestom.logger.SLF4JAgentLogger
import net.minestom.server.extensions.Extension
import org.slf4j.LoggerFactory

class ShulkerServerAgentMinestom: Extension() {

    companion object{
        private val logger = LoggerFactory.getLogger(ShulkerServerAgentMinestom::class.java)
    }
    private val agent = ShulkerServerAgentCommon(ServerInterfaceMinestom(this), SLF4JAgentLogger(ShulkerServerAgentMinestom.logger))

    override fun initialize() {
        agent.onServerInitialization()
    }

    override fun terminate() {
        agent.onServerShutdown()
    }
}
