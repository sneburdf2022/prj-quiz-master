package org.senai.prjquiz.repository;

import org.senai.prjquiz.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

}
