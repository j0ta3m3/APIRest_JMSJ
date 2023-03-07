package com.dam.api.models

import jakarta.persistence.*
import java.sql.Time
import java.time.LocalDate
import java.util.Calendar

@Entity
@Table(name = "sesiones")
class Sesiones(

    @Column
    var movie_id: String,

    @Column
    var room_id: String,

    @Column
    @Temporal(TemporalType.DATE)
    var date: LocalDate,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long
) {
}