/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import until.Conexao;
import model.TabelaModel;

/**
 *
 * @author Daniel Leal
 */
public class TabelaController {
    public boolean inserirJogo(TabelaModel tabela){
        boolean retorno = false;
        Conexao c = new Conexao();
        String sql = "insert into jogos (placar ,minimotemp,maxtemp,quebrarecordemax,quebrarecordemin) values (?,?,?,?,?)";
        try{
            PreparedStatement sentenca = c.con.prepareStatement(sql);
            sentenca.setInt(1,tabela.getPlacar());
            sentenca.setInt(2,tabela.getMinimotemp());
            sentenca.setInt(3,tabela.getMaxtemp());
            sentenca.setInt(4,tabela.getQuebrarecordemax());
            sentenca.setInt(5,tabela.getQuebrarecordemin());
            
            if(!sentenca.execute())
                retorno = true;
            c.desconectar();
        }catch(SQLException erro){
            System.out.println("Erro na sentenca: "+ erro.getMessage());
        }
        return retorno;
    }
    
    public boolean editarTabela(TabelaModel tabela){
        boolean retorno = false;
        Conexao c = new Conexao();
        String sql = "update jogos set placar = ? , minimotemp = ? , maxtemp = ? , quebrarecordemax = ? , quebrarecordemin = ?"
                + "where jogo = ?";
        try{
            PreparedStatement sentenca = c.con.prepareStatement(sql);
            sentenca.setInt(1,tabela.getPlacar());
            sentenca.setInt(2,tabela.getMinimotemp());
            sentenca.setInt(3,tabela.getMaxtemp());
            sentenca.setInt(4,tabela.getQuebrarecordemax());
            sentenca.setInt(5,tabela.getQuebrarecordemin());
            
            if(sentenca.executeUpdate()==1)
                retorno = true;
            c.desconectar();
        }catch(SQLException erro){
            System.out.println("Erro na sentenca: "+ erro.getMessage());
        }
        return retorno;
    }
    
    public boolean excluirTabela(TabelaModel tabela){
        boolean retorno = false;
        Conexao c = new Conexao();
        String sql = "delete from jogos where jogo = ?";
        try{
            PreparedStatement sentenca = c.con.prepareStatement(sql);
            sentenca.setInt(1, tabela.getJogo());
            if(!sentenca.execute())
                retorno = true;
            c.desconectar();
        }catch(SQLException erro){
            System.out.println("Erro na sentenca: "+ erro.getMessage());
        }
        return retorno;
    }
    
    
    public ArrayList<TabelaModel> selecionarTodosTabelas(){
        ArrayList<TabelaModel> lista = new ArrayList<>();
        Conexao c = new Conexao();
        String sql = "select * from jogos";
        try{
            PreparedStatement sentenca = c.con.prepareStatement(sql);
            ResultSet rs = sentenca.executeQuery();
            while(rs.next()){
                TabelaModel p= new TabelaModel();
                p.setJogo(rs.getInt("jogo"));
                p.setPlacar(rs.getInt("placar"));
                p.setMinimotemp(rs.getInt("minimotemp"));
                p.setMaxtemp(rs.getInt("maxtemp"));
                p.setQuebrarecordemin(rs.getInt("quebrarecordemax"));
                p.setQuebrarecordemax(rs.getInt("quebrarecordemin"));
                lista.add(p);
            }
            c.desconectar();
        }catch(SQLException erro){
            System.out.println("Erro na sentenca: "+ erro.getMessage());
        }
        return lista;
    }
}
