package com.kcci.facestagram.repositories

import com.kcci.facestagram.entities.AccessibleLevel


import java.sql.PreparedStatement
import java.sql.ResultSet
import java.time.LocalDateTime

class AccessibleLevelRepository : SingleKeyEntityRepository<AccessibleLevel, Int>() {

    override val entityName get() = "AccessibleLevel"
    override val keyNames get() = "accessibleLevelId"


    override fun readEntity(result: ResultSet): AccessibleLevel {
        val entity = AccessibleLevel()
        entity.accessibleLevelId = result.getInt(1)
        entity.name = result.getString(2)

        return entity

    }


    override fun insertCore(entity: AccessibleLevel): PreparedStatement {
        val statement = createStatement("insert into AccessibleLevel values(?)")

        statement.setString(1, entity.name)

        return statement
    }

    override fun updateCore(entity: AccessibleLevel): PreparedStatement {
        val statement = createStatement("update AccessibleLevel set Name = ? where AccessibleLevelId = ?")
        statement.setString(1, entity.name)
        statement.setInt(2, entity.accessibleLevelId)

        return statement
    }
}