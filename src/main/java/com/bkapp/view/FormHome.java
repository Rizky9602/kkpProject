package com.bkapp.view;

import java.awt.Color;
import javax.swing.JButton;

public class FormHome extends javax.swing.JFrame {

    String userRole;

    public FormHome() {
        initComponents();
    }

    public FormHome(String userRole) {
        initComponents();
        this.userRole = userRole;
        hakAkses();
    }

    public void hakAkses() {
        if (userRole.equalsIgnoreCase("kesiswaan")) {
            btn_konsultasi.setVisible(false);
            btn_kelola.setVisible(false);
            btn_dataSiswa.setVisible(false);
            btn_Ppelanggaran.setVisible(false);
            btn_Pprestasi.setVisible(false);
        } else {
            btn_konsultasi.setVisible(true);
            btn_kelola.setVisible(true);
            btn_dataSiswa.setVisible(true);
        }
    }
    
    Color defaultColor = new Color(255,255,255); 
    
    Color activeColor = new Color(238, 238, 238); 

    private void resetButtonColor() {
        btn_dashboard.setBackground(defaultColor);
        btn_konsultasi.setBackground(defaultColor);
        btn_Pprestasi.setBackground(defaultColor);
        btn_Ppelanggaran.setBackground(defaultColor);
        btn_kelola.setBackground(defaultColor);
        btn_dataSiswa.setBackground(defaultColor);
        btn_laporan1.setBackground(defaultColor);
    }

    private void setButtonActive(JButton button) {
        resetButtonColor();
        
        button.setBackground(activeColor);
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_Ppelanggaran = new javax.swing.JButton();
        btn_dashboard = new javax.swing.JButton();
        btn_Pprestasi = new javax.swing.JButton();
        btn_konsultasi = new javax.swing.JButton();
        btn_logOut = new javax.swing.JButton();
        btn_kelola = new javax.swing.JButton();
        btn_dataSiswa = new javax.swing.JButton();
        btn_laporan1 = new javax.swing.JButton();
        pn_utama = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(248, 248, 248));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logoassalam.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Sans Serif Collection", 1, 36)); // NOI18N
        jLabel2.setText("SMK Assalam Depok");

        jLabel3.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        jLabel3.setText("Aplikasi Bimbingan Konseling");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 332, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(333, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(110, 203, 246));
        jPanel2.setPreferredSize(new java.awt.Dimension(150, 626));

        btn_Ppelanggaran.setFont(new java.awt.Font("Sans Serif Collection", 1, 12)); // NOI18N
        btn_Ppelanggaran.setText("Poin Pelanggaran");
        btn_Ppelanggaran.setBorder(null);
        btn_Ppelanggaran.setBorderPainted(false);
        btn_Ppelanggaran.setFocusPainted(false);
        btn_Ppelanggaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PpelanggaranActionPerformed(evt);
            }
        });

        btn_dashboard.setFont(new java.awt.Font("Sans Serif Collection", 1, 12)); // NOI18N
        btn_dashboard.setText("Dashboard");
        btn_dashboard.setBorder(null);
        btn_dashboard.setFocusPainted(false);
        btn_dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dashboardActionPerformed(evt);
            }
        });

        btn_Pprestasi.setFont(new java.awt.Font("Sans Serif Collection", 1, 12)); // NOI18N
        btn_Pprestasi.setText("Poin Prestasi");
        btn_Pprestasi.setBorder(null);
        btn_Pprestasi.setBorderPainted(false);
        btn_Pprestasi.setFocusPainted(false);
        btn_Pprestasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PprestasiActionPerformed(evt);
            }
        });

        btn_konsultasi.setFont(new java.awt.Font("Sans Serif Collection", 1, 12)); // NOI18N
        btn_konsultasi.setText("Konsultasi");
        btn_konsultasi.setBorder(null);
        btn_konsultasi.setBorderPainted(false);
        btn_konsultasi.setFocusPainted(false);
        btn_konsultasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_konsultasiActionPerformed(evt);
            }
        });

        btn_logOut.setBackground(new java.awt.Color(255, 0, 51));
        btn_logOut.setFont(new java.awt.Font("Sans Serif Collection", 1, 12)); // NOI18N
        btn_logOut.setForeground(new java.awt.Color(255, 255, 255));
        btn_logOut.setText("LOG OUT");
        btn_logOut.setBorder(null);
        btn_logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logOutActionPerformed(evt);
            }
        });

        btn_kelola.setFont(new java.awt.Font("Sans Serif Collection", 1, 12)); // NOI18N
        btn_kelola.setText("Kelola Poin");
        btn_kelola.setBorder(null);
        btn_kelola.setBorderPainted(false);
        btn_kelola.setFocusPainted(false);
        btn_kelola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kelolaActionPerformed(evt);
            }
        });

        btn_dataSiswa.setFont(new java.awt.Font("Sans Serif Collection", 1, 12)); // NOI18N
        btn_dataSiswa.setText("Kelola Siswa");
        btn_dataSiswa.setBorder(null);
        btn_dataSiswa.setFocusPainted(false);
        btn_dataSiswa.setFocusable(false);
        btn_dataSiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dataSiswaActionPerformed(evt);
            }
        });

        btn_laporan1.setFont(new java.awt.Font("Sans Serif Collection", 1, 12)); // NOI18N
        btn_laporan1.setText("Laporan");
        btn_laporan1.setBorder(null);
        btn_laporan1.setFocusPainted(false);
        btn_laporan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_laporan1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_konsultasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Ppelanggaran, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(btn_dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Pprestasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_kelola, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_dataSiswa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_logOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_laporan1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btn_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btn_konsultasi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btn_Pprestasi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btn_Ppelanggaran, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btn_kelola, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btn_dataSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btn_laporan1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btn_logOut, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_START);

        pn_utama.setLayout(new java.awt.CardLayout());
        getContentPane().add(pn_utama, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setButtonActive(btn_dashboard); 
        
        pn_utama.removeAll();
        pn_utama.setLayout(new java.awt.BorderLayout());
        pn_utama.add(new PanelHome(), java.awt.BorderLayout.CENTER);
        pn_utama.revalidate();
        pn_utama.repaint();
        
        pn_utama.removeAll();
        pn_utama.setLayout(new java.awt.BorderLayout());
        pn_utama.add(new PanelHome(), java.awt.BorderLayout.CENTER);
        pn_utama.revalidate();
        pn_utama.repaint();
    }//GEN-LAST:event_formWindowOpened

    private void btn_PpelanggaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PpelanggaranActionPerformed
        setButtonActive(btn_Ppelanggaran); 
        pn_utama.removeAll();
        
        pn_utama.removeAll();
        pn_utama.setLayout(new java.awt.BorderLayout());
        pn_utama.add(new PanelPelanggaran(), java.awt.BorderLayout.CENTER);
        pn_utama.revalidate();
        pn_utama.repaint();
    }//GEN-LAST:event_btn_PpelanggaranActionPerformed

    private void btn_dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dashboardActionPerformed
        setButtonActive(btn_dashboard);
        pn_utama.removeAll();
        
        pn_utama.removeAll();
        pn_utama.setLayout(new java.awt.BorderLayout());
        pn_utama.add(new PanelHome(), java.awt.BorderLayout.CENTER);
        pn_utama.revalidate();
        pn_utama.repaint();
    }//GEN-LAST:event_btn_dashboardActionPerformed

    private void btn_konsultasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_konsultasiActionPerformed
        setButtonActive(btn_konsultasi); 
        pn_utama.removeAll();
        
        pn_utama.removeAll();
        pn_utama.setLayout(new java.awt.BorderLayout());
        pn_utama.add(new PanelKonsultasi(), java.awt.BorderLayout.CENTER);
        pn_utama.revalidate();
        pn_utama.repaint();
    }//GEN-LAST:event_btn_konsultasiActionPerformed

    private void btn_logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logOutActionPerformed
        this.dispose();
        new FormLogin().setVisible(true);
    }//GEN-LAST:event_btn_logOutActionPerformed

    private void btn_PprestasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PprestasiActionPerformed
       setButtonActive(btn_Pprestasi); 
        pn_utama.removeAll();
        
        pn_utama.removeAll();
        pn_utama.setLayout(new java.awt.BorderLayout());
        pn_utama.add(new PanelPencapaian(), java.awt.BorderLayout.CENTER);
        pn_utama.revalidate();
        pn_utama.repaint();
    }//GEN-LAST:event_btn_PprestasiActionPerformed

    private void btn_kelolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kelolaActionPerformed
       setButtonActive(btn_kelola); 
        pn_utama.removeAll();
        
        pn_utama.removeAll();
        pn_utama.setLayout(new java.awt.BorderLayout());
        pn_utama.add(new PanelKelola(), java.awt.BorderLayout.CENTER);
        pn_utama.revalidate();
        pn_utama.repaint();
    }//GEN-LAST:event_btn_kelolaActionPerformed

    private void btn_dataSiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dataSiswaActionPerformed
        setButtonActive(btn_dataSiswa); 
        pn_utama.removeAll();
        
        pn_utama.removeAll();
        pn_utama.setLayout(new java.awt.BorderLayout());
        pn_utama.add(new PanelDataSiswa(), java.awt.BorderLayout.CENTER);
        pn_utama.revalidate();
        pn_utama.repaint();
    }//GEN-LAST:event_btn_dataSiswaActionPerformed

    private void btn_laporan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_laporan1ActionPerformed
       setButtonActive(btn_laporan1); 
        pn_utama.removeAll();
        
        pn_utama.removeAll();
        pn_utama.setLayout(new java.awt.BorderLayout());
        pn_utama.add(new PanelLaporan(), java.awt.BorderLayout.CENTER);
        pn_utama.revalidate();
        pn_utama.repaint();
    }//GEN-LAST:event_btn_laporan1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Ppelanggaran;
    private javax.swing.JButton btn_Pprestasi;
    private javax.swing.JButton btn_dashboard;
    private javax.swing.JButton btn_dataSiswa;
    private javax.swing.JButton btn_kelola;
    private javax.swing.JButton btn_konsultasi;
    private javax.swing.JButton btn_laporan1;
    private javax.swing.JButton btn_logOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel pn_utama;
    // End of variables declaration//GEN-END:variables
}
