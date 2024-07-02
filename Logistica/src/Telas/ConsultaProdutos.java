package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class ConsultaProdutos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtcodigo;
	private JTextField txtnome;
	private JTextField txtdescri;
	private JTextField txtquant;
	private JTextField txtvalidade;
	private JTextField txtfornecedor;
	private JTextField txtbairro;
	private JTextField txtcidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Produtos frame = new Produtos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConsultaProdutos() {
		setTitle("Consulta de Produtos");
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 665, 403);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(146, 187, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Código");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(33, 58, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setForeground(Color.WHITE);
		lblNome.setBackground(Color.BLACK);
		lblNome.setBounds(33, 95, 45, 13);
		contentPane.add(lblNome);
		
		JLabel lblNewLabel_1_1 = new JLabel("Descrição");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1.setBounds(33, 134, 74, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Quantidade");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setBackground(Color.BLACK);
		lblNewLabel_1_2.setBounds(33, 175, 74, 13);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Validade");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setBackground(Color.BLACK);
		lblNewLabel_1_3.setBounds(33, 210, 74, 13);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Fornecedor");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setBackground(Color.BLACK);
		lblNewLabel_1_4.setBounds(312, 58, 74, 13);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Bairro");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_5.setForeground(Color.WHITE);
		lblNewLabel_1_5.setBackground(Color.BLACK);
		lblNewLabel_1_5.setBounds(312, 95, 45, 13);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Cidade");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_6.setForeground(Color.WHITE);
		lblNewLabel_1_6.setBackground(Color.BLACK);
		lblNewLabel_1_6.setBounds(312, 134, 45, 13);
		contentPane.add(lblNewLabel_1_6);
		
		txtcodigo = new JTextField();
		txtcodigo.setColumns(10);
		txtcodigo.setBounds(117, 55, 130, 19);
		contentPane.add(txtcodigo);
		
		txtnome = new JTextField();
		txtnome.setEditable(false);
		txtnome.setColumns(10);
		txtnome.setBounds(117, 92, 130, 19);
		contentPane.add(txtnome);
		
		txtdescri = new JTextField();
		txtdescri.setEditable(false);
		txtdescri.setColumns(10);
		txtdescri.setBounds(117, 131, 130, 19);
		contentPane.add(txtdescri);
		
		txtquant = new JTextField();
		txtquant.setEditable(false);
		txtquant.setColumns(10);
		txtquant.setBounds(117, 172, 130, 19);
		contentPane.add(txtquant);
		
		txtvalidade = new JTextField();
		txtvalidade.setEditable(false);
		txtvalidade.setColumns(10);
		txtvalidade.setBounds(117, 207, 130, 19);
		contentPane.add(txtvalidade);
		
		txtfornecedor = new JTextField();
		txtfornecedor.setEditable(false);
		txtfornecedor.setColumns(10);
		txtfornecedor.setBounds(396, 55, 130, 19);
		contentPane.add(txtfornecedor);
		
		txtbairro = new JTextField();
		txtbairro.setEditable(false);
		txtbairro.setColumns(10);
		txtbairro.setBounds(396, 92, 130, 19);
		contentPane.add(txtbairro);
		
		txtcidade = new JTextField();
		txtcidade.setEditable(false);
		txtcidade.setColumns(10);
		txtcidade.setBounds(396, 134, 130, 19);
		contentPane.add(txtcidade);
		
		JButton btnConsultaDePedidos = new JButton("Voltar");
		btnConsultaDePedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnConsultaDePedidos.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
				Produtos abrir = new Produtos();
				
				abrir.setVisible(true);
				abrir.setLocationRelativeTo(null);
				setVisible(false);
						
						
			}
		});
		btnConsultaDePedidos.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConsultaDePedidos.setBounds(33, 282, 163, 38);
		contentPane.add(btnConsultaDePedidos);
		
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
				
try {
					
					//INVOCAR O CONECTOR DO BANCO DE DADOS:
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					// REALIZAR A CONEXÃO COM BANCO DE DADOS:
					
					Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/petrobras", "root", "alunolab");
					
					String consulta = txtcodigo.getText();
					
		            // Executar a consulta
		           PreparedStatement pesquisa = conexao.prepareStatement("SELECT * FROM produto where codigo = ?");
		           
		           pesquisa.setString(1, consulta);
		            
		        	ResultSet resultado = pesquisa.executeQuery();


		            // Processar os resultados
		            while (resultado.next()) {
		            	
		                // Supondo que você tenha uma coluna chamada "nome" na tabela
		                String codigo = resultado.getString("codigo");
		                String nome = resultado.getString("nome");
		                String descricao = resultado.getString("descrição");
		                String fornecedor = resultado.getString("fornecedor");
		                String bairro = resultado.getString("bairro");
		                String cidade = resultado.getString("cidade");
		                
		                
		               
		                txtcodigo.setText(codigo);
		               
		                txtnome.setText(nome);
		                txtdescri.setText(descricao);
		                txtfornecedor.setText(fornecedor);
		                txtbairro.setText(bairro);
		                txtcidade.setText(cidade);
		            }
					
					//TRATANDO CONEXÃO COM BANCO DE DADOS SIM OU NÃO:
					
					} catch (Exception erro) {
						erro.printStackTrace();
						JOptionPane.showMessageDialog(null, "ERRO DE CONEXÃO COM BANCO DE DADOS");
					}
			
			
				
				
			}
				
				
				
				
				
				
				
				
				
				
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(500, 282, 130, 38);
		contentPane.add(btnNewButton);
	}
}
