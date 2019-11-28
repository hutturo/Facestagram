package com.kcci.facestagram.repositories

import com.kcci.facestagram.entities.Post
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.time.LocalDateTime

class PostRepository : SingleKeyEntityRepository<Post, Int>() {
    override val entityName get() = "Post"
    override val keyNames get() = "PostId"

    override fun readEntity(result: ResultSet): Post {
        val entity = Post()
        entity.postId = result.getInt(1)
        entity.userId = result.getInt(2)
        entity.content = result.getString(3)
        entity.lastModified = LocalDateTime.parse(result.getString(4))
        entity.planStartDatetime = LocalDateTime.parse(result.getString(5))
        entity.planEndDatetime = LocalDateTime.parse(result.getString(6))
        entity.placeId = result.getInt(7)
        entity.accessibleLevelId = result.getInt(8)

        return entity
    }

    override fun insertCore(entity: Post): PreparedStatement {
        val statement = createStatement(
                "insert into [$entityName] values(?, ?, CONVERT(smalldatetime, CURRENT_TIMESTAMP), ?, ?, ?, ?)")

        statement.setInt(1, entity.userId)
        statement.setString(2, entity.content)
        // statement.setString(3, convertDate(entity.lastModified))
        statement.setString(3, convertDate(entity.planStartDatetime))
        statement.setString(4, convertDate(entity.planEndDatetime))
        statement.setInt(5, entity.placeId)
        statement.setInt(6, entity.accessibleLevelId)

        return statement
    }

    override fun updateCore(entity: Post): PreparedStatement {
        val statement = createStatement("update [$entityName]" +
                " set UsersId = ?, LastModified = CONVERT(smalldatetime, CURRENT_TIMESTAMP), Content = ?," +
                " PlanStartDate = ?, PlanEndDate = ?, PlaceId = ?," +
                " AccessibleLevelId = ? where $keyNames = ?")
        statement.setInt(1, entity.userId)
        statement.setString(2, entity.content)
        // statement.setString(3, convertDate(entity.lastModified))
        statement.setString(3, convertDate(entity.planStartDatetime))
        statement.setString(4, convertDate(entity.planEndDatetime))
        statement.setInt(5, entity.placeId)
        statement.setInt(6, entity.accessibleLevelId)
        statement.setInt(7, entity.postId)

        return statement
    }
}