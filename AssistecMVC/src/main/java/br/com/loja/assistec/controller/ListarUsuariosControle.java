package br.com.loja.assistec.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import br.com.loja.assistec.model.Usuario;
import br.com.loja.assistec.view.ListarUsuariosView;

public class ListarUsuariosControle {
	private ListarUsuariosView luv;

	public ListarUsuariosControle() {
		this.luv = new ListarUsuariosView();
		luv.setLocationRelativeTo(null);
		luv.setVisible(true);
		configurarListeners();
	}

	private class ListarUsuariosListner implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String comando = e.getActionCommand();

			switch (comando) {
			case "btFechar":
				luv.dispose();
				break;
			case "btCadastrar":
//				abrirCAdastroUsuario(null);
				break;
			}
		}
	}
	
	private void configurarListeners() {
		luv.addListarUsuariosListener(new ListarUsuariosListner());
		luv.addWindowListener(new JanelaAberturaListner());
	}

	public void abrirCAdastroUsuario(Usuario user) {
//		new CadastrarUsuarioControle(this,user);
	}
	
	private class JanelaAberturaListner extends WindowAdapter{
		public void WindowOpened(WindowEvent e) {
//			carregarUsuarios();
		}
	}

}