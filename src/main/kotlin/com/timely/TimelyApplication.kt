package com.timely

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TimelyApplication

fun main(args: Array<String>) {
    runApplication<TimelyApplication>(*args)
}
