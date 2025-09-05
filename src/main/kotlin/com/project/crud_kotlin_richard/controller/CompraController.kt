package com.example.crudkotlin.controller

import com.example.crudkotlin.model.Compra
import com.example.crudkotlin.model.PedidoCompra
import com.example.crudkotlin.repository.CompraRepository
import com.example.crudkotlin.repository.PedidoCompraRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/compras")
class CompraController(
    private val compraRepository: CompraRepository,
    private val pedidoCompraRepository: PedidoCompraRepository
) {

    @PostMapping("/operar/{pedidoCompraId}")
    fun operarCompra(@PathVariable pedidoCompraId: Long): ResponseEntity<Any> {
        val pedidoCompraOptional: Optional<PedidoCompra> = pedidoCompraRepository.findById(pedidoCompraId)

        if (pedidoCompraOptional.isEmpty) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido de Compra não encontrado.")
        }

        val pedidoCompra = pedidoCompraOptional.get()

        if (pedidoCompra.status != "PENDENTE") {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Este Pedido de Compra já foi processado.")
        }

        // Atualiza o status do Pedido de Compra
        pedidoCompra.status = "CONCLUÍDO"
        pedidoCompraRepository.save(pedidoCompra)

        // Cria a Compra
        val novaCompra = Compra(pedidoCompra = pedidoCompra)
        val compraSalva = compraRepository.save(novaCompra)

        return ResponseEntity.status(HttpStatus.CREATED).body(compraSalva)
    }
}