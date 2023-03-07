package com.dam.api.services

import com.dam.api.commons.GenericServiceAPI
import com.dam.api.commons.GenericServiceImpl
import com.dam.api.models.Producto
import com.dam.api.models.Sesiones
import com.dam.api.repositories.ProductosRepository
import com.dam.api.repositories.SessionsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class SesionServicesImpl : SesionServiceAPI, GenericServiceImpl<Sesiones,Long>(){
    @Autowired
    lateinit var sesionRepository: SessionsRepository

    override val dao: CrudRepository<Sesiones, Long>
        get() = sesionRepository
}