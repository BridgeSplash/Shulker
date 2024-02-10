package io.shulkermc.proxyagent.velocity.commands

import com.mojang.brigadier.Command
import com.mojang.brigadier.arguments.StringArgumentType
import com.mojang.brigadier.builder.LiteralArgumentBuilder
import com.mojang.brigadier.builder.RequiredArgumentBuilder
import com.velocitypowered.api.command.BrigadierCommand
import com.velocitypowered.api.command.CommandSource
import io.shulkermc.proxyagent.ShulkerProxyAgentCommon
import io.shulkermc.proxyagent.commands.ShutdownCommandHandler
import io.shulkermc.proxyagent.velocity.ShulkerProxyAgentVelocity

object GlobalShutdownCommand {

    fun register(plugin: ShulkerProxyAgentVelocity) {
        plugin.proxy.commandManager.register(
            plugin.proxy.commandManager.metaBuilder(ShutdownCommandHandler.NAME).plugin(plugin).build(),
            createCommand(plugin.agent)
        )
    }

    private fun createCommand(agent: ShulkerProxyAgentCommon): BrigadierCommand {
        val rootNode = LiteralArgumentBuilder.literal<CommandSource>(ShutdownCommandHandler.NAME)
            .requires { it.hasPermission(ShutdownCommandHandler.PERMISSION) }
            .executes { context ->
                val source = context.source
                ShutdownCommandHandler.executeServerShutdownSchedule(agent, source)
                return@executes Command.SINGLE_SUCCESS
            }
            .then(
                RequiredArgumentBuilder.argument<CommandSource, String>("proxy_name", StringArgumentType.word())
                    .executes { context ->
                        val source = context.source
                        val proxyName = context.getArgument("proxy_name", String::class.java)
                        ShutdownCommandHandler.executeServerShutdownSchedule(agent, source, proxyName)
                        return@executes Command.SINGLE_SUCCESS
                    }
            )
            .build()

        return BrigadierCommand(rootNode)
    }
}
