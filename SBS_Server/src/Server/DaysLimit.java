/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.awt.Color;
import java.awt.Font;
import static java.awt.image.ImageObserver.HEIGHT;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author nicho
 */
public class DaysLimit extends javax.swing.JDialog {

    /**
     * Creates new form DaysLimit
     */
    private Settings setting = new Settings();
    private String cmrId= "";
    
    public DaysLimit(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        checkSettings();
    }
    
    private void checkSettings(){
        int limit= setting.getIntValue("srvGbLim");
        if(limit==-1){
            labelStorLimitOnOff.setIcon(new ImageIcon(getClass().getResource(switchOff)));
            labelStorLimit.setText("OFF");
            labelStorLimit.setForeground(Color.orange);
        }
        else{
            labelStorLimitOnOff.setIcon(new ImageIcon(getClass().getResource(switchOn)));
            labelStorLimit.setText(Integer.toString(limit) + " GB");
            labelStorLimit.setForeground(Color.green);
        }
    }
    
    private int GetLimit(){
        String strLimit= textFieldStorLimit.getText();
        int limit= -1;
        try{
            limit= Integer.parseInt(strLimit);
            if(limit<=0){
            JLabel msgLabel= new JLabel();
            msgLabel.setFont(new Font ("Microsoft tai le", Font.BOLD, 16));
            msgLabel.setText("Limit must be greater than 0");
            JOptionPane.showMessageDialog(rootPane, msgLabel, null, HEIGHT, new ImageIcon(getClass().getResource(errorIcon)));
            textFieldStorLimit.setText("");
            }
        }
        catch (NumberFormatException nfe){
            if(strLimit.length()>0){
                JLabel msgLabel= new JLabel();
                msgLabel.setFont(new Font ("Microsoft tai le", Font.BOLD, 16));
                msgLabel.setText("Limit must be a number");
                JOptionPane.showMessageDialog(rootPane, msgLabel, null, HEIGHT, new ImageIcon(getClass().getResource(errorIcon)));
                textFieldStorLimit.setText("");
            }
        }
        return limit;
    }
    
    public void deleteFilesLimit(long backupSize, String cmrId){
        this.cmrId= cmrId;
        boolean check= setting.getIntValue("srvGbLim")>0;  //true if on
        if(check){
            deleteGbLimit(backupSize);
        }
    }
    
    private void deleteGbLimit(long backupSize){
        long gbLimit = (long) setting.getIntValue("srvGbLim") * 1073741824;  //convert "gbLimitInt" to bytes. 1048576= 1024^3
        long filesSize= FilesListSize();
        System.out.println("DaysLimit - filesSize= " + filesSize);  //debug
        System.out.println("DaysLimit - gbLimit= " + gbLimit);  //debug
        long totSize= filesSize + backupSize;  //sum all SBS files size + backup size
        while(totSize>gbLimit && filesSize>0){
            File fileToDel= getOldestFile();
            fileToDel.delete();
            totSize= FilesListSize() + backupSize;
        }
    }
    
    private File getOldestFile(){
        List fileList= getFileList();
        Iterator<File> itFile= fileList.iterator();
        if(!itFile.hasNext()){
            return null;
        }
        File tmpOld= itFile.next();
        while(itFile.hasNext()){
            File tmpFile= itFile.next();
            if(tmpFile.lastModified() < tmpOld.lastModified()){
                tmpOld= tmpFile;
            }
        }
        return tmpOld;
    }
    
    private long FilesListSize(){
        //get the fileList and calculate total size of SBS files.
        long size=0;
        List fileList= getFileList();
        Iterator<File> itFile= fileList.iterator();
        while(itFile.hasNext()){
            File tmpFile= itFile.next();
            size+=tmpFile.length();
        }
        return size;
    }
    
