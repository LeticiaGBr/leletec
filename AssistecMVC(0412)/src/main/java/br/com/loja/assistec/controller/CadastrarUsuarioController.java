package br.com.loja.assistec.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import br.com.loja.assistec.model.Usuario;
import br.com.loja.assistec.model.UsuarioDAO;
import br.com.loja.assistec.view.CadastrarUsuariosView;
import br.com.loja.assistec.view.MensagemView;

public class CadastrarUsuarioController {
	private CadastrarUsuariosView cadastrarView;
	private ListarUsuarioController listarController;
	private Usuario usuarioSelecionado;
	
	public CadastrarUsuarioController(ListarUsuarioController listarUsuarioController, Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
		this.listarController = listarUsuarioController;
		cadastrarView = new CadastrarUsuariosView(usuarioSelecionado);
		cadastrarView.setLocationRelativeTo(null);
		cadastrarView.setVisible(true);
		configurarListeners();
	}

	private void configurarListeners() {
		cadastrarView.addCadastrarUsuariosListeners(new CadastrarUsuariosListeners());
		cadastrarView.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				if(usuarioSelecionado != null) {
					cadastrarView.preencherCampos(usuarioSelecionado);
					cadastrarView.habilitarBotaoExcluir(true);
				}
			}
		});
		
	}
	
	private class CadastrarUsuariosListeners implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "btnIncluir": 
				try {
					metodoAlterarIncluir();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;
			case "btnExcluir":
				metodoExcluir();
				break;
			case "btnFechar":
				cadastrarView.dispose();
				break;			
			}
		}
		
	}

	private void metodoAlterarIncluir() throws SQLException {
		String perfil = (String) cadastrarView.getPefilSelecionado();
		if(usuarioSelecionado == null) {
			incluir(cadastrarView.getNome(), cadastrarView.getFone(), cadastrarView.getLogin(), cadastrarView.getSenha(), perfil);
			new MensagemView("Registro inserido com sucesso",3);
		} else {
			alterar(usuarioSelecionado.getIduser(), cadastrarView.getNome(), cadastrarView.getFone(), cadastrarView.getLogin(), cadastrarView.getSenha(), perfil);
			new MensagemView("usuario altrado com sucesso",3);
		}
		cadastrarView.dispose();
		atualizarListaUsuarios();
	}

	private void alterar(long iduser, String nome, String fone, String login, String senha, String perfil) throws SQLException {
		Usuario usuario = new Usuario(iduser,nome,fone,login,senha,perfil);
		new UsuarioDAO().alterar(usuario);
	}

	private void incluir(String nome, String fone, String login, String senha, String perfil) throws SQLException {
		Usuario usuario = new Usuario(nome,fone,login,senha,perfil);
		new UsuarioDAO().salvar(usuario);
	}

	private void metodoExcluir() {
		MensagemView mv =  new MensagemView("Tem certeza que qur Excluir?");
		int confirmacao = mv.getResposta();
		if(confirmacao ==1) {
			try {
				excluir(usuarioSelecionado.getIduser());
				cadastrarView.dispose();
				atualizarListaUsuarios();
				new MensagemView("usuario excluido com sucesso",3);
			} catch (SQLException e) {
				new MensagemView("Erro ao excluir usuario",0);
			}
		}
	}

	private void atualizarListaUsuarios() throws SQLException {
		ArrayList<Usuario> novosUsuarios = listarController.listarUsuario();
		listarController.atualizarTabela(novosUsuarios);
	}

	private void excluir(long iduser) throws SQLException {
		new UsuarioDAO().excluir(iduser);
		
	}

}
