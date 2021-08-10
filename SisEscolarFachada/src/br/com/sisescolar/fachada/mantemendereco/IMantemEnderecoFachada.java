package br.com.sisescolar.fachada.mantemendereco;

import java.util.List;

import br.com.sisescolar.fachada.dto.mantemendereco.ConsultaEnderecoFiltroDTO;
import br.com.sisescolar.fachada.dto.mantemendereco.ConsultaEnderecoRetornoDTO;
import br.com.sisescolar.fachada.dto.mantemendereco.ObtemDadosCidadeDTO;
import br.com.sisescolar.fachada.dto.mantemendereco.ObtemDadosEnderecoDTO;

public interface IMantemEnderecoFachada extends ISisEscolarBaseEnderecoFachada {
	/**
	 * 
	 * @param filtro
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */
	List<ConsultaEnderecoRetornoDTO> consultarEndereco(ConsultaEnderecoFiltroDTO filtro) throws Exception;

	/**
	 * 
	 * @param filtro
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */
	void excluirEndereco(Long IdAluno) throws Exception;

	/**
	 * 
	 * @param filtro
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */

	ObtemDadosEnderecoDTO obterDadosEndereco(Long idAluno) throws Exception;

	/**
	 * 
	 * @param filtro
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */

	void alterarEndereco(ObtemDadosEnderecoDTO itemParaSalva) throws Exception;

	/**
	 * 
	 * @param filtro
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */

	void incluirEndereco(ObtemDadosEnderecoDTO itemParaSalva) throws Exception;

	/**
	 * 
	 * 
	 * @param filtro
	 * @return
	 */
	List<ObtemDadosCidadeDTO> preencherCombox() throws Exception;

	/**
	 * 
	 * 
	 * @param filtro
	 * @return
	 */

	void incluirCidade(ObtemDadosCidadeDTO itemSelecionado) throws Exception;

	/**
	 * 
	 * 
	 * @param filtro
	 * @return
	 */

	void alterarCidade(ObtemDadosCidadeDTO itemSelecionado) throws Exception;
	
	/**
	 * 
	 * 
	 * @param filtro
	 * @return
	 */
	void vizualizarCidade(ObtemDadosCidadeDTO itemSelecionado) throws Exception;

}
