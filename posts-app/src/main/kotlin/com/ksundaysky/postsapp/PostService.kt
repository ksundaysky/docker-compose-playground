package com.ksundaysky.postsapp

import org.springframework.http.*
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.exchange
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.jvm.optionals.getOrElse

@Service
class PostService(val db: PostRepository) {

    fun findPosts(): List<Post> = db.findAll().toList()
    fun findPostById(id: Long): Optional<Post> = db.findById(id)
    fun deletePostById(id: Long) {
        val optionalPost = db.findById(id)
        if (optionalPost.isPresent) db.deleteById(id) else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    fun save(post: Post): Post {
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        val current = LocalDateTime.now().format(formatter)
        val post = db.save(post.copy(postedAt = current.toString()))

//        val user  = webClient.get().uri("/addPostToUser/${post.authorId}").header("Content-Type",MediaType.TEXT_PLAIN_VALUE).retrieve().bodyToMono(User::class.java).block()
        val restTemplate = RestTemplate()

        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        val request = HttpEntity<String>("", headers);
        val response: ResponseEntity<String> = restTemplate.exchange(
            "http://localhost:8080/users/addPostToUser/${post.authorId}".replace("localhost", "host.docker.internal", true),
            HttpMethod.GET,
            request,
            String::class
        )
        print(response.body)
        return post
    }

    @OptIn(ExperimentalStdlibApi::class)
    fun update(id: Long, text: String): Post {
        val optionalPost = db.findById(id)
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        val current = LocalDateTime.now().format(formatter)
        val post = optionalPost.getOrElse { throw ResponseStatusException(HttpStatus.NOT_FOUND) }
        return db.save(
            post.copy(
                text = text,
                postedAt = current.toString()
            )
        )
    }

}