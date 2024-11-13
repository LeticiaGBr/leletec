package br.com.loja.Assistec.controle;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.loja.Assistec.modelo.LoginDAO;
import br.com.loja.Assistec.modelo.Usuario;

public class LoginController{
	
	private Usuario model;

	public LoginController() 
	{

	}

	public ArrayList<String> autenticar(String login, String senha) throws SQLException{
		ArrayList<String> lista = new ArrayList<>();
		LoginDAO ldao = new LoginDAO();
		Usuario user = ldao.autenticar(login, senha);
		lista.add(0,user.getNome());
		lista.add(1,user.getPerfil());
		return lista;
		
	}
	
	public boolean verificarBancoOnline() throws SQLException
	{
		LoginDAO ldao = new LoginDAO();
		return ldao.bancoOnline();
	}

}
