package com.kcci.facestagram

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FacestagramApplication : CommandLineRunner {
    override fun run(vararg args: String?) {
        println("Hello world!")
        //println("유저 카운트" + Repository.user.count())
    }
}

fun main(args: Array<String>) {
    runApplication<FacestagramApplication>(*args)
}
