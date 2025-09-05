package com.example.crudkotlin.repository

import com.example.crudkotlin.model.Fornecedor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FornecedorRepository : JpaRepository<Fornecedor, Long>