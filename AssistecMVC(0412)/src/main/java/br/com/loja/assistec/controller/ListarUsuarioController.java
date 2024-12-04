package br.com.loja.assistec.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.loja.assistec.model.Usuario;
import br.com.loja.assistec.model.UsuarioDAO;
import br.com.loja.assistec.view.ListarUsuariosView;
import br.com.loja.assistec.view.MensagemView;

public class ListarUsuarioController {
	private ListarUsuariosView listarView;
	
	public ListarUsuarioController() {
		listarView = new ListarUsuariosView();
		listarView.setLocationRelativeTo(null);
		listarView.setVisible(true);
		configurarListeners();
		carregarUsuarios();
	}
	
	public void configurarListeners() {
		listarView.addListarUsuariosListener(new ListarUsuariosListener());
		listarView.addWindowListener(new JanelaAberturaListener());
		listarView.addTabelaMouseListener(new TabelaMouseClickListener());
	}

	public void carregarUsuarios() {
		ArrayList<Usuario> listaUsuarios;
		try {
			listaUsuarios = listarUsuario();
			if(!listaUsuarios.isEmpty()) {
				listarView.mostrarUsuariosTabela(listaUsuarios);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			new MensagemView("Erro ao carregar usários",0);
		}
	}
	
	private Usuario buscarUsuarioPorID(Long idUser) throws SQLException {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.selecionarUsuario(idUser);
	}
	
	private class TabelaMouseClickListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			if(e.getButton() == MouseEvent.BUTTON1) {
				int linha = listarView.getLinhaSelecionada();
				Long idUser = (Long) listarView.getValorLinhaColuna(linha,0);
				try {
					Usuario usuarioSelecionado = buscarUsuarioPorID(idUser);
					abrirCadastroUsuario(usuarioSelecionado);
				} catch (SQLException e1) {
					e1.printStackTrace();
					new MensagemView("Erro ao buscar usuário",0);
				}
			}
		}

	}
	
	public ArrayList<Usuario> listarUsuario() throws SQLException {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.selecionarUsuarios();
	}

	private class ListarUsuariosListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String comando = e.getActionCommand();
			switch (comando) {
			case "BotaoCadastrarAction": 
				abrirCadastroUsuario(null);
				break;
			case "BotaoFecharAction":
				listarView.dispose();
				break;
			default:
				break;
			}
		}
		
	}
	
	public void abrirCadastroUsuario(Usuario usuarioSelecionado) {
		new CadastrarUsuarioController(this, usuarioSelecionado);
	}
	
	private class JanelaAberturaListener extends WindowAdapter{
		public void windowOpened(WindowEvent e) {
			carregarUsuarios();
		}
	}

	public void atualizarTabela(ArrayList<Usuario> novosUsuarios) {
		listarView.atualizarTabelaUsuarios(novosUsuarios);		
	}
}
