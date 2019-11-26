package com.kcci.facestagram.repositories

import com.kcci.facestagram.entities.Users
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.time.LocalDateTime

class UsersRepository : SingleKeyEntityRepository<Users, Int>() {
    override val entityName get() = "Users"
    override val keyNames get() = "UsersId"

    override fun readEntity(result: ResultSet): Users {
        val user = Users()
        user.usersId = result.getInt(1)
        user.email = result.getString(2)
        user.password = result.getString(3)
        user.name = result.getString(4)
        user.profileImage = result.getBytes(5)

        return user
    }

    fun find(name: String): MutableList<Users> {
        val statement = createStatement(
                "select * from $entityName where Name like ?")
        statement.setString(1, "%$name%")

        val result = statement.executeQuery()

        val users = mutableListOf<Users>()
        while (result.next()) {
            val user = readEntity(result)

            users.add(user)
        }

        close(statement)

        return users
    }

    override fun insertCore(entity: Users): PreparedStatement {
        val statement = createStatement("insert into $entityName values(?, ?, ?, ?)")

        statement.setString(1, entity.email)
        statement.setString(2, entity.password)
        statement.setString(3, entity.name)
        statement.setBytes(4, entity.profileImage)

        return statement
    }

    override fun updateCore(entity: Users): PreparedStatement {
        val statement = createStatement(
                "update $entityName set Email = ?, password = ?," +
                        " name = ?, profileImage = ? where $keyNames = ?")

        statement.setString(1, entity.email)
        statement.setString(2, entity.password)
        statement.setString(3, entity.name)
        statement.setBytes(4, entity.profileImage)
        statement.setInt(5, entity.usersId)

        return statement
    }
}