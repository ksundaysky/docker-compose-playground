package com.ksundaysky.usersapp

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.core.JdbcTemplate
import javax.sql.DataSource


@SpringBootApplication()
@EnableJpaRepositories
class UsersApplication

fun main(args: Array<String>) {
	runApplication<UsersApplication>(*args)
}
