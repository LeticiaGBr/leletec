package br.com.loja.Assistec.visao;

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


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalView frame = new PrincipalView("","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public PrincipalView(String user,String perfil) {
		setTitle("Sistema de Gestão ASSISTEC");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuArquivo = new JMenu("Arquivo");
		menuBar.add(menuArquivo);
		
		JMenuItem menuSair = new JMenuItem("Sair");
		menuSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sair = JOptionPane.showConfirmDialog(null, "Quer sair?","Sair",JOptionPane.YES_NO_OPTION);
				if(sair == 0) {
					System.exit(0);
				}
				
			}
		});
		menuArquivo.add(menuSair);
		
		JMenu menuCadastro = new JMenu("Cadastro");
		menuCadastro.setEnabled(false);
		menuBar.add(menuCadastro);
		
		JMenuItem menuUsuarios = new JMenuItem("Usuários");
		menuUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarUsuarios();
			}

		});
		menuCadastro.add(menuUsuarios);
		
		JMenu menuRelatorio = new JMenu("Relatórios");
		menuRelatorio.setEnabled(false);
		menuBar.add(menuRelatorio);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		menuRelatorio.add(mntmNewMenuItem);
		
		JMenu menuAjuda = new JMenu("Ajuda");
		menuBar.add(menuAjuda);
		
		JMenuItem menuSobre = new JMenuItem("Sobre");
		menuSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "ASSISTEC ver 1.0");
			}
		});
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


	protected void ListarUsuarios() {
		ListarUsuariosvView luv = null;
		try {
			luv = new ListarUsuariosvView();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		luv.setLocationRelativeTo(luv);
		dispose();
		luv.setVisible(true);
	}
}
