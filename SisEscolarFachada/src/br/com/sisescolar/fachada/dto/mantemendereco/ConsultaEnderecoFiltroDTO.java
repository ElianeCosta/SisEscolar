package br.com.sisescolar.fachada.dto.mantemendereco;

import java.io.Serializable;

public class ConsultaEnderecoFiltroDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6669569742823909960L;

	private String idaluno;
	private String idCidade;
	private String nomeCidade;
	private String cep;
	private String complemento;
	private String rua;

	/**
	 * @return the idaluno
	 */
	public String getIdAluno() {
		return idaluno;
	}

	/**
	 * @param idaluno the idaluno to set
	 */
	public void setIdAluno(String idaluno) {
		this.idaluno = idaluno;
	}

	/**
	 * @return the idCidade
	 */
	public String getIdCidade() {
		return idCidade;
	}

	/**
	 * @param idCidade the idCidade to set
	 */
	public void setIdCidade(String idCidade) {
		this.idCidade = idCidade;
	}

	/**
	 * @return the nomeCIdade
	 */
	public String getNomeCidade() {
		return nomeCidade;
	}

	/**
	 * @param nomeCIdade the nomeCIdade to set
	 */
	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public String getCep() {

		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {

		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getRua() {
		
		return rua;
	}
	public void setRua(String rua) {
		this.rua= rua;
	}

}
