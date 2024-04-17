package view;

import dao.ProdutoDao;
import dao.VendaDao;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelClasse.BaixaEstoque;
import modelClasse.PassarVenda;
import modelClasse.Produto;
import modelClasse.Venda;
import modelTable.ModeloTabelaVendaCompras;


public class FormVenda extends javax.swing.JFrame {

   
    private ModeloTabelaVendaCompras modelo;
    private List<BaixaEstoque> list;

    
    
    public FormVenda() {
        modelo = new ModeloTabelaVendaCompras();
        initComponents();
        list = new ArrayList<>();
    }
    
    private int codigo_cliente = 0;

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblTotalPagar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtCodigo = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCompra = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnAdicionar = new javax.swing.JButton();
        btnPagamento = new javax.swing.JComboBox<>();
        btnVendaAvulsa = new javax.swing.JRadioButton();
        btnFinalizar = new javax.swing.JButton();
        btnVincularCliente = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Realizar Venda");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));

        lblTotalPagar.setFont(new java.awt.Font("Dialog", 1, 65)); // NOI18N
        lblTotalPagar.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotalPagar)
                .addGap(32, 32, 32))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTotalPagar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("Total a Pagar");

        jPanel3.setBackground(new java.awt.Color(255, 255, 153));
        jPanel3.setToolTipText("");

        txtCodigo.setBackground(new java.awt.Color(255, 255, 153));
        txtCodigo.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        txtCodigo.setToolTipText("Informe o codigo do produto");
        txtCodigo.setBorder(null);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 153));

        tabelaCompra.setBackground(new java.awt.Color(255, 255, 204));
        tabelaCompra.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tabelaCompra.setModel(modelo);
        tabelaCompra.setRowHeight(30);
        tabelaCompra.setSelectionBackground(new java.awt.Color(153, 153, 255));
        tabelaCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaCompraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaCompra);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/carrinho_compra.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("Carrinho");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setText("Codigo");

        jPanel5.setBackground(new java.awt.Color(255, 255, 153));

        btnAdicionar.setFont(new java.awt.Font("Dialog", 0, 40)); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.setToolTipText("Adicionar produto ao carrinho");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnPagamento.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        btnPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----", "Dinheiro", "Cheque", "Crediário", "Cartão de crédito", "Cartão de débito" }));

        btnVendaAvulsa.setBackground(new java.awt.Color(255, 255, 153));
        btnVendaAvulsa.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnVendaAvulsa.setText("Venda Avulsa");
        btnVendaAvulsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendaAvulsaActionPerformed(evt);
            }
        });

        btnFinalizar.setFont(new java.awt.Font("Dialog", 0, 40)); // NOI18N
        btnFinalizar.setText("Finalizar");
        btnFinalizar.setToolTipText("Finalizar venda");
        btnFinalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFinalizarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFinalizarMouseEntered(evt);
            }
        });
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        btnVincularCliente.setBackground(new java.awt.Color(255, 255, 153));
        btnVincularCliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnVincularCliente.setText("Vincular Cliente");
        btnVincularCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVincularClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPagamento, 0, 489, Short.MAX_VALUE)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVincularCliente)
                            .addComponent(btnVendaAvulsa))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdicionar)
                .addGap(26, 26, 26)
                .addComponent(btnPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(btnVincularCliente)
                .addGap(18, 18, 18)
                .addComponent(btnVendaAvulsa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFinalizar)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 23, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jLabel4))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinalizarMouseEntered
        
        btnFinalizar.setForeground(Color.ORANGE);
    }//GEN-LAST:event_btnFinalizarMouseEntered

    private void btnFinalizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinalizarMouseExited
        
        btnFinalizar.setForeground(null);
    }//GEN-LAST:event_btnFinalizarMouseExited

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
       
        if (!txtCodigo.getText().equals("")) {
            try {
                // Objetos de classes
                BaixaEstoque baixa = new BaixaEstoque();
                PassarVenda venda = new PassarVenda();
                ProdutoDao produto = new ProdutoDao();

                // Recebe a listagem de um produto pelo codigo digitado
                Produto prod = produto.listProduto(Integer.parseInt(txtCodigo.getText()));

                // Pegando o preco do produto e quantidade
                double preco_produto = prod.getPreco_un();
                int quantidade = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a quantidade de itens deste produto!", "Quantidade", JOptionPane.OK_OPTION));
                if (quantidade > 0 && quantidade <= produto.verificarEstoque(prod.getCodigo())) {
                    // Dando baixa no estoque pelo codigo do produto e a quantidade  
                    baixa.setCodigo(Integer.parseInt(txtCodigo.getText()));
                    baixa.setQuantidade(quantidade);
                    list.add(baixa);

                    // Calculando total a pagar
                    double lbl = Double.parseDouble(lblTotalPagar.getText().replace(",", "."));
                    double total = lbl + (preco_produto * quantidade);

                    // Colocando produto na tabela de compra
                    venda.setProduto(prod.getDescricao());
                    venda.setQuantidade(quantidade);
                    venda.setValor(quantidade * preco_produto);
                    modelo.insertLista(venda);

                    // Classe para formatar saida
                    DecimalFormat formato = new DecimalFormat("#.00");
                    
                    // Mostrando total a pagar
                    lblTotalPagar.setText("" + formato.format(total));
                    txtCodigo.setText("");
                } else if (quantidade > produto.verificarEstoque(prod.getCodigo())) {
                    JOptionPane.showMessageDialog(null, "Quantidade nao disponivel no estoque, verifique se este produto foi atualizado sobre seu estoque!", "Indisponivel", JOptionPane.INFORMATION_MESSAGE);
                } else if (quantidade <= 0) {
                    JOptionPane.showMessageDialog(null, "Por favor, informe uma quantidade valida!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Informe apenas a quantidade usando numeros inteiros!", "Atençao", JOptionPane.ERROR_MESSAGE);
            } catch (java.lang.NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Nao existe produto com o codigo " + txtCodigo.getText(), "Atençao", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Informe o codigo!", "Atençao", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        // Objetos de classes
        VendaDao venda = new VendaDao();
        ProdutoDao produto = new ProdutoDao();

        // obtendo tipo de pagamento e o total a pagar
        String tipo_venda = (String) btnPagamento.getSelectedItem();
        double total = Double.parseDouble(lblTotalPagar.getText().replace(",", "."));

        // Venda Vinculada
        if (this.codigo_cliente != 0) {
            //Verificando se a forma de pagamento foi selecionada e se foi selecionado algum item
            if (!tipo_venda.equals("-----") && total != 0) {

                // Inserindo venda vinculada
                Venda v = new Venda();
                v.setCodigo_cliente(codigo_cliente);
                v.setTipo_pagamento(tipo_venda);
                v.setValor(total);
                venda.inserirVendaVinculada(v);

                // Dando baixa no estoque
                for (BaixaEstoque baixar : list) {
                    produto.baixarEstoque(baixar.getCodigo(), baixar.getQuantidade());
                }

                //Fazendo limpeza dos campos e botoes
                modelo.limparTabela();
                lblTotalPagar.setText("0");
                btnVincularCliente.setSelected(false);
                btnPagamento.setSelectedIndex(0);
                this.codigo_cliente = 0;
            } else {
                if (tipo_venda.equals("-----")) {
                    JOptionPane.showMessageDialog(null, "Informe o tipo de pagamento!", "Atençao", JOptionPane.INFORMATION_MESSAGE);
                }
                if (total == 0) {
                    JOptionPane.showMessageDialog(null, "Informe a quantidade de cada produto!", "Atençao", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            // Venda nao vinculada
        } else {
            if (!tipo_venda.equals("-----") && total != 0) {

                // Inserindo venda nao vinculada
                Venda v = new Venda();
                v.setTipo_pagamento(tipo_venda);
                v.setValor(total);
                venda.inserirVendaNaoVinculada(v);

                // Dando baixa no estoque
                for (BaixaEstoque baixar : list) {
                    produto.baixarEstoque(baixar.getCodigo(), baixar.getQuantidade());
                }

                //Fazendo limpeza dos campos e botoes
                modelo.limparTabela();
                lblTotalPagar.setText("0");
                btnVendaAvulsa.setSelected(false);
                btnPagamento.setSelectedIndex(0);
            } else {
                if (tipo_venda.equals("-----")) {
                    JOptionPane.showMessageDialog(null, "Informe o tipo de pagamento!", "Atençao", JOptionPane.INFORMATION_MESSAGE);
                }
                if (total == 0) {
                    JOptionPane.showMessageDialog(null, "Informe a quantidade de cada produto!", "Atençao", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnVincularClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVincularClienteActionPerformed
        // Vincular cliente
        btnVendaAvulsa.setSelected(false);
        this.codigo_cliente = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o codigo do cliente"));
    }//GEN-LAST:event_btnVincularClienteActionPerformed

    private void btnVendaAvulsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendaAvulsaActionPerformed
        // Venda avulsa
        btnVincularCliente.setSelected(false);
        this.codigo_cliente = 0;
    }//GEN-LAST:event_btnVendaAvulsaActionPerformed

    private void tabelaCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCompraMouseClicked
        // Removendo itens do carrinho de compra
        DecimalFormat formato = new DecimalFormat("#.00");
        ImageIcon image = new ImageIcon("src//image//carrinho_compra.png");
        int resposta = JOptionPane.showConfirmDialog(null, "Confirma a retirada deste item do carrinho?", "Retirada", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, image);
        if (resposta == JOptionPane.YES_OPTION) {
            int linha = tabelaCompra.getSelectedRow();
            PassarVenda obj = modelo.getItem(linha);
            int resposta2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantos itens deseja remover deste produto ?", "Retirada", JOptionPane.INFORMATION_MESSAGE));

            if (resposta2 < obj.getQuantidade()) {
                double preco_unitario = obj.getValor() / obj.getQuantidade();
                double valorRetirar = resposta2 * preco_unitario;
                int novaQtd = obj.getQuantidade() - resposta2;
                double total = Double.parseDouble(lblTotalPagar.getText().replace(",", ".")) - valorRetirar;
                lblTotalPagar.setText("" + formato.format(total));
                modelo.alterarArray(linha, novaQtd, novaQtd * preco_unitario);
                list.get(linha).setQuantidade(novaQtd);
                
            } else if (resposta2 == obj.getQuantidade()) {
                double total = Double.parseDouble(lblTotalPagar.getText().replace(",", ".")) - obj.getValor();
                lblTotalPagar.setText("" + formato.format(total));
                modelo.retirarCompra(linha);
                list.get(linha).setQuantidade(obj.getQuantidade() - resposta2);
            } else {
                JOptionPane.showMessageDialog(null, "A quantidade a retirar e maior que a quantidade deste item no carrinho!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }

           
        } else {
            JOptionPane.showMessageDialog(null, "O item nao foi retirado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_tabelaCompraMouseClicked

    
    public static void main(String args[]) {
        
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
            java.util.logging.Logger.getLogger(FormVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JComboBox<String> btnPagamento;
    private javax.swing.JRadioButton btnVendaAvulsa;
    private javax.swing.JRadioButton btnVincularCliente;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotalPagar;
    private javax.swing.JTable tabelaCompra;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
