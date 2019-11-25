package com.kcci.facestagram.repositories

import com.kcci.facestagram.entities.Place
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.time.LocalDateTime

class PlaceRepository : SingleKeyEntityRepository<Place, Int>() {

    override val entityName get() = "Place"
    override val keyNames get() = "PlaceId"

    override fun readEntity(result: ResultSet): Place {
        val place = Place()
        place.placeId = result.getInt(1)
        place.category = result.getInt(2)
        place.name = result.getString(3)

        return place
    }

    fun find(PlaceId: Int): MutableList<Place> {
        val statement = createStatement("select PlaceId, Category, Name from Place where PlaceId like ?")
        statement.setInt(1, PlaceId)

        val result = statement.executeQuery()

        val places = mutableListOf<Place>()
        while (result.next()) {
            val place = readEntity(result)

            places.add(place)
        }

        close(statement)

        return places
    }

    override fun insertCore(entity: Place): PreparedStatement {
        val statement = createStatement("insert into Place values(?, ?)")

        statement.setInt(1, entity.category)
        statement.setString(2, entity.name)

        return statement
    }

    override fun updateCore(entity: Place): PreparedStatement {
        val statement = createStatement("update Place set Category = ?, Name = ? where PlaceId = ?")
        statement.setInt(1, entity.category)
        statement.setString(2, entity.name)
        statement.setInt(3, entity.placeId)

        return statement
    }
}