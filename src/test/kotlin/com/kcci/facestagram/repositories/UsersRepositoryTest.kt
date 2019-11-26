package com.kcci.facestagram.repositories

import com.kcci.facestagram.entities.Users
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

internal class UsersRepositoryTest {
    @Test
    fun count() {
        assertTrue(Repository.users.count() > 0)
    }

    @Test
    fun getAll() {
        assertTrue(Repository.users.getAll().size > 0)
    }

    @Test
    fun insert() {
        val oldCount = Repository.users.count()
        val testUser = Users()
        val time = LocalDateTime.now().format(DateTimeFormatter
                .ofPattern("MM-dd_HH:mm:ss"))
        testUser.name = "테스트$time"
        testUser.email = "테스트$time@gmail.com"
        testUser.password = "1234"

        Repository.users.insert(testUser)
        assertEquals(oldCount+1, Repository.users.count())
    }

    @Test
    fun update() {
        val testUserId = 1
        val time = LocalDateTime.now().format(DateTimeFormatter
                .ofPattern("HH:mm:ss"))
        val user = Repository.users.getByPK(testUserId)!!
        val updatedName = user.name + time
        user.name = updatedName
        Repository.users.update(user)

        val updatedUser = Repository.users.getByPK(testUserId)!!
        assertEquals(updatedUser.name, updatedName)
    }

    @Test
    fun delete() {
        val lastUser = Repository.users.getLast()!!
        val oldCount = Repository.users.count()
        Repository.users.delete(lastUser)

        assertEquals(oldCount-1, Repository.users.count())
    }

    @Test
    fun getLast() {
        val allUsers = Repository.users.getAll()
        val lastUser = Repository.users.getLast()!!
        assertEquals(allUsers[allUsers.size-1].usersId, lastUser.usersId)
    }

    @Test
    fun find() {
        assertEquals(Repository.users.find("지아").size, 1)
    }

    @Test
    fun getByPK() {
        val user1 = Repository.users.getByPK(70)
        assertEquals(user1?.name, "이하린")
        assertEquals(user1?.email, "dlgkfls@naver.com")
        assertEquals(user1?.password, "1234")
    }

}