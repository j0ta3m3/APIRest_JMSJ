package com.dam.api.models

import jakarta.persistence.*

@Entity
@Table(name = "users")
class User(

    @Column
    var nick: String,

    @Column
    var email: String,

    @Column
    var profilePicture: String,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?
) {
}