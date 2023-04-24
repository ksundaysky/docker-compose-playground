package com.ksundaysky.usersapp

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
class UsersController(val userService: UserService) {
    @GetMapping("/greeting")
    fun greetings() = "Hello, k8s!"

    @PostMapping("/users")
    fun createUser(@RequestBody user: User): User {
        return userService.save(user)
    }

    @GetMapping("/users/{id}")
    fun getUserById(@PathVariable(value = "id") id: Long): User {
        return userService.findUserById(id).orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }
    }

    @DeleteMapping("/users/{id}")
    fun deleteUserById(@PathVariable(value = "id") id: Long) {
        userService.deleteUserById(id)
    }

    @PutMapping("/users/{id}")
    fun updateUsernameById(@PathVariable(value = "id") id: Long, @RequestBody updateUser: UpdateUser): User {
        return userService.update(id, updateUser.username)
    }

    @GetMapping("/users/addPostToUser/{id}", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun addPostToUserById(@PathVariable(value = "id") id: Long): User {
        return userService.updatePostsNumber(id)
    }

    @GetMapping("/users")
    fun getUsers() {
        userService.findUsers()
    }

    class UpdateUser(
        val username: String
    )


}