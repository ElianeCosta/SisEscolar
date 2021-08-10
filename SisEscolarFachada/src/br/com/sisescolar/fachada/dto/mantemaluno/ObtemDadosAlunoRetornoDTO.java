package br.com.sisescolar.fachada.dto.mantemaluno;

import java.io.Serializable;

public class ObtemDadosAlunoRetornoDTO extends ConsultaAlunoRetornoDTO implements Serializable {

	private static final long serialVersionUID = 3629151744375394521L;
	
	private Integer idadeAluno;

	/**
	 * @return the idadeAluno
	 */
	public Integer getIdadeAluno() {
		return idadeAluno;
	}

	/**
	 * @param idadeAluno the idadeAluno to set
	 */
	public void setIdadeAluno(Integer idadeAluno) {
		this.idadeAluno = idadeAluno;
	}
}
