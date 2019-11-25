package com.kcci.facestagram.repositories

import com.kcci.facestagram.entities.Friend
import com.kcci.facestagram.entities.User
import com.kcci.facestagram.exceptions.UnupdatableException
import java.sql.PreparedStatement
import java.sql.ResultSet

class FriendRepository : DoubleKeyEntityRepository<Friend, Int, Int>() {
    override val entityName: String
        get() = "Friend"
    override val keyNames: String
        get() = "UserId, FriendId"

    override fun readEntity(result: ResultSet): Friend {
        val entity = Friend()
        entity.userId = result.getInt(1)
        entity.friendId = result.getInt(2)

        return entity
    }

    fun find(FriendId: Int): MutableList<Friend> {
        val statement = createStatement("select  UserId, FriendId from Friend where UserId like ?")
        statement.setInt(1, FriendId)
        val result = statement.executeQuery()

        val friends = mutableListOf<Friend>()
        while (result.next()) {
            val friend = readEntity(result)

            friends.add(friend)
        }

        close(statement)

        return friends
    }

    override fun insertCore(entity: Friend): PreparedStatement {
        val statement = createStatement("insert into Friend values(?, ?)")

        statement.setInt(1, entity.userId)
        statement.setInt(2, entity.friendId)

        return statement
    }

    override fun updateCore(entity: Friend): PreparedStatement {
        throw UnupdatableException(2, "기본키만 있는 엔터티는 업데이트 할 수 없음")
    }

}