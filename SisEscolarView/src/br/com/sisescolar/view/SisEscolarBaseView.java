package br.com.sisescolar.view;

import javax.swing.JFrame;

public abstract class SisEscolarBaseView extends JFrame {

	private static final long serialVersionUID = -6343909976845346241L;

	/** Componente da tela **/

	/** Mensagens negociasi **/
	protected static final String MSG001 = "Nenhum registro encontrado!";

	/** Fachadas **/
	
	public SisEscolarBaseView(String titulo) {

		super(titulo);
	}	
}
