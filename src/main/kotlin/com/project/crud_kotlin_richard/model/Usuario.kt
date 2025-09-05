package com.example.crudkotlin.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotBlank

@Entity
data class Usuario(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @field:NotBlank(message = "O nome do usuário é obrigatório.")
    val nome: String,

    @field:NotBlank(message = "O email do usuário é obrigatório.")
    val email: String
)