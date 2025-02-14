package br.fatec.api.repository;

import br.fatec.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u")
    List<Usuario> findAllUsuarios();

    @Query("SELECT u.nome FROM Usuario u")
    List<String> findAllUserNames();

    Optional<Usuario> findByEmail(String email);

    boolean existsByEmail(String email);
}
