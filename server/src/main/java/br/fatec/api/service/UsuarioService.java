package br.fatec.api.service;

import br.fatec.api.dto.UsuarioDto;
import br.fatec.api.model.Usuario;
import br.fatec.api.repository.UsuarioRepository;
import br.fatec.api.exception.ResourceNotFoundException;
import br.fatec.api.exception.DuplicateResourceException;
import br.fatec.api.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Listar todos os usuários
    public List<UsuarioDto> findAll() {
        try {
            List<Usuario> usuarios = usuarioRepository.findAll();
            if (usuarios.isEmpty()) {
                throw new ServiceException("Nenhum usuário encontrado.");
            }
            return usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());
        } catch (Exception e) {
            throw new ServiceException("Erro ao listar usuários: " + e.getMessage());
        }
    }

    // Buscar usuário por ID
    public Optional<UsuarioDto> findById(Long id) {
        try {
            Usuario usuario = usuarioRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + id));
            return Optional.of(new UsuarioDto(usuario));
        } catch (Exception e) {
            throw new ServiceException("Erro ao buscar usuário: " + e.getMessage());
        }
    }

    // Criar um novo usuário
    public UsuarioDto save(UsuarioDto usuarioDto) {
        try {
            if (usuarioRepository.existsByEmail(usuarioDto.getEmail())) {
                throw new DuplicateResourceException("E-mail já cadastrado: " + usuarioDto.getEmail());
            }

            Usuario usuario = new Usuario(null, usuarioDto.getNome(), usuarioDto.getEmail(),null);
            Usuario savedUsuario = usuarioRepository.save(usuario);
            return new UsuarioDto(savedUsuario);
        } catch (Exception e) {
            throw new ServiceException("Erro ao salvar usuário: " + e.getMessage());
        }
    }

    // Atualizar um usuário existente
    public UsuarioDto update(Long id, UsuarioDto usuarioDto) {
        try {
            Usuario usuario = usuarioRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + id));

            usuario.setNome(usuarioDto.getNome());
            usuario.setEmail(usuarioDto.getEmail());

            Usuario updatedUsuario = usuarioRepository.save(usuario);
            return new UsuarioDto(updatedUsuario);
        } catch (Exception e) {
            throw new ServiceException("Erro ao atualizar usuário: " + e.getMessage());
        }
    }

    // Deletar usuário
    public boolean delete(Long id) {
        try {
            Usuario usuario = usuarioRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + id));

            usuarioRepository.delete(usuario);
            return true;
        } catch (Exception e) {
            throw new ServiceException("Erro ao deletar usuário: " + e.getMessage());
        }
    }
}
