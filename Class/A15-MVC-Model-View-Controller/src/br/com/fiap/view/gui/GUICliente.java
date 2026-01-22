package br.com.fiap.view.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.fiap.controller.ClienteController;

public class GUICliente extends JPanel {

	private JLabel lbId, lbNome, lbPlaca;
	private JTextField tfId, tfNome, tfPlaca;
	private JButton btPesquisa, btNovo, btAtualiza, btApaga, btCancelar;
	
	public GUICliente() {
		inicializarComponentes();
		definirEventos();
	}

	private void inicializarComponentes() {
		setLayout(null);
		setBackground(Color.cyan);
		
		lbId = new JLabel("ID:", JLabel.RIGHT);
		lbNome = new JLabel("Nome:", JLabel.RIGHT);
		lbPlaca = new JLabel("Placa:", JLabel.RIGHT);
		tfId = new JTextField();
		tfNome = new JTextField();
		tfPlaca = new JTextField();
		btPesquisa = new JButton(new ImageIcon(getClass().getResource("images/search_icon.png")));
		btNovo = new JButton(new ImageIcon(getClass().getResource("images/new_icon.png")));
		btAtualiza = new JButton(new ImageIcon(getClass().getResource("images/update_icon.png")));
		btApaga = new JButton(new ImageIcon(getClass().getResource("images/delete_icon.png")));
		btCancelar = new JButton(new ImageIcon(getClass().getResource("images/exit_icon.png")));
		lbId.setBounds(10, 30, 80, 25);
		tfId.setBounds(100, 30, 120, 25);
		lbNome.setBounds(10, 75, 80, 25);
		tfNome.setBounds(100, 75, 200, 25);
		lbPlaca.setBounds(10, 120, 80, 25);
		tfPlaca.setBounds(100, 120, 120, 25);
		btPesquisa.setBounds(50, 250, 60, 40);
		btNovo.setBounds(120, 250, 60, 40);
		btAtualiza.setBounds(190, 250, 60, 40);
		btApaga.setBounds(260, 250, 60, 40);
		btCancelar.setBounds(330, 250, 60, 40);
		add(lbId);
		add(tfId);
		add(lbNome);
		add(tfNome);
		add(lbPlaca);
		add(tfPlaca);
		add(btPesquisa);
		add(btNovo);
		add(btAtualiza);
		add(btApaga);
		add(btCancelar);
	}

	private void definirEventos() {
		btCancelar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btApaga.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				ClienteController clienteController = new ClienteController();
				try {
					if (tfId.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Preencha o ID");
						tfId.requestFocus();
					} else {
						JOptionPane.showMessageDialog(null, clienteController.excluirCliente(
								Integer.parseInt(tfId.getText())));
						tfId.setText("");
						tfNome.setText("");
						tfPlaca.setText("");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		
		btNovo.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				ClienteController clienteController = new ClienteController();
				try {
					if (tfNome.getText().equals("") || tfPlaca.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Preencha Nome e Placa");
					} else {
						JOptionPane.showMessageDialog(null,
								clienteController.inserirCliente(tfNome.getText(), tfPlaca.getText()));
							tfId.setText("");
							tfNome.setText("");
							tfPlaca.setText("");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		
		btAtualiza.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				ClienteController clienteController = new ClienteController();
				try {
					if (tfId.getText().equals("") || tfNome.getText().equals("") || 
							tfPlaca.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Preencha todos os campos");
					} else {
						JOptionPane.showMessageDialog(null, clienteController.alterarCliente(
								Integer.parseInt(tfId.getText()), tfNome.getText(), tfPlaca.getText()));
							tfId.setText("");
							tfNome.setText("");
							tfPlaca.setText("");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		
		btPesquisa.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				ClienteController clienteController = new ClienteController();
				try {
					if (tfId.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Preencha o ID");
						tfId.requestFocus();
					} else {
						String cliente = clienteController.listarUmCliente(Integer.parseInt(tfId.getText()));
						JOptionPane.showMessageDialog(null, cliente);
						tfId.setText("");
						tfNome.setText("");
						tfPlaca.setText("");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
	}
}
