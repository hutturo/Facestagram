package com.kcci.facestagram.repositories

import com.kcci.facestagram.entities.PostUser
import com.kcci.facestagram.exceptions.UnupdatableException
import java.sql.PreparedStatement
import java.sql.ResultSet

class PostUsersRepository : DoubleKeyEntityRepository<PostUser, Int, Int>() {
    override val entityName get() = "PostUser"
    override val keyNames get() = "PostId, UserId"

    override fun readEntity(result: ResultSet): PostUser {
        val entity = PostUser()
        entity.postId = result.getInt(1)
        entity.userId = result.getInt(2)

        return entity
    }

    override fun insertCore(entity: PostUser): PreparedStatement {
        val statement = createStatement("insert into [$entityName] values(?, ?)")

        statement.setInt(1, entity.postId)
        statement.setInt(2, entity.userId)

        return statement
    }

    override fun updateCore(entity: PostUser): PreparedStatement {
        throw UnupdatableException(2, "기본키만 있는 엔터티는 업데이트 할 수 없음")
    }
}