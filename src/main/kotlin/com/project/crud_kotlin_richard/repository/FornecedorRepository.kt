package com.project.crud_kotlin_richard

import com.project.crud_kotlin_richard.model.Fornecedor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FornecedorRepository : JpaRepository<Fornecedor, Long>