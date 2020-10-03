
package model;

/**
 *
 * @author Daniel Leal
 */
public class TabelaModel { // classe com Model, todas variaveis do tabela
    int jogo; // Variavel inteira do Numero do Jogo
    int placar; // Variavel inteira Placar do Jogo
    int minimotemp;//Variavel inteira  Minimo da temporada
    int maxtemp;//Variavel inteira Maximo da temporada
    int quebrarecordemax;//Variavel inteira quebra de recorde maximo
    int quebrarecordemin;//Variavel inteira quebra de recorde minimo
    
    // Metodos get e set das variaveis criadas
    public int getJogo() { 
        return jogo;
    }

    public void setJogo(int jogo) {
        this.jogo = jogo;
    }

    public int getPlacar() {
        return placar;
    }

    public void setPlacar(int placar) {
        this.placar = placar;
    }

    public int getMinimotemp() {
        return minimotemp;
    }

    public void setMinimotemp(int minimotemp) {
        this.minimotemp = minimotemp;
    }

    public int getMaxtemp() {
        return maxtemp;
    }

    public void setMaxtemp(int maxtemp) {
        this.maxtemp = maxtemp;
    }

    public int getQuebrarecordemax() {
        return quebrarecordemax;
    }

    public void setQuebrarecordemax(int quebrarecordemax) {
        this.quebrarecordemax = quebrarecordemax;
    }

    public int getQuebrarecordemin() {
        return quebrarecordemin;
    }

    public void setQuebrarecordemin(int quebrarecordemin) {
        this.quebrarecordemin = quebrarecordemin;
    }
    
    
} // fim da classe java tabela model
