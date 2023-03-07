package com.dam.api.services

import com.dam.api.commons.GenericServiceImpl
import com.dam.api.models.Pelicula
import com.dam.api.repositories.PeliculasRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class PeliculaServicesImpl : PeliculaServiceAPI, GenericServiceImpl<Pelicula, Long>() {

    @Autowired
    lateinit var peliculasRepository: PeliculasRepository

    override val dao: CrudRepository<Pelicula, Long>
        get() = peliculasRepository

}