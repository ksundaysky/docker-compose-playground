package com.ksundaysky.usersapp

import jakarta.persistence.*
import lombok.NoArgsConstructor

@Table(name = "UserTable")
@Entity
@NoArgsConstructor
data class User(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,
    val username: String,
    val amountOfPosts: Long
)