    private List getFileList(){
        File folder= new File(cmrId);
        File[] totTree= folder.listFiles();
        List<File> fileList= new LinkedList<File>();
        for (int i=0; i<totTree.length; i++){
            String toCheckFile= totTree[i].toString();
            if(toCheckFile.endsWith(".zip")){
                if(toCheckFile.contains("SBS-Backup-")){
                    fileList.add(totTree[i]);
                }
            }
        }
        return fileList;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelStorLimitTxt = new javax.swing.JLabel();
        textFieldStorLimit = new javax.swing.JTextField();
        labelDayLimitTxtGB = new javax.swing.JLabel();
        labelStorLimitOnOffLabel = new javax.swing.JLabel();
        labelStorLimitOnOff = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        labelStorLimitTxtFooter = new javax.swing.JLabel();
        labelStorLimit = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        labelStorLimitTxt.setFont(new java.awt.Font("Microsoft Tai Le", 1, 18)); // NOI18N
        labelStorLimitTxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Server/Icons/storage-icon-2-50x50.png"))); // NOI18N
        labelStorLimitTxt.setText("Storage Limit");

        textFieldStorLimit.setFont(new java.awt.Font("Microsoft Tai Le", 1, 18)); // NOI18N
        textFieldStorLimit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textFieldStorLimitClick(evt);
            }
        });
        textFieldStorLimit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldStorLimitActionPerformed(evt);
            }
        });

        labelDayLimitTxtGB.setFont(new java.awt.Font("Microsoft Tai Le", 1, 18)); // NOI18N
        labelDayLimitTxtGB.setText("GB");

        labelStorLimitOnOffLabel.setFont(new java.awt.Font("Microsoft Tai Le", 1, 18)); // NOI18N
        labelStorLimitOnOffLabel.setText("On/Off");

        labelStorLimitOnOff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Server/Icons/switch-on-icon-70x30.png"))); // NOI18N
        labelStorLimitOnOff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelStorLimitOnOffMouseClicked(evt);
            }
        });

        labelStorLimitTxtFooter.setFont(new java.awt.Font("Microsoft Tai Le", 1, 18)); // NOI18N
        labelStorLimitTxtFooter.setText("Storage Limit");

        labelStorLimit.setFont(new java.awt.Font("Microsoft Tai Le", 1, 18)); // NOI18N
        labelStorLimit.setForeground(new java.awt.Color(0, 0, 255));
        labelStorLimit.setText("GB");

        btnClose.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Server/Icons/close-icon-30x30.png"))); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(labelStorLimitTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldStorLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelDayLimitTxtGB)
                .addGap(42, 42, 42)
                .addComponent(labelStorLimitOnOffLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelStorLimitOnOff)
                .addContainerGap(12, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelStorLimitTxtFooter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelStorLimit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClose)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelStorLimitTxt)
                            .addComponent(textFieldStorLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDayLimitTxtGB)
                            .addComponent(labelStorLimitOnOffLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(labelStorLimitOnOff)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose)
                    .addComponent(labelStorLimitTxtFooter, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelStorLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldStorLimitClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textFieldStorLimitClick
        
    }//GEN-LAST:event_textFieldStorLimitClick

    private void textFieldStorLimitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldStorLimitActionPerformed

    }//GEN-LAST:event_textFieldStorLimitActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void labelStorLimitOnOffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelStorLimitOnOffMouseClicked
        int limit = GetLimit();
        if(setting.getIntValue("srvGbLim")>0){
            setting.SaveSetting("int", "srvGbLim", "-1");
        }
        else{
            setting.SaveSetting("int", "srvGbLim", Integer.toString(limit));
            JLabel msgLabel= new JLabel();
            msgLabel.setFont(new Font ("Microsoft tai le", Font.BOLD, 16));
            msgLabel.setText("Remind to update the HTML file");
            JOptionPane.showMessageDialog(rootPane, msgLabel, null, HEIGHT, new ImageIcon(getClass().getResource(exclamationIcon)));
        }
        checkSettings();
        textFieldStorLimit.setText("");
    }//GEN-LAST:event_labelStorLimitOnOffMouseClicked

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
            java.util.logging.Logger.getLogger(DaysLimit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DaysLimit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DaysLimit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DaysLimit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DaysLimit dialog = new DaysLimit(new javax.swing.JFrame(), true);
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
        String switchOn= "/Server/Icons/switch-on-icon-70x30.png";
        String switchOff= "/Server/Icons/switch-off-icon-70x30.png";
        String errorIcon= "/Server/Icons/error-logo-50x50.png";
        String exclamationIcon= "/Server/Icons/Exclamation-point-info-icon-50x50.png";
    //***************ICONS DATABASE END*****************

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelDayLimitTxtGB;
    private javax.swing.JLabel labelStorLimit;
    private javax.swing.JLabel labelStorLimitOnOff;
    private javax.swing.JLabel labelStorLimitOnOffLabel;
    private javax.swing.JLabel labelStorLimitTxt;
    private javax.swing.JLabel labelStorLimitTxtFooter;
    private javax.swing.JTextField textFieldStorLimit;
    // End of variables declaration//GEN-END:variables
}