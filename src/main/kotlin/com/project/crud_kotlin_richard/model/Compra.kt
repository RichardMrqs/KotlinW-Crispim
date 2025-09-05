package com.project.crud_kotlin_richard

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import java.time.LocalDateTime

@Entity
data class Compra(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @OneToOne
    @JoinColumn(name = "pedido_compra_id")
    @field:NotNull(message = "O pedido de compra é obrigatório.")
    val pedidoCompra: PedidoCompra,

    @field:NotNull(message = "A data e hora da compra são obrigatórias.")
    val dataHoraCompra: LocalDateTime = LocalDateTime.now()
)