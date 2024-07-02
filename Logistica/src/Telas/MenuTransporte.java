package Telas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MenuTransporte extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel txtquantidade;
	private JTextField txtcodigo;
	private JTextField txtcompra;
	private JTextField txtentrega;
	private JTextField txtquant;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuTransporte frame = new MenuTransporte();
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
	public MenuTransporte() {
		setResizable(false);
		setTitle("Tela Inicial Transportadora");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100,584, 475);
		txtquantidade = new JPanel();
		txtquantidade.setBackground(new Color(146, 187, 219));
		txtquantidade.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(txtquantidade);
		txtquantidade.setLayout(null);
		
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
		txtquantidade.add(btnDeslogar);
		
		txtcodigo = new JTextField();
		txtcodigo.setBounds(154, 11, 267, 20);
		txtquantidade.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		JLabel lblCodigoDoPedido = new JLabel("Codigo do Pedido");
		lblCodigoDoPedido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodigoDoPedido.setForeground(Color.WHITE);
		lblCodigoDoPedido.setBounds(39, 14, 101, 14);
		txtquantidade.add(lblCodigoDoPedido);
		
		JLabel lblDataDaCompra = new JLabel("Data da compra");
		lblDataDaCompra.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataDaCompra.setForeground(Color.WHITE);
		lblDataDaCompra.setBackground(Color.BLACK);
		lblDataDaCompra.setBounds(39, 108, 92, 13);
		txtquantidade.add(lblDataDaCompra);
		
		txtcompra = new JTextField();
		txtcompra.setEditable(false);
		txtcompra.setColumns(10);
		txtcompra.setBounds(154, 104, 130, 19);
		txtquantidade.add(txtcompra);
		
		JLabel lblDataDeEntrega = new JLabel("Data de entrega");
		lblDataDeEntrega.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataDeEntrega.setForeground(Color.WHITE);
		lblDataDeEntrega.setBackground(Color.BLACK);
		lblDataDeEntrega.setBounds(39, 149, 92, 13);
		txtquantidade.add(lblDataDeEntrega);
		
		txtentrega = new JTextField();
		txtentrega.setEditable(false);
		txtentrega.setColumns(10);
		txtentrega.setBounds(154, 145, 130, 19);
		txtquantidade.add(txtentrega);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStatus.setForeground(Color.WHITE);
		lblStatus.setBackground(Color.BLACK);
		lblStatus.setBounds(39, 219, 45, 13);
		txtquantidade.add(lblStatus);
		
		JComboBox txtstatus = new JComboBox();
		txtstatus.setEditable(true);
		txtstatus.setModel(new DefaultComboBoxModel(new String[] {"Em Andamento", "Em Rota"}));
		txtstatus.setBounds(154, 214, 130, 22);
		txtquantidade.add(txtstatus);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//atualização do pedido
				try {
		            // INVOCAR O CONECTOR DO BANCO DE DADOS:
		            Class.forName("com.mysql.cj.jdbc.Driver");


		            // REALIZAR A CONEXÃO COM BANCO DE DADOS:
		            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/petrobras", "root", "alunolab");


		            // PEGAR VALORES DAS CAIXAS DE TEXTOS:
		            String codigo = txtcodigo.getText();
		            String status = txtstatus.getSelectedItem().toString();
		            


		            // ATUALIZAR DADOS ATRAVÉS DE LINGUAGEM SQL:
		            String atualizar = "UPDATE pedidos SET status_pedido = ? WHERE codigo = ?";


		            // PREPARANDO PARA ENVIAR:
		            PreparedStatement statement = conexao.prepareStatement(atualizar);


		            statement.setString(1, status);
		            statement.setString(2, codigo);
		           


		            int resultado = statement.executeUpdate();


		            // TRATANDO CONDIÇÃO PARA SABER SE A ATUALIZAÇÃO FOI BEM-SUCEDIDA:
		            if (resultado > 0) {
		                JOptionPane.showMessageDialog(null, "DADOS ATUALIZADOS COM SUCESSO!");
		            } else {
		                JOptionPane.showMessageDialog(null, "ERRO AO ATUALIZAR DADOS, CONFIRA OS DADOS E TENTE NOVAMENTE!");
		            }


		            // FECHAR CONEXÃO COM BANCO DE DADOS:
		            conexao.close();


		        } catch (Exception erro) {
		            erro.printStackTrace();
		            JOptionPane.showMessageDialog(null, "ERRO DE CONEXÃO COM BANCO DE DADOS");
		        }
		    }

				
				
				
				
				
				
				
			}
		);
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAtualizar.setBounds(428, 361, 130, 38);
		txtquantidade.add(btnAtualizar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
	//consulta pelo codigo
				
				try {
					
					//INVOCAR O CONECTOR DO BANCO DE DADOS:
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					// REALIZAR A CONEXÃO COM BANCO DE DADOS:
					
					Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/petrobras", "root", "alunolab");
					
					String consulta = txtcodigo.getText();
					
		            // Executar a consulta
		           PreparedStatement pesquisa = conexao.prepareStatement("SELECT * FROM pedido where codigo = ?");
		           
		           pesquisa.setString(1, consulta);
		            
		        	ResultSet resultado = pesquisa.executeQuery();


		            // Processar os resultados
		            while (resultado.next()) {
		            	
		                // Supondo que você tenha uma coluna chamada "nome" na tabela
		                String entrega = resultado.getString("entrega");
		                String saida = resultado.getString("saida");
		                String quantidade = resultado.getString("quantidade");
		                
		                
		                
		                txtcompra.setText(saida);
		                txtentrega.setText(entrega);
		                txtquant.setText(quantidade);
		                
		             
		            }
					
					//TRATANDO CONEXÃO COM BANCO DE DADOS SIM OU NÃO:
					
					} catch (Exception erro) {
						erro.printStackTrace();
						JOptionPane.showMessageDialog(null, "ERRO DE CONEXÃO COM BANCO DE DADOS");
					}
			
			
				
				
			}
		});
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConsultar.setBounds(428, 10, 101, 20);
		txtquantidade.add(btnConsultar);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblQuantidade.setForeground(Color.WHITE);
		lblQuantidade.setBackground(Color.BLACK);
		lblQuantidade.setBounds(39, 183, 85, 13);
		txtquantidade.add(lblQuantidade);
		
		txtquant = new JTextField();
		txtquant.setEditable(false);
		txtquant.setColumns(10);
		txtquant.setBounds(154, 179, 130, 19);
		txtquantidade.add(txtquant);
	}
}
