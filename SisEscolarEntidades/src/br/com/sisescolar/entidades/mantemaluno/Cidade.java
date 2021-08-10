package br.com.sisescolar.entidades.mantemaluno;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.sisescolar.entidades.SisEscolarEntidade;

@Entity
@Table(name = "Cidade")
public class Cidade extends SisEscolarEntidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCidade;
	
	@Column(name = "nomeCidade", nullable = false)
	private String nomeCidade;
	
	@Column(name = "IdAluno", nullable = true)
	private Integer IdAluno;

	/**
	 * @return the idCidade
	 */
	public Integer getIdCidade() {
		return idCidade;
	}

	/**
	 * @param idCidade the idCidade to set
	 */
	public void setIdCidade(Integer idCidade) {
		this.idCidade = idCidade;
	}

	/**
	 * @return the nomeCidade
	 */
	public String getNomeCidade() {
		return nomeCidade;
	}

	/**
	 * @param nomeCidade the nomeCidade to set
	 */
	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	/**
	 * @return the idAluno
	 */
	public Integer getIdAluno() {
		return IdAluno;
	}

	/**
	 * @param idAluno the idAluno to set
	 */
	public void setIdAluno(Integer idAluno) {
		IdAluno = idAluno;
	}

}
