package br.com.sisescolar.view.mantemaluno;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.sisescolar.fachada.dto.mantemaluno.ConsultaAlunoFiltroDTO;
import br.com.sisescolar.fachada.dto.mantemaluno.ConsultaAlunoRetornoDTO;
import br.com.sisescolar.fachada.mantemaluno.IMantemAlunoFachada;
import br.com.sisescolar.fachada.mantemaluno.MantemAlunoFachada;
import br.com.sisescolar.view.SisEscolarBaseView;

public class ConsultaAlunoView extends SisEscolarBaseView {

	private static final long serialVersionUID = -7520643350620661036L;

	/** Componente da tela **/
	private JTextField textCpfAluno;
	private JTextField textNomeAluno;
	private DefaultTableModel defTableModel;
	private JButton btnVisualizar;
	private JButton btnExcluir;
	private JButton btnAlterar;
	private JTable tabela;

	/** Mensagens negociasi **/

	/** Fachadas **/
	private IMantemAlunoFachada fachada;

	private Component textIdAluno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		ConsultaAlunoView frame = new ConsultaAlunoView();
		frame.setVisible(Boolean.TRUE);
	}

	/**
	 * Create the frame.
	 */
	public ConsultaAlunoView() {

		super("Consultar Aluno");

		setResizable(false);

		JPanel painelFundo = new JPanel();
		painelFundo.setBorder(new EmptyBorder(5, 5, 5, 5));
		painelFundo.setLayout(null);

		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setBounds(10, 14, 31, 14);

		painelFundo.add(lblNewLabel);

		this.textCpfAluno = new JTextField();
		this.textCpfAluno.setBounds(51, 11, 86, 20);
		this.textCpfAluno.setColumns(10);

		painelFundo.add(this.textCpfAluno);

		JLabel label = new JLabel("Nome:");
		label.setBounds(10, 39, 37, 14);

		painelFundo.add(label);

		this.textNomeAluno = new JTextField();
		this.textNomeAluno.setColumns(10);
		this.textNomeAluno.setBounds(51, 36, 304, 20);

		painelFundo.add(this.textNomeAluno);

		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				onClikBtnProcurar();
			}
		});
		btnProcurar.setBounds(400, 35, 92, 23);

		painelFundo.add(btnProcurar);

		JLabel lblNewLabel_1 = new JLabel("Resultado da Pesquisa");
		lblNewLabel_1.setBounds(10, 64, 482, 14);

		painelFundo.add(lblNewLabel_1);

		String[] colunas = { "Id", "Cpf", "Nome", "Sexo" };

		this.defTableModel = new DefaultTableModel(null, colunas);

		tabela = new JTable(this.defTableModel);

		JScrollPane barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(21, 108, 471, 244);

		painelFundo.add(barraRolagem);

		JPanel barraBotoes = new JPanel();
		FlowLayout flowLayout = (FlowLayout) barraBotoes.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		barraBotoes.setBounds(10, 363, 482, 33);

		painelFundo.add(barraBotoes);

		this.btnVisualizar = new JButton("Visualizar");
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClikBtnVisualizar();
			}
		});
		this.btnVisualizar.setEnabled(false);
		barraBotoes.add(this.btnVisualizar);

		this.btnExcluir = new JButton("Excluir");
		this.btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClikBtnExcluir();
			}
		});
		this.btnExcluir.setEnabled(false);
		barraBotoes.add(this.btnExcluir);

		this.btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClikBtnAlterar();
			}
		});
		this.btnAlterar.setEnabled(false);
		barraBotoes.add(this.btnAlterar);

		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClikBtnIncluir();
			}
		});
		barraBotoes.add(btnIncluir);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(Boolean.FALSE);
			}
		});

		barraBotoes.add(btnFechar);

		tabela.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				btnVisualizar.setEnabled(Boolean.TRUE);
				btnExcluir.setEnabled(Boolean.TRUE);
				btnAlterar.setEnabled(Boolean.TRUE);
			}
		});

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setBounds(100, 100, 518, 446);

		this.getContentPane().add(painelFundo);
	}

	private void onClikBtnProcurar() {

		try {

			this.defTableModel.setRowCount(0);

			this.btnVisualizar.setEnabled(Boolean.FALSE);
			this.btnExcluir.setEnabled(Boolean.FALSE);
			this.btnAlterar.setEnabled(Boolean.FALSE);

			ConsultaAlunoFiltroDTO filtro = new ConsultaAlunoFiltroDTO();

			filtro.setCpf(this.textCpfAluno.getText());

			filtro.setNome(this.textNomeAluno.getText());

			this.fachada = new MantemAlunoFachada();

			List<ConsultaAlunoRetornoDTO> itensRetorno = this.fachada.consultarAlunos(filtro);

			if (itensRetorno.isEmpty()) {

				JOptionPane.showMessageDialog(this.textCpfAluno, MSG001);
			} else {

				Integer contador = 0;

				for (ConsultaAlunoRetornoDTO itemRetorno : itensRetorno) {
					// Preenchimento da tela em forma de tabela.
					String[] item = { itemRetorno.getIdAluno().toString(), itemRetorno.getCpf().toString(),
							itemRetorno.getNome(), itemRetorno.getSexo() };

					defTableModel.insertRow(contador, item);

					contador++;
				}
			}
		} catch (Exception e) {

			JOptionPane.showMessageDialog(this.textCpfAluno, e.getMessage());
		}
	}

	/**
	 * 
	 * 
	 * 
	 */
	private void onClikBtnExcluir() {

		try {

			Integer linhaSelecionada = this.tabela.getSelectedRow();

			Long idAluno = Long.valueOf(this.tabela.getValueAt(linhaSelecionada, 0).toString());

			this.fachada = new MantemAlunoFachada();
			this.fachada.excluirAluno(idAluno);

			this.onClikBtnProcurar();
		} catch (Exception e) {

			JOptionPane.showMessageDialog(this.textCpfAluno, e.getMessage());
		}
	}

	/**
	 * 
	 * 
	 * 
	 */
	private void onClikBtnAlterar() {

		try {

			Integer linhaSelecionada = this.tabela.getSelectedRow();

			Long idAluno = Long.valueOf(this.tabela.getValueAt(linhaSelecionada, 0).toString());

			CadastroAlunoView frame = new CadastroAlunoView();
			frame.abrirTela(idAluno, Boolean.FALSE);
		} catch (Exception e) {

			JOptionPane.showMessageDialog(this.textIdAluno, e.getMessage());
		}
	}

	/**
	 * 
	 * 
	 * 
	 */
	private void onClikBtnVisualizar() {

		try {

			Integer linhaSelecionada = this.tabela.getSelectedRow();

			Long idAluno = Long.valueOf(this.tabela.getValueAt(linhaSelecionada, 0).toString());

			CadastroAlunoView frame = new CadastroAlunoView();
			frame.abrirTela(idAluno, Boolean.TRUE);
		} catch (Exception e) {

			JOptionPane.showMessageDialog(this.textIdAluno, e.getMessage());
		}
	}

	private void onClikBtnIncluir() {
		CadastroAlunoView frame = new CadastroAlunoView();

		frame.setVisible(Boolean.TRUE);

	}
}