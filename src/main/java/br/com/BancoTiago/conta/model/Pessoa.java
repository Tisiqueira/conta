package br.com.BancoTiago.conta.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("deprecation")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable= false, unique= true)
	@Email(message="Email Inválido")
	@Length(min = 16, max=  100)
	@NotEmpty(message="Campo email é obrigatorio")
	private String emailString;
	
	@Column(nullable= false, length= 100)
	@NotEmpty(message="Campo nome é obrigatorio")
	private String nome;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate dataDeNascimento;
	
	@Column(nullable= false, length= 11, unique= true)
	@NotEmpty(message="Campo cpf é obrigatorio")
	@CPF(message="CPF inválido")
	private String cpf;
	
	@OneToOne(mappedBy ="pessoa", cascade=CascadeType.ALL)
	@JoinColumn(foreignKey= @ForeignKey(name = "conta_fk"))
	@JsonIgnoreProperties("pessoa")
	private Conta conta;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmailString() {
		return emailString;
	}

	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	
	
}
