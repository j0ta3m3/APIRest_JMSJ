package com.dam.api.controllers

import com.dam.api.models.Producto
import com.dam.api.models.User
import com.dam.api.services.UsersServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin("*")
class UsersController {

    @Autowired
    lateinit var userService: UsersServiceImpl

    // URL -> /api/v1/users/
    @GetMapping("/")
    fun getAll(): ResponseEntity<MutableList<User>> {
        var listaUsers: MutableList<User>? = mutableListOf()
        listaUsers = userService.all
        return ResponseEntity(listaUsers, HttpStatus.OK)
    }

    // URL -> DELETE /api/v1/users/id
    @GetMapping("/{id}")
    fun getOneUser(@PathVariable id: Long): ResponseEntity<User>{
        var idUser: Long = id //Podemos hacer cualquier tipo de comprobacion
        var user: User? = userService[idUser]

        return ResponseEntity<User>(user, HttpStatus.OK)
    }

    @PostMapping("/")
    fun insertUser(@RequestBody user: User): ResponseEntity<User> {

        userService.save(user)

        println("Lo que viaja en el cuerpo de la peticion")
        println("ID: ${user.id}")
        println("Nick: ${user.nick}")
        println("Email: ${user.email} ")
        println("Profile P: ${user.profilePicture}")
        return ResponseEntity<User>(user, HttpStatus.OK)
    }

}