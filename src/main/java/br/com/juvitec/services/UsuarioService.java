package br.com.juvitec.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.juvitec.dto.UsuarioDTO;
import br.com.juvitec.entities.Usuario;
import br.com.juvitec.repository.InterfaceUsuario;

@Service
public class UsuarioService {
	//injeção de dependencia
	private InterfaceUsuario repository;
	
	private PasswordEncoder passworderEncoder;
	
	public UsuarioService(InterfaceUsuario repository) {
		this.repository = repository;
		//injentando dependencia dentro do construtor cryptografia senha
		this.passworderEncoder = new BCryptPasswordEncoder();
		
	}
	
	public List<Usuario> listarUsuario(){
		List<Usuario> lista = repository.findAll();
		return lista;
	}
	
	public Usuario criarUsuario(Usuario usuario){
		String cryptosenha = this.passworderEncoder.encode(usuario.getSenha());
		usuario.setSenha(cryptosenha);
		Usuario usuarioNovo = repository.save(usuario);
		return usuarioNovo;
	}
	
	public Usuario editarUsuario(Usuario usuario){
		String cryptosenha = this.passworderEncoder.encode(usuario.getSenha());
		usuario.setSenha(cryptosenha);
		Usuario usuarioEditado = repository.save(usuario);
		return usuarioEditado;
	}
	public Boolean exluirUsuario(Integer id) {
		repository.deleteById(id);
		return true;
		
	}

	public Boolean validarSenha(Usuario usuario) {
		String senha = repository.getById(usuario.getId()).getSenha();
		Boolean valid = passworderEncoder.matches(usuario.getSenha(), senha);
		return valid;
	} 
	
	//busca por id
	public UsuarioDTO findById(Integer id) {
		Usuario entities = repository.findById(id).get();
		UsuarioDTO dto = new UsuarioDTO(entities);
		
		return dto;
	}
}
