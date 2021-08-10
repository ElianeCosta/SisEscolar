package br.com.sisescolar.fachada.mantemendereco;

import java.util.ArrayList;
import java.util.List;

import br.com.sisescolar.fachada.dto.mantemendereco.ConsultaEnderecoFiltroDTO;
import br.com.sisescolar.fachada.dto.mantemendereco.ConsultaEnderecoRetornoDTO;
import br.com.sisescolar.fachada.dto.mantemendereco.ObtemDadosCidadeDTO;
import br.com.sisescolar.fachada.dto.mantemendereco.ObtemDadosEnderecoDTO;
import br.com.sisescolar.fachada.mantemaluno.SisEscolarBaseFachada;
import br.com.sisescolar.infraestrutura.exception.SisEscolarNegocioException;
import br.com.sisescolar.negocio.servicos.ejb.MantemEnderecoServicoEJB;

public class MantemEnderecoFachada extends SisEscolarBaseFachada implements IMantemEnderecoFachada {

	/** ejb's **/
	private MantemEnderecoServicoEJB ejb;

	/**
	 *
	 */
	public List<ConsultaEnderecoRetornoDTO> consultarEndereco(ConsultaEnderecoFiltroDTO filtroView) throws Exception {

		List<ConsultaEnderecoRetornoDTO> itensRetornoView = new ArrayList<ConsultaEnderecoRetornoDTO>(0);

		br.com.sisescolar.dto.mantemEndereco.ConsultaEnderecoFiltroDTO filtro = new br.com.sisescolar.dto.mantemEndereco.ConsultaEnderecoFiltroDTO();

		filtro.setIdAluno(filtroView.getIdAluno());

		this.ejb = new MantemEnderecoServicoEJB();

		List<br.com.sisescolar.dto.mantemEndereco.ConsultaEnderecoRetornoDTO> itensRetornoEndereco = this.ejb
				.consultarEndereco(filtro);

		for (br.com.sisescolar.dto.mantemEndereco.ConsultaEnderecoRetornoDTO itemRetornoEndereco : itensRetornoEndereco) {

			ConsultaEnderecoRetornoDTO itemRetornoView = new ConsultaEnderecoRetornoDTO();

			itemRetornoView.setIdAluno(itemRetornoEndereco.getIdAluno());
			itemRetornoView.setIdCidade(itemRetornoEndereco.getIdCidade());
			itemRetornoView.setRua(itemRetornoEndereco.getRua());
			itemRetornoView.setComplemento(itemRetornoEndereco.getComplemento());
			itemRetornoView.setCep(itemRetornoEndereco.getCep());
			itemRetornoView.setNomeCidade(itemRetornoEndereco.getNomeCidade());

			itensRetornoView.add(itemRetornoView);
		}

		return itensRetornoView;
	}

	/**
	 * @throws SisEscolarNegocioException
	 *
	 */

	public ObtemDadosEnderecoDTO obterDadosEndereco(Long idAluno) throws Exception {

		this.ejb = new MantemEnderecoServicoEJB();

		br.com.sisescolar.dto.mantemEndereco.ObtemDadosEnderecoDTO itemRetorno = this.ejb.obterDadosEndereco(idAluno);

		ObtemDadosEnderecoDTO itemRetornoView = new ObtemDadosEnderecoDTO();

		itemRetornoView.setIdAluno(itemRetorno.getIdAluno());
		itemRetornoView.setIdCidade(itemRetorno.getIdCidade());
		//itemRetornoView.setNomeCidade(itemRetorno.getNomeCidade());
		itemRetornoView.setComplemento(itemRetorno.getComplemento());
		itemRetornoView.setRua(itemRetorno.getRua());
		itemRetornoView.setCep(itemRetorno.getCep());

		return itemRetornoView;
	}

	/**
	 * @throws SisEscolarNegocioException
	 *
	 */
	public void excluirEndereco(Long IdAluno) throws Exception {

		this.ejb = new MantemEnderecoServicoEJB();

		this.ejb.excluirEndereco(IdAluno);

	}

	/**
	 * @throws SisEscolarNegocioException
	 *
	 */

