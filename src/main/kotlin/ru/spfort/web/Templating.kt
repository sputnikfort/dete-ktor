package ru.spfort.web

import io.ktor.server.application.*
import io.ktor.server.thymeleaf.*
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver

fun Application.configureTemplating() {
    install(Thymeleaf) {
        setTemplateResolver(ClassLoaderTemplateResolver().apply {
            prefix = "/static/"
            suffix = ".html"
            characterEncoding = "utf-8"

        })
    }
}