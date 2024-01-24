package io.shulkermc.serveragent.minestom

import io.shulkermc.serveragent.ServerInterface
import io.shulkermc.serveragent.minestom.scheduler.MinestomTask
import io.shulkermc.serveragent.platform.HookPostOrder
import io.shulkermc.serveragent.platform.PlayerDisconnectHook
import io.shulkermc.serveragent.platform.PlayerLoginHook
import net.minestom.server.MinecraftServer
import net.minestom.server.event.Event
import net.minestom.server.event.EventNode
import net.minestom.server.event.player.PlayerDisconnectEvent
import net.minestom.server.event.player.PlayerSpawnEvent
import net.minestom.server.permission.Permission
import net.minestom.server.timer.TaskSchedule
import java.time.Duration
import java.util.UUID
import java.util.concurrent.TimeUnit

class ServerInterfaceMinestom(private val plugin: ShulkerServerAgentMinestom): ServerInterface {

    private val eventNode: EventNode<Event> = EventNode.all("shulker-server-agent-minestom")


    override fun prepareNetworkAdminsPermissions(playerIds: List<UUID>) {
        eventNode.addListener(PlayerSpawnEvent::class.java) { event ->
            if (event.player.uuid in playerIds) {
                event.player.permissionLevel = 4
                event.player.addPermission(Permission("*"));
            }
        }
    }

    override fun addPlayerJoinHook(hook: PlayerLoginHook, postOrder: HookPostOrder) {
        eventNode.addListener(PlayerSpawnEvent::class.java) { _ ->
            hook()
        }
    }

    override fun addPlayerQuitHook(hook: PlayerDisconnectHook, postOrder: HookPostOrder) {
        eventNode.addListener(PlayerDisconnectEvent::class.java) { _ ->
            hook()
        }
    }

    override fun getPlayerCount(): Int {
        return MinecraftServer.getConnectionManager().onlinePlayers.size
    }

    override fun scheduleDelayedTask(
        delay: Long,
        timeUnit: TimeUnit,
        runnable: Runnable
    ): ServerInterface.ScheduledTask {
        val duration = Duration.ofNanos(timeUnit.toNanos(delay))
        val task = MinecraftServer.getSchedulerManager().scheduleTask(runnable,
            TaskSchedule.duration(duration),
            TaskSchedule.stop()
        )
        return MinestomTask(task)
    }

    override fun scheduleRepeatingTask(
        delay: Long,
        interval: Long,
        timeUnit: TimeUnit,
        runnable: Runnable
    ): ServerInterface.ScheduledTask {
        val delayDuration = Duration.ofNanos(timeUnit.toNanos(delay))
        val intervalDuration = Duration.ofNanos(timeUnit.toNanos(interval))
        val task = MinecraftServer.getSchedulerManager().scheduleTask(runnable,
            TaskSchedule.duration(delayDuration),
            TaskSchedule.duration(intervalDuration)
        )
        return MinestomTask(task)
    }
}
