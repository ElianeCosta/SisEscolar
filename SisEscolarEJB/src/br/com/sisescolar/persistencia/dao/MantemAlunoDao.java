/**
 * 
 */
package br.com.sisescolar.persistencia.dao;

import java.util.List;

import br.com.sisescolar.dto.mantemaluno.ConsultaAlunoFiltroDTO;
import br.com.sisescolar.dto.mantemaluno.ConsultaAlunoRetornoDTO;
import br.com.sisescolar.dto.mantemaluno.ObtemDadosAlunoRetornoDTO;

/**
 * @author Fam�lia
 *
 */
public interface MantemAlunoDao extends SisEscolarBaseDao {

	/**
	 * 
	 * 
	 * @param filtro
	 * @return
	 */
	List<ConsultaAlunoRetornoDTO> consultarAlunos(ConsultaAlunoFiltroDTO filtro);

	/**
	 * 
	 * @param idAluno
	 */
	void excluirAluno(Long idAluno);

	/**
	 * 
	 * @param idAluno
	 * 
	 * @return
	 */
	ObtemDadosAlunoRetornoDTO obterDadosAluno(Long idAluno);
	/**
	 * 
	 * @param idAluno
	 * 
	 * @return
	 */
	void alterarAluno(ObtemDadosAlunoRetornoDTO itemParaSalva);
	
	/**
	 * 
	 * @param idAluno
	 * 
	 * @return
	 */
	void incluirAluno(ObtemDadosAlunoRetornoDTO itemParaSalva);


}
