package com.project.crud_kotlin_richard.repository

import com.project.crud_kotlin_richard.model.Pedido
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PedidoRepository : JpaRepository<Pedido, Long>