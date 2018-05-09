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
import br.edu.ifsp.srt.model.enumerator.Period;
import br.edu.ifsp.srt.service.SubjectService;
import br.edu.ifsp.srt.util.Util;
import javax.swing.JOptionPane;

public class frmAddSubject extends javax.swing.JInternalFrame {

    public frmAddSubject() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblWorkload = new javax.swing.JLabel();
        txtWorkload = new javax.swing.JTextField();
        lblCourse = new javax.swing.JLabel();
        txtCourse = new javax.swing.JTextField();
        cbPeriod = new javax.swing.JComboBox<>();
        lblPeriod = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        lblVacancies = new javax.swing.JLabel();
        txtVacancies = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastrar Disciplina");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon.png"))); // NOI18N

        lblName.setText("Nome: ");
        lblName.setToolTipText("Nome da disciplina");

        txtName.setToolTipText("Informe o nome da disciplina");

        lblWorkload.setText("Carga horária:");
        lblWorkload.setToolTipText("Carga horária da disciplina");

        txtWorkload.setToolTipText("Informe a carga horária da disciplina");

        lblCourse.setText("Curso:");
        lblCourse.setToolTipText("Curso da disciplina");

        txtCourse.setToolTipText("Informe o curso da disciplina");

        cbPeriod.setModel(new javax.swing.DefaultComboBoxModel(Period.values()));
        cbPeriod.setToolTipText("Selecione o período da disciplina");

        lblPeriod.setText("Período:");
        lblPeriod.setToolTipText("Período da disciplina");

        btnCancel.setText("Cancelar");
        btnCancel.setToolTipText("Clique para cancelar o procedimento do cadastro");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSave.setText("Salvar");
        btnSave.setToolTipText("Clique para salvar o cadastro");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        lblVacancies.setText("Vagas:");
        lblVacancies.setToolTipText("Quantidade de vagas da disciplina");

        txtVacancies.setToolTipText("Informe a quantidade de vagas da disciplina");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(lblName))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(lblPeriod))
                            .addComponent(lblWorkload)
                            .addComponent(lblCourse, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName)
                            .addComponent(txtCourse)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtWorkload, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblVacancies)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtVacancies, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbPeriod, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWorkload)
                    .addComponent(txtWorkload, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVacancies)
                    .addComponent(txtVacancies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCourse)
                    .addComponent(txtCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPeriod))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel))
                .addContainerGap())
        );

        txtName.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(this,
                "Tem certeza que deseja cadastrar uma nova disciplina?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.NO_OPTION) {
            return;
        }
        //Cria uma instância
        //seus valores dos campos da tela
        Subject s = new Subject();
        s.setName(txtName.getText());
        s.setWorkload(Util.parseFloat(txtWorkload.getText().replace(",", ".")));
        s.setCourse(txtCourse.getText());
        s.setVacancies(Util.parseInteger(txtVacancies.getText()));
        s.setPeriod((Period) cbPeriod.getSelectedItem());

        try {
            //Chama o serviço para cadastro da disciplina
            SubjectService.getInstance().insert(s);
        } catch (DataSourceException | SubjectException e) {
            //Exibe mensagens de erro para o usuário
            JOptionPane.showMessageDialog(rootPane, e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Caso tenha chegado até aqui, a disciplina foi inserida com sucesso
        //Então exibe uma mensagem de sucesso para o usuário
        JOptionPane.showMessageDialog(rootPane, "Disciplina cadastrada com sucesso",
                "Cadastro efetuado", JOptionPane.INFORMATION_MESSAGE);

        //Limpa os campos da tela após realizar a inserção
        txtName.setText("");
        txtWorkload.setText("");
        txtCourse.setText("");
        txtVacancies.setText("");
        cbPeriod.setSelectedIndex(0);
    }//GEN-LAST:event_btnSaveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbPeriod;
    private javax.swing.JLabel lblCourse;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPeriod;
    private javax.swing.JLabel lblVacancies;
    private javax.swing.JLabel lblWorkload;
    private javax.swing.JTextField txtCourse;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtVacancies;
    private javax.swing.JTextField txtWorkload;
    // End of variables declaration//GEN-END:variables
}
