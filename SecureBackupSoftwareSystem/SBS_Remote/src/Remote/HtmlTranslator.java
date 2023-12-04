/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Remote;

import java.awt.Font;
import static java.awt.image.ImageObserver.HEIGHT;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicholas
 */
public class HtmlTranslator extends javax.swing.JDialog {

    /**
     * Creates new form HtmlTranslator
     */
    public HtmlTranslator(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("Html Translator");
        decryptedString.setText("");
    }
    
    private void translate(){
        String input= encryptField.getText();
        if(input==null || input.length()<=2){
            JLabel msgLabel= new JLabel();
            msgLabel.setFont(new Font ("Microsoft tai le", Font.BOLD, 16));
            msgLabel.setText("Enter Key to Decrypt");
            JOptionPane.showMessageDialog(null, msgLabel, null, HEIGHT, new ImageIcon(getClass().getResource(infoIcon)));
            encryptField.setText("");
            return;
        }
        try{
            Double.parseDouble(input);
        }catch  (NumberFormatException e) {
            JLabel msgLabel= new JLabel();
            msgLabel.setFont(new Font ("Microsoft tai le", Font.BOLD, 16));
            msgLabel.setText("Key must be a number");
            JOptionPane.showMessageDialog(null, msgLabel, null, HEIGHT, new ImageIcon(getClass().getResource(errorIcon)));
            encryptField.setText("");
            return;
        }
        input= decrypt(input);
        decryptedString.setText(input);
    }
    
    private String decrypt(String toDecrypt){
        if(toDecrypt.length()==0) return "";
        String retStr="";
        String[] arrStr= toDecrypt.split("1910");
        for(int i=0; i<arrStr.length; i++){
            int tmpInt= Integer.parseInt(arrStr[i]);
            char tmpChar= (char) (tmpInt-1910);
            retStr+=tmpChar;
        }
        return retStr;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnClose2 = new javax.swing.JButton();
        htmlTranslatorLabel = new javax.swing.JLabel();
        encryptField = new javax.swing.JTextField();
        encryptLabelTxt = new javax.swing.JLabel();
        decryptedLabelTxt = new javax.swing.JLabel();
        decryptedString = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        btnTranslate = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        btnClose2.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        btnClose2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Remote/Icons/close-icon-30x30.png"))); // NOI18N
        btnClose2.setText("Close");
        btnClose2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClose2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        htmlTranslatorLabel.setFont(new java.awt.Font("Microsoft Tai Le", 1, 18)); // NOI18N
        htmlTranslatorLabel.setForeground(new java.awt.Color(0, 0, 255));
        htmlTranslatorLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Remote/Icons/translate-icon-40x40.png"))); // NOI18N
        htmlTranslatorLabel.setText("Html Translator");

        encryptLabelTxt.setFont(new java.awt.Font("Microsoft Tai Le", 1, 16)); // NOI18N
        encryptLabelTxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Remote/Icons/encrypted-icon-30x30.png"))); // NOI18N
        encryptLabelTxt.setText("Encrypted Key");

        decryptedLabelTxt.setFont(new java.awt.Font("Microsoft Tai Le", 1, 16)); // NOI18N
        decryptedLabelTxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Remote/Icons/decrypted-icon-30x30.png"))); // NOI18N
        decryptedLabelTxt.setText("Decrypted Key");

        decryptedString.setFont(new java.awt.Font("Microsoft Tai Le", 1, 16)); // NOI18N
        decryptedString.setText("String");

        btnClose.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Remote/Icons/close-icon-30x30.png"))); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnTranslate.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        btnTranslate.setForeground(new java.awt.Color(0, 0, 255));
        btnTranslate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Remote/Icons/translate-icon-30x30.png"))); // NOI18N
        btnTranslate.setText("Translate");
        btnTranslate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTranslateActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Remote/Icons/reset-icon-30x30.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(encryptField)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(htmlTranslatorLabel)
                            .addComponent(encryptLabelTxt)
                            .addComponent(decryptedLabelTxt)
                            .addComponent(decryptedString))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 127, Short.MAX_VALUE)
                        .addComponent(btnReset)
                        .addGap(18, 18, 18)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTranslate)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(htmlTranslatorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(encryptLabelTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(encryptField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(decryptedLabelTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(decryptedString)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTranslate, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnClose2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClose2ActionPerformed
        dispose();
    }//GEN-LAST:event_btnClose2ActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnTranslateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTranslateActionPerformed
        translate();
    }//GEN-LAST:event_btnTranslateActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        encryptField.setText("");
        decryptedString.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

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
            java.util.logging.Logger.getLogger(HtmlTranslator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HtmlTranslator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HtmlTranslator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HtmlTranslator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HtmlTranslator dialog = new HtmlTranslator(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    
    //***************ICONS DATABASE START***************
    String infoIcon="/Remote/Icons/info-icon-50x50.png";
    String errorIcon= "/Remote/Icons/error-logo-50x50.png";
    //***************ICONS DATABASE END*****************

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnClose2;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTranslate;
    private javax.swing.JLabel decryptedLabelTxt;
    private javax.swing.JLabel decryptedString;
    private javax.swing.JTextField encryptField;
    private javax.swing.JLabel encryptLabelTxt;
    private javax.swing.JLabel htmlTranslatorLabel;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}