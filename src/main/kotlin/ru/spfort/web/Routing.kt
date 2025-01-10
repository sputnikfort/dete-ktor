package ru.spfort.web

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.thymeleaf.*
import org.bukkit.Bukkit
import ru.spfort.minecraft.PlayerSystemDetectedEvent
import java.util.*

fun Application.configureRouting() {
    routing {
        get("/{uuid}") {
            val uuid = UUID.fromString(call.parameters["uuid"]) ?: return@get call.respond(HttpStatusCode.BadRequest)
            val player = Bukkit.getPlayer(uuid) ?: return@get call.respond(HttpStatusCode.BadRequest)
            PlayerSystemDetectedEvent(
                player,
                call.request.headers["User-Agent"] ?: ""
            ).callEvent()
            call.respond(ThymeleafContent("index", mapOf()))
        }
    }
}
