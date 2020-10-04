
package until;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Daniel Leal
 */
public class Conexao { // Classe para realizar a conexão com banco de dados
   public Connection con; //cria a variavel de conexao
    
    public Conexao(){ // Classe para realizar a conexão com banco de dados
        try{
            Class.forName("com.mysql.jdbc.Driver"); // Integração com Driver do SQL
            String url = "jdbc:mysql://localhost:3306/tabelabasquete?useTimezone=true&serverTimezone=UTC"; // conexão com banco de dados Tabela de Basquete
            String user = "root"; // usuario do mysql
            String password = "admin";// senha do mysql
            con = DriverManager.getConnection(url, user, password); // conecta ao banco passando o caminho do banco, usuario e senha

        }catch(ClassNotFoundException erro){ // catch para encontrar erro na conexao
            System.out.println("Driver não encontrado!" + erro.getMessage()); // erro quando nao encontrar o driver
        }catch(SQLException erro){ 
            System.out.println("Erro na conexão com DB!" + erro.getMessage()); // erro com banco de dados
        } // fim Exception clausula de erro
    }//fim da classe Conexao
    
    public void desconectar(){ // classe para desconectar do banco de dados
        try{ // try catch para desconctar do banco
            con.close(); // descontar do banco
        }catch(SQLException erro){ // catch com Expetion erro do SQL
            System.out.println("Erro ao desconectar!" + erro.getMessage()); // erro pra desconctar
        }// fim do try catch
    } // fim da classe de desconctar
 
}// fim da classe java de conexao
