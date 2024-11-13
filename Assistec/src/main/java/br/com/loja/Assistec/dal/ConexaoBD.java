package br.com.loja.Assistec.dal;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD {
	public static Connection getConnection()
	{
		Connection conexao = null;
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/lojabd";
		String user = "root";
		String senha = "aluno";
		
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url,user,senha);
			return conexao;
		} catch (Exception e) {
			return null;
		}
	}
	
	
}
