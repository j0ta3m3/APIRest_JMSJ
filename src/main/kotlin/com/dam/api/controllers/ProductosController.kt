package com.dam.api.controllers

import com.dam.api.models.Producto
import com.dam.api.services.ProductosServicesImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
@RestController
// TODAS LAS PETICIONES QUE LLEGUEN A "/api/v1/productos"
@RequestMapping("/api/v1/productos")
@CrossOrigin("*")
class ProductosController {

    @Autowired
    lateinit var productosService: ProductosServicesImpl

    // URL -> /api/v1/productos/
    @GetMapping("/")
    fun getAll(): ResponseEntity<MutableList<Producto>> {
        var listaProductos: MutableList<Producto>? = mutableListOf()
        listaProductos = productosService.all
        return ResponseEntity(listaProductos, HttpStatus.OK)
    }

    // URL -> DELETE /api/v1/productos/cerveza
    @GetMapping("/{id}")
    fun getOneProduct(@PathVariable id: String): ResponseEntity<Producto>{
        var idProd: Long = id.toLong() //Podemos hacer cualquier tipo de comprobacion
        var producto: Producto? = productosService[idProd]

        return ResponseEntity<Producto>(producto, HttpStatus.OK)
    }

    @PostMapping("/")
    fun insertProducto(@RequestBody prod: Producto): ResponseEntity<Producto> {

        productosService.save(prod)

        println("Lo que viaja en el cuerpo de la peticion")
      println("ID: ${prod.id}")
       println("Nombre: ${prod.nombre}")
        return ResponseEntity<Producto>(prod, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteProducto(@PathVariable id: String): ResponseEntity<String>{
        productosService.delete(id.toLong())
        return ResponseEntity<String>("DELETED", HttpStatus.OK)
    }

}