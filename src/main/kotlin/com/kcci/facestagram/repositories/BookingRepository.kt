package com.kcci.facestagram.repositories

import com.kcci.facestagram.entities.Booking
import java.sql.Date
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Timestamp
import java.time.LocalDateTime
import java.time.ZoneId

class BookingRepository: SingleKeyEntityRepository<Booking, Int>() {

    override val entityName get() = "Booing"
    override val keyNames get() = "bookingId"



    override fun readEntity(result: ResultSet): Booking {
        val booking = Booking()
        booking.bookingId = result.getInt(1)
        booking.startDate = LocalDateTime.parse(result.getString(2))
        booking.endDate = LocalDateTime.parse(result.getString(3))
        booking.price = result.getInt(4)

        return booking

    }

    fun find(BookingId: Int): MutableList<Booking> {
        val statement = createStatement("select BookingId, startDate, endDate, price from Booking where BookingId like ?")
        statement.setInt(1, BookingId)

        val result = statement.executeQuery()

        val bookings = mutableListOf<Booking>()
        while (result.next()) {
            val booking = readEntity(result)

            bookings.add(booking)
        }

        close(statement)

        return bookings
    }

    override fun insertCore(entity: Booking): PreparedStatement {
        val statement = createStatement("insert into Booking values(?, ?, ?)")

        statement.setString(1, entity.startDate.toString().replace("T", " ").dropLast(6))
        statement.setString(2, entity.endDate.toString().replace("T", " ").dropLast(6))
        statement.setInt(3, entity.price)

        return statement
    }

    override fun updateCore(entity: Booking): PreparedStatement {
        val statement = createStatement("update Booking set startDate = ?, endDate = ? where bookingId = ?")
        statement.setString(1, entity.startDate.toString().replace("T", " ").dropLast(6))
        statement.setString(2, entity.endDate.toString().replace("T", " ").dropLast(6))
        statement.setInt(3, entity.bookingId)

        return statement
    }
}