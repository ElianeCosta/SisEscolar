package br.com.sisescolar.entidades.mantemaluno;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.sisescolar.entidades.SisEscolarEntidade;

@Entity
@Table(name = "Endereco")
public class Endereco extends SisEscolarEntidade {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAluno;

	@Column(name = "idCidade", nullable = true)
	private Integer idCidade;

	@Column(name = " complemento", nullable = false)
	private String complemento;

	@Column(name = " rua", nullable = false)
	private String rua;

	@Column(name = " cep", nullable = false)
	private Long cep;

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
	 * @return the complemento
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * @param complemento the complemento to set
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * @return the rua
	 */
	public String getRua() {
		return rua;
	}

	/**
	 * @param rua the rua to set
	 */
	public void setRua(String rua) {
		this.rua = rua;
	}

	/**
	 * @return the cep
	 */
	public Long getCep() {
		return cep;
	}

	/**
	 * @param cep the cep to set
	 */
	public void setCep(Long cep) {
		this.cep = cep;
	}

}
