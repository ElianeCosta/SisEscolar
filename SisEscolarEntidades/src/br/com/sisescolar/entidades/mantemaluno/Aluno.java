package br.com.sisescolar.entidades.mantemaluno;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.sisescolar.entidades.SisEscolarEntidade;

@Entity
@Table(name = "Aluno")
public class Aluno extends SisEscolarEntidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7813975243372573616L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAluno;

	@Column(name = "cpf", nullable = false)
	private String cpf;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "sexo", nullable = false)
	private String sexo;

	@Column(name = "idade", nullable = false)
	private Integer idade;

	/**
	 * @return the idAluno
	 */
	public Long getIdAluno() {
		return idAluno;
	}

	/**
	 * @param idAluno the idAluno to set
	 */
	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	/**
	 * @param sexo the idadeAluno to set
	 */
	public Integer getIdadeAluno() {
		return idade;
	}

	/**
	 * @param sexo the idadeAluno to set
	 */
	public void setIdadeAluno(Integer integer) {
		this.idade = integer;
	}
}
