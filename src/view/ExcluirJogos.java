package view;

import controller.TabelaController;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.TabelaModel;

/**
 *
 * @author Daniel Leal
 */
public class ExcluirJogos extends javax.swing.JFrame {

    public ExcluirJogos() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        jtxPlacar.setEnabled(false);
        jlPlacar.setEnabled(false);
        jtxJogo.setEnabled(false);
        TabelaModel tabela = new TabelaModel();
        TabelaController t = new TabelaController();
        tabela = t.selecionarUltimo();
        jtxJogo.setText(String.valueOf(tabela.getJogo()));
        jtxPlacar.setText(String.valueOf(tabela.getPlacar()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpExcluir = new javax.swing.JPanel();
        jbSair = new javax.swing.JButton();
        jtxPlacar = new javax.swing.JTextField();
        jlJogo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtxJogo = new javax.swing.JTextField();
        jlPlacar = new javax.swing.JLabel();
        jbExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpExcluir.setBackground(new java.awt.Color(255, 255, 255));

        jbSair.setBackground(new java.awt.Color(255, 255, 255));
        jbSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logout256_24927.png"))); // NOI18N
        jbSair.setText("Sair");
        jbSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairActionPerformed(evt);
            }
        });

        jtxPlacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxPlacarActionPerformed(evt);
            }
        });

        jlJogo.setText("Jogo:");

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Remover Ultimo Jogo");

        jtxJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxJogoActionPerformed(evt);
            }
        });

        jlPlacar.setText("Placar:");

        jbExcluir.setBackground(new java.awt.Color(255, 255, 255));
        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/rec.png"))); // NOI18N
        jbExcluir.setText("Excluir");
        jbExcluir.setBorderPainted(false);
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpExcluirLayout = new javax.swing.GroupLayout(jpExcluir);
        jpExcluir.setLayout(jpExcluirLayout);
        jpExcluirLayout.setHorizontalGroup(
            jpExcluirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpExcluirLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(jpExcluirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpExcluirLayout.createSequentialGroup()
                        .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jbSair, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpExcluirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jpExcluirLayout.createSequentialGroup()
                            .addComponent(jlPlacar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jtxPlacar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpExcluirLayout.createSequentialGroup()
                            .addComponent(jlJogo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jtxJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(379, Short.MAX_VALUE))
        );
        jpExcluirLayout.setVerticalGroup(
            jpExcluirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpExcluirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(13, 13, 13)
                .addGroup(jpExcluirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlJogo)
                    .addComponent(jtxJogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jpExcluirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxPlacar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlPlacar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpExcluirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSair, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(231, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSairActionPerformed
        // botão para sair da tela de exclusão de jogo
        Principal principal = new Principal(); // cria uma nova tela Principal
        principal.setVisible(true); // torna ela visivel
        principal.atualizarTabela(); // atualiza tabela de jogos
        dispose();  // fecha a tela de exclusã ode jogo
    }//GEN-LAST:event_jbSairActionPerformed

    private void jtxPlacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxPlacarActionPerformed

    }//GEN-LAST:event_jtxPlacarActionPerformed

    private void jtxJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxJogoActionPerformed
        
    }//GEN-LAST:event_jtxJogoActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        //botão para excluir tabela
        TabelaController tabela = new TabelaController(); // cria uma variavel tabela do tipo Tabela Controller que permite chamar os metodos de exclusao
        boolean excluir = false; // variavel booleana para armazenar se conseguiu excluir 
        TabelaModel t = new TabelaModel(); // Cria uma variavel t do tipo TabelaModel para armazenar os dados digitados no JTextField
        t.setJogo(Integer.parseInt(jtxJogo.getText())); // armazena o ultimo jogo
        excluir = tabela.excluir(t); // chama a função de excluir passando o numero do jogo e retornando booleano
        if (excluir = true){ // se ocorreu tudo bem na exclusão exibe mensagem de confirmação
            JOptionPane.showMessageDialog(this, "Jogo excluido com sucesso!", 
                "Retorno", JOptionPane.INFORMATION_MESSAGE); // mensagem de sucesso
            jtxJogo.setText(""); // esvazia o jtxfield de jogo
            jtxPlacar.setText(""); //esvazia o jtxfield de Placar
        }else{
            JOptionPane.showMessageDialog(this, "Erro ao Excluir o Jogo!",
                "Retorno", JOptionPane.ERROR_MESSAGE);
   
        }
        
        TabelaModel novatabela = new TabelaModel();  // cria uma nova tabela para armazenar dados de jogos
        TabelaController novot = new TabelaController(); // cria novo controler que permite chamar metodo de selecionar
        novatabela = novot.selecionarUltimo(); // busca novamente a ultimo jogo na tabela
        jtxJogo.setText(String.valueOf(novatabela.getJogo())); // define o ultimo jogo
        jtxPlacar.setText(String.valueOf(novatabela.getPlacar())); // define o ultimo placar
    }//GEN-LAST:event_jbExcluirActionPerformed
    // Main do JFrame de Excluir Jogos
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExcluirJogos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbSair;
    private javax.swing.JLabel jlJogo;
    private javax.swing.JLabel jlPlacar;
    private javax.swing.JPanel jpExcluir;
    private javax.swing.JTextField jtxJogo;
    private javax.swing.JTextField jtxPlacar;
    // End of variables declaration//GEN-END:variables
}
