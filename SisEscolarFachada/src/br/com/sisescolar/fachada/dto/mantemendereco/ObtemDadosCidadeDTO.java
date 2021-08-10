package br.com.sisescolar.fachada.dto.mantemendereco;

public class ObtemDadosCidadeDTO {
	private Integer idCidade;
	private String nomeCidade;
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

	public String toString() {
		return this.nomeCidade;
	}

	/**
	 * @param nomeCidade the nomeCidade to set
	 */
	public Integer getIdAluno() {
		return IdAluno;

	}

	public void setNomeIdAluno(Integer IdAluno) {
		this.IdAluno = IdAluno;
	}

}
