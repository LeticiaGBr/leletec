package br.com.loja.Assistec.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO extends GenericDAO{

	public void salvar(Usuario usuario) throws SQLException {
		String insert = "INSERT INTO USUARIOS(nome, fone, login, senha, perfil) VALUES(?,?,?,?,?)";
		save(insert, usuario.getNome(), usuario.getFone(), usuario.getLogin(), usuario.getSenha(), usuario.getPerfil());
	}

	public void alterar(Usuario usuario) throws SQLException {
		String update = "UPDATE USUARIOS " + "SET nome = ?, fone = ?, login = ?, senha = ?, perfil = ? "
				+ "WHERE IDUSER = ?";
		update(update, usuario.getIduser(), usuario.getNome(), usuario.getFone(), usuario.getLogin(),
				usuario.getSenha(), usuario.getPerfil());
	}

	public void excluir(long id) throws SQLException {
		String delete = "DELETE FROM USUARIOS WHERE IDUSER = ?";
		delete(delete, id);
	}
	
	public ArrayList<Usuario> selecionarUsuarios() throws SQLException {
		ArrayList<Usuario> usuarios = new ArrayList<>();
		String sql = "SELECT * FROM USUARIOS";
		PreparedStatement pstm = getConnection().prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			Usuario usuario = new Usuario();
			usuario.setIduser(rs.getInt("iduser"));
			usuario.setNome(rs.getString("usuario"));
			usuario.setFone(rs.getString("fone"));
			usuario.setLogin(rs.getString("login"));
			usuario.setSenha(rs.getString("senha"));
			usuario.setPerfil(rs.getString("perfil"));
			usuarios.add(usuario);
		}

		rs.close();
		pstm.close();
		getConnection().close();
		
		return usuarios;
	}
	
		public Usuario selecionarUsuario(Long iduser) throws SQLException {
			Usuario usuario = new Usuario();
			String sql = "SELECT * FROM USUARIOS WHERE IDUSER = ?";
			PreparedStatement pstm = getConnection().prepareStatement(sql);
			pstm.setLong(1, iduser);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				usuario.setIduser(rs.getLong("iduser"));
				usuario.setNome(rs.getString("nome"));
				usuario.setFone(rs.getString("fone"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setPerfil(rs.getString("perfil"));
			}

			rs.close();
			pstm.close();
			getConnection().close();
			
			return usuario;
		}
}