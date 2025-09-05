package com.project.crud_kotlin_richard

import com.project.crud_kotlin_richard.model.Fornecedor
import com.project.crud_kotlin_richard.repository.FornecedorRepository
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/fornecedores")
class FornecedorController(private val fornecedorRepository: FornecedorRepository) {

    @GetMapping
    fun listarTodos(): List<Fornecedor> = fornecedorRepository.findAll()

    @PostMapping
    fun cadastrar(@Valid @RequestBody fornecedor: Fornecedor): ResponseEntity<Fornecedor> {
        val fornecedorSalvo = fornecedorRepository.save(fornecedor)
        return ResponseEntity.status(HttpStatus.CREATED).body(fornecedorSalvo)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ResponseEntity<Fornecedor> {
        return fornecedorRepository.findById(id)
            .map { ResponseEntity.ok(it) }
            .orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @Valid @RequestBody fornecedor: Fornecedor): ResponseEntity<Fornecedor> {
        return fornecedorRepository.findById(id)
            .map {
                val fornecedorAtualizado = it.copy(nome = fornecedor.nome, cnpj = fornecedor.cnpj)
                ResponseEntity.ok(fornecedorRepository.save(fornecedorAtualizado))
            }
            .orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long): ResponseEntity<Void> {
        return fornecedorRepository.findById(id)
            .map {
                fornecedorRepository.delete(it)
                ResponseEntity<Void>(HttpStatus.NO_CONTENT)
            }
            .orElse(ResponseEntity.notFound().build())
    }
}