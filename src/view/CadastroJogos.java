/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.TabelaController;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.TabelaModel;

/**
 *
 * @author Daniel Leal
 */
public class CadastroJogos extends javax.swing.JFrame {

    public CadastroJogos() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE); 
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbCadastrar = new javax.swing.JButton();
        jbSair = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtxPlacar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jbCadastrar1 = new javax.swing.JButton();
        jbSair1 = new javax.swing.JButton();

        jbCadastrar.setBackground(new java.awt.Color(255, 255, 255));
        jbCadastrar.setText("Novo");
        jbCadastrar.setBorderPainted(false);
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });

        jbSair.setBackground(new java.awt.Color(255, 255, 255));
        jbSair.setText("Sair");
        jbSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Placar:");

        jtxPlacar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jtxPlacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxPlacarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Adicionar Novo Jogo");

        jbCadastrar1.setBackground(new java.awt.Color(255, 255, 255));
        jbCadastrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/inserir.png"))); // NOI18N
        jbCadastrar1.setText("Novo");
        jbCadastrar1.setBorderPainted(false);
        jbCadastrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrar1ActionPerformed(evt);
            }
        });

        jbSair1.setBackground(new java.awt.Color(255, 255, 255));
        jbSair1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logout256_24927.png"))); // NOI18N
        jbSair1.setText("Sair");
        jbSair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSair1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jbCadastrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbSair1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxPlacar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(467, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxPlacar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCadastrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSair1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(251, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxPlacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxPlacarActionPerformed

    }//GEN-LAST:event_jtxPlacarActionPerformed

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        
    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSairActionPerformed

        dispose();
    }//GEN-LAST:event_jbSairActionPerformed
    
    public void limparCampos(){
        jtxPlacar.setText("");
    }
    
    private void jbCadastrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrar1ActionPerformed
        TabelaModel tabela = new TabelaModel();
        
        tabela.setPlacar(Integer.parseInt(jtxPlacar.getText()));
        TabelaController controle = new TabelaController();
        if(controle.inserirJogo(tabela)){
            JOptionPane.showMessageDialog(this, "Tabela Inserido com sucesso!");
            limparCampos();
            
        }else{
            JOptionPane.showMessageDialog(this, "Erro ao Inserir o tabela!", 
            "Retorno", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jbCadastrar1ActionPerformed

    private void jbSair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSair1ActionPerformed
        Principal principal = new Principal();
        principal.setVisible(true);
        principal.atualizarTabela();
        dispose();        
    }//GEN-LAST:event_jbSair1ActionPerformed
    

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroJogos().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbCadastrar1;
    private javax.swing.JButton jbSair;
    private javax.swing.JButton jbSair1;
    private javax.swing.JTextField jtxPlacar;
    // End of variables declaration//GEN-END:variables
}
