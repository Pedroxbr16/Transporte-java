package Telas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;

public class MenuPedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPedido frame = new MenuPedido();
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
	public MenuPedido() {
		setResizable(false);
		setTitle("Tela Inicial Pedidos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100,627, 475);
		
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
		contentPane.setBackground(new Color(146, 187, 219));
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
		
		JLabel NumeroTransporte = new JLabel("  0 ");
		NumeroTransporte.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				

				
				
				
				
				
				
			}
		});
		
		JLabel NumeroAndamendo = new JLabel("0");
		NumeroAndamendo.setFont(new Font("Tahoma", Font.BOLD, 24));
		NumeroAndamendo.setBounds(431, 154, 43, 46);
		contentPane.add(NumeroAndamendo);
		
		NumeroAndamendo.setVisible(false);
		
		
		JLabel NumeroRecebidos = new JLabel("0");
		NumeroRecebidos.setFont(new Font("Tahoma", Font.BOLD, 24));
		NumeroRecebidos.setBounds(431, 50, 43, 46);
		contentPane.add(NumeroRecebidos);
		
		NumeroRecebidos.setVisible(false);
		
		
		JButton btnNewButton_1_1_1 = new JButton("");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TabelaPedidoRecebido abrir = new TabelaPedidoRecebido();
				
				abrir.setVisible(true);
				abrir.setLocationRelativeTo(null);
				
				
				
			}
		});
		btnNewButton_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				NumeroRecebidos.setVisible(false);
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_1_1_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				try {
		            // Invocar o conector do banco de dados:
		            Class.forName("com.mysql.cj.jdbc.Driver");


		            // Realizar a conexão com banco de dados:
		            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/petrobras", "root", "alunolab");


		            // Preparar a consulta SQL
		            String sql = "SELECT COUNT(*) AS total_pedidos FROM pedidos WHERE status_pedido = ?";
		            PreparedStatement consulta = conexao.prepareStatement(sql);
		            consulta.setString(1, "Recebimento");


		            // Executar a consulta
		            ResultSet resultado = consulta.executeQuery();


		            // Processar os resultados
		            if (resultado.next()) {
		            	
		                int totalPedidosEmTransporte = resultado.getInt("total_pedidos");
		                
		                String total = String.valueOf(totalPedidosEmTransporte);
		                
		                NumeroRecebidos.setVisible(true);
		                NumeroRecebidos.setText(total);
		                
		            } else {
		            	
		                JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado.");
		                
		            }


		            // Fechar a conexão com banco de dados
		            conexao.close();


		        } catch (Exception erro) {
		            erro.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Erro de conexão com banco de dados");
		        }
				
				
				
				
				
				
			}
		});
		btnNewButton_1_1_1.setBounds(387, 35, 99, 74);
		contentPane.add(btnNewButton_1_1_1);
		NumeroTransporte.setFont(new Font("Tahoma", Font.BOLD, 24));
		NumeroTransporte.setForeground(Color.BLACK);
		NumeroTransporte.setBounds(431, 253, 43, 46);
		
		contentPane.add(NumeroTransporte);
		btnDeslogar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeslogar.setBounds(10, 361, 130, 38);
		contentPane.add(btnDeslogar);
		
		NumeroTransporte.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("Em andamento");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(176, 174, 116, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TabelaPedidoTransporte abrir = new TabelaPedidoTransporte();
				
				abrir.setVisible(true);
				abrir.setLocationRelativeTo(null);
				
				
				
				
				
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				 NumeroTransporte.setVisible(false);	
				
			}
		});
		btnNewButton_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				

				try {
		            // Invocar o conector do banco de dados:
		            Class.forName("com.mysql.cj.jdbc.Driver");


		            // Realizar a conexão com banco de dados:
		            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/petrobras", "root", "alunolab");


		            // Preparar a consulta SQL
		            String sql = "SELECT COUNT(*) AS total_pedidos FROM pedidos WHERE status_pedido = ?";
		            PreparedStatement consulta = conexao.prepareStatement(sql);
		            consulta.setString(1, "Em Transporte");


		            // Executar a consulta
		            ResultSet resultado = consulta.executeQuery();


		            // Processar os resultados
		            if (resultado.next()) {
		            	
		                int totalPedidosEmTransporte = resultado.getInt("total_pedidos");
		                
		                String total = String.valueOf(totalPedidosEmTransporte);
		                
		                NumeroTransporte.setVisible(true);
		                NumeroTransporte.setText(total);
		                
		            } else {
		            	
		                JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado.");
		                
		            }


		            // Fechar a conexão com banco de dados
		            conexao.close();


		        } catch (Exception erro) {
		            erro.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Erro de conexão com banco de dados");
		        }
				
				
				
			}
		});
		btnNewButton_1.setBounds(387, 239, 99, 74);
		contentPane.add(btnNewButton_1);
		
		JLabel lblEmTransporte = new JLabel("Em Transporte");
		lblEmTransporte.setForeground(Color.WHITE);
		lblEmTransporte.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmTransporte.setBackground(Color.WHITE);
		lblEmTransporte.setBounds(176, 273, 116, 14);
		contentPane.add(lblEmTransporte);
		
		JLabel lblRecebimento = new JLabel("Recebidos");
		lblRecebimento.setForeground(Color.WHITE);
		lblRecebimento.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRecebimento.setBackground(Color.WHITE);
		lblRecebimento.setBounds(176, 70, 116, 14);
		contentPane.add(lblRecebimento);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				TabelaPedidoAndamento abrir = new TabelaPedidoAndamento();
				
				abrir.setVisible(true);
				abrir.setLocationRelativeTo(null);
			
			
			
			}
		});
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				NumeroAndamendo.setVisible(false);
				
			}
		});
		btnNewButton_1_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				try {
		            // Invocar o conector do banco de dados:
		            Class.forName("com.mysql.cj.jdbc.Driver");


		            // Realizar a conexão com banco de dados:
		            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/petrobras", "root", "alunolab");


		            // Preparar a consulta SQL
		            String sql = "SELECT COUNT(*) AS total_pedidos FROM pedidos WHERE status_pedido = ?";
		            PreparedStatement consulta = conexao.prepareStatement(sql);
		            consulta.setString(1, "Em Transporte");


		            // Executar a consulta
		            ResultSet resultado = consulta.executeQuery();


		            // Processar os resultados
		            if (resultado.next()) {
		            	
		                int totalPedidosEmTransporte = resultado.getInt("total_pedidos");
		                
		                String total = String.valueOf(totalPedidosEmTransporte);
		                
		                NumeroAndamendo.setVisible(true);
		                NumeroAndamendo.setText(total);
		                
		            } else {
		            	
		                JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado.");
		                
		            }


		            // Fechar a conexão com banco de dados
		            conexao.close();


		        } catch (Exception erro) {
		            erro.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Erro de conexão com banco de dados");
		        }
				
				
				
			}
		});
		btnNewButton_1_1.setBounds(387, 137, 99, 74);
		contentPane.add(btnNewButton_1_1);
	}
}
