package ru.spfort.minecraft

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.bukkit.plugin.java.JavaPlugin
import ru.spfort.web.configureRouting
import ru.spfort.web.configureTemplating

class Detektor : JavaPlugin() {


    override fun onEnable() {
        embeddedServer(Netty, port = 3280, host = "0.0.0.0", module = Application::module)
            .start(wait = true)
    }
}

fun Application.module() {
    configureRouting()
    configureTemplating()
}
