package view;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelDominio.Marca;
import view.util.MarcaTableModel;

public class FormConsultaMarcas extends javax.swing.JFrame {

    //marca global
    private MarcaTableModel marcaModel;

    //método que atualiza os dados da jtable
    private void atualizaTabela() {
        ArrayList<Marca> lista;
        if (jCBfiltro.getSelectedIndex() == 1) {
            lista = BikeShopCliente.ccont.marcaListaNome(jTFpesquisa.getText());
        } else {
            lista = BikeShopCliente.ccont.marcaLista();  
        }
        marcaModel = new MarcaTableModel(lista);
            jTable1.setModel(marcaModel);
    }

    public FormConsultaMarcas() {
        initComponents();
        atualizaTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jBvoltar = new javax.swing.JButton();
        jBadicionar = new javax.swing.JButton();
        jLfiltro = new javax.swing.JLabel();
        jCBfiltro = new javax.swing.JComboBox<>();
        jTFpesquisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Marcas");

        jBvoltar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBvoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/voltar.png"))); // NOI18N
        jBvoltar.setText("Voltar");
        jBvoltar.setMaximumSize(new java.awt.Dimension(110, 30));
        jBvoltar.setMinimumSize(new java.awt.Dimension(110, 30));
        jBvoltar.setPreferredSize(new java.awt.Dimension(110, 30));
        jBvoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBvoltarActionPerformed(evt);
            }
        });

        jBadicionar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBadicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/adicionar.png"))); // NOI18N
        jBadicionar.setText("Adicionar");
        jBadicionar.setMaximumSize(new java.awt.Dimension(110, 30));
        jBadicionar.setMinimumSize(new java.awt.Dimension(110, 30));
        jBadicionar.setPreferredSize(new java.awt.Dimension(110, 30));
        jBadicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBadicionarActionPerformed(evt);
            }
        });

        jLfiltro.setText("Filtro:");

        jCBfiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos ", "Nome" }));
        jCBfiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBfiltroActionPerformed(evt);
            }
        });

        jTFpesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFpesquisaActionPerformed(evt);
            }
        });
        jTFpesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFpesquisaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLfiltro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTFpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jBvoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBadicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBadicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBvoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLfiltro)
                    .addComponent(jCBfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBvoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBvoltarActionPerformed
        dispose();
    }//GEN-LAST:event_jBvoltarActionPerformed

    private void jBadicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBadicionarActionPerformed
        FormCadastroMarca formCadastroMarca = new FormCadastroMarca();
        formCadastroMarca.setModal(true);
        //o codigo trava no setvisible pro causa do setmodal(true)
        //e só volta a executar quando o usuario fechar a tela de cadsatro
        formCadastroMarca.setVisible(true);

        atualizaTabela();
    }//GEN-LAST:event_jBadicionarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        if (evt.getClickCount() == 2 && evt.getButton() == MouseEvent.BUTTON1) {
            Marca m = marcaModel.getMarca(jTable1.getSelectedRow());
            System.out.println(m);

            FormCadastroMarca formCadastroMarca = new FormCadastroMarca(m);
            formCadastroMarca.setModal(true);
            formCadastroMarca.setVisible(true);
            atualizaTabela();

        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTFpesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFpesquisaActionPerformed
        atualizaTabela();
    }//GEN-LAST:event_jTFpesquisaActionPerformed

    private void jTFpesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFpesquisaKeyReleased
        atualizaTabela();
    }//GEN-LAST:event_jTFpesquisaKeyReleased

    private void jCBfiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBfiltroActionPerformed
        atualizaTabela();
        if (jCBfiltro.getSelectedIndex() == 0) {
            jTFpesquisa.setText("");
            jTFpesquisa.setEnabled(false);
        } else{
            jTFpesquisa.setEnabled(true);
        }
    }//GEN-LAST:event_jCBfiltroActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBadicionar;
    private javax.swing.JButton jBvoltar;
    private javax.swing.JComboBox<String> jCBfiltro;
    private javax.swing.JLabel jLfiltro;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFpesquisa;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
