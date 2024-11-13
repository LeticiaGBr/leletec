package br.com.loja.Assistec.modelo;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class UsuarioTableModel extends AbstractTableModel {
	
	private static final String[] colunas= {"ID","Nome","Telefone","Login","Perfil"};
	private ArrayList<Usuario> lista;

	public UsuarioTableModel(ArrayList<Usuario> list) {
		this.lista = list;
	}

	public int getRowCount() {
		return lista.size();
	}

	public int getColumnCount() {
		return colunas.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Usuario user = lista.get(rowIndex);
		if(columnIndex == 0) {
			return user.getIduser();
		}else if(columnIndex == 1) {
			return user.getNome();
		}else if(columnIndex == 2) {
			return user.getFone();
		}else if(columnIndex == 3) {
			return user.getLogin();
		}else if(columnIndex == 4) {
			return user.getPerfil();
		}else {
			return null;
		}
	}
	public String getColumName(int coluna) {
		return colunas[coluna];
	}
}