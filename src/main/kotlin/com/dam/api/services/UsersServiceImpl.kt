package com.dam.api.services

import com.dam.api.commons.GenericServiceImpl
import com.dam.api.models.Producto
import com.dam.api.models.User
import com.dam.api.repositories.ProductosRepository
import com.dam.api.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class UsersServiceImpl : UsersServiceAPI, GenericServiceImpl<User,Long>() {

    @Autowired
    lateinit var usersRepository: UserRepository

    override val dao: CrudRepository<User, Long>
        get() = usersRepository

}