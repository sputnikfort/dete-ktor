package ru.spfort.minecraft

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import net.kyori.adventure.text.minimessage.MiniMessage
import ru.spfort.web.configureRouting
import ru.spfort.web.configureTemplating
import java.util.*

object Detektor {
    fun getClickableLink(messageText: String, hostname: String, playerUUID: UUID) =
        MiniMessage.miniMessage().deserialize("<open_url:$hostname/$playerUUID>")

    fun start(port: Int = 8080, host: String = "0.0.0.0") {
        embeddedServer(Netty, port = port, host = host, module = Application::module)
            .start(wait = true)
    }
}

fun Application.module() {
    configureRouting()
    configureTemplating()
}