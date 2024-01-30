package io.shulkermc.serveragent.paper

import io.shulkermc.serveragent.ShulkerServerAgentCommon
import io.shulkermc.serveragent.logger.JavaAgentLogger
import org.bukkit.plugin.java.JavaPlugin

@Suppress("unused")
class ShulkerServerAgentPaper : JavaPlugin() {
    private val agent = ShulkerServerAgentCommon(ServerInterfacePaper(this), JavaAgentLogger(this.logger))

    override fun onEnable() {
        this.agent.onServerInitialization()
    }

    override fun onDisable() {
        this.agent.onServerShutdown()
    }
}
