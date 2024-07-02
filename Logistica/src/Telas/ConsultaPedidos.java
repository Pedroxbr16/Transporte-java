package Telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ConsultaPedidos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtcodigo;
	private JTextField txtproduto;
	private JTextField txtcompra;
	private JTextField txtentrega;
	private JTextField txtquant;
	private JTextField txtcep;
	private JTextField txtrua;
	private JTextField txtbairro;
	private JTextField txtcidade;
	private JTextField txtcomplemento;
	private JTextField txtcpf;
	private JTextField txtstatus;
	private JTextField txtsetor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pedidos frame = new Pedidos();
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
	public ConsultaPedidos() {
		setTitle("Consulta de Pedidos");
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 403);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(146, 187, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtcodigo = new JTextField();
		txtcodigo.setBounds(123, 48, 130, 19);
		contentPane.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		txtproduto = new JTextField();
		txtproduto.setEditable(false);
		txtproduto.setColumns(10);
		txtproduto.setBounds(123, 77, 130, 19);
		contentPane.add(txtproduto);
		
		txtcompra = new JTextField();
		txtcompra.setEditable(false);
		txtcompra.setColumns(10);
		txtcompra.setBounds(123, 106, 130, 19);
		contentPane.add(txtcompra);
		
		txtentrega = new JTextField();
		txtentrega.setEditable(false);
		txtentrega.setColumns(10);
		txtentrega.setBounds(123, 135, 130, 19);
		contentPane.add(txtentrega);
		
		txtquant = new JTextField();
		txtquant.setEditable(false);
		txtquant.setColumns(10);
		txtquant.setBounds(123, 164, 130, 19);
		contentPane.add(txtquant);
		
		txtcep = new JTextField();
		txtcep.setEditable(false);
		txtcep.setColumns(10);
		txtcep.setBounds(459, 46, 163, 19);
		contentPane.add(txtcep);
		
		txtrua = new JTextField();
		txtrua.setEditable(false);
		txtrua.setColumns(10);
		txtrua.setBounds(459, 77, 163, 19);
		contentPane.add(txtrua);
		
		txtbairro = new JTextField();
		txtbairro.setEditable(false);
		txtbairro.setColumns(10);
		txtbairro.setBounds(459, 106, 163, 19);
		contentPane.add(txtbairro);
		
		txtcidade = new JTextField();
		txtcidade.setEditable(false);
		txtcidade.setColumns(10);
		txtcidade.setBounds(459, 138, 163, 19);
		contentPane.add(txtcidade);
		
		txtcomplemento = new JTextField();
		txtcomplemento.setEditable(false);
		txtcomplemento.setColumns(10);
		txtcomplemento.setBounds(459, 167, 163, 19);
		contentPane.add(txtcomplemento);
		
		txtcpf = new JTextField();
		txtcpf.setEditable(false);
		txtcpf.setColumns(10);
		txtcpf.setBounds(123, 193, 130, 19);
		contentPane.add(txtcpf);
		
		JLabel lblNewLabel = new JLabel("Código");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setBounds(21, 51, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProduto.setForeground(Color.WHITE);
		lblProduto.setBackground(Color.BLACK);
		lblProduto.setBounds(21, 80, 92, 13);
		contentPane.add(lblProduto);
		
		JLabel lblDataDaCompra = new JLabel("Data da compra");
		lblDataDaCompra.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataDaCompra.setForeground(Color.WHITE);
		lblDataDaCompra.setBackground(Color.BLACK);
		lblDataDaCompra.setBounds(21, 109, 92, 13);
		contentPane.add(lblDataDaCompra);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblQuantidade.setForeground(Color.WHITE);
		lblQuantidade.setBackground(Color.BLACK);
		lblQuantidade.setBounds(21, 167, 85, 13);
		contentPane.add(lblQuantidade);
		
		JLabel lblCpf = new JLabel("Cpf");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setBackground(Color.BLACK);
		lblCpf.setBounds(21, 196, 45, 13);
		contentPane.add(lblCpf);
		
		JLabel lblSetor = new JLabel("Setor");
		lblSetor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSetor.setForeground(Color.WHITE);
		lblSetor.setBackground(Color.BLACK);
		lblSetor.setBounds(21, 226, 45, 13);
		contentPane.add(lblSetor);
		
		JLabel lblCep = new JLabel("Cep");
		lblCep.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCep.setForeground(Color.WHITE);
		lblCep.setBackground(Color.BLACK);
		lblCep.setBounds(372, 49, 45, 13);
		contentPane.add(lblCep);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRua.setForeground(Color.WHITE);
		lblRua.setBackground(Color.BLACK);
		lblRua.setBounds(372, 80, 45, 13);
		contentPane.add(lblRua);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBairro.setForeground(Color.WHITE);
		lblBairro.setBackground(Color.BLACK);
		lblBairro.setBounds(372, 109, 45, 13);
		contentPane.add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCidade.setForeground(Color.WHITE);
		lblCidade.setBackground(Color.BLACK);
		lblCidade.setBounds(372, 141, 45, 13);
		contentPane.add(lblCidade);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblComplemento.setForeground(Color.WHITE);
		lblComplemento.setBackground(Color.BLACK);
		lblComplemento.setBounds(372, 170, 92, 13);
		contentPane.add(lblComplemento);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStatus.setForeground(Color.WHITE);
		lblStatus.setBackground(Color.BLACK);
		lblStatus.setBounds(372, 199, 45, 13);
		contentPane.add(lblStatus);
		
		txtstatus = new JTextField();
		txtstatus.setEditable(false);
		txtstatus.setColumns(10);
		txtstatus.setBounds(459, 196, 163, 19);
		contentPane.add(txtstatus);
		
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					//INVOCAR O CONECTOR DO BANCO DE DADOS:
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					// REALIZAR A CONEXÃO COM BANCO DE DADOS:
					
					Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/petrobras", "root", "alunolab");
					
					String consulta = txtcodigo.getText();
					
		            // Executar a consulta
		           PreparedStatement pesquisa = conexao.prepareStatement("SELECT * FROM pedidos where codigo = ?");
		           
		           pesquisa.setString(1, consulta);
		            
		        	ResultSet resultado = pesquisa.executeQuery();


		            // Processar os resultados
		            while (resultado.next()) {
		            	
		                // Supondo que você tenha uma coluna chamada "nome" na tabela
		                String codigo = resultado.getString("codigo");
		                String produto = resultado.getString("codigo_produto");
		                String compra = resultado.getString("data_compra");
		                String entrega = resultado.getString("data_entrega");
		                String quantidade = resultado.getString("quantidade");
		                String cpf_usuario = resultado.getString("cpf_usuario");
		                String setor = resultado.getString("setor");
		                String cep = resultado.getString("cep");
		                String rua = resultado.getString("rua");
		                String bairro = resultado.getString("bairro");
		                String cidade = resultado.getString("cidade");
		                String complemento = resultado.getString("complemento");
		                String status = resultado.getString("status_pedidos");
		                
		                txtcodigo.setText(codigo);
		                txtproduto.setText(produto);
		                txtcompra.setText(compra);
		                txtentrega.setText(entrega); 
		                txtquant.setText(quantidade);
		                txtcpf.setText(cpf_usuario);
		                txtsetor.setText(setor);
		                txtcep.setText(cep);
		                txtrua.setText(rua);
		                txtbairro.setText(bairro);
		                txtcidade.setText(cidade);
		                txtcomplemento.setText(complemento);
		                txtstatus.setText(status);
		            }
					
					//TRATANDO CONEXÃO COM BANCO DE DADOS SIM OU NÃO:
					
					} catch (Exception erro) {
						erro.printStackTrace();
						JOptionPane.showMessageDialog(null, "ERRO DE CONEXÃO COM BANCO DE DADOS");
					}
			
			
				
				
			}
				
				
				
				
				
				
			
				
				
				
			
				
				
					
	
		}
	
		);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(492, 293, 130, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblDataDeEntrega = new JLabel("Data de entrega");
		lblDataDeEntrega.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataDeEntrega.setForeground(Color.WHITE);
		lblDataDeEntrega.setBackground(Color.BLACK);
		lblDataDeEntrega.setBounds(21, 138, 92, 13);
		contentPane.add(lblDataDeEntrega);
		
		txtsetor = new JTextField();
		txtsetor.setEditable(false);
		txtsetor.setColumns(10);
		txtsetor.setBounds(123, 223, 130, 19);
		contentPane.add(txtsetor);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			Pedidos abrir = new Pedidos();
			
			abrir.setVisible(true);
			abrir.setLocationRelativeTo(null);
			setVisible(false);
			
			
			
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltar.setBounds(21, 293, 130, 38);
		contentPane.add(btnVoltar);
	}
}
