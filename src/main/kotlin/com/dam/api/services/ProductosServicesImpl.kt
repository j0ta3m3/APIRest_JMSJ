package com.dam.api.services

import com.dam.api.commons.GenericServiceImpl
import com.dam.api.models.Producto
import com.dam.api.repositories.ProductosRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service


@Service
class ProductosServicesImpl : ProductosServiceAPI, GenericServiceImpl<Producto, Long>() {

    @Autowired
    lateinit var productosRepository: ProductosRepository

    override val dao: CrudRepository<Producto, Long>
        get() = productosRepository

/*
    val dao : CrudRepository<Producto,Long>
        get() {
            return productosRepository
        }

    fun getAll(): MutableList<Producto> {
        val returnList : MutableList<Producto> = ArrayList()
        dao.findAll().forEach(Consumer { obj: Producto -> returnList.add(obj) })

        return returnList;
    }


    fun getProduct(@PathVariable id: Long): Producto? {


        return dao.findByIdOrNull(id)

    }

    fun deleteProduct(@PathVariable id : Long) : Producto? {

        dao.deleteById(id)
    var resultado : Producto ? = dao.findByIdOrNull(id)

      return resultado
    }

    fun insertOneProduct(prod : Producto) : Producto? {

        dao.save(prod)
        var resultado : Producto? = dao.findByIdOrNull(prod.id)

        return resultado
    }

 */



}