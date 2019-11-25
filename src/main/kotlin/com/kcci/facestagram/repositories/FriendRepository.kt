package com.kcci.facestagram.repositories

import com.kcci.facestagram.entities.Friend
import java.sql.PreparedStatement
import java.sql.ResultSet

class FriendRepository : DoubleKeyEntityRepository<Friend, Int, Int>() {
    override val entityName: String
        get() = "Friend"
    override val keyNames: String
        get() = "UserId, FriendId"

    override fun readEntity(result: ResultSet): Friend {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun insertCore(entity: Friend): PreparedStatement {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateCore(entity: Friend): PreparedStatement {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}