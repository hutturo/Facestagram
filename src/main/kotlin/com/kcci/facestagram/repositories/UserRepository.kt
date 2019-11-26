package com.kcci.facestagram.repositories

import com.kcci.facestagram.entities.User
import java.sql.PreparedStatement
import java.sql.ResultSet

class UserRepository : SingleKeyEntityRepository<User, Int>() {
    override val entityName get() = "User"
    override val keyNames get() = "UserId"

    override fun readEntity(result: ResultSet): User {
        val user = User()
        user.userId = result.getInt(1)
        user.email = result.getString(2)
        user.password = result.getString(3)
        user.name = result.getString(4)
        user.profileImage = result.getBytes(5)

        return user
    }

    fun find(name: String): MutableList<User> {
        val statement = createStatement(
                "select * from [$entityName] where Name like ?")
        statement.setString(1, "%$name%")

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
        val statement = createStatement("insert into [$entityName] values(?, ?, ?, ?)")

        statement.setString(1, entity.email)
        statement.setString(2, entity.password)
        statement.setString(3, entity.name)
        statement.setBytes(4, entity.profileImage)

        return statement
    }

    override fun updateCore(entity: User): PreparedStatement {
        val statement = createStatement(
                "update [$entityName] set Email = ?, password = ?," +
                        " name = ?, profileImage = ? where $keyNames = ?")

        statement.setString(1, entity.email)
        statement.setString(2, entity.password)
        statement.setString(3, entity.name)
        statement.setBytes(4, entity.profileImage)
        statement.setInt(5, entity.userId)

        return statement
    }
}