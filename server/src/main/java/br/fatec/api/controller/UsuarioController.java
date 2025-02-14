package br.fatec.api.controller;

import br.fatec.api.dto.UsuarioDto;
import br.fatec.api.service.UsuarioService;
import br.fatec.api.exception.ResourceNotFoundException;
import br.fatec.api.exception.DuplicateResourceException;
import br.fatec.api.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> listar() {
        try {
            List<UsuarioDto> usuarios = usuarioService.findAll();
            return ResponseEntity.ok(usuarios);
        } catch (ServiceException e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> buscarPorId(@PathVariable Long id) {
        try {
            Optional<UsuarioDto> usuario = usuarioService.findById(id);
            return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(null);
        } catch (ServiceException e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> salvar(@RequestBody UsuarioDto usuarioDto) {
        try {
            UsuarioDto novoUsuario = usuarioService.save(usuarioDto);
            return ResponseEntity.ok(novoUsuario);
        } catch (DuplicateResourceException e) {
            return ResponseEntity.status(409).body(null);
        } catch (ServiceException e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> atualizar(@PathVariable Long id, @RequestBody UsuarioDto usuarioDto) {
        try {
            UsuarioDto usuarioAtualizado = usuarioService.update(id, usuarioDto);
            return ResponseEntity.ok(usuarioAtualizado);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(null);
        } catch (ServiceException e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            usuarioService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        } catch (ServiceException e) {
            return ResponseEntity.status(500).build();
        }
    }
}
