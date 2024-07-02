
package Telas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtemail;
	private JTextField txtsenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/IMG/LOGO.jpg")));
		setTitle("Reception Alert");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 846, 475);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(146, 187, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtemail = new JTextField();
		txtemail.setBounds(596, 259, 207, 19);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Email:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(541, 262, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(541, 313, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		txtsenha = new JTextField();
		txtsenha.setColumns(10);
		txtsenha.setBounds(596, 310, 207, 19);
		contentPane.add(txtsenha);
		
		JButton btnNewButton = new JButton("Logar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
				
					try {
					
					//INVOCAR O CONECTOR DO BANCO DE DADOS:
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					// REALIZAR A CONEXÃO COM BANCO DE DADOS:
					
					Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/petrobras", "root", "alunolab");
					
					String consulta = txtemail.getText();
					
		            // Executar a consulta
		           PreparedStatement pesquisa = conexao.prepareStatement("SELECT * FROM usuario where email = ?");
		           
		           pesquisa.setString(1, consulta);
		            
		        	ResultSet resultado = pesquisa.executeQuery();
		        	
		        	String email = "";
		        	String senha = "";
		        	String setor = "";
		        	
		        	


		            // Processar os resultados
		            while (resultado.next()) {//INICIO DO ENQUANTO
		            	
		                // Supondo que você tenha uma coluna chamada "nome" na tabela
		            	email = resultado.getString("email");
		                senha = resultado.getString("senha");
		                setor = resultado.getString("setor");
		                
		                if(txtemail.getText().equals(email) && txtsenha.getText().equals(senha) && setor.equals("Pedido")) {
		                	
		                	JOptionPane.showMessageDialog(null, "Seja Bem Vindo(a) ao Sistema!");
		                	
		                	MenuPedido pedidos = new MenuPedido();
		                	
		                	pedidos.setVisible(true);
			                pedidos.setLocationRelativeTo(null);
			                setVisible(false);
			                
		                	
		            	
			                
		            		}//FIMSE
		            
		                else if(txtemail.getText().equals(email) && txtsenha.getText().equals(senha) && setor.equals("Transporte")) {
		                	
		                	JOptionPane.showMessageDialog(null, "Seja Bem Vindo(a) ao Sistema!");
		                	
		                	MenuTransporte transportes = new MenuTransporte();
		                	
		                	transportes.setVisible(true);
		                	transportes.setLocationRelativeTo(null);
			                setVisible(false);
		                	
	
		            		
		                }
		                	
		                else if(txtemail.getText().equals(email) && txtsenha.getText().equals(senha) && setor.equals("Recebimento")) {
		            		
		            			JOptionPane.showMessageDialog(null, "Seja Bem Vindo(a) ao Sistema!");
			                	
			                	MenuRecebimento recebimentos = new MenuRecebimento();
			                	
			                	recebimentos .setVisible(true);
			                	recebimentos .setLocationRelativeTo(null);
				                setVisible(false);
			                	
			                }else{
		            			
			            		JOptionPane.showMessageDialog(null, "A Senha esta Incorreta!!!");	
		            			
		            			
			                }
		                }
		                
		                
		                
		            }//FIM DO ENQUANTO
		            
		            
					
					//TRATANDO CONEXÃO COM BANCO DE DADOS SIM OU NÃO:
					
					 catch (Exception erro) {
						erro.printStackTrace();
						JOptionPane.showMessageDialog(null, "ERRO DE CONEXÃO COM BANCO DE DADOS");
					}
			
			
				
				
			}



				
				
				
			}
		);
		btnNewButton.setBounds(634, 340, 109, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cadastrar - se");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CadastroLogin abrir = new CadastroLogin();
				
				abrir.setVisible(true);
				abrir.setLocationRelativeTo(null);
				btnNewButton_1.setCursor(new Cursor(Cursor.HAND_CURSOR));


				
			}
		});
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_1.setBounds(694, 389, 109, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/IMG/LOGO COMPLETO.jpg")));
		lblNewLabel_2.setBounds(448, 11, -141, 80);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(342, 11, 133, 80);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Login.class.getResource("/IMG/fundoTelaLogin_Azul2.png")));
		lblNewLabel_5.setBounds(0, 0, 531, 436);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/IMG/logo 11.03.jpg")));
		lblNewLabel_3.setBounds(533, 0, 296, 238);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_6 = new JLabel("Sem cadastro?");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(584, 392, 100, 13);
		contentPane.add(lblNewLabel_6);
	}
}
