//******************************************************
// Instituto Federal de São Paulo - Campus Sertãozinho
// Disciplina......: M3LPBD
// Programação de Computadores e Dispositivos Móveis
// Aluno...........: Victor Rubens da Silva Santos
//******************************************************
package br.edu.ifsp.srt.view;

import br.edu.ifsp.srt.exception.DataSourceException;
import br.edu.ifsp.srt.exception.SubjectException;
import br.edu.ifsp.srt.model.Subject;
import br.edu.ifsp.srt.service.SubjectService;
import br.edu.ifsp.srt.util.Util;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;

public class frmListSubject extends javax.swing.JInternalFrame {

    public frmListSubject() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollSubject = new javax.swing.JScrollPane();
        tableSubject = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consultar Disciplina");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon.png"))); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        tableSubject.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Carga Horária", "Curso", "Vagas", "Período"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSubject.setToolTipText("Clique em um item para ver as opções");
        tableSubject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSubjectMouseClicked(evt);
            }
        });
        scrollSubject.setViewportView(tableSubject);

        jLabel1.setText("Clique em um item para ver as opções");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollSubject, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollSubject, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        loadSubject();
    }//GEN-LAST:event_formComponentShown

    private void tableSubjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSubjectMouseClicked
        Integer id = Util.parseInteger(tableSubject.getModel().getValueAt(tableSubject.getSelectedRow(), 0) + "");
     
        if (id == null) {
            return;
        }
        if (id < 1) {
            return;
        }

        JPopupMenu popup = new JPopupMenu();
        JMenuItem mItemShow = new JMenuItem("Ver");
        JMenuItem mItemDelete = new JMenuItem("Deletar");
        mItemShow.addActionListener((e) -> {
            showSubject(id);
        });
        mItemDelete.addActionListener((e) -> {
            deleteSubject(id);
        });
        popup.add(mItemShow);
        popup.add(mItemDelete);
        popup.show(this, evt.getX(), (evt.getY() + 10));
    }//GEN-LAST:event_tableSubjectMouseClicked

    // Deleta a disciplina escolhida pelo usuário
    void deleteSubject(Integer id) {
        int dialogResult = JOptionPane.showConfirmDialog(this,
                "Tem certeza que deseja deletar a disciplina?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.NO_OPTION) {
            return;
        }

        try {
            //Chama o serviço que exclui a disciplina
            SubjectService.getInstance().delete(id);
        } catch (DataSourceException | SubjectException e) {
            //Exibe mensagens de erro para o usuário
            JOptionPane.showMessageDialog(rootPane, e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        loadSubject();
    }

    // Mostra a disciplina para o usuário
    void showSubject(Integer id) {
        Subject subject = null;
        try {
            //Chama o serviço que consulta o cadastro da disciplina
            subject = SubjectService.getInstance().show(id);
        } catch (DataSourceException | SubjectException e) {
            //Exibe mensagens de erro para o usuário
            JOptionPane.showMessageDialog(rootPane, e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (subject == null) {
            JOptionPane.showMessageDialog(rootPane, "Falha ao buscar a disciplina");
            return;
        }

        JOptionPane.showMessageDialog(rootPane, ""
                + "------ Disciplina ------" + "\n"
                + "Código: " + subject.getId() + "\n"
                + "Nome: " + subject.getName() + "\n"
                + "Curso: " + subject.getCourse() + "\n"
                + "Período: " + subject.getPeriod().toString() + "\n"
                + "Carga horária: " + subject.getWorkload() + "\n"
                + "Vagas: " + subject.getVacancies() + "\n"
        );
    }

    //carrega as disciplinas na tabela
    void loadSubject() {
        List<Subject> list = new ArrayList<>();
        // Faz o select no banco
        try {
            //Chama o serviço para cadastro da disciplina
            list = SubjectService.getInstance().list();
        } catch (DataSourceException | SubjectException e) {
            //Exibe mensagens de erro para o usuário
            JOptionPane.showMessageDialog(rootPane, e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //jtable
        DefaultTableModel model = (DefaultTableModel) tableSubject.getModel();
        model.setNumRows(0);

        for (Subject s : list) {
            //jtable
            model.addRow(new Object[]{
                s.getId(),
                s.getName(),
                s.getWorkload(),
                s.getCourse(),
                s.getVacancies(),
                s.getPeriod().toString()
            });
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmListSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmListSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmListSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmListSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmListSubject().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane scrollSubject;
    private javax.swing.JTable tableSubject;
    // End of variables declaration//GEN-END:variables
}
