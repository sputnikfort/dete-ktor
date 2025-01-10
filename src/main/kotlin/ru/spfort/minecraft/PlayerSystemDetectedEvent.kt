package ru.spfort.minecraft

import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class PlayerSystemDetectedEvent(
    val player: Player,
    val system: String,
): Event() {
    companion object{
        private val handlerList = HandlerList()
        
        @JvmStatic
        fun getHandlerList() = handlerList
    }
    override fun getHandlers(): HandlerList = handlerList
}