package br.com.loja.Assistec.controle;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.loja.Assistec.modelo.Usuario;
import br.com.loja.Assistec.modelo.UsuarioDAO;

public class UsuarioControle {
	
	public UsuarioControle() {
	}
	
	public  ArrayList<Usuario> listarUsuarios() throws SQLException {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.selecionarUsuarios();
	}

	public void salvar(String nome, String fone, String login, String senha,String perfil) throws SQLException {
		Usuario user = new Usuario();
		user.setNome(nome);
		user.setFone(fone);
		user.setLogin(login);
		user.setSenha(senha);
		user.setPerfil(perfil);
		
		new UsuarioDAO().salvar(user);
	}
}