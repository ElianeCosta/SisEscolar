/**
 * 
 */
package br.com.sisescolar.fachada.mantemaluno;

import java.util.ArrayList;
import java.util.List;

import br.com.sisescolar.fachada.dto.mantemaluno.ConsultaAlunoFiltroDTO;
import br.com.sisescolar.fachada.dto.mantemaluno.ConsultaAlunoRetornoDTO;
import br.com.sisescolar.fachada.dto.mantemaluno.ObtemDadosAlunoRetornoDTO;
import br.com.sisescolar.infraestrutura.exception.SisEscolarNegocioException;
import br.com.sisescolar.negocio.servicos.MantemAlunoServico;
import br.com.sisescolar.negocio.servicos.ejb.MantemAlunoServicoEJB;

/**
 * @author Família
 *
 */
public class MantemAlunoFachada extends SisEscolarBaseFachada implements IMantemAlunoFachada {

	/** ejb's **/
	private MantemAlunoServico ejb;

	/**
	 *
	 */
	public List<ConsultaAlunoRetornoDTO> consultarAlunos(ConsultaAlunoFiltroDTO filtroView) throws Exception {

		List<ConsultaAlunoRetornoDTO> itensRetornoView = new ArrayList<ConsultaAlunoRetornoDTO>(0);

		br.com.sisescolar.dto.mantemaluno.ConsultaAlunoFiltroDTO filtro = new br.com.sisescolar.dto.mantemaluno.ConsultaAlunoFiltroDTO();

		filtro.setCpf(filtroView.getCpf());

		filtro.setNome(filtroView.getNome());

		this.ejb = new MantemAlunoServicoEJB();

		List<br.com.sisescolar.dto.mantemaluno.ConsultaAlunoRetornoDTO> itensRetorno = this.ejb.consultarAlunos(filtro);

		for (br.com.sisescolar.dto.mantemaluno.ConsultaAlunoRetornoDTO itemRetorno : itensRetorno) {

			ConsultaAlunoRetornoDTO itemRetornoView = new ConsultaAlunoRetornoDTO();
			itemRetornoView.setIdAluno(itemRetorno.getIdAluno());
			itemRetornoView.setCpf(itemRetorno.getCpf());
			itemRetornoView.setNome(itemRetorno.getNome());
			itemRetornoView.setSexo(itemRetorno.getSexo());

			itensRetornoView.add(itemRetornoView);
		}

		return itensRetornoView;
	}

	/**
	 *
	 */
	public void excluirAluno(Long idAluno) throws Exception {

		this.ejb = new MantemAlunoServicoEJB();

		this.ejb.excluirAluno(idAluno);

	}

	/**
	 *
	 */
	public ObtemDadosAlunoRetornoDTO obterDadosAluno(Long idAluno) {

		this.ejb = new MantemAlunoServicoEJB();

		br.com.sisescolar.dto.mantemaluno.ObtemDadosAlunoRetornoDTO itemRetorno = this.ejb.obterDadosAluno(idAluno);

		ObtemDadosAlunoRetornoDTO itemRetornoView = new ObtemDadosAlunoRetornoDTO();
		itemRetornoView.setIdAluno(itemRetorno.getIdAluno());
		itemRetornoView.setCpf(itemRetorno.getCpf());
		itemRetornoView.setNome(itemRetorno.getNome());
		itemRetornoView.setSexo(itemRetorno.getSexo());
		itemRetornoView.setIdadeAluno(itemRetorno.getIdadeAluno());

		return itemRetornoView;
	}

	/**
	 * @return
	 *
	 */
	public ObtemDadosAlunoRetornoDTO onClickbtnSalvar(Long idAluno) {

		this.ejb = new MantemAlunoServicoEJB();

		br.com.sisescolar.dto.mantemaluno.ObtemDadosAlunoRetornoDTO itemRetorno = this.ejb.obterDadosAluno(idAluno);

		ObtemDadosAlunoRetornoDTO itemRetornoView = new ObtemDadosAlunoRetornoDTO();

		itemRetornoView.setIdAluno(itemRetorno.getIdAluno());
		itemRetornoView.setCpf(itemRetorno.getCpf());
		itemRetornoView.setNome(itemRetorno.getNome());
		itemRetornoView.setSexo(itemRetorno.getSexo());
		itemRetornoView.setIdadeAluno(itemRetorno.getIdadeAluno());

		return itemRetornoView;
	}

	public void alterarAluno(ObtemDadosAlunoRetornoDTO itemParaSalvaVeiw) throws SisEscolarNegocioException {
		// itemParaSalvaView campos trazidos da view
		// itemParaSalva campos trazidos da ejb
		// item vindo do ejb itemParaSalva.setIdAluno//item pego da
		// view(itemParaSalvaView.getIdAluno());

		br.com.sisescolar.dto.mantemaluno.ObtemDadosAlunoRetornoDTO itemParaSalvar = new br.com.sisescolar.dto.mantemaluno.ObtemDadosAlunoRetornoDTO();
		itemParaSalvar.setIdAluno(itemParaSalvaVeiw.getIdAluno());
		itemParaSalvar.setCpf(itemParaSalvaVeiw.getCpf());
		itemParaSalvar.setNome(itemParaSalvaVeiw.getNome());
		itemParaSalvar.setSexo(itemParaSalvaVeiw.getSexo());
		itemParaSalvar.setIdadeAluno(itemParaSalvaVeiw.getIdadeAluno());

		this.ejb = new MantemAlunoServicoEJB();

		this.ejb.alterarAluno(itemParaSalvar);
	}

	/**
	 * @return
	 * @throws SisEscolarNegocioException
	 *
	 */
	public void incluirAluno(ObtemDadosAlunoRetornoDTO itemParaSalva) throws Exception {
		br.com.sisescolar.dto.mantemaluno.ObtemDadosAlunoRetornoDTO itemParaSalvar = new br.com.sisescolar.dto.mantemaluno.ObtemDadosAlunoRetornoDTO();
		itemParaSalvar.setIdAluno(itemParaSalva.getIdAluno());
		itemParaSalvar.setCpf(itemParaSalva.getCpf());
		itemParaSalvar.setNome(itemParaSalva.getNome());
		itemParaSalvar.setSexo(itemParaSalva.getSexo());
		itemParaSalvar.setIdadeAluno(itemParaSalva.getIdadeAluno());

		this.ejb = new MantemAlunoServicoEJB();

		this.ejb.incluirAluno(itemParaSalvar);
	}

}
