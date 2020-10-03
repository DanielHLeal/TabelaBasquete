/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package until;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Daniel Leal
 */
public class Conexao {
   public Connection con;
    
    public Conexao(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/tabelabasquete";
            String user = "root";
            String password = "daniel9951";
            con = DriverManager.getConnection(url, user, password);

        }catch(ClassNotFoundException erro){
            System.out.println("Driver não encontrado!" + erro.getMessage());
        }catch(SQLException erro){
            System.out.println("Erro na conexão com DB!" + erro.getMessage());
        }
    }
    
    public void desconectar(){
        try{
            con.close();
        }catch(SQLException erro){
            System.out.println("Erro ao desconectar!" + erro.getMessage());
        }
    }
 
}
