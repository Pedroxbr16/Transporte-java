package Telas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class TabelaPedidoAndamento extends JFrame {
   public TabelaPedidoAndamento() {
       setTitle("Tabela de Pedidos Recebidos");
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       // Criar um modelo de tabela padrão
       DefaultTableModel modeloTabela = new DefaultTableModel();
       // Adicionar colunas ao modelo de tabela
       modeloTabela.addColumn("Código");
       modeloTabela.addColumn("Produto");
       modeloTabela.addColumn("Data de Compra");
       modeloTabela.addColumn("Data de Entrega");
       // Adicione mais colunas conforme necessário
       try {
           // Conectar ao banco de dados
           Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/petrobras", "root", "alunolab");
           // Preparar e executar a consulta SQL
           PreparedStatement consulta = conexao.prepareStatement("SELECT * FROM pedidos WHERE status_pedido = ?");
           consulta.setString(1, "Em Andamento");
           ResultSet resultado = consulta.executeQuery();
           // Processar os resultados e preencher a tabela
           while (resultado.next()) {
               modeloTabela.addRow(new Object[]{
                   resultado.getString("codigo"),
                   resultado.getString("codigo_produto"),
                   resultado.getString("data_compra"),
                   resultado.getString("data_entrega")
                      
                   // Adicione mais colunas conforme necessário
               });
           }
           // Fechar a conexão com o banco de dados
           conexao.close();
       } catch (SQLException e) {
           e.printStackTrace();
           JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados");
       }
       // Criar uma JTable com o modelo de tabela preenchido
       JTable tabela = new JTable(modeloTabela);
       // Adicionar a tabela a um JScrollPane e exibi-la
       JScrollPane scrollPane = new JScrollPane(tabela);
       add(scrollPane);
       setSize(600, 400);
       setVisible(true);
       setLocationRelativeTo(null);
   }
   public static void main(String[] args) {
       // Criar uma instância da classe e exibir a janela
       new TabelaPedidoAndamento();
   }
}



