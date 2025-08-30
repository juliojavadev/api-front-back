package br.com.juvitec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.juvitec.entities.Usuario;

public interface InterfaceUsuario extends JpaRepository<Usuario, Integer> {

}
