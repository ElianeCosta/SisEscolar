package br.com.sisescolar.view.mantemaluno;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import br.com.sisescolar.fachada.dto.mantemaluno.ObtemDadosAlunoRetornoDTO;
import br.com.sisescolar.fachada.mantemaluno.IMantemAlunoFachada;
import br.com.sisescolar.fachada.mantemaluno.MantemAlunoFachada;
import br.com.sisescolar.view.SisEscolarBaseView;
import javax.swing.JTextField;
import java.awt.Font;

public class CadastroAlunoView extends SisEscolarBaseView {

	private static final long serialVersionUID = 8295478720567988352L;

	private JTextPane textIdAluno;
	private JTextPane textCpfAluno;
	private JTextPane textNomeAluno;
	private JTextPane textSexoAluno;
	private JTextPane textIdadeAluno;

	/** Mensagens negociasi **/

	/** Fachadas **/
	private IMantemAlunoFachada fachada;
	private JTextField textCidade;
	private JTextField textCpf;
	private JTextField textRua;
	private JTextField textComplemento;

	/**
	 * Create the frame.
	 * 
	 * @param idAluno2
	 */
	public CadastroAlunoView() {

		super("Cadastro Aluno");

		setResizable(false);

		JPanel painelFundo = new JPanel();
		painelFundo.setBorder(new EmptyBorder(5, 5, 5, 5));
		painelFundo.setLayout(null);

		JLabel lblIdAluno = new JLabel("IdAluno:");
		lblIdAluno.setBounds(10, 27, 46, 14);

		painelFundo.add(lblIdAluno);

		this.textIdAluno = new JTextPane();
		textIdAluno.setEnabled(false);
		this.textIdAluno.setBounds(58, 24, 61, 20);

		painelFundo.add(this.textIdAluno);

		JLabel lblCpfAluno = new JLabel("Cpf:");
		lblCpfAluno.setBounds(10, 58, 25, 14);

		painelFundo.add(lblCpfAluno);

		this.textCpfAluno = new JTextPane();
		this.textCpfAluno.setBounds(58, 55, 105, 20);

		painelFundo.add(this.textCpfAluno);

		JLabel lblNomeAluno = new JLabel("Nome:");
		lblNomeAluno.setBounds(10, 89, 41, 14);

		painelFundo.add(lblNomeAluno);

		this.textNomeAluno = new JTextPane();
		this.textNomeAluno.setBounds(58, 86, 215, 20);

		painelFundo.add(this.textNomeAluno);

		JLabel lblSexoAluno = new JLabel("Sexo:");
		lblSexoAluno.setBounds(10, 120, 41, 14);

		painelFundo.add(lblSexoAluno);

		this.textSexoAluno = new JTextPane();
		this.textSexoAluno.setBounds(58, 117, 25, 20);

		painelFundo.add(this.textSexoAluno);

		JLabel lblIdadeAluno = new JLabel("Idade:");
		lblIdadeAluno.setBounds(10, 151, 41, 14);

		painelFundo.add(lblIdadeAluno);

		this.textIdadeAluno = new JTextPane();
		this.textIdadeAluno.setBounds(58, 148, 70, 20);

		painelFundo.add(this.textIdadeAluno);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickBtnSalvar();

			}

		});
		btnSalvar.setBounds(111, 383, 89, 32);
		painelFundo.add(btnSalvar);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setBounds(100, 100, 320, 455);

		this.getContentPane().add(painelFundo);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(Boolean.FALSE);
			}
		});
		btnFechar.setBounds(203, 383, 89, 32);
		painelFundo.add(btnFechar);

		JLabel lblCidade = new JLabel("Nome Cidade:");
		lblCidade.setBounds(10, 333, 73, 20);
		painelFundo.add(lblCidade);

		textCidade = new JTextField();
		textCidade.setBounds(94, 333, 142, 20);
		painelFundo.add(textCidade);
		textCidade.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Rua:");
		lblNewLabel_1.setBounds(10, 248, 46, 14);
		painelFundo.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("idAluno:");
		lblNewLabel.setBounds(10, 199, 46, 14);
		painelFundo.add(lblNewLabel);

		textCpf = new JTextField();
		textCpf.setBounds(58, 220, 86, 20);
		painelFundo.add(textCpf);
		textCpf.setColumns(10);

		JLabel lblCep = new JLabel("Cep:");
		lblCep.setBounds(10, 224, 46, 14);
		painelFundo.add(lblCep);

		textRua = new JTextField();
		textRua.setBounds(58, 248, 86, 20);
		painelFundo.add(textRua);
		textRua.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Complemento:");
		lblNewLabel_2.setBounds(10, 279, 73, 14);
		painelFundo.add(lblNewLabel_2);

		textComplemento = new JTextField();
		textComplemento.setBounds(93, 276, 86, 20);
		painelFundo.add(textComplemento);
		textComplemento.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("IdCidade:");
		lblNewLabel_3.setBounds(10, 308, 52, 14);
		painelFundo.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Endereco:");
		lblNewLabel_4.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(10, 176, 61, 14);
		painelFundo.add(lblNewLabel_4);
	}

	/**
	 *
	 */
	public void abrirTela(Long idAluno, Boolean isVisualizacao) throws Exception {

		this.setVisible(Boolean.TRUE);

		if (idAluno != null) {

			this.fachada = new MantemAlunoFachada();

			this.preencherTelaCadastroAluno(idAluno, isVisualizacao);
		}
	}

	/**
	 *
	 */
	private void preencherTelaCadastroAluno(Long idAluno, Boolean isVisualizacao) {

		try {

			this.fachada = new MantemAlunoFachada();
			// Preencher os componentes da tela(sem ser em tabela).
			ObtemDadosAlunoRetornoDTO itemRetorno = this.fachada.obterDadosAluno(idAluno);
			// itemRetornoView.setIdAluno(itemRetorno.getIdAluno());
			this.textIdAluno.setText(itemRetorno.getIdAluno().toString());

			this.textCpfAluno.setText(itemRetorno.getCpf());
			this.textCpfAluno.setEnabled(!isVisualizacao);

			this.textNomeAluno.setText(itemRetorno.getNome());
			this.textNomeAluno.setEnabled(!isVisualizacao);

			this.textSexoAluno.setText(itemRetorno.getSexo());
			this.textSexoAluno.setEnabled(!isVisualizacao);

			this.textIdadeAluno.setText(itemRetorno.getIdadeAluno().toString());
			this.textIdadeAluno.setEnabled(!isVisualizacao);

		} catch (Exception e) {

			JOptionPane.showMessageDialog(this.textCpfAluno, e.getMessage());
		}
	}

	/**
	 *
	 */
	private void onClickBtnSalvar() {

		try {

			/*
			 * pegando dados preenchidos da tela preencherTelaCadastroAluno p/ser
			 * atualizados na dao itemParaSalva.setCpf(this.textCpfAluno.getText());
			 */
			ObtemDadosAlunoRetornoDTO itemParaSalva = new ObtemDadosAlunoRetornoDTO();

			if (this.textIdAluno.getText() != null && !this.textIdAluno.getText().equals("")) {

				itemParaSalva.setIdAluno(Long.valueOf(this.textIdAluno.getText()));
			}

			itemParaSalva.setCpf(this.textCpfAluno.getText());
			itemParaSalva.setNome(this.textNomeAluno.getText());
			itemParaSalva.setSexo(this.textSexoAluno.getText());

			if (this.textIdadeAluno.getText() != null && !this.textIdadeAluno.getText().equals("")) {

				itemParaSalva.setIdadeAluno(Integer.valueOf(this.textIdadeAluno.getText()));
			}

			this.fachada = new MantemAlunoFachada();

			if (itemParaSalva.getIdAluno() != null) {

				this.fachada.alterarAluno(itemParaSalva);
			} else {
				this.fachada.incluirAluno(itemParaSalva);
			}

			JOptionPane.showMessageDialog(this.textCpfAluno, "Operação realizada com sucesso!");
		} catch (Exception e) {

			JOptionPane.showMessageDialog(this.textCpfAluno, e.getMessage());
		}
	}

}
