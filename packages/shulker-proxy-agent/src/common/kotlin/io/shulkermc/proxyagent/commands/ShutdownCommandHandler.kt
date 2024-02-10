package io.shulkermc.proxyagent.commands

import io.shulkermc.proxyagent.ShulkerProxyAgentCommon
import net.kyori.adventure.audience.Audience
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor

object ShutdownCommandHandler {
    const val NAME = "gshutdown"
    const val PERMISSION = "shulker.command.gshutdown"

    fun executeServerShutdownSchedule(agent: ShulkerProxyAgentCommon, audience: Audience, proxyName: String? = null) {
        if (proxyName == null) {
            agent.shutdown()
        }

        agent.cache.listRegisteredProxies()
            .filter { it.proxyName == proxyName }
            .forEach { agent.cache.unregisterProxy(it.proxyName) }

        audience.sendMessage(Component.text("Server $proxyName has been shutdown", NamedTextColor.RED))
    }
}
