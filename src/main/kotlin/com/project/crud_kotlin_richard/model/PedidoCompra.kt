package com.project.crud_kotlin_richard
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

@Entity
data class PedidoCompra(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    @field:NotNull(message = "O fornecedor é obrigatório.")
    val fornecedor: Fornecedor,

    @field:NotNull(message = "A data do pedido de compra é obrigatória.")
    val dataPedido: LocalDate = LocalDate.now(),

    var status: String = "PENDENTE"
)