package br.com.loja.assistec.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class PrincipalView extends JFrame {
	
	private JMenuItem menuSair;
	private JMenuItem menuUsuarios;
	private JMenuItem menuSobre;
	
	public PrincipalView(String user,String perfil) {
		setTitle("Sistema de Gestão ASSISTEC");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuArquivo = new JMenu("Arquivo");
		menuBar.add(menuArquivo);
		
		menuSair = new JMenuItem("Sair");
		menuSair.setActionCommand("sair");
		menuArquivo.add(menuSair);
		
		JMenu menuCadastro = new JMenu("Cadastro");
		menuCadastro.setEnabled(false);
		menuBar.add(menuCadastro);
		
		menuUsuarios = new JMenuItem("Usuários");
		menuUsuarios.setActionCommand("usuario");
		menuCadastro.add(menuUsuarios);
		
		JMenu menuRelatorio = new JMenu("Relatórios");
		menuRelatorio.setEnabled(false);
		menuBar.add(menuRelatorio);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		menuRelatorio.add(mntmNewMenuItem);
		
		JMenu menuAjuda = new JMenu("Ajuda");
		menuBar.add(menuAjuda);
		
		menuSobre = new JMenuItem("Sobre");
		menuSobre.setActionCommand("sobre");
		menuAjuda.add(menuSobre);
		
		JLabel lblUsuário = new JLabel("");
		lblUsuário.setText(user);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblUsuário)
					.addContainerGap(378, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(214, Short.MAX_VALUE)
					.addComponent(lblUsuário)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		if("admin".equalsIgnoreCase(perfil)) {
			menuCadastro.setEnabled(true);
			menuRelatorio.setEnabled(true);
		}
	}
	public void addPrincipalListener(ActionListener listener) {
		menuUsuarios.addActionListener(listener);
		menuSobre.addActionListener(listener);
		menuSair.addActionListener(listener);
	}	
}
