package com.dam.api.repositories

import com.dam.api.models.Pelicula
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PeliculasRepository : CrudRepository<Pelicula, Long> {
}