package com.ksundaysky.postsapp

import jakarta.persistence.*
import lombok.NoArgsConstructor

@Table(name = "PostTable")
@Entity
@NoArgsConstructor
data class Post(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,
    val authorId: Long,
    val text: String,
    val postedAt: String?
)




