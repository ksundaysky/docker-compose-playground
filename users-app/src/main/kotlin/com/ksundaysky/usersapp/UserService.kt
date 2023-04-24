package com.ksundaysky.usersapp

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*
import kotlin.jvm.optionals.getOrElse

@Service
class UserService(val db: UserRepository) {


    fun findUsers(): List<User> = db.findAll().toList()
    fun findUserById(id: Long): Optional<User> = db.findById(id)
    fun deleteUserById(id: Long){
        val optionalUser = db.findById(id)
        if(optionalUser.isPresent) db.deleteById(id) else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    fun save(user: User) : User{
       return db.save(user)
    }

    @OptIn(ExperimentalStdlibApi::class)
    fun update(id: Long, username: String) :User{
        val optionalUser = db.findById(id)
        val user =  optionalUser.getOrElse { throw ResponseStatusException(HttpStatus.NOT_FOUND)}
        return db.save(user.copy(
            username = username
        ))
    }

    @OptIn(ExperimentalStdlibApi::class)
    fun updatePostsNumber(id: Long): User {
        val optionalUser = db.findById(id)
        val user =  optionalUser.getOrElse { throw ResponseStatusException(HttpStatus.NOT_FOUND)}
        return db.save(user.copy(
            amountOfPosts = user.amountOfPosts+1
        ))
    }
}