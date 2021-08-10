/**
 * 
 */
package br.com.sisescolar.fachada.mantemaluno;

import java.util.List;

import br.com.sisescolar.fachada.dto.mantemaluno.ConsultaAlunoFiltroDTO;
import br.com.sisescolar.fachada.dto.mantemaluno.ConsultaAlunoRetornoDTO;
import br.com.sisescolar.fachada.dto.mantemaluno.ObtemDadosAlunoRetornoDTO;
import br.com.sisescolar.infraestrutura.exception.SisEscolarNegocioException;

/**
 * @author Família
 *
 */
public interface IMantemAlunoFachada extends ISisEscolarBaseFachada {

	/**
	 * 
	 * @param filtro
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */
	List<ConsultaAlunoRetornoDTO> consultarAlunos(ConsultaAlunoFiltroDTO filtro) throws Exception;

	/**
	 * 
	 * @param idAluno
	 * 
	 * @throws Exception
	 */
	void excluirAluno(Long idAluno) throws Exception;

	/**
	 * 
	 * @param idAluno
	 * 
	 * @throws Exception
	 */
	ObtemDadosAlunoRetornoDTO obterDadosAluno(Long idAluno) throws Exception;

	/**
	 * 
	 * @param idAluno
	 * @throws SisEscolarNegocioException 
	 * 
	 * @throws Exception
	 */
	void alterarAluno(ObtemDadosAlunoRetornoDTO itemParaSalva) throws Exception;

	/**
	 * 
	 * @param idAluno
	 * 
	 * @throws Exception
	 */
	void incluirAluno(ObtemDadosAlunoRetornoDTO itemParaSalva) throws Exception;

}
