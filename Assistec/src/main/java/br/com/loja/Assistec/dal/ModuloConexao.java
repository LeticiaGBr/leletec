package br.com.loja.Assistec.dal;

import java.sql.Connection;
import java.sql.DriverManager;

public class ModuloConexao {

	public static Connection conector() {

		Connection conexao = null;
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdb:mysql://localhost:3306/lojabd";
		String user = "root";
		String password = "aluno";
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection (url, user, password);
			return conexao;
		}
		catch (Exception e) {
			return null;
		}
	}

}
