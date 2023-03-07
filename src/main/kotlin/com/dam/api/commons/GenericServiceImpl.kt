package com.dam.api.commons

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
abstract class GenericServiceImpl<T, ID> : GenericServiceAPI<T, ID> {

    override fun save(entity: T): T {
      return  dao.save(entity)
    }

    override fun delete(id: ID) {

        dao.deleteById(id)

    }

    override fun get(id: ID): T? {

        return dao.findByIdOrNull(id)

    }

    override val all: MutableList<T>?
        get() {

            val returnList : MutableList<T> = mutableListOf()
            dao.findAll().forEach{ obj: T -> returnList.add(obj) }

            return returnList;
        }

abstract val dao : CrudRepository<T, ID>

}