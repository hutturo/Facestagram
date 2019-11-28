package com.kcci.facestagram.repositories

import com.kcci.facestagram.entities.Post
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.time.LocalDateTime
import kotlin.random.Random

internal class PostRepositoryTest {

    @Test
    fun getByPK() {
    }

    @Test
    fun deleteByPK() {
    }

    @Test
    fun delete() {
    }

    @Test
    fun count() {
    }

    @Test
    fun getAll() {
        assertTrue(Repository.post.getAll().count() > 0)
    }

    @Test
    fun insert() {
        for (i in 0 until 100) {
            val post = Post()
            post.userId = Random.nextInt(0, 100) + 1
            post.content = "Some super cool contents"
            val randomStartDays = Random.nextLong(0, 365) + 1
            val randomEndDays = Random.nextLong(0, 365) + 1
            post.planStartDatetime = LocalDateTime.now().minusDays(randomStartDays)
            post.planEndDatetime = LocalDateTime.now().plusDays(randomEndDays)
            post.placeId = Random.nextInt(0, 36) + 1
            post.accessibleLevelId = Random.nextInt(0, 3) + 1
            Repository.post.insert(post)
        }
    }

    @Test
    fun update() {
    }

    @Test
    fun getLast() {
    }

}