package br.com.juvitec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.juvitec.dto.UsuarioDTO;
import br.com.juvitec.entities.Usuario;
import br.com.juvitec.services.UsuarioService;

@RestController
@CrossOrigin("*")//para liberar todas as portas maquina local
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	//aqui faz o Get de todos os usuarios
	@GetMapping
	public ResponseEntity<List<Usuario>> listaUsuarios() {
//		List<Usuario> lista = usuarioService.listarUsuario();funciona assim tambem
		return ResponseEntity.status(200).body(usuarioService.listarUsuario());
	}
	
	//BUSCA POR ID DE USUARIO COM DTO, última alteraçao
	@GetMapping(value = "/{id}")
	public UsuarioDTO findById(@PathVariable Integer id) {
		return usuarioService.findById(id);
	}
	
	
	//cria novo usuario
	@PostMapping
	public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
//		Usuario usuarioNovo = dao.save(usuario);
		return ResponseEntity.status(201).body(usuarioService.criarUsuario(usuario));
	}
	@PutMapping
	public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usuario) {
		return ResponseEntity.status(201).body(usuarioService.editarUsuario(usuario));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> exluirUsuario(@PathVariable Integer id){
//		dao.deleteById(id);
		usuarioService.exluirUsuario(id);
		return ResponseEntity.status(204).build();
	}
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> validarSenha(@RequestBody Usuario usuario){
		Boolean valid = usuarioService.validarSenha(usuario);
		if (!valid) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		return ResponseEntity.status(200).build();
	} 
}
