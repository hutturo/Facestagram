package com.kcci.facestagram

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FacestagramApplication : CommandLineRunner {
    override fun run(vararg args: String?) {
        println("Hello world!")
    }
}

fun main(args: Array<String>) {
    runApplication<FacestagramApplication>(*args)
}
