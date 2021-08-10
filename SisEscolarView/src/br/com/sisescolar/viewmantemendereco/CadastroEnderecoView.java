package br.com.sisescolar.viewmantemendereco;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.sisescolar.fachada.dto.mantemendereco.ObtemDadosCidadeDTO;
import br.com.sisescolar.fachada.dto.mantemendereco.ObtemDadosEnderecoDTO;
import br.com.sisescolar.fachada.mantemendereco.IMantemEnderecoFachada;
import br.com.sisescolar.fachada.mantemendereco.MantemEnderecoFachada;
import br.com.sisescolar.view.SisEscolarBaseView;

public class CadastroEnderecoView extends SisEscolarBaseView {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4548775279538427649L;

	private JTextField textIdAluno;
	private JTextField textComplemento;
	private JTextField textRua;
	private JTextField textCep;

	private JComboBox<ObtemDadosCidadeDTO> comboCidade;

	/**
	 * Launch the application.
	 */

	private IMantemEnderecoFachada fachada;

	private Component textNomeCidade;

	/**
	 * Create the frame.
	 */
	public CadastroEnderecoView() {
		super("Consulta Endereco ");
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 381, 258);
		getContentPane().setLayout(null);

		JLabel lblIdAluno = new JLabel("idAluno:");
		lblIdAluno.setBounds(10, 11, 46, 14);

		getContentPane().add(lblIdAluno);

		this.textIdAluno = new JTextField();
		textIdAluno.setEnabled(false);
		this.textIdAluno.setBounds(95, 8, 131, 20);

		getContentPane().add(this.textIdAluno);
		this.textIdAluno.setColumns(10);

		JLabel lblNomeCidade = new JLabel("NomeCidade:");
		lblNomeCidade.setBounds(10, 39, 82, 14);

		getContentPane().add(lblNomeCidade);

		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(10, 64, 82, 14);

		getContentPane().add(lblComplemento);

		this.textComplemento = new JTextField();
		this.textComplemento.setBounds(95, 61, 228, 20);
		getContentPane().add(this.textComplemento);

		this.textComplemento.setColumns(10);

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(10, 89, 46, 14);

		getContentPane().add(lblRua);

		this.textRua = new JTextField();
		this.textRua.setBounds(95, 86, 228, 20);
		getContentPane().add(this.textRua);

		this.textRua.setColumns(10);

		JLabel lbllCep = new JLabel("Cep:");
		lbllCep.setBounds(10, 156, 46, 14);

		this.textCep = new JTextField();
		this.textCep.setBounds(95, 123, 131, 20);
		getContentPane().add(this.textCep);

