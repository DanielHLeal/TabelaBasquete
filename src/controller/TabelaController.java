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
    
    
    public TabelaController() { /* Construtor vazio */
        
    }
    
    
    public boolean inserirJogo(TabelaModel tabela){ /* Função para inserir um novo jogo na tabela */
        boolean retorno = false; /* boolean para retornar se houve sucesso ao inserir */
        Conexao c = new Conexao(); /* Conexão com Banco */
        calcularDados(tabela); /* Função para calcular os dados da tabela (Pontuação maxima e minima, e Recorde minima e maximo */
        
        String sql = "insert into jogos (jogo, placar ,minimotemp,maxtemp,quebrarecordemax,quebrarecordemin) values (?,?,?,?,?,?)"; /* Querry em SQL para inserir */
        try{
            PreparedStatement sentenca = c.con.prepareStatement(sql); /* Sentençã para preparar a inserção de dados */
            sentenca.setInt(1,tabela.getJogo()); /* Adiciona dados a setença */
            sentenca.setInt(2,tabela.getPlacar()); /* Adiciona dados a setença */
            sentenca.setInt(3,tabela.getMinimotemp()); /* Adiciona dados a setença */
            sentenca.setInt(4,tabela.getMaxtemp()); /* Adiciona dados a setença */
            sentenca.setInt(5,tabela.getQuebrarecordemin()); /* Adiciona dados a setença */
            sentenca.setInt(6,tabela.getQuebrarecordemax()); /* Adiciona dados a setença */
            if(!sentenca.execute()) /* Teste para saber se executa a setença*/
                retorno = true;
            c.desconectar(); /* Desconectar do banco */
        }catch(SQLException erro){
            System.out.println("Erro na sentenca: "+ erro.getMessage());
        }
        return retorno; /* retorno se conseguiu inserir */
    }
    
    public void calcularDados(TabelaModel tabela){ /* Função para Calcular Dados da Tabela Pontuação maxima e minima, e Recorde minima e maximo*/
        ArrayList<TabelaModel> todosItens = new ArrayList<>(); /* Array List para guardar todos itens da tabela*/
        todosItens = selecionarTodosTabelas(); /* Busca no metodo para selecionar todos dados da tabela e guardar Array List */
        int minTemp = 0; /* Variavel para guardar a pontuação minimo da temporada */
        int maxTemp = 0; /* Variavel para guardar a pontuação maximo da temporada */
        int minRecor = 0; /* Variavel para guardar o recorde minimo da temporada */
        int maxRecor = 0; /* Variavel para guardar o recorde maximo da temporada */
        int cont = 0; /* Variavel para saber quantos itens tem na tabela */
        int apoio = 0; /* apoio para controlar qual posição está na tabela */
        int entrou = 0; /* if para saber se conseguiu atigir o placar minimo ou maximo */
        for (TabelaModel x:todosItens) { /* for para percorrer o arquivo e descobrir quantos itens tem na tabela */
            cont++;            
        } // fim do primeiro for
        for (TabelaModel x:todosItens) { /* for para calcular a função */
            apoio++; /* apoio para controlar qual posição está na tabela */
            if (cont == apoio){ /* if para saber se estar na ultima posição */
                if(tabela.getPlacar() < x.getMinimotemp()){ /* If para saber se ele bateu o menor placar da tabela */
                  tabela.setMinimotemp(tabela.getPlacar()); /* Setar o minimo da tabela para o placar realizado */
                  tabela.setMaxtemp(x.getMaxtemp()); /* Tempo máximo se mantem */
                  tabela.setQuebrarecordemin(x.getQuebrarecordemin() + 1); /* Incrementa a quebra de recorde minimo*/
                  tabela.setQuebrarecordemax(x.getQuebrarecordemax()); /* Mantem a quebra de recorde maxima */
                  tabela.setJogo(x.getJogo()+1); /* controle do ultimo codigo do jogo, incrementar o ultimo codigo */
                  entrou = 1; /* setar 1 para saber que entrou no if */
                } // fim do if menor placar
                if(tabela.getPlacar() > x.getMaxtemp()){ /* If para saber se ele bateu o maior placar da tabela */
                  tabela.setMinimotemp(x.getMinimotemp()); /* Tempo minimo se mantem */
                  tabela.setMaxtemp(tabela.getPlacar()); /* Setar o maximo da tabela para o placar realizado */
                  tabela.setQuebrarecordemin(x.getQuebrarecordemin()); /* Mantem a quebra de recorde minimo */
                  tabela.setQuebrarecordemax(x.getQuebrarecordemax() + 1); /* Incrementa a quebra de recorde maximo*/
                  tabela.setJogo(x.getJogo()+1); /* controle do ultimo codigo do jogo, incrementar o ultimo codigo */
                  entrou = 1; /* setar 1 para saber que entrou no if */
                } // fim do if maior placar
                if(entrou == 0){ /* Se não entrar em nenhum if, significa que não quebrou nenhum recorde */
                  tabela.setMinimotemp(x.getMinimotemp()); /* Tempo minimo se mantem */
                  tabela.setMaxtemp(x.getMaxtemp()); /* Tempo máximo se mantem */
                  tabela.setQuebrarecordemin(x.getQuebrarecordemin()); /* Mantem a quebra de recorde minimo */
                  tabela.setQuebrarecordemax(x.getQuebrarecordemax()); /* Mantem a quebra de recorde maxima */
                  tabela.setJogo(x.getJogo()+1); /* controle do ultimo codigo do jogo, incrementar o ultimo codigo */
                } // fim do if quando não entrar em nenhum if
            } // fim do if para saber se estar na ultima posição         
        } // fim do for para calcular a função 
    } // fim do metodo de calcular dados
    
    
    public boolean excluir(TabelaModel tabela){ //Metodo pra excluir o ultimo jogo
        boolean retorno = false; // Boleano para saber se conseguiu ou não executar
        Conexao c = new Conexao(); // Conexão com Banco de Dados
        String sql = "delete from jogos where jogo = ?"; // String com a setença no sql
        try{
            PreparedStatement sentenca = c.con.prepareStatement(sql); // Prepara a setença
            sentenca.setInt(1, tabela.getJogo()); // Seta qual jogo irá excluir
            if(!sentenca.execute()) // Verifica se houve sucesso a executar a setença
                retorno = true; // Se houve seta como true o retorno da função
            c.desconectar(); // desconecta do banco
        }catch(SQLException erro){
            System.out.println("Erro na sentenca: "+ erro.getMessage());
        }
        return retorno;
    } // fim do metodo de excluir tabela
    
    public ArrayList<TabelaModel> selecionarTodosTabelas(){ // Função para selionar todos dados da tabela
        ArrayList<TabelaModel> lista = new ArrayList<>(); // Array List para armazenar todos dados da tabela
        Conexao c = new Conexao(); // Conexão com banco de dados
        String sql = "select * from jogos"; // String com Querry do SQL
        try{
            PreparedStatement sentenca = c.con.prepareStatement(sql); // setença que prepara a querry e executa o sql
            ResultSet rs = sentenca.executeQuery(); //variavel para armazenar dados da setença
            while(rs.next()){ // while pra percorrer
                TabelaModel p= new TabelaModel(); // Variavel com o Model da Tabela
                p.setJogo(rs.getInt("jogo")); // Armazena os dados procurados
                p.setPlacar(rs.getInt("placar")); // Armazena os dados procurados
                p.setMinimotemp(rs.getInt("minimotemp")); // Armazena os dados procurados
                p.setMaxtemp(rs.getInt("maxtemp")); // Armazena os dados procurados
                p.setQuebrarecordemin(rs.getInt("quebrarecordemax")); // Armazena os dados procurados
                p.setQuebrarecordemax(rs.getInt("quebrarecordemin")); // Armazena os dados procurados
                lista.add(p); // Armazena os dados do model no Array List
            }
            c.desconectar(); // desconecta do banco de dados
        }catch(SQLException erro){
            System.out.println("Erro na sentenca: "+ erro.getMessage());
        }
        return lista; // retorna a lista com toda a tabela
    } // fim do metodo para selecionar todos dados
        
    public TabelaModel selecionarUltimo(){ // Selecionar o ultimo jogo da tabela 
        ArrayList<TabelaModel> todosItens = new ArrayList<>(); // Array list para armazenar todos itens da tabela
        todosItens = selecionarTodosTabelas(); // chama a função de selecionar todos itens da tabela para armazenar no array
        int cont = 0; // variavel contadora para achar o ultimo item
        for (TabelaModel x:todosItens) { // for para pecorrer todo arraylist e encontrar o numero de total de jogos
            cont++; // incrementa a variavel a cada vez que pecorre             
        } // fim do for que pecorre todo array list
        TabelaModel tabela = new TabelaModel(); // cria uma variavel do tipo Tabela model
        tabela.setJogo(cont); // seta na variavel tabela no jogo a ultima posição encontrada
        TabelaModel p = null; // cria uma variavel de Tabela Model nulo
        Conexao c = new Conexao(); // conecta com banco de dados
        String sql = "select * from jogos where jogo = ?"; // prepara a querry sql dentro de uma string
        try{
            PreparedStatement sentenca = c.con.prepareStatement(sql); // prepara para excutar a setença sql
            sentenca.setInt(1, tabela.getJogo()); // seta a ultima posição como o jogo para procurar
            ResultSet rs = sentenca.executeQuery(); //variavel para armazenar dados da setença
            if(rs.next()){ // se encontrar a ultima posição ele traz todos dados
                p = new TabelaModel(); // instancia a variavel p criada para armazenar os dados
                p.setJogo(rs.getInt("jogo")); // armazena o jogo para confirmar 
                p.setPlacar(rs.getInt("placar"));// armazena o placar                 
            }
            c.desconectar(); // desconeta do banco
        }catch(SQLException erro){
            System.out.println("Erro na sentenca: "+ erro.getMessage());
        }
        return p; // retorna a Tabela Model com o ultimo jogo
    } // fim do metodo selecionar ultimo
} // fim
