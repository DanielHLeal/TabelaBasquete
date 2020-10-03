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

    public TabelaController() {
        
    }
    
    
    public boolean inserirJogo(TabelaModel tabela){
        boolean retorno = false;
        Conexao c = new Conexao();
        calcularDados(tabela);
        
        String sql = "insert into jogos (jogo, placar ,minimotemp,maxtemp,quebrarecordemax,quebrarecordemin) values (?,?,?,?,?,?)";
        try{
            PreparedStatement sentenca = c.con.prepareStatement(sql);
            sentenca.setInt(1,tabela.getJogo());
            sentenca.setInt(2,tabela.getPlacar());
            sentenca.setInt(3,tabela.getMinimotemp());
            sentenca.setInt(4,tabela.getMaxtemp());
            sentenca.setInt(5,tabela.getQuebrarecordemin());
            sentenca.setInt(6,tabela.getQuebrarecordemax());
            if(!sentenca.execute())
                retorno = true;
            c.desconectar();
        }catch(SQLException erro){
            System.out.println("Erro na sentenca: "+ erro.getMessage());
        }
        return retorno;
    }
    
    public void calcularDados(TabelaModel tabela){
        ArrayList<TabelaModel> todosItens = new ArrayList<>();
        todosItens = selecionarTodosTabelas();
        int minTemp = 0;
        int maxTemp = 0;
        int minRecor = 0;
        int maxRecor = 0;
        int cont = 0;
        int apoio = 0;
        int entrou = 0;
        for (TabelaModel x:todosItens) {
            cont++;            
        }
        for (TabelaModel x:todosItens) {
            apoio++;
            if (cont == apoio){
                if(tabela.getPlacar() < x.getMinimotemp()){
                  tabela.setMinimotemp(tabela.getPlacar());
                  tabela.setMaxtemp(x.getMaxtemp());
                  tabela.setQuebrarecordemin(x.getQuebrarecordemin() + 1);
                  tabela.setQuebrarecordemax(x.getQuebrarecordemax());
                  tabela.setJogo(x.getJogo()+1);
                  entrou = 1;
                }
                if(tabela.getPlacar() > x.getMaxtemp()){;
                  tabela.setMinimotemp(x.getMinimotemp());
                  tabela.setMaxtemp(tabela.getPlacar());
                  tabela.setQuebrarecordemin(x.getQuebrarecordemin());
                  tabela.setQuebrarecordemax(x.getQuebrarecordemax() + 1);
                  tabela.setJogo(x.getJogo()+1);
                  entrou = 1;
                }
                if(entrou == 0){
                  tabela.setMinimotemp(x.getMinimotemp());
                  tabela.setMaxtemp(x.getMaxtemp());
                  tabela.setQuebrarecordemin(x.getQuebrarecordemin());
                  tabela.setQuebrarecordemax(x.getQuebrarecordemax());
                  tabela.setJogo(x.getJogo()+1);
                }
            }           
        }
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
    
    
    
    public boolean excluir(TabelaModel tabela){
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
        
    public TabelaModel selecionarUltimo(){
        ArrayList<TabelaModel> todosItens = new ArrayList<>();
        todosItens = selecionarTodosTabelas();
        int cont = 0;
        for (TabelaModel x:todosItens) {
            cont++;            
        }
        TabelaModel tabela = new TabelaModel();
        tabela.setJogo(cont);
        TabelaModel p = null;
        Conexao c = new Conexao();
        String sql = "select * from jogos where jogo = ?";
        try{
            PreparedStatement sentenca = c.con.prepareStatement(sql);
            sentenca.setInt(1, tabela.getJogo());
            ResultSet rs = sentenca.executeQuery();
            if(rs.next()){
                p = new TabelaModel();
                p.setJogo(rs.getInt("jogo"));
                p.setPlacar(rs.getInt("placar"));                
            }
            c.desconectar();
        }catch(SQLException erro){
            System.out.println("Erro na sentenca: "+ erro.getMessage());
        }
        return p;
    }
}
