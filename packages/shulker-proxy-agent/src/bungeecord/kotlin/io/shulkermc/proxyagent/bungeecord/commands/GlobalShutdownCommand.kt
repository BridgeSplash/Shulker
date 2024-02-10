package io.shulkermc.proxyagent.bungeecord.commands

import io.shulkermc.proxyagent.ShulkerProxyAgentCommon
import io.shulkermc.proxyagent.commands.ShutdownCommandHandler
import net.kyori.adventure.platform.bungeecord.BungeeAudiences
import net.md_5.bungee.api.CommandSender
import net.md_5.bungee.api.plugin.Command

class GlobalShutdownCommand(
    private val agent: ShulkerProxyAgentCommon,
    private val adventure: BungeeAudiences
) : Command(ShutdownCommandHandler.NAME, ShutdownCommandHandler.PERMISSION) {
    override fun execute(sender: CommandSender, args: Array<out String>) {
        val audience = this.adventure.sender(sender)
        if (!BungeeCordCommandHelper.testPermissionOrMessage(sender, audience, this.permission)) {
            return
        }

        if (args.isEmpty()) {
            ShutdownCommandHandler.executeServerShutdownSchedule(this.agent, audience)
            return
        }

        val proxyName = args[0]
        ShutdownCommandHandler.executeServerShutdownSchedule(this.agent, audience, proxyName)
    }
}
