package com.ksundaysky.postsapp

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication
//@EnableAutoConfiguration(exclude = [ WebMvcAutoConfiguration::class ])
class PostsAppApplication

fun main(args: Array<String>) {
	runApplication<PostsAppApplication>(*args)
}
