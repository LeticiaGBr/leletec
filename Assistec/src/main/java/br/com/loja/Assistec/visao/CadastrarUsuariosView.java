package br.com.loja.Assistec.visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;

import br.com.loja.Assistec.controle.UsuarioControle;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;

public class CadastrarUsuariosView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JTextField txtFone;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	private JComboBox cbPerfil;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarUsuariosView frame = new CadastrarUsuariosView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public CadastrarUsuariosView() {
		setBounds(100, 100, 700, 350);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorte = new JPanel();
		getContentPane().add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblcadastro = new JLabel("Cadastro de usuários");
		panelNorte.add(lblcadastro);
		
		JPanel panelSul = new JPanel();
		getContentPane().add(panelSul, BorderLayout.SOUTH);
		
		JButton btIncluir = new JButton("Incluir");
		btIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!"".equalsIgnoreCase(txtLogin.getText()) && !"".equalsIgnoreCase(String.valueOf(txtSenha.getPassword()))) {
					String perfil = (String) cbPerfil.getSelectedItem();
					UsuarioControle uc = new UsuarioControle();
					try {
						uc.salvar(txtNome.getText(),txtFone.getText(),txtLogin.getText(),String.valueOf(txtSenha.getPassword()),perfil);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		panelSul.add(btIncluir);
		
		JButton btRemover = new JButton("Remover");
		panelSul.add(btRemover);
		
		JButton btFechar = new JButton("Fechar");
		panelSul.add(btFechar);
		
		JPanel panelCentro = new JPanel();
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(6, 0, 0, 0));
		
		JLabel lblNome = new JLabel("Nome");
		panelCentro.add(lblNome);
		
		txtNome = new JTextField();
		panelCentro.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblFone = new JLabel("Fone");
		panelCentro.add(lblFone);
		
		txtFone = new JTextField();
		panelCentro.add(txtFone);
		txtFone.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login");
		panelCentro.add(lblLogin);
		
		txtLogin = new JTextField();
		panelCentro.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		panelCentro.add(lblSenha);
		
		txtSenha = new JPasswordField();
		panelCentro.add(txtSenha);
		
		JLabel lblPerfil = new JLabel("Perfil");
		panelCentro.add(lblPerfil);
		
		cbPerfil = new JComboBox();
		cbPerfil.setModel(new DefaultComboBoxModel(new String[] {"User", "Admim"}));
		panelCentro.add(cbPerfil);

	}

}
