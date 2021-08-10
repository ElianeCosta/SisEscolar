/**
 * 
 */
package br.com.sisescolar.negocio.servicos.ejb;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.lang.StringUtils;

import br.com.sisescolar.dto.mantemaluno.ConsultaAlunoFiltroDTO;
import br.com.sisescolar.dto.mantemaluno.ConsultaAlunoRetornoDTO;
import br.com.sisescolar.dto.mantemaluno.ObtemDadosAlunoRetornoDTO;
import br.com.sisescolar.entidades.mantemaluno.Aluno;
import br.com.sisescolar.entidades.mantemaluno.Endereco;
import br.com.sisescolar.infraestrutura.exception.SisEscolarNegocioException;
import br.com.sisescolar.negocio.servicos.MantemAlunoServico;
import br.com.sisescolar.persistencia.dao.MantemAlunoDao;
import br.com.sisescolar.persistencia.dao.impl.SisEscolarDaoFactory;

/**
 * @author Família
 *
 */
// Acabei mechendo sem querer talvez de erro
public class MantemAlunoServicoEJB extends SisEscolarBaseServicoEJB implements MantemAlunoServico {

	/** Mensagems Negociais. **/
	private static final String MSG001 = "%s é um campo de preenchimento obrigatório!";

	/**
	 *
	 */
	public List<ConsultaAlunoRetornoDTO> consultarAlunos(ConsultaAlunoFiltroDTO filtro)
			throws SisEscolarNegocioException {

		MantemAlunoDao dao = SisEscolarDaoFactory.getInstance().criarMantemAlunoDao();

		return dao.consultarAlunos(filtro);
	}

	/**
	 *
	 */
	public void excluirAluno(Long idAluno) throws SisEscolarNegocioException {

		// MantemAlunoDao dao =
		// SisEscolarDaoFactory.getInstance().criarMantemAlunoDao();

		// dao.excluirAluno(idAluno);
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emSisEscolar");

		EntityManager manager = factory.createEntityManager();

		Endereco aluno = manager.find(Endereco.class, idAluno);

		manager.getTransaction().begin();
		manager.remove(aluno);
		manager.getTransaction().commit();
	}

	/**
	 *
	 */

	public ObtemDadosAlunoRetornoDTO obterDadosAluno(Long idAluno) {

		MantemAlunoDao dao = SisEscolarDaoFactory.getInstance().criarMantemAlunoDao();

		return dao.obterDadosAluno(idAluno);
	}

	/**
	 *
	 */
	public void incluirAluno(ObtemDadosAlunoRetornoDTO itemParaSalva) throws SisEscolarNegocioException {

		// this.validarFormulario(itemParaSalva);

		// MantemAlunoDao dao =
		// SisEscolarDaoFactory.getInstance().criarMantemAlunoDao();

		// dao.incluirAluno(itemParaSalva);
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emSisEscolar");

		EntityManager manager = factory.createEntityManager();

		Aluno aluno = new Aluno();
		aluno.setIdAluno(itemParaSalva.getIdAluno());
		aluno.setIdadeAluno(itemParaSalva.getIdadeAluno());
		aluno.setCpf(itemParaSalva.getCpf());
		aluno.setNome(itemParaSalva.getNome());
		aluno.setSexo(itemParaSalva.getSexo());

		manager.getTransaction().begin();
		manager.persist(aluno);
		manager.getTransaction().commit();
	}

	/**
	 * @throws SisEscolarNegocioException
	 *
	 */
	public void alterarAluno(ObtemDadosAlunoRetornoDTO itemParaSalva) throws SisEscolarNegocioException {

		//this.validarFormulario(itemParaSalva);

		//MantemAlunoDao dao = SisEscolarDaoFactory.getInstance().criarMantemAlunoDao();

		//dao.alterarAluno(itemParaSalva);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emSisEscolar");

		EntityManager manager = factory.createEntityManager();

		Aluno aluno = new Aluno();
		aluno.setIdAluno(itemParaSalva.getIdAluno());
		aluno.setIdadeAluno(itemParaSalva.getIdadeAluno());
		aluno.setCpf(itemParaSalva.getCpf());
		aluno.setNome(itemParaSalva.getNome());
		aluno.setSexo(itemParaSalva.getSexo());

		manager.getTransaction().begin();
		manager.merge(aluno);
		manager.getTransaction().commit();
	}

	private void validarFormulario(ObtemDadosAlunoRetornoDTO itemParaSalva) throws SisEscolarNegocioException {

		if (StringUtils.isBlank(itemParaSalva.getCpf())) {

			throw new SisEscolarNegocioException(String.format(MSG001, "CPF"));
		}

		if (StringUtils.isBlank(itemParaSalva.getNome())) {

			throw new SisEscolarNegocioException(String.format(MSG001, "Nome"));
		}

		if (StringUtils.isBlank(itemParaSalva.getSexo())) {

			throw new SisEscolarNegocioException(String.format(MSG001, "Sexo"));
		}

		if (itemParaSalva.getIdadeAluno() == null) {

			throw new SisEscolarNegocioException(String.format(MSG001, "Idade"));
		}
	}

}
