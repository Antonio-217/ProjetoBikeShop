package view;

import modelDominio.Comum;

public class FormPrincipal extends javax.swing.JFrame {

    public FormPrincipal() {
        initComponents();
        
        jLaviso.setText(BikeShopCliente.ccont.getUsuario().getNomeUsuario()+", Seja bem vindo!");
        
        //escondendo o botão usuarios
        if (BikeShopCliente.ccont.getUsuario() instanceof Comum) {
            jBusuarios.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLaviso = new javax.swing.JLabel();
        jBbikes = new javax.swing.JButton();
        jBmarcas = new javax.swing.JButton();
        jBusuarios = new javax.swing.JButton();
        jBsair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bike Shop");

        jLaviso.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        jLaviso.setForeground(new java.awt.Color(51, 102, 255));
        jLaviso.setText("Usuário, seja bem vindo!");

        jBbikes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBbikes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/bike.png"))); // NOI18N
        jBbikes.setText("Bikes");
        jBbikes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBbikesActionPerformed(evt);
            }
        });

        jBmarcas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBmarcas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/marcas.png"))); // NOI18N
        jBmarcas.setText("Marcas");
        jBmarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBmarcasActionPerformed(evt);
            }
        });

        jBusuarios.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBusuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/usuario.png"))); // NOI18N
        jBusuarios.setText("Usuários");

        jBsair.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBsair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/voltar.png"))); // NOI18N
        jBsair.setText("Sair");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBbikes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBusuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(jBsair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBmarcas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLaviso)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLaviso)
                .addGap(18, 18, 18)
                .addComponent(jBbikes, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBmarcas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBusuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBsair, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBsairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsairActionPerformed
        dispose();
    }//GEN-LAST:event_jBsairActionPerformed

    private void jBmarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBmarcasActionPerformed
        FormConsultaMarcas formConsultaMarcas = new FormConsultaMarcas();
        formConsultaMarcas.setVisible(true);
    }//GEN-LAST:event_jBmarcasActionPerformed

    private void jBbikesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBbikesActionPerformed
        FormConsultaBike formConsultaBike = new FormConsultaBike();
        formConsultaBike.setVisible(true);
    }//GEN-LAST:event_jBbikesActionPerformed

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
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBbikes;
    private javax.swing.JButton jBmarcas;
    private javax.swing.JButton jBsair;
    private javax.swing.JButton jBusuarios;
    private javax.swing.JLabel jLaviso;
    // End of variables declaration//GEN-END:variables
}
