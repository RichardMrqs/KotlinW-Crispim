package com.example.crudkotlin.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

@Entity
data class Pedido(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @field:NotNull(message = "O usuário do pedido é obrigatório.")
    val usuario: Usuario,

    @field:NotNull(message = "O valor do pedido é obrigatório.")
    val valor: BigDecimal
)