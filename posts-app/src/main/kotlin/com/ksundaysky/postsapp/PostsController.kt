package com.ksundaysky.postsapp

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
class PostsController(val postService: PostService) {
    @GetMapping("/greeting")
    fun greetings() = "Hello, k8s!"

    @PostMapping("/posts")
    fun createUser(@RequestBody post: Post): Post {
        return postService.save(post)
    }

    @GetMapping("/users/{id}")
    fun getUserById(@PathVariable(value = "id") id: Long): Post {
        return postService.findPostById(id).orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }
    }

    @DeleteMapping("/users/{id}")
    fun deleteUserById(@PathVariable(value = "id") id: Long) {
        postService.deletePostById(id)
    }

    @PutMapping("/users/{id}")
    fun updateUsernameById(@PathVariable(value = "id") id: Long, @RequestBody updatePost: UpdatePost): Post {
        return postService.update(id, updatePost.text)
    }

    @GetMapping("/users")
    fun getUsers() {
        postService.findPosts()
    }

    class UpdatePost(
        val text: String
    )
}