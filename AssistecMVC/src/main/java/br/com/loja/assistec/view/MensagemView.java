package br.com.loja.assistec.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MensagemView extends JDialog {
	private static final long serialVersionUID = 1L;
	int resposta;

	public MensagemView(String mensagem, int tipo) {
		setTitle("Mensagem");
		setModal(true);
		setSize(350,200);
		setLocationRelativeTo(null);
		setResizable(false);

		JPanel painel = new JPanel();
		painel.setLayout(new BorderLayout());
		add(painel);

		JLabel lblMensagem = new JLabel(mensagem, SwingConstants.CENTER);
		painel.add(lblMensagem, BorderLayout.CENTER);

		String iconeURL;
		switch (tipo) {
		case 0:
			iconeURL = "/br/com/loja/assistec/icones/errro.png";
			lblMensagem.setIcon(new ImageIcon(getClass().getResource(iconeURL)));
			break;
		case 1:
			iconeURL = "/br/com/loja/assistec/icones/info.png";
			lblMensagem.setIcon(new ImageIcon(getClass().getResource(iconeURL)));
			break;
		case 2:
			iconeURL = "/br/com/loja/assistec/icones/alerta.png";
			lblMensagem.setIcon(new ImageIcon(getClass().getResource(iconeURL)));
			break;
		case 3:
			iconeURL = "/br/com/loja/assistec/icones/sucesso.png";
			lblMensagem.setIcon(new ImageIcon(getClass().getResource(iconeURL)));
			break;
		case 10:
			iconeURL = "/br/com/loja/assistec/icones/assistec.png";
			lblMensagem.setIcon(new ImageIcon(getClass().getResource(iconeURL)));
			break;
		}
		
		JPanel painelSul = new JPanel(new FlowLayout(FlowLayout.CENTER,20,10));
		painelSul.add(new JPanel());
		JButton btOk = new JButton("Ok");
		btOk.setPreferredSize(new Dimension(100,30));
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}});
		
		painelSul.add(btOk);
		painelSul.add(new JPanel());
		painelSul.setBorder(new EmptyBorder(10,10,10,10));
		painel.add(painelSul,BorderLayout.SOUTH);
		
		getRootPane().setDefaultButton(btOk);
		setVisible(true);
	}

	public MensagemView(String mensagem) {
		setTitle("Mensagem");
		setModal(true);
		setSize(350,200);
		setLocationRelativeTo(null);
		setResizable(false);

		JPanel painel = new JPanel();
		painel.setLayout(new BorderLayout());
		add(painel);

		JLabel lblMensagem = new JLabel(mensagem, SwingConstants.CENTER);
		painel.add(lblMensagem, BorderLayout.CENTER);

		
		String iconeURL = "/br/com/loja/assistec/icones/alerta.png";
		lblMensagem.setIcon(new ImageIcon(getClass().getResource(iconeURL)));
		
		JPanel painelSul = new JPanel(new FlowLayout(FlowLayout.CENTER,20,10));
		painelSul.add(new JPanel());
		
		JButton btSim = new JButton("Sim");
		btSim.setPreferredSize(new Dimension(100,30));
		btSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				resposta =0;
			}});
		
		JButton btNao = new JButton("Não");
		btNao.setPreferredSize(new Dimension(100,30));
		btNao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				resposta =1;
			}});
		
		painelSul.add(btSim);
		painelSul.add(btNao);
		painelSul.add(new JPanel());
		painelSul.setBorder(new EmptyBorder(10,10,10,10));
		painel.add(painelSul,BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public int getResposta() {
		return resposta;
	}

}
