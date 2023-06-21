package view;

import javax.swing.JOptionPane;
import modelDominio.Marca;

public class FormCadastroMarca extends javax.swing.JDialog {

    private Marca marcaSelecionada = null;

    public FormCadastroMarca() {
        initComponents();
        jBexcluir.setVisible(false);
    }
    

    public FormCadastroMarca(Marca m) {
        initComponents();
        marcaSelecionada = m;
        jTFnomeMarca.setText(m.getNomeMarca());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLmarca = new javax.swing.JLabel();
        jTFnomeMarca = new javax.swing.JTextField();
        jBsalvar = new javax.swing.JButton();
        jBexcluir = new javax.swing.JButton();
        jBsair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Marcas");

        jLmarca.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLmarca.setText("Marca");

        jTFnomeMarca.setMinimumSize(new java.awt.Dimension(64, 25));
        jTFnomeMarca.setPreferredSize(new java.awt.Dimension(64, 25));

        jBsalvar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBsalvar.setText("Salvar");
        jBsalvar.setMaximumSize(new java.awt.Dimension(80, 26));
        jBsalvar.setMinimumSize(new java.awt.Dimension(80, 26));
        jBsalvar.setPreferredSize(new java.awt.Dimension(80, 26));
        jBsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsalvarActionPerformed(evt);
            }
        });

        jBexcluir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBexcluir.setText("Excluir");
        jBexcluir.setMaximumSize(new java.awt.Dimension(80, 26));
        jBexcluir.setMinimumSize(new java.awt.Dimension(80, 26));
        jBexcluir.setPreferredSize(new java.awt.Dimension(80, 26));
        jBexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBexcluirActionPerformed(evt);
            }
        });

        jBsair.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBsair.setText("Sair");
        jBsair.setMaximumSize(new java.awt.Dimension(80, 26));
        jBsair.setMinimumSize(new java.awt.Dimension(80, 26));
        jBsair.setPreferredSize(new java.awt.Dimension(80, 26));
        jBsair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBsalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBexcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBsair, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLmarca)
                    .addComponent(jTFnomeMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLmarca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFnomeMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBexcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBsair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBsalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalvarActionPerformed
        if (jTFnomeMarca.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo nome!");
            jTFnomeMarca.requestFocus();
        } else {
            //tudo certo nos testes, então podemos inserir no banco
            Marca m = new Marca(jTFnomeMarca.getText());

            boolean resultado;
            if (marcaSelecionada == null) {
                resultado = BikeShopCliente.ccont.marcaInserir(m);
            } else {
                //atribuição do que foi recebido do marca selecionada
                m.setCodMarca(marcaSelecionada.getCodMarca());
                resultado = BikeShopCliente.ccont.marcaEditar(m);
            }
            if (resultado) {
                JOptionPane.showMessageDialog(null, "marca inserida/alterada com sucesso!");
                if (marcaSelecionada != null) {
                    dispose();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro!");
            }
        }
    }//GEN-LAST:event_jBsalvarActionPerformed

    private void jBsairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsairActionPerformed
        dispose();
    }//GEN-LAST:event_jBsairActionPerformed

    private void jBexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBexcluirActionPerformed
        int resultado = JOptionPane.showConfirmDialog(rootPane, "Tem certeza disso? ", "", JOptionPane.YES_NO_OPTION);
        if (resultado == JOptionPane.YES_OPTION) {
            BikeShopCliente.ccont.marcaExcluir(marcaSelecionada);
            dispose();
        } else if (resultado == JOptionPane.NO_OPTION) {
            dispose();
        }
        {

        }

    }//GEN-LAST:event_jBexcluirActionPerformed

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
            java.util.logging.Logger.getLogger(FormCadastroMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCadastroMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCadastroMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCadastroMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormCadastroMarca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBexcluir;
    private javax.swing.JButton jBsair;
    private javax.swing.JButton jBsalvar;
    private javax.swing.JLabel jLmarca;
    private javax.swing.JTextField jTFnomeMarca;
    // End of variables declaration//GEN-END:variables
}
