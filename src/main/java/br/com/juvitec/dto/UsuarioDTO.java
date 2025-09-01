package br.com.juvitec.dto;

import br.com.juvitec.entities.Usuario;

public class UsuarioDTO {
	
	private Integer id;
	private String nome;
	private String email;
//	private String senha;
	private String telefone;
//coorigindo erro pom xml downloads
	
	public UsuarioDTO() {
		
	}


	public UsuarioDTO(Integer id, String nome, String email,String telefone) {
		
		this.id = id;
		this.nome = nome;
		this.email = email;
//		this.senha = senha;
		this.telefone = telefone;
	}
	
	public UsuarioDTO(Usuario usuario) {
		id = usuario.getId();
		nome = usuario.getNome();
		email = usuario.getEmail();
//		senha = usuario.getSenha();
		telefone = usuario.getTelefone();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

/*
	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
*/

	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	
}
