package com.example.crudkotlin.controller

import com.example.crudkotlin.model.Pedido
import com.example.crudkotlin.repository.PedidoRepository
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pedidos")
class PedidoController(private val pedidoRepository: PedidoRepository) {

    @PostMapping
    fun cadastrar(@Valid @RequestBody pedido: Pedido): ResponseEntity<Pedido> {
        val pedidoSalvo = pedidoRepository.save(pedido)
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoSalvo)
    }

    // Implementar outros endpoints (GET, PUT, DELETE) para Pedido
}