package br.com.loja.Assistec.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.loja.Assistec.dal.ConexaoBD;

//Classe abstrata não pode ser instanciada, é um modelo para as classes que irão herdar seu comportamento
//Esta classe facilita para que não precisemos em todas as Classes DAO executar todo este código, 
//iremos apenas passar os parâmetros
public abstract class GenericDAO {
	private Connection connection;

	// Protected pois pertencem a esta classe, somente podem ser usadas por classes
	// que herdam desta
	public GenericDAO() {
		this.connection = ConexaoBD.getConnection();
	}

	protected Connection getConnection() {
		return connection;
	}

	// Método para salvar
	protected void save(String insertSql, Object... parametros) throws SQLException {
		PreparedStatement pstmt = getConnection().prepareStatement(insertSql);

		for (int i = 0; i < parametros.length; i++) {
			pstmt.setObject(i + 1, parametros[i]);
		}

		pstmt.execute();
		pstmt.close();
		connection.close();
	}

	// Método para atualizar
	protected void update(String updateSql, Object id, Object... parametros) throws SQLException {
		PreparedStatement pstmt = getConnection().prepareStatement(updateSql);
		for (int i = 0; i < parametros.length; i++) {
			pstmt.setObject(i + 1, parametros[i]);
		}
		pstmt.setObject(parametros.length + 1, id);
		pstmt.execute();
		pstmt.close();
		connection.close();
	}

	// Método para deletar
	protected void delete(String deleteSql, Object... parametros) throws SQLException {
		PreparedStatement pstmt = getConnection().prepareStatement(deleteSql);

		for (int i = 0; i < parametros.length; i++) {
			pstmt.setObject(i + 1, parametros[i]);
		}

		pstmt.execute();
		pstmt.close();
		connection.close();
	}
}