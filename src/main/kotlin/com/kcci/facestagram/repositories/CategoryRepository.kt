package com.kcci.facestagram.repositories

import com.kcci.facestagram.entities.Category
import java.sql.PreparedStatement
import java.sql.ResultSet

class CategoryRepository : SingleKeyEntityRepository<Category, Int>() {
    override val entityName get() = "Category"
    override val keyNames get() = "CategoryId"

    override fun readEntity(result: ResultSet): Category {
        val entity = Category()
        entity.categoryId = result.getInt(1)
        entity.name = result.getString(2)

        return entity

    }

    override fun insertCore(entity: Category): PreparedStatement {
        val statement = createStatement("insert into $entityName values(?)")

        statement.setString(1, entity.name)

        return statement
    }

    override fun updateCore(entity: Category): PreparedStatement {
        val statement = createStatement(
                "update $entityName set CategoryName = ? where $keyNames = ?")
        statement.setString(1, entity.name)
        statement.setInt(2, entity.categoryId)

        return statement
    }
}