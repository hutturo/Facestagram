package com.kcci.facestagram.repositories

import com.kcci.facestagram.entities.User
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.time.LocalDateTime

class UserRepository : SingleKeyEntityRepository<User, Int>() {
    override val entityName get() = "User"
    override val keyNames get() = "UserId"

    override fun readEntity(result: ResultSet): User {
        val user = User()
        user.userId = result.getInt(1)
        user.name = result.getString(2)
        user.email = result.getString(3)
        user.profileImage = result.getString(4)

        return user

    }

    fun find(UserId: Int): MutableList<User> {
        val statement = createStatement("select UserId, Name, Email, ProfileImage from [User] where UserId like ?")
        statement.setInt(1, UserId)

        val result = statement.executeQuery()

        val users = mutableListOf<User>()
        while (result.next()) {
            val user = readEntity(result)

            users.add(user)
        }

        close(statement)

        return users
    }

    override fun insertCore(entity: User): PreparedStatement {
        val statement = createStatement("insert into [User] values(?, ?, ?)")

        statement.setString(1, entity.name)
        statement.setString(2, entity.email)
        statement.setString(3, entity.profileImage)

        return statement
    }

    override fun updateCore(entity: User): PreparedStatement {
        val statement = createStatement("update [User] set Name = ?, Email = ?, ProfileImage = ? where UserId = ?")

        statement.setString(1, entity.name)
        statement.setString(2, entity.email)
        statement.setString(3, entity.profileImage)
        statement.setInt(4, entity.userId)

        return statement
    }
}