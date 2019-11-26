package com.kcci.facestagram.repositories

import com.kcci.facestagram.entities.Users
import java.sql.PreparedStatement
import java.sql.ResultSet

class UserRepository : SingleKeyEntityRepository<Users, Int>() {

    override val entityName get() = "Users"
    override val keyNames get() = "UsersId"

    override fun readEntity(result: ResultSet): Users {
        val entity = Users()
        entity.usersId = result.getInt(1)
        entity.email = result.getString(2)
        entity.password = result.getString(3)
        entity.name = result.getString(4)
        entity.profileImage = result.getString(5)

        return entity
    }

    fun find(UsersId: Int): MutableList<Users> {
        val statement = createStatement("select UsersId, Email, Password, Name, ProfileImage from Users where UsersId like ?")
        statement.setInt(1, UsersId)

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
        val statement = createStatement("insert into Users values(?, ?, ?)")

        statement.setString(1, entity.email)
        statement.setString(2, entity.password)
        statement.setString(3, entity.name)
        statement.setString(4, entity.profileImage)

        return statement
    }

    override fun updateCore(entity: Users): PreparedStatement {
        val statement = createStatement("update Users set Email = ?, Password = ?, Name = ?, ProfileImage = ? where UsersId = ?")

        statement.setString(1, entity.email)
        statement.setString(2, entity.password)
        statement.setString(3, entity.name)
        statement.setString(4, entity.profileImage)
        statement.setInt(5, entity.usersId)

        return statement
    }
}