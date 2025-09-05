package com.project.crud_kotlin_richard.controller

import com.project.crud_kotlin_richard.model.Usuario
import com.project.crud_kotlin_richard.repository.UsuarioRepository
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuarios")
class UsuarioController(private val usuarioRepository: UsuarioRepository) {

    @GetMapping
    fun listarTodos(): List<Usuario> = usuarioRepository.findAll()

    @PostMapping
    fun cadastrar(@Valid @RequestBody usuario: Usuario): ResponseEntity<Usuario> {
        val usuarioSalvo = usuarioRepository.save(usuario)
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ResponseEntity<Usuario> {
        return usuarioRepository.findById(id)
            .map { ResponseEntity.ok(it) }
            .orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @Valid @RequestBody usuario: Usuario): ResponseEntity<Usuario> {
        return usuarioRepository.findById(id)
            .map {
                val usuarioAtualizado = it.copy(nome = usuario.nome, email = usuario.email)
                ResponseEntity.ok(usuarioRepository.save(usuarioAtualizado))
            }
            .orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long): ResponseEntity<Void> {
        return usuarioRepository.findById(id)
            .map {
                usuarioRepository.delete(it)
                ResponseEntity<Void>(HttpStatus.NO_CONTENT)
            }
            .orElse(ResponseEntity.notFound().build())
    }
}