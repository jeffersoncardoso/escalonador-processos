/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controle.EscalonadorControle;
import java.awt.Toolkit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author jeffe
 */
public class Principal extends javax.swing.JFrame {
    
    private ScheduledExecutorService threadListaProcessos;
    private ScheduledExecutorService threadLogProcessos;
    private final EscalonadorControle controle;
    /**
     * Creates new form Principal
     */
    public Principal() {
        controle = new EscalonadorControle();
        initComponents();
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_qtdProcessos = new javax.swing.JLabel();
        textBox_qtdProcessos = new javax.swing.JTextField();
        textBox_valorQuantum = new javax.swing.JTextField();
        btn_iniciarEscalonador = new javax.swing.JButton();
        lbl_quantum = new javax.swing.JLabel();
        lbl_tempoVida = new javax.swing.JLabel();
        textBox_tempoVida = new javax.swing.JTextField();
        radio_tipoProcessoCPU = new javax.swing.JRadioButton();
        radio_tipoProcessoIO = new javax.swing.JRadioButton();
        btn_criarProcesso = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        textArea_logProcesso = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textArea_listaProcessos = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.SystemColor.activeCaption);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.SystemColor.activeCaption);
        setLocationByPlatform(true);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_qtdProcessos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_qtdProcessos.setText("Processos por mínuto:");

        textBox_qtdProcessos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBox_qtdProcessosActionPerformed(evt);
            }
        });

        textBox_valorQuantum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBox_valorQuantumActionPerformed(evt);
            }
        });

        btn_iniciarEscalonador.setText("Iniciar Escalonador");
        btn_iniciarEscalonador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciarEscalonadorActionPerformed(evt);
            }
        });

        lbl_quantum.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_quantum.setText("Quantum:");

        lbl_tempoVida.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_tempoVida.setText("Tempo de vida:");

        textBox_tempoVida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBox_tempoVidaActionPerformed(evt);
            }
        });

        radio_tipoProcessoCPU.setSelected(true);
        radio_tipoProcessoCPU.setText("CPU-Bound");
        radio_tipoProcessoCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_tipoProcessoCPUActionPerformed(evt);
            }
        });

        radio_tipoProcessoIO.setText("IO-Bound");

        btn_criarProcesso.setText("Criar Processo");
        btn_criarProcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_criarProcessoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_criarProcesso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textBox_qtdProcessos)
                    .addComponent(textBox_tempoVida)
                    .addComponent(textBox_valorQuantum)
                    .addComponent(btn_iniciarEscalonador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_tempoVida, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radio_tipoProcessoIO)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radio_tipoProcessoCPU))
                            .addComponent(lbl_quantum, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_qtdProcessos, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lbl_qtdProcessos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textBox_qtdProcessos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_quantum, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textBox_valorQuantum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_iniciarEscalonador, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_tempoVida, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textBox_tempoVida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radio_tipoProcessoIO)
                    .addComponent(radio_tipoProcessoCPU))
                .addGap(18, 18, 18)
                .addComponent(btn_criarProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        textArea_logProcesso.setColumns(20);
        textArea_logProcesso.setRows(5);
        textArea_logProcesso.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        textArea_logProcesso.setEnabled(false);
        jScrollPane3.setViewportView(textArea_logProcesso);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Log de Execução");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Lista de Processos");

        textArea_listaProcessos.setEditable(false);
        textArea_listaProcessos.setColumns(20);
        textArea_listaProcessos.setRows(5);
        jScrollPane2.setViewportView(textArea_listaProcessos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_criarProcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_criarProcessoActionPerformed
        try{
            controle.criarProcesso(textBox_tempoVida.getText(),"C");
        }catch(RuntimeException e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }//GEN-LAST:event_btn_criarProcessoActionPerformed

    private void radio_tipoProcessoCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_tipoProcessoCPUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radio_tipoProcessoCPUActionPerformed

    private void textBox_tempoVidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBox_tempoVidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textBox_tempoVidaActionPerformed

    private void btn_iniciarEscalonadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciarEscalonadorActionPerformed
        try{
            if(controle.estalonadorEstaEmExecucao()) { return; }
            controle.iniciarEscalonador(textBox_qtdProcessos.getText(),textBox_valorQuantum.getText());

            bloquearCamposEscalonador();
            atualizarListaDeProcessosPorTempo();
            atualizarLogDeExecucaoPorTempo();
        }catch(RuntimeException e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }//GEN-LAST:event_btn_iniciarEscalonadorActionPerformed

    private void textBox_valorQuantumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBox_valorQuantumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textBox_valorQuantumActionPerformed

    private void textBox_qtdProcessosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBox_qtdProcessosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textBox_qtdProcessosActionPerformed
    
    private void bloquearCamposEscalonador(){
        this.textBox_qtdProcessos.setEnabled(false);
        this.textBox_valorQuantum.setEnabled(false);
        this.btn_iniciarEscalonador.setText("Parar Escalonador");
    }
    
    private void atualizarListaDeProcessosPorTempo(){
        threadListaProcessos = Executors.newSingleThreadScheduledExecutor();
        threadListaProcessos.scheduleAtFixedRate(() -> {
            textArea_listaProcessos.setText(controle.listarProcessosEmExecucao());
        }, 0, 100, TimeUnit.MILLISECONDS);

    }
    
    private void atualizarLogDeExecucaoPorTempo(){
        threadLogProcessos = Executors.newSingleThreadScheduledExecutor();
        threadLogProcessos.scheduleAtFixedRate(() -> {
            textArea_logProcesso = controle.mostrarLogDeExecucao(textArea_logProcesso);
        }, 0, 100, TimeUnit.MILLISECONDS);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_criarProcesso;
    private javax.swing.JButton btn_iniciarEscalonador;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_qtdProcessos;
    private javax.swing.JLabel lbl_quantum;
    private javax.swing.JLabel lbl_tempoVida;
    private javax.swing.JRadioButton radio_tipoProcessoCPU;
    private javax.swing.JRadioButton radio_tipoProcessoIO;
    private javax.swing.JTextArea textArea_listaProcessos;
    private javax.swing.JTextArea textArea_logProcesso;
    private javax.swing.JTextField textBox_qtdProcessos;
    private javax.swing.JTextField textBox_tempoVida;
    private javax.swing.JTextField textBox_valorQuantum;
    // End of variables declaration//GEN-END:variables
}
