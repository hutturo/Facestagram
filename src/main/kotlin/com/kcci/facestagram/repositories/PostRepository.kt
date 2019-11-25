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
        entity.planStartDate = LocalDateTime.parse(result.getString(4))
        entity.planEndDate = LocalDateTime.parse(result.getString(5))
        entity.placeId = result.getInt(6)
        entity.accessibleLevelId = result.getInt(7)

        return entity
    }

    fun find(PostId: Int): MutableList<Post> {
        val statement = createStatement("select PostId, UserId, Content, PlanStartDate, PlanEndDate, PlaceId, AccessibleLevelId from Post where PostId like ?")
        statement.setInt(1, PostId)

        val result = statement.executeQuery()

        val posts = mutableListOf<Post>()
        while (result.next()) {
            val post = readEntity(result)

            posts.add(post)
        }

        close(statement)

        return posts
    }

    override fun insertCore(entity: Post): PreparedStatement {
        val statement = createStatement("insert into Post values(?, ?, ?, ?, ?, ?)")

        statement.setInt(1, entity.userId)
        statement.setString(2, entity.content)
        statement.setString(3, entity.planStartDate.toString().replace("T", " ").dropLast(6))
        statement.setString(4, entity.planEndDate.toString().replace("T", " ").dropLast(6))
        statement.setInt(5, entity.placeId)
        statement.setInt(6, entity.accessibleLevelId)

        return statement
    }

    override fun updateCore(entity: Post): PreparedStatement {
        val statement = createStatement("update Post set UserId = ?, Content = ?, PlanStartDate = ?, PlanEndDate = ?, PlaceId = ?, AccessibleLevelId = ? where PostId = ?")
        statement.setInt(1, entity.userId)
        statement.setString(2, entity.content)
        statement.setString(3, entity.planStartDate.toString().replace("T", " ").dropLast(6))
        statement.setString(4, entity.planEndDate.toString().replace("T", " ").dropLast(6))
        statement.setInt(5, entity.placeId)
        statement.setInt(6, entity.accessibleLevelId)
        statement.setInt(7, entity.postId)

        return statement
    }
}