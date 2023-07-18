
package view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelDominio.Bike;
import modelDominio.Marca;
import view.util.BikeTableModel;
import view.util.ComboboxMarca;
import view.util.Imagem;

public class FormConsultaBike extends javax.swing.JFrame {

    private BikeTableModel bikemodel;
    private Imagem imagem = null;
    
    private void atualizaTabela(){
        ArrayList<Bike> listaBike = BikeShopCliente.ccont.bikeLista();
        
        bikemodel = new BikeTableModel(listaBike);
        jTbikes.setModel(bikemodel);
    }
    
    public void preencheComboboxMarcas(){
        //preenchendo o comboBox das Marcas
        ArrayList<Marca> listaMarcas = new ArrayList<>();
        listaMarcas = BikeShopCliente.ccont.marcaLista();
        ComboboxMarca.preencheComboBoxMarca(-1, jCBmarcas, listaMarcas, false);
    }
    
    public FormConsultaBike() {
        initComponents();
        
        preencheComboboxMarcas();
        atualizaTabela();
        
        jTFmodelo.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jFileChooser = new javax.swing.JFileChooser();
        jBmarcas = new javax.swing.JButton();
        jBvoltar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTbikes = new javax.swing.JTable();
        jTFmodelo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCBmarcas = new javax.swing.JComboBox<>();
        jBremover = new javax.swing.JButton();
        jBadicionar = new javax.swing.JButton();
        jBcarregarImagem = new javax.swing.JButton();
        jTFpreco = new javax.swing.JFormattedTextField();
        jTFdataLancamento = new javax.swing.JFormattedTextField();
        jLvisualizaImagem = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Consulta bikes");

        jBmarcas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBmarcas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/bike.png"))); // NOI18N
        jBmarcas.setText("Marcas");
        jBmarcas.setPreferredSize(new java.awt.Dimension(110, 30));
        jBmarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBmarcasActionPerformed(evt);
            }
        });

        jBvoltar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBvoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/voltar.png"))); // NOI18N
        jBvoltar.setText("Voltar");
        jBvoltar.setPreferredSize(new java.awt.Dimension(110, 30));
        jBvoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBvoltarActionPerformed(evt);
            }
        });

        jTbikes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTbikes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTbikesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTbikes);

        jTFmodelo.setPreferredSize(new java.awt.Dimension(190, 25));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Modelo:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Marca:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Preço:");
        jLabel3.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Data lançamento:");
        jLabel4.setToolTipText("");

        jCBmarcas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Selecionar>" }));
        jCBmarcas.setPreferredSize(new java.awt.Dimension(190, 25));

        jBremover.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBremover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/fechar.png"))); // NOI18N
        jBremover.setText("Remover");
        jBremover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBremoverActionPerformed(evt);
            }
        });

        jBadicionar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBadicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/adicionar.png"))); // NOI18N
        jBadicionar.setText("Adicionar");
        jBadicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBadicionarActionPerformed(evt);
            }
        });

        jBcarregarImagem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBcarregarImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/upload.png"))); // NOI18N
        jBcarregarImagem.setText("Carregar Imagem");
        jBcarregarImagem.setPreferredSize(new java.awt.Dimension(190, 25));
        jBcarregarImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcarregarImagemActionPerformed(evt);
            }
        });

        jTFpreco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        jTFpreco.setPreferredSize(new java.awt.Dimension(190, 25));

        jTFdataLancamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        jTFdataLancamento.setPreferredSize(new java.awt.Dimension(190, 25));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(jBadicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBremover, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 234, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTFmodelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCBmarcas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTFpreco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTFdataLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBcarregarImagem, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(jLvisualizaImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jBcarregarImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jCBmarcas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jTFpreco, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTFdataLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLvisualizaImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBremover, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBadicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jBmarcas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jBvoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap(598, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jBmarcas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jBvoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(490, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBvoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBvoltarActionPerformed
        dispose();
    }//GEN-LAST:event_jBvoltarActionPerformed

    private void jBmarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBmarcasActionPerformed
       FormConsultaMarcas formConsultaMarcas = new FormConsultaMarcas();
       formConsultaMarcas.setModal(true);
       formConsultaMarcas.setVisible(true);
       //preencheComboBoxMarcas();
    }//GEN-LAST:event_jBmarcasActionPerformed

    private void jBcarregarImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcarregarImagemActionPerformed
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("image files", ImageIO.getReaderFileSuffixes());
        jFileChooser.addChoosableFileFilter(imageFilter);
        if (jFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            imagem = new Imagem(jFileChooser.getSelectedFile());
            jLvisualizaImagem.setIcon(imagem.getImageIcon());
        }
    }//GEN-LAST:event_jBcarregarImagemActionPerformed

    private void jBadicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBadicionarActionPerformed
        int codmarca = ComboboxMarca.getSelectedIndex(jCBmarcas);
        
        float valor;
        Date dataLancamento;
        try {
            valor = ((Number) jTFpreco.getValue()).floatValue();
        } catch (Exception e) {
            valor = 0;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dataLancamento = sdf.parse(jTFdataLancamento.getText());
        } catch (Exception e) {
            dataLancamento = null;
            e.printStackTrace();
        }
        if (jTFmodelo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencha o campo modelo", 
                    this.getTitle(), JOptionPane.ERROR_MESSAGE);
            jTFmodelo.requestFocus();
        } else if (codmarca <= 0) {
                JOptionPane.showMessageDialog(this, "Preencha o campo marca", 
                        this.getTitle(), JOptionPane.ERROR_MESSAGE);
                jCBmarcas.requestFocus();
        } else if (valor <= 0) {
                JOptionPane.showMessageDialog(this, "Preencha o campo valor", 
                        this.getTitle(), JOptionPane.ERROR_MESSAGE);
                jTFpreco.requestFocus();
        } else if (dataLancamento == null) {
                JOptionPane.showMessageDialog(this, "Preencha o campo data de lançamento", 
                        this.getTitle(), JOptionPane.ERROR_MESSAGE);
                jTFdataLancamento.requestFocus();
        } else{
            Bike bk;
            if (imagem != null) {//se o usuario setou uma imagem então salva
                bk = new Bike(jTFmodelo.getText(), new Marca(codmarca), dataLancamento, valor, imagem.getImagem());
            } else{
                bk = new Bike(jTFmodelo.getText(), new Marca(codmarca) ,dataLancamento, valor, null); 
            }
            
            Boolean ok = BikeShopCliente.ccont.bikeInserir(bk);
            if(!ok){
                JOptionPane.showMessageDialog(this, 
                        "Ocorreu um erro", this.getTitle(), 
                        JOptionPane.ERROR_MESSAGE);
                
            } else{
                JOptionPane.showMessageDialog(this, 
                        "Bike inserida com sucesso", this.getTitle(), 
                        JOptionPane.INFORMATION_MESSAGE);
                atualizaTabela();
                jTFmodelo.requestFocus();
                jTFmodelo.setText("");
                jTFpreco.setText("");
                jBcarregarImagem.setIcon(null);
                imagem = null;
            }
        }
    }//GEN-LAST:event_jBadicionarActionPerformed

    private void jBremoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBremoverActionPerformed
        if (jTbikes.getSelectedRow() >= 0) {
            if (JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir?", this.getTitle(), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                
                Bike bike = bikemodel.getBike(jTbikes.getSelectedRow());
                if (bike != null) {
                    BikeShopCliente.ccont.bikeExcluir(bike);
                    atualizaTabela();
                }
            }
        }
    }//GEN-LAST:event_jBremoverActionPerformed

    private void jTbikesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbikesMouseClicked
        FormBikesImagem formBikesImagem = new FormBikesImagem(bikemodel.getBike(jTbikes.getSelectedRow()));
        formBikesImagem.setVisible(true);
    }//GEN-LAST:event_jTbikesMouseClicked

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
            java.util.logging.Logger.getLogger(FormConsultaBike.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormConsultaBike.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormConsultaBike.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormConsultaBike.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormConsultaBike().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBadicionar;
    private javax.swing.JButton jBcarregarImagem;
    private javax.swing.JButton jBmarcas;
    private javax.swing.JButton jBremover;
    private javax.swing.JButton jBvoltar;
    private javax.swing.JComboBox<String> jCBmarcas;
    private javax.swing.JFileChooser jFileChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLvisualizaImagem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JFormattedTextField jTFdataLancamento;
    private javax.swing.JTextField jTFmodelo;
    private javax.swing.JFormattedTextField jTFpreco;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTbikes;
    // End of variables declaration//GEN-END:variables
}
