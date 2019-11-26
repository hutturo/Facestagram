package com.kcci.facestagram.repositories

import com.kcci.facestagram.entities.PlacePrice
import com.kcci.facestagram.exceptions.UnupdatableException
import java.sql.PreparedStatement
import java.sql.ResultSet

class PlacePriceRepository
    : DoubleKeyEntityRepository<PlacePrice, Int, Int>() {
    override val entityName: String
        get() = "PlacePrice"
    override val keyNames: String
        get() = "PlaceId, TimeTableId"

    override fun readEntity(result: ResultSet): PlacePrice {
        val entity = PlacePrice()
        entity.placeId = result.getInt(1)
        entity.timeTableId = result.getInt(2)
        entity.price = result.getInt(3)

        return entity
    }

    override fun insertCore(entity: PlacePrice): PreparedStatement {
        val statement = createStatement("insert into [$entityName] values(?, ?, ?)")

        statement.setInt(1, entity.placeId)
        statement.setInt(2, entity.timeTableId)
        statement.setInt(3, entity.price)

        return statement
    }

    override fun updateCore(entity: PlacePrice): PreparedStatement {
        throw UnupdatableException(2, "기본키만 있는 엔터티는 업데이트 할 수 없음")
    }
}