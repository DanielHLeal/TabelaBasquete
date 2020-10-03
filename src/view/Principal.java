
package view;

import controller.TabelaController;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.TabelaModel;


public class Principal extends javax.swing.JFrame { // JFrame com a tela principal da aplicação
    public Principal() { // construtor do JFrame
        initComponents(); // inicia todos componentes do JFrame
        atualizarTabela(); // atualiza a Tabela de Jogos
        this.setLocationRelativeTo(null);  // seta a localização da tela
        setResizable(false); // impede de maximinzar a tela
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabela = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmCadastros = new javax.swing.JMenu();
        jmNovoJogo = new javax.swing.JMenuItem();
        jmExcluir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(241, 241, 241));

        jtTabela.setBackground(new java.awt.Color(241, 241, 241));
        jtTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Jogo", "Placar", "Mínimo da Temporada", "Máximo da Temporada", "Quebra recorde min.", "Quebra recorde max."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTabela.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(jtTabela);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
        );

        jmCadastros.setText("Cadastros");

        jmNovoJogo.setText("Novo Jogo");
        jmNovoJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmNovoJogoActionPerformed(evt);
            }
        });
        jmCadastros.add(jmNovoJogo);

        jmExcluir.setText("Excluir Jogo");
        jmExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmExcluirActionPerformed(evt);
            }
        });
        jmCadastros.add(jmExcluir);

        jMenuBar1.add(jmCadastros);

        jMenu2.setText("Sair");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem2.setText("Sair");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void atualizarTabela(){ // Classe para atualizar a Tabela
        TabelaController controle = new TabelaController(); // Cria uma variavel com a classe Java Controller
        ArrayList<TabelaModel> lista = controle.selecionarTodosTabelas(); // Array List com todas as Tabelas
        if(!lista.isEmpty()){ // se a lista estiver diferente de vazio
            DefaultTableModel modelo = (DefaultTableModel)jtTabela.getModel(); // seta as variaveis model na tabela
            modelo.setRowCount(0); // seta a posição inicial da tabela
            for(TabelaModel p: lista){ // pecorre todas lista com o Model e a lista criada
                modelo.addRow(new String[]{ // cria uma linha string com modelo da Tabela
                    String.valueOf(p.getJogo()), // gravar o jogo na tabela
                    String.valueOf(p.getPlacar()), // gravar o placar na tabela
                    String.valueOf(p.getMinimotemp()), // gravar o minimo da temporada na tabela
                    String.valueOf(p.getMaxtemp()), // gravar o maximo da temporada na tabela
                    String.valueOf(p.getQuebrarecordemin()),// gravar a quebra de recorde minimo na tabela
                    String.valueOf(p.getQuebrarecordemax()) // gravar a quebra de recorde maximo na tabela
                });
            }// fim do for pra pecorrer toda a lista
        } // fim do if se a lista tiver diferente de 0
    }
    int linha =0;
    private void jmNovoJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmNovoJogoActionPerformed
    // SubMenu para cadastrar novo jogo
    CadastroJogos cadastro = new CadastroJogos(); // cria uma nova tela para cadastrar o novo jogo
    cadastro.setVisible(true); // torna visivel a nova tela de cadastrar jogo
    setVisible(false); // deixa a tela principal invisivel
    }//GEN-LAST:event_jmNovoJogoActionPerformed
    
    private void jmExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmExcluirActionPerformed
    //Sub Menu para Excluir Jogos
    ExcluirJogos jogos = new ExcluirJogos(); // cria a nova tela de excluir jogos
    jogos.setVisible(true); // seta a tela como visivel
    setVisible(false); // seta a tela principal invisivel
    }//GEN-LAST:event_jmExcluirActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        //Sub menu para sair
        System.exit(0); // aborda a aplicação
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    // classe main para criar a tela principal
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu jmCadastros;
    private javax.swing.JMenuItem jmExcluir;
    private javax.swing.JMenuItem jmNovoJogo;
    private javax.swing.JTable jtTabela;
    // End of variables declaration//GEN-END:variables
}
