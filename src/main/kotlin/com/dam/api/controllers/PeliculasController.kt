package com.dam.api.controllers;

import com.dam.api.models.Pelicula
import com.dam.api.services.PeliculaServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
// TODAS LAS PETICIONES QUE LLEGUEN A "/api/v1/peliculas"
@RequestMapping("/api/v1/peliculas")
@CrossOrigin("*")
class PeliculasController {

    @Autowired
    lateinit var peliculasService : PeliculaServicesImpl



    // URL -> /api/v1/peliculas/
    @GetMapping("/")
    fun getAll(): ResponseEntity<MutableList<Pelicula>> {
        var listaPelis: MutableList<Pelicula>? = mutableListOf()
        listaPelis = peliculasService.all
        return ResponseEntity(listaPelis, HttpStatus.OK)
    }

    // URL -> DELETE /api/v1/productos/cerveza
    @GetMapping("/{id}")
    fun getOnePeli(@PathVariable id: Long): ResponseEntity<Pelicula>{
        var idPeli: Long = id //Podemos hacer cualquier tipo de comprobacion
        var pelicula: Pelicula? = peliculasService[idPeli]

        return ResponseEntity<Pelicula>(pelicula, HttpStatus.OK)
    }
}
