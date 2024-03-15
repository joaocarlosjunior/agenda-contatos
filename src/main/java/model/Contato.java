package model;

import java.io.Serializable;

public class Contato implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String nome;
	
	private String fone;
	
	private String email;
	
	public Contato() {
		super();
	}
	
	public Contato(String id, String nome, String fone, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.fone = fone;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String name) {
		this.nome = name;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String number_phone) {
		this.fone = number_phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", nome=" + nome + ", fone=" + fone + ", email=" + email + "]";
	}

}
