package com.kcci.facestagram.repositories

import com.kcci.facestagram.entities.DoubleKeyEntity

abstract class DoubleKeyEntityRepository<T : DoubleKeyEntity<K1, K2>, K1, K2>
    : EntityRepository<T>() {
    override val getLastQuery: String
        get() = "select top 1 * from $entityName order by ${keyNames.split(",")[0]} desc"

    fun getByPK(id1: K1, id2: K2): T? {
        val keyNamesContainer = keyNames.split(",")
        val statement = createStatement(
                "select * from [$entityName] where ${keyNamesContainer[0]} = ? and ${keyNamesContainer[1]} = ?")
        statement.setObject(1, id1)
        statement.setObject(2, id2)

        val result = statement.executeQuery()

        var entity: T? = null

        while (result.next()) {
            entity = readEntity(result)
        }

        close(statement)

        return entity
    }

    fun deleteByPK(id1: K1, id2: K2){
        val keyNamesContainer = keyNames.split(",")
        val statement = createStatement(
                "delete [$entityName] where ${keyNamesContainer[0]} = ? and ${keyNamesContainer[1]} = ?")
        statement.setObject(1, id1)
        statement.setObject(2, id2)

        statement.executeUpdate()

        close(statement)
    }

    fun delete(entity: T){
        deleteByPK(entity.keyValue1, entity.keyValue2)
    }
}