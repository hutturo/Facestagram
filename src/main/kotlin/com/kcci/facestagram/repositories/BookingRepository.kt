package com.kcci.facestagram.repositories

import com.kcci.facestagram.entities.Booking
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.time.LocalDateTime

class BookingRepository: SingleKeyEntityRepository<Booking, Int>() {
    override val entityName get() = "Booing"
    override val keyNames get() = "bookingId"

    override fun readEntity(result: ResultSet): Booking {
        val entity = Booking()
        entity.bookingId = result.getInt(1)
        entity.placeId = result.getInt(2)
        entity.startDatetime = convertDate(result.getString(3))
        entity.endDatetime = convertDate(result.getString(4))

        return entity
    }

    override fun insertCore(entity: Booking): PreparedStatement {
        val statement = createStatement("insert into $entityName values(?, ?, ?)")

        statement.setInt(1, entity.placeId)
        statement.setString(2, convertDate(entity.startDatetime))
        statement.setString(3, convertDate(entity.endDatetime))

        return statement
    }

    override fun updateCore(entity: Booking): PreparedStatement {
        val statement = createStatement(
                "update $entityName set plcaeId = ?, startDatetime = ?, endDatetime = ?" +
                " where $keyNames = ?")
        statement.setInt(1, entity.placeId)
        statement.setString(2, convertDate(entity.startDatetime))
        statement.setString(3, convertDate(entity.endDatetime))
        statement.setInt(4, entity.bookingId)

        return statement
    }
}