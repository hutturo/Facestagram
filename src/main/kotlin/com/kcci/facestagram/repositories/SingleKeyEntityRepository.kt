package com.kcci.facestagram.repositories

import com.kcci.facestagram.entities.SingleKeyEntity

abstract class SingleKeyEntityRepository<T: SingleKeyEntity<K1>, K1> : EntityRepository<T>() {
    protected fun getByPK(id: K1): T? {
        val statement = createStatement("select * from $entityName where $keyNames = ?")
        statement.setObject(1, id)

        val result = statement.executeQuery()

        var entity: T? = null

        while (result.next()) {
            entity = readEntity(result)
        }

        close(statement)

        return entity
    }

    protected fun deleteByPK(id: K1){
        val statement = createStatement("delete $entityName where $keyNames = ?")
        statement.setObject(1, id)

        statement.executeUpdate()

        close(statement)
    }

    protected fun delete(entity: T){
        deleteByPK(entity.keyValue1)
    }
}