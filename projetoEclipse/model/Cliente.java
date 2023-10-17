package model;

public class Cliente {
	private int id;
	private String email;
	private String senha;
	private String telefone;
	private String nome_Completo;
	
	

	public Cliente() {
	}

	public Cliente(int id, String email, String senha, String telefone, String nome_Completo) {
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.nome_Completo = nome_Completo;
	}

	public Cliente(String email, String senha, String telefone, String nome_Completo) {
		super();
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.nome_Completo = nome_Completo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome_Completo() {
		return nome_Completo;
	}

	public void setNome_Completo(String nome_Completo) {
		this.nome_Completo = nome_Completo;
	}

}