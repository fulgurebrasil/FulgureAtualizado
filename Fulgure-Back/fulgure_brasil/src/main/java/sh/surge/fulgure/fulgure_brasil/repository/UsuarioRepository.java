package sh.surge.fulgure.fulgure_brasil.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import sh.surge.fulgure.fulgure_brasil.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    List<Usuario> findByNome(String nome);
}
