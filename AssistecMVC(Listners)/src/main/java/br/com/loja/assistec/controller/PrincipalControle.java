package br.com.loja.assistec.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.com.loja.assistec.model.Usuario;
import br.com.loja.assistec.view.LoginView;
import br.com.loja.assistec.view.PrincipalView;


public class PrincipalControle {
	
	private LoginView loginView;
	private PrincipalView principalView;
	private String user;
	private String senha;
	
	public PrincipalControle(String user,String senha,PrincipalView principalView) {
		this.user = user;
		this.senha = senha;
		this.principalView = principalView;
		principalView.setBounds(0, 0, 450, 350);
		principalView.setLocationRelativeTo(null);
		principalView.setVisible(true);
		principalView.addPrincipalListener(new PrincipalListener());
	}
	private class PrincipalListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			String command = e.getActionCommand();
			
			if (command.equals("sair")) {
				int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Atenção",JOptionPane.YES_NO_OPTION);
				if (sair == 0) {
					System.exit(0);
				}
			} else if (command.equals("usuario")) {
				//n sei o que fazer
			} else if (command.equals("sobre")) {
				JOptionPane.showMessageDialog(null, "ASSISTEC ver 1.0");
			}
		}
	}
}
