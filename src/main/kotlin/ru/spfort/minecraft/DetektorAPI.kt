package ru.spfort.minecraft

import net.kyori.adventure.text.minimessage.MiniMessage
import java.util.*

object DetektorAPI {
    fun getClickableLink(messageText: String, hostname: String, playerUUID: UUID) =
        MiniMessage.miniMessage().deserialize("<open_url:$hostname/$playerUUID>")
}