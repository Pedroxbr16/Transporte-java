package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Window.Type;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Pedidos extends JFrame {

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
	public Pedidos() {
		setTitle("Cadastro de Pedidos");
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		txtproduto.setColumns(10);
		txtproduto.setBounds(123, 77, 130, 19);
		contentPane.add(txtproduto);
		
		txtcompra = new JTextField();
		txtcompra.setColumns(10);
		txtcompra.setBounds(123, 106, 130, 19);
		contentPane.add(txtcompra);
		
		txtentrega = new JTextField();
		txtentrega.setColumns(10);
		txtentrega.setBounds(123, 135, 130, 19);
		contentPane.add(txtentrega);
		
		txtquant = new JTextField();
		txtquant.setColumns(10);
		txtquant.setBounds(123, 164, 130, 19);
		contentPane.add(txtquant);
		
		txtcep = new JTextField();
		txtcep.setColumns(10);
		txtcep.setBounds(459, 46, 163, 19);
		contentPane.add(txtcep);
		
		txtrua = new JTextField();
		txtrua.setColumns(10);
		txtrua.setBounds(459, 77, 163, 19);
		contentPane.add(txtrua);
		
		txtbairro = new JTextField();
		txtbairro.setColumns(10);
		txtbairro.setBounds(459, 106, 163, 19);
		contentPane.add(txtbairro);
		
		txtcidade = new JTextField();
		txtcidade.setColumns(10);
		txtcidade.setBounds(459, 138, 163, 19);
		contentPane.add(txtcidade);
		
		txtcomplemento = new JTextField();
		txtcomplemento.setColumns(10);
		txtcomplemento.setBounds(459, 167, 163, 19);
		contentPane.add(txtcomplemento);
		
		txtcpf = new JTextField();
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
		
		JComboBox txtsetor = new JComboBox();
		txtsetor.setModel(new DefaultComboBoxModel(new String[] {"","Pedido", "Transporte", "Recebimento"}));
		txtsetor.setBounds(123, 222, 130, 21);
		contentPane.add(txtsetor);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStatus.setForeground(Color.WHITE);
		lblStatus.setBackground(Color.BLACK);
		lblStatus.setBounds(372, 199, 45, 13);
		contentPane.add(lblStatus);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
				
try {
					
					//INVOCAR O CONECTOR DO BANCO DE DADOS:
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					// REALIZAR A CONEXÃO COM BANCO DE DADOS:
					
					Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/petrobras", "root", "alunolab");
					
					//PEGAR VALORES DAS CAIXAS DE TEXTOS:
					String codigo = txtcodigo.getText();
					String produto = txtproduto.getText();					
					String compra = txtcompra.getText();					
					String entrega = txtentrega.getText();
					String quantidade = txtquant.getText();
					String cpf = txtcpf.getText();
					String setor = txtsetor.getSelectedItem().toString();
					String cep = txtcep.getText();
					String rua = txtrua.getText();
					String bairro = txtbairro.getText();
					String cidade = txtcidade.getText();
					String complemento = txtcomplemento.getText();
				    JComboBox txts = null;
					String status = txts.getSelectedItem().toString();
					
					int quanti = Integer.parseInt(quantidade);
					//INSERIR DADOS ATRAVÉS DE LINGUAGEM SQL:
					
					String inserir = "INSERT INTO usuario (codigo, codigo_prodto, data_compra, data_entrega, quantidade, cpf_usuario, setor, cep, rua, bairro, cidade, complemento, status_pedido) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					
					//PREPARANDO PARA ENVIAR:
					
					PreparedStatement statement = conexao.prepareStatement(inserir);
					
					statement.setString(1, codigo);
					statement.setString(2, produto);
					statement.setString(3, compra);
					statement.setString(4, entrega);
					statement.setInt(5, quanti);
					statement.setString(6, cpf);
					statement.setString(7, setor);
					statement.setString(8, cep);
					statement.setString(9, rua);
					statement.setString(10, bairro);
					statement.setString(11, cidade);
					statement.setString(12, complemento);
					statement.setString(13, status);
					
					int resultado = statement.executeUpdate();
					
					//TRATANDO CONDIÇÃO PARA SABER A A LINHA DO CADASTRO SERÁ PREENCHIDA:
					
					if (resultado > 0) {
						
						JOptionPane.showMessageDialog(null, "Pedido Cadastrado Com Sucesso!");
					}else{
							JOptionPane.showMessageDialog(null, "ERRO DE CADASTRO, CONFIRA OS DADOS E TENTE NOVAMENTE!");
						}
					
					//TRATANDO CONEXÃO COM BANCO DE DADOS SIM OU NÃO:22
					
					} catch (Exception erro) {
						erro.printStackTrace();
						JOptionPane.showMessageDialog(null, "ERRO DE CONEXÃO COM BANCO DE DADOS");
					}
			
				
				
				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(492, 293, 130, 38);
		contentPane.add(btnNewButton);
	
		
		JButton btnConsultaDePedidos = new JButton("Consulta de Pedidos");
		btnConsultaDePedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				
				ConsultaPedidos abrir = new ConsultaPedidos();
				
				abrir.setVisible(true);
				abrir.setLocationRelativeTo(null);
				setVisible(false);
				
				
				
				
				
				
			}
		});
		btnConsultaDePedidos.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConsultaDePedidos.setBounds(21, 293, 163, 38);
		contentPane.add(btnConsultaDePedidos);
		
		JLabel lblDataDeEntrega = new JLabel("Data de entrega");
		lblDataDeEntrega.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataDeEntrega.setForeground(Color.WHITE);
		lblDataDeEntrega.setBackground(Color.BLACK);
		lblDataDeEntrega.setBounds(21, 138, 92, 13);
		contentPane.add(lblDataDeEntrega);
		
		JComboBox txts = new JComboBox();
		txts.setModel(new DefaultComboBoxModel(new String[] {"", "Em Andamento"}));
		txts.setEditable(true);
		txts.setBounds(459, 197, 163, 22);
		contentPane.add(txts);
	}
}
