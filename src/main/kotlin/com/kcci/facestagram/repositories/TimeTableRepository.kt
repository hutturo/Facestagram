package com.kcci.facestagram.repositories

import com.kcci.facestagram.entities.TimeTable
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.time.LocalDateTime

class TimeTableRepository : SingleKeyEntityRepository<TimeTable, Int>() {
    override val entityName: String
        get() = "TimeTable"
    override val keyNames: String
        get() = "TimeTableId"

    override fun readEntity(result: ResultSet): TimeTable {
        val entity = TimeTable()
        entity.timeTableId = result.getInt(1)
        entity.starttime = LocalDateTime.parse(result.getString(2))
        entity.endtime = LocalDateTime.parse(result.getString(3))

        return entity
    }

    override fun insertCore(entity: TimeTable): PreparedStatement {
        val statement = createStatement("insert into [$entityName] values(?, ?, ?)")

        statement.setInt(1, entity.timeTableId)
        statement.setString(2, convertDate(entity.starttime))
        statement.setString(3, convertDate(entity.endtime))

        return statement
    }

    override fun updateCore(entity: TimeTable): PreparedStatement {
        val statement = createStatement("update [$entityName] set StartTime = ?, EndTime = ?" +
                " where $keyNames = ?")
        statement.setString(1, convertDate(entity.starttime))
        statement.setString(2, convertDate(entity.endtime))
        statement.setInt(3, entity.timeTableId)

        return statement
    }
}