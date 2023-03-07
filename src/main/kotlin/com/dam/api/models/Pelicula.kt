package com.dam.api.models

import jakarta.persistence.*


@Entity
@Table(name = "peliculas")
class Pelicula(


    @Column
    var title : String,

    @Column
    var director : String,

    @Column
    var time : String,

    @Column
    var trailer : String,

    @Column
    var poster_image : String,

    @Column
    var screenshot : String,

    @Column
    var synopsis : String,


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long?

) {
}