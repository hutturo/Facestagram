package com.kcci.facestagram.repositories

import com.kcci.facestagram.entities.Friend
import com.kcci.facestagram.exceptions.UnupdatableException
import java.sql.PreparedStatement
import java.sql.ResultSet

class FriendRepository : DoubleKeyEntityRepository<Friend, Int, Int>() {
    override val entityName: String
        get() = "Friend"
    override val keyNames: String
        get() = "UsersId, FriendId"

    override fun readEntity(result: ResultSet): Friend {
        val entity = Friend()
        entity.usersId = result.getInt(1)
        entity.friendId = result.getInt(2)

        return entity
    }

    override fun insertCore(entity: Friend): PreparedStatement {
        val statement = createStatement("insert into $entityName values(?, ?)")

        statement.setInt(1, entity.usersId)
        statement.setInt(2, entity.friendId)

        return statement
    }

    override fun updateCore(entity: Friend): PreparedStatement {
        throw UnupdatableException(2, "기본키만 있는 엔터티는 업데이트 할 수 없음")
    }

}