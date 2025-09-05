package com.project.crud_kotlin_richard.repository

import com.project.crud_kotlin_richard.model.Compra
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CompraRepository : JpaRepository<Compra, Long>