	@Override
	public void alterarEndereco(ObtemDadosEnderecoDTO itemParaSalva) throws Exception {

		br.com.sisescolar.dto.mantemEndereco.ObtemDadosEnderecoDTO itemParaSalvar = new br.com.sisescolar.dto.mantemEndereco.ObtemDadosEnderecoDTO();

		itemParaSalvar.setIdAluno(itemParaSalva.getIdAluno());
		itemParaSalvar.setIdCidade(itemParaSalva.getIdCidade());
		// itemParaSalvar.setNomeCidade(itemParaSalva.getNomeCidade());
		itemParaSalvar.setComplemento(itemParaSalva.getComplemento());
		itemParaSalvar.setRua(itemParaSalva.getRua());
		itemParaSalvar.setCep(itemParaSalva.getCep());

		this.ejb = new MantemEnderecoServicoEJB();

		this.ejb.alterarEndereco(itemParaSalvar);
	}

	/**
	 * @throws SisEscolarNegocioException
	 *
	 */

	@Override
	public void incluirEndereco(ObtemDadosEnderecoDTO itemParaSalva) throws Exception {

		br.com.sisescolar.dto.mantemEndereco.ObtemDadosEnderecoDTO itemParaSalvar = new br.com.sisescolar.dto.mantemEndereco.ObtemDadosEnderecoDTO();

		itemParaSalvar.setIdAluno(itemParaSalva.getIdAluno());
		itemParaSalvar.setIdCidade(itemParaSalva.getIdCidade());
		// itemParaSalvar.setNomeCidade(itemParaSalva.getNomeCidade());
		itemParaSalvar.setComplemento(itemParaSalva.getComplemento());
		itemParaSalvar.setRua(itemParaSalva.getRua());
		itemParaSalvar.setCep(itemParaSalva.getCep());

		this.ejb = new MantemEnderecoServicoEJB();

		this.ejb.incluirEndereco(itemParaSalvar);

	}

	/**
	 * @throws SisEscolarNegocioException
	 *
	 */

	public List<ObtemDadosCidadeDTO> preencherCombox() throws Exception {

		List<ObtemDadosCidadeDTO> itensRetornoView = new ArrayList<ObtemDadosCidadeDTO>(0);

		this.ejb = new MantemEnderecoServicoEJB();

		List<br.com.sisescolar.dto.mantemEndereco.ObtemDadosCidadeDTO> itensRetornoEndereco = this.ejb
				.preencherCombox();

		for (br.com.sisescolar.dto.mantemEndereco.ObtemDadosCidadeDTO itemRetornoEndereco : itensRetornoEndereco) {

			ObtemDadosCidadeDTO itemRetornoView = new ObtemDadosCidadeDTO();

			itemRetornoView.setIdCidade(itemRetornoEndereco.getIdCidade());
			itemRetornoView.setNomeCidade(itemRetornoEndereco.getNomeCidade());

			itensRetornoView.add(itemRetornoView);

		}

		return itensRetornoView;
	}

	/**
	 * @return
	 * @throws SisEscolarNegocioException
	 *
	 */
	@Override
	public void incluirCidade(ObtemDadosCidadeDTO itemSelecionado) throws Exception {

		br.com.sisescolar.dto.mantemEndereco.ObtemDadosCidadeDTO itemParaSalva = new br.com.sisescolar.dto.mantemEndereco.ObtemDadosCidadeDTO();

		itemParaSalva.setNomeCidade(itemSelecionado.getNomeCidade());

		this.ejb = new MantemEnderecoServicoEJB();

		this.ejb.incluirCidade(itemParaSalva);

	}

	public void alterarCidade(ObtemDadosCidadeDTO itemSelecionado) throws Exception {

		br.com.sisescolar.dto.mantemEndereco.ObtemDadosCidadeDTO itemParaSalvar = new br.com.sisescolar.dto.mantemEndereco.ObtemDadosCidadeDTO();

	    itemParaSalvar.setIdCidade(itemSelecionado.getIdCidade());

		itemParaSalvar.setNomeCidade(itemSelecionado.getNomeCidade());

		this.ejb = new MantemEnderecoServicoEJB();

		this.ejb.alterarCidade(itemParaSalvar);
	}

	@Override
	public void vizualizarCidade(ObtemDadosCidadeDTO itemSelecionado) {
		// TODO Auto-generated method stub

	}

}
