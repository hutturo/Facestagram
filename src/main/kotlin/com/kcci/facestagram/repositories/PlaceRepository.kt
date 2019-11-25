package com.kcci.facestagram.repositories

import com.kcci.facestagram.entities.Place
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.time.LocalDateTime

class PlaceRepository : SingleKeyEntityRepository<Place, Int>() {

    override val entityName get() = "Place"
    override val keyNames get() = "PlaceId"

    override fun readEntity(result: ResultSet): Place {
        val entity = Place()
        entity.placeId = result.getInt(1)
        entity.category = result.getInt(2)
        entity.name = result.getString(3)

        return entity
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