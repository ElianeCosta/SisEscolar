package br.com.sisescolar.viewmantemendereco;

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

import br.com.sisescolar.fachada.dto.mantemendereco.ConsultaEnderecoFiltroDTO;
import br.com.sisescolar.fachada.dto.mantemendereco.ConsultaEnderecoRetornoDTO;
import br.com.sisescolar.fachada.mantemendereco.IMantemEnderecoFachada;
import br.com.sisescolar.fachada.mantemendereco.MantemEnderecoFachada;
import br.com.sisescolar.view.SisEscolarBaseView;

public class ConsultaEnderecoView extends SisEscolarBaseView {

	/**
	 * 
	 */
	private static final long serialVersionUID = -804127239715659037L;
	/**
	 * 
	 */

	private JPanel contentPane;
	private JTextField textIdAluno;
	private JTextField textNomeCidade;
	private DefaultTableModel defTableModel;
	private JTable tabela;
	private JButton btnVisualizar;
	private JButton btnExcluir;
	private JButton btnAlterar;

	/**
	 * Launch the application.
	 */

	private IMantemEnderecoFachada fachada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		ConsultaEnderecoView frame = new ConsultaEnderecoView();
		frame.setVisible(Boolean.TRUE);

	}

	/**
	 * Create the frame.
	 */
	public ConsultaEnderecoView() {
		super("Consultar Endereco:");
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("IdAluno:");
		lblNewLabel.setBounds(10, 11, 63, 14);
		contentPane.add(lblNewLabel);

		this.textIdAluno = new JTextField();
		this.textIdAluno.setBounds(85, 8, 95, 23);
		contentPane.add(this.textIdAluno);
		this.textIdAluno.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("NomeCidade:");
		lblNewLabel_1.setBounds(10, 45, 89, 14);
		contentPane.add(lblNewLabel_1);

		this.textNomeCidade = new JTextField();
		this.textNomeCidade.setBounds(86, 39, 197, 23);

		contentPane.add(this.textNomeCidade);
		this.textNomeCidade.setColumns(10);

		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onclickProcurar();
			}

		});
		btnProcurar.setBounds(400, 42, 95, 23);
		contentPane.add(btnProcurar);

		JLabel lblNewLabel_2 = new JLabel("Resultado Da Pesquisa:");
		lblNewLabel_2.setBounds(10, 76, 144, 14);

		contentPane.add(lblNewLabel_2);

		String[] colunas = { "IdAluno", "IdCidade", "cep", "Rua", "Complemento", "NomeCidade" };

		this.defTableModel = new DefaultTableModel(null, colunas);
		this.tabela = new JTable(this.defTableModel);

		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(10, 102, 485, 239);

		contentPane.add(scrollPane);

		this.btnVisualizar = new JButton("Vizualizar");
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onclickVisualizar();
		}

});
		
		btnVisualizar.setEnabled(false);
		this.btnVisualizar.setBounds(85, 352, 89, 23);

		contentPane.add(this.btnVisualizar);

		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onclickBtnIncluir();

			}
		});
		btnIncluir.setBounds(178, 352, 73, 23);
		contentPane.add(btnIncluir);

		JButton btnNewButton = new JButton("Fechar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(Boolean.FALSE);

			}

		});
		tabela.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				btnVisualizar.setEnabled(Boolean.TRUE);
				btnExcluir.setEnabled(Boolean.TRUE);
				btnAlterar.setEnabled(Boolean.TRUE);
			}
		});
		btnNewButton.setBounds(415, 352, 80, 23);
		contentPane.add(btnNewButton);

		this.btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onCLickbtnAlterar();

			}

		});
		this.btnAlterar.setBounds(252, 352, 80, 23);
		contentPane.add(this.btnAlterar);

		this.btnExcluir = new JButton("Excluir");
		this.btnExcluir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				onclickExcluir();
			}

		});
		this.btnExcluir.setBounds(326, 352, 89, 23);
		contentPane.add(this.btnExcluir);
	}

	/**
	 * 
	 * 
	 * 
	 */
	private void onclickProcurar() {

		try {

			this.defTableModel.setRowCount(0);

			this.btnVisualizar.setEnabled(Boolean.FALSE);
			this.btnExcluir.setEnabled(Boolean.FALSE);
			this.btnAlterar.setEnabled(Boolean.FALSE);

			ConsultaEnderecoFiltroDTO filtro = new ConsultaEnderecoFiltroDTO();
			filtro.setNomeCidade(this.textNomeCidade.getText());

			this.fachada = new MantemEnderecoFachada();

			List<ConsultaEnderecoRetornoDTO> itensRetornoEndereco = this.fachada.consultarEndereco(filtro);

			if (itensRetornoEndereco.isEmpty()) {

				JOptionPane.showMessageDialog(this.textNomeCidade, MSG001);
			} else {

				Integer contador = 0;

				for (ConsultaEnderecoRetornoDTO itemRetornoEndereco : itensRetornoEndereco) {
					// Preenchimento da tela em forma de tabela.
					String[] item = { itemRetornoEndereco.getIdAluno().toString(),
							itemRetornoEndereco.getIdCidade().toString(), itemRetornoEndereco.getCep().toString(),
							itemRetornoEndereco.getRua(), itemRetornoEndereco.getComplemento(),
							itemRetornoEndereco.getNomeCidade() };

					defTableModel.insertRow(contador, item);

					contador++;
				}
			}
		} catch (Exception e) {

			JOptionPane.showMessageDialog(this.textNomeCidade, e.getMessage());
		}
	}

	private void onclickExcluir() {

		try {

			Integer linhaSelecionada = this.tabela.getSelectedRow();
			Long idAluno = Long.valueOf(this.tabela.getValueAt(linhaSelecionada, 0).toString());

			this.fachada = new MantemEnderecoFachada();
			this.fachada.excluirEndereco(idAluno);

			this.onclickProcurar();

		} catch (Exception e) {

			JOptionPane.showMessageDialog(this.textNomeCidade, e.getMessage());
		}
	}

	/**
	 * 
	 * 
	 * 
	 */
	private void onclickVisualizar() {

		try {
			
			Integer linhaSelecionada = this.tabela.getSelectedRow();
			Long idAluno = Long.valueOf(this.tabela.getValueAt(linhaSelecionada, 0).toString());

			this.fachada = new MantemEnderecoFachada();

			CadastroEnderecoView frame = new CadastroEnderecoView();

			frame.abrirTela(idAluno, Boolean.TRUE);

			this.onclickProcurar();

		} catch (Exception e) {

			JOptionPane.showMessageDialog(this.textNomeCidade, e.getMessage());
		}
	}

	/**
	 * 
	 * 
	 * 
	 */
	protected void onclickBtnIncluir() {

		try {

			this.fachada = new MantemEnderecoFachada();

			CadastroEnderecoView frame = new CadastroEnderecoView();

			frame.setVisible(Boolean.TRUE);

		} catch (Exception e) {

			JOptionPane.showMessageDialog(this.textNomeCidade, e.getMessage());
		}

	}

	/**
	 * 
	 * 
	 * 
	 */
private void onCLickbtnAlterar() {

		try {
			this.fachada = new MantemEnderecoFachada();
			Integer linhaSelecionada = this.tabela.getSelectedRow();

			Long idAluno = Long.valueOf(this.tabela.getValueAt(linhaSelecionada, 0).toString());

			CadastroEnderecoView frame = new CadastroEnderecoView();

			frame.abrirTela(idAluno, Boolean.FALSE);

		} catch (Exception e) {

			JOptionPane.showMessageDialog(this.textNomeCidade, e.getMessage());
		}

}
}
	
	
