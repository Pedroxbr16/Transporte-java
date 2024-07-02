package Telas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setResizable(false);
		setTitle("Tela Inicial");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100,937, 475);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnNewButton = new JButton("Produtos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Produtos abrir = new Produtos();
				
				abrir.setVisible(true);
				abrir.setLocationRelativeTo(null);
				btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		menuBar.add(btnNewButton);
		
		JButton btnPedidos = new JButton("Pedidos");
		btnPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Pedidos abrir = new Pedidos();
				
				abrir.setVisible(true);
				abrir.setLocationRelativeTo(null);
				btnPedidos.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
				
			}
		});
		btnPedidos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		menuBar.add(btnPedidos);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(25, 25, 112));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDeslogar = new JButton("Deslogar");
		btnDeslogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login abrir = new Login();
				
				setVisible(false);
				abrir.setVisible(true);
				abrir.setLocationRelativeTo(null);
				btnDeslogar.setCursor(new Cursor(Cursor.HAND_CURSOR));
				 
				JOptionPane.showMessageDialog(null,"Sessão encerrada");
				
				
				
			}
		});
		btnDeslogar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeslogar.setBounds(10, 361, 130, 38);
		contentPane.add(btnDeslogar);
	}
}
