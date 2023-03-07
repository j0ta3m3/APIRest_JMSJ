package com.dam.api.controllers

import com.dam.api.models.Producto
import com.dam.api.models.Sesiones
import com.dam.api.services.ProductosServicesImpl
import com.dam.api.services.SesionServicesImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.util.Calendar

@RestController
@RequestMapping("/api/v1/sesiones")
@CrossOrigin("*")
class SessionsController {

    @Autowired
    lateinit var sesionService: SesionServicesImpl


    // URL -> /api/v1/sesiones/
    @GetMapping("/")
    fun getAll(): ResponseEntity<MutableList<Sesiones>> {
        var listaSesiones: MutableList<Sesiones>? = mutableListOf()
        listaSesiones = sesionService.all
        return ResponseEntity(listaSesiones, HttpStatus.OK)
    }

    @GetMapping("/sincetoday")
    fun getAllHoyenAdelante(): ResponseEntity<MutableList<Sesiones>> {
        var listaSesiones: MutableList<Sesiones>? = mutableListOf()
        var hoyEnAdelante: MutableList<Sesiones>? = mutableListOf()
        listaSesiones = sesionService.all
        var hoy = LocalDate.now()

        if (listaSesiones != null) {
            for (i in listaSesiones) {
                if (i.date.compareTo(hoy) >= 0) if (hoyEnAdelante != null) {
                    hoyEnAdelante.add(i)
                }
            }
        }

        return ResponseEntity(hoyEnAdelante, HttpStatus.OK)
    }

    @GetMapping("/today")
    fun getAllHoy(): ResponseEntity<MutableList<Sesiones>> {
        var listaSesiones: MutableList<Sesiones>? = mutableListOf()
        var hoyList: MutableList<Sesiones>? = mutableListOf()
        listaSesiones = sesionService.all
        var hoy = LocalDate.now()

        if (listaSesiones != null) {
            for (i in listaSesiones) {
                if (i.date.compareTo(hoy) == 0) if (hoyList != null) {
                    if (hoyList != null) {
                        hoyList.add(i)
                    }
                }
            }
        }

        return ResponseEntity(hoyList, HttpStatus.OK)
    }



}