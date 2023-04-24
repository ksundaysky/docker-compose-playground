//package com.ksundaysky.postsapp
//
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.http.HttpHeaders
//import org.springframework.http.MediaType
//import org.springframework.web.reactive.config.EnableWebFlux
//import org.springframework.web.reactive.config.WebFluxConfigurer
//import org.springframework.web.reactive.function.client.WebClient
//
//@Configuration
//@EnableWebFlux
//class WebFluxConfig : WebFluxConfigurer {
//    @Bean
//    fun getWebClient(): WebClient {
//        return WebClient.builder().baseUrl("http://localhost:8080/users")
//            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build()
//    }
//}