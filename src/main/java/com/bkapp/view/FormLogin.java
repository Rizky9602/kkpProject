package com.bkapp.view;

import com.bkapp.dao.UserDAO;
import com.bkapp.model.User;
import static javax.swing.JOptionPane.showMessageDialog;

public class FormLogin extends javax.swing.JFrame {

    public FormLogin() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        TFpassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TFusername = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(248, 248, 248));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logoassalam.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, -1, -1));

        jLabel6.setFont(new java.awt.Font("Sans Serif Collection", 0, 8)); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Sans Serif Collection", 1, 24)); // NOI18N
        jLabel2.setText("SMK Assalam Depok");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, 20));

        TFpassword.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        TFpassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(110, 203, 246), 2));
        TFpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFpasswordActionPerformed(evt);
            }
        });
        TFpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TFpasswordKeyPressed(evt);
            }
        });
        jPanel2.add(TFpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 200, 30));

        jLabel4.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        jLabel4.setText("Username");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel5.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        jLabel5.setText("Password");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        TFusername.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        TFusername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(110, 203, 246), 2));
        jPanel2.add(TFusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 200, 30));

        jButton1.setBackground(new java.awt.Color(110, 203, 246));
        jButton1.setFont(new java.awt.Font("Sans Serif Collection", 1, 12)); // NOI18N
        jButton1.setText("Login");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 70, 40));

        jLabel7.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        jLabel7.setText("Aplikasi Bimbingan Konseling");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 270));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
             String username = TFusername.getText();
        String password = new String(TFpassword.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            showMessageDialog(this, "username dan Password tidak boleh kosong!");
            return;
        }
        UserDAO dao = new UserDAO();
        User userLogin = dao.login(username, password);

        if (userLogin != null) {
            new FormHome().setVisible(true);
            this.dispose();
        }else {
            // LOGIN GAGAL
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Login Gagal! Username atau Password salah.",
                    "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            TFusername.setText("");
            TFpassword.setText("");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TFpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFpasswordActionPerformed

    private void TFpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFpasswordKeyPressed
       if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
        
        // Masukkan kodingan yang ingin dijalankan di sini
        // Contoh: Memanggil fungsi klik pada tombol Login secara otomatis
        jButton1.doClick(); 
        
        // Atau bisa langsung coding logic-nya:
        // JOptionPane.showMessageDialog(null, "Anda menekan Enter!");
    }
    }//GEN-LAST:event_TFpasswordKeyPressed

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
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField TFpassword;
    private javax.swing.JTextField TFusername;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
