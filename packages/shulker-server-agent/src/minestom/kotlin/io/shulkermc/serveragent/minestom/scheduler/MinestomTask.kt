package io.shulkermc.serveragent.minestom.scheduler

import io.shulkermc.serveragent.ServerInterface
import net.minestom.server.timer.Task

class MinestomTask(private val task: Task) : ServerInterface.ScheduledTask {

    override fun cancel() {
        task.cancel()
    }
}