		this.textCep.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickBtnSalvar();
			}
		});
		btnSalvar.setBounds(177, 190, 89, 23);

		getContentPane().add(btnSalvar);

		JButton btnFEchar = new JButton("Fechar");
		btnFEchar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(Boolean.FALSE);
			}
		});
		btnFEchar.setBounds(276, 190, 89, 23);

		getContentPane().add(btnFEchar);

		comboCidade = new JComboBox<ObtemDadosCidadeDTO>();

		comboCidade.setBounds(95, 36, 129, 20);

		getContentPane().add(comboCidade);

		JLabel lblCep = new JLabel("Cep:");
		lblCep.setBounds(10, 129, 46, 14);
		getContentPane().add(lblCep);

		/*
		 * JButton btnSalvarCombobox = new JButton("Salvar");
		 * btnSalvarCombobox.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { onClickSalvar(); } });
		 * btnSalvarCombobox.setBounds(234, 65, 89, 23);
		 * getContentPane().add(btnSalvarCombobox);
		 */
	}

	/**
	 * 
	 * @param filtro
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */

	public void abrirTela(Long idAluno, Boolean isVisualizacao) {

		this.setVisible(Boolean.TRUE);

		this.carregaCombox();

		if (idAluno != null) {

			this.fachada = new MantemEnderecoFachada();

			this.preencherTelaEndereco(idAluno, isVisualizacao);
		}
	}

	/**
	 * 
	 * @param filtro
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */
	private void preencherTelaEndereco(Long idAluno, Boolean isVisualizacao) {

		try {
			this.carregaCombox();
			this.fachada = new MantemEnderecoFachada();

			ObtemDadosEnderecoDTO itemRetorno = this.fachada.obterDadosEndereco(idAluno);

			this.textIdAluno.setText(itemRetorno.getIdAluno().toString());

			ObtemDadosCidadeDTO cidadeSelecionada = new ObtemDadosCidadeDTO();
			cidadeSelecionada.setIdCidade(itemRetorno.getIdCidade());

			for (int i = 0; i < this.comboCidade.getItemCount(); i++) {

				ObtemDadosCidadeDTO item = (ObtemDadosCidadeDTO) this.comboCidade.getItemAt(i);

				if (item.getIdCidade().equals(cidadeSelecionada.getIdCidade())) {

					this.comboCidade.setSelectedIndex(i);
					break;
				}
			}

			this.comboCidade.setEditable(Boolean.TRUE);

			this.textComplemento.setText(itemRetorno.getComplemento());
			this.textComplemento.setEnabled(!isVisualizacao);

			this.textRua.setText(itemRetorno.getRua());
			this.textRua.setEnabled(!isVisualizacao);

			this.textCep.setText(itemRetorno.getCep().toString());
			this.textCep.setEnabled(!isVisualizacao);

		} catch (Exception e) {

			JOptionPane.showMessageDialog(this.textIdAluno, e.getMessage());

		}
	}

	/**
	 * 
	 * @param filtro
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */
	private void onClickBtnSalvar() {

		try {

			// pegando dados preenchidos da tela preencherTelaCadastroAluno p/ser salvos na
			// dao

			ObtemDadosEnderecoDTO itemParaSalva = new ObtemDadosEnderecoDTO();

			if (this.textIdAluno.getText() != null && !this.textIdAluno.getText().equals("")) {

				itemParaSalva.setIdAluno(Long.valueOf(this.textIdAluno.getText()));
			}

			if (this.comboCidade.getSelectedIndex() != 0) {

				ObtemDadosCidadeDTO cidadeSelecionada = (ObtemDadosCidadeDTO) this.comboCidade.getSelectedItem();

				itemParaSalva.setIdCidade(cidadeSelecionada.getIdCidade());
			}

			itemParaSalva.setComplemento(this.textComplemento.getText());

			itemParaSalva.setComplemento(this.textComplemento.getText());
			itemParaSalva.setRua(this.textRua.getText());
			itemParaSalva.setCep(Long.valueOf(this.textCep.getText()));

			if (this.textCep.getText() != null && !this.textCep.getText().equals("")) {

				itemParaSalva.setCep(Long.valueOf(this.textCep.getText()));
			}

			this.fachada = new MantemEnderecoFachada();

			if (itemParaSalva.getIdAluno() != null) {

				this.fachada.alterarEndereco(itemParaSalva);
			} else {
				this.fachada.incluirEndereco(itemParaSalva);

			}

			JOptionPane.showMessageDialog(this.textIdAluno, "Operação realizada com sucesso!");
		} catch (Exception e) {

			JOptionPane.showMessageDialog(this.textIdAluno, e.getMessage());
		}
	}

	/**
	 * 
	 * @param filtro
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */
	private void carregaCombox() {

		try {
			this.onClickBtnSalvar();
			this.fachada = new MantemEnderecoFachada();

			List<ObtemDadosCidadeDTO> itensRetorno = this.fachada.preencherCombox();

			ObtemDadosCidadeDTO itemOpcional = new ObtemDadosCidadeDTO();
			itemOpcional.setIdCidade(-1);
			itemOpcional.setNomeCidade("Selecione");

			DefaultComboBoxModel<ObtemDadosCidadeDTO> modelComboCategorias = new DefaultComboBoxModel<ObtemDadosCidadeDTO>();
			modelComboCategorias.addElement(itemOpcional);

			for (ObtemDadosCidadeDTO itemRetornoEndereco : itensRetorno) {

				modelComboCategorias.addElement(itemRetornoEndereco);
			}

			this.comboCidade.setModel(modelComboCategorias);

		} catch (Exception e) {

			JOptionPane.showMessageDialog(this.textNomeCidade, e.getMessage());
		}
	}

	/**
	 * 
	 * @param filtro
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */
	public void salvarcombox() {

		try {

			this.onClickBtnSalvar();

			this.fachada = new MantemEnderecoFachada();

			ObtemDadosCidadeDTO itemSelecionado = (ObtemDadosCidadeDTO) comboCidade.getSelectedItem();

			itemSelecionado.getIdCidade();
			itemSelecionado.getNomeCidade();

			if (itemSelecionado.getIdAluno() != null) {

				this.fachada.alterarCidade(itemSelecionado);
			} else {

				this.fachada.incluirCidade(itemSelecionado);
			}

		} catch (Exception e) {

			JOptionPane.showMessageDialog(this.textNomeCidade, e.getMessage());

		}
	}

	/**
	 * 
	 * @param filtro
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */
	public void vizualizarCombox() {

		try {

			this.fachada = new MantemEnderecoFachada();

			ObtemDadosCidadeDTO itemSelecionado = (ObtemDadosCidadeDTO) comboCidade.getSelectedItem();

			itemSelecionado.getIdCidade();

			this.fachada.vizualizarCidade(itemSelecionado);

		} catch (

		Exception e) {

			JOptionPane.showMessageDialog(this.textNomeCidade, e.getMessage());

		}
	}
}

/**
 * 
 * @param filtro
 * 
 * @return
 * 
 * @throws Exception
 */
