package com.ksundaysky.postsapp

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface PostRepository : JpaRepository<Post, Long>