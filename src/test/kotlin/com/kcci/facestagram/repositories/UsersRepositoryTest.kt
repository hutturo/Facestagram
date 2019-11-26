package com.kcci.facestagram.repositories

import com.kcci.facestagram.entities.User
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

internal class UsersRepositoryTest {
    @Test
    fun count() {
        assertTrue(Repository.user.count() > 0)
    }

    @Test
    fun getAll() {
        assertTrue(Repository.user.getAll().size > 0)
    }

    @Test
    fun insert() {
        val oldCount = Repository.user.count()
        val testUser = User()
        val time = LocalDateTime.now().format(DateTimeFormatter
                .ofPattern("MM-dd_HH:mm:ss"))
        testUser.name = "테스트$time"
        testUser.email = "테스트$time@gmail.com"
        testUser.password = "1234"

        Repository.user.insert(testUser)
        assertEquals(oldCount+1, Repository.user.count())
    }

    @Test
    fun update() {
        val testUserId = 1
        val time = LocalDateTime.now().format(DateTimeFormatter
                .ofPattern("HH:mm:ss"))
        val user = Repository.user.getByPK(testUserId)!!
        val updatedName = user.name + time
        user.name = updatedName
        Repository.user.update(user)

        val updatedUser = Repository.user.getByPK(testUserId)!!
        assertEquals(updatedUser.name, updatedName)
    }

    @Test
    fun delete() {
        val lastUser = Repository.user.getLast()!!
        val oldCount = Repository.user.count()
        Repository.user.delete(lastUser)

        assertEquals(oldCount-1, Repository.user.count())
    }

    @Test
    fun getLast() {
        val allUsers = Repository.user.getAll()
        val lastUser = Repository.user.getLast()!!
        assertEquals(allUsers[allUsers.size-1].userId, lastUser.userId)
    }

    @Test
    fun find() {
        assertEquals(Repository.user.find("지아").size, 1)
    }

    @Test
    fun getByPK() {
        val user1 = Repository.user.getByPK(70)
        assertEquals(user1?.name, "이하린")
        assertEquals(user1?.email, "dlgkfls@naver.com")
        assertEquals(user1?.password, "1234")
    }

}