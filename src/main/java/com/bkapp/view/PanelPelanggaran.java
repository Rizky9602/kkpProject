package com.bkapp.view;

import java.io.File;
import javax.swing.JFileChooser;

import com.bkapp.dao.*;
import com.bkapp.model.*;

import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class PanelPelanggaran extends javax.swing.JPanel {

    private File fileFotoDipilih = null;


    public PanelPelanggaran() {
        initComponents();
        initForm();
        dcTanggal.setDate(new Date());
    }

    private void initForm() {
        MasterDAO masterDao = new MasterDAO();
        List<Pelanggaran> listPel = masterDao.getAllPelanggaran();

        cbJenisPelanggaran.removeAllItems();
        cbJenisPelanggaran.addItem("-- Pilih Pelanggaran --");
        for (Pelanggaran p : listPel) {
            cbJenisPelanggaran.addItem(p);
        }

        // 2. Isi Dropdown Kelas
        SiswaDAO siswaDao = new SiswaDAO();
        List<String> listKelas = siswaDao.getAllKelas();

        cbKelas.removeAllItems();
        cbKelas.addItem("-- Pilih Kelas --");
        for (String k : listKelas) {
            cbKelas.addItem(k);
        }


        txtSanksi.setEditable(false);
        txtTotalPoin.setEditable(false);
    }

    // Method untuk membersihkan form inputan
    private void resetFormInput() {
        cbJenisPelanggaran.setSelectedIndex(0);
        txtSanksi.setText("");
        txtPoinInput.setText("");
        txtFoto.setText("");
        fileFotoDipilih = null;
        dcTanggal.setDate(new Date());
        jLabel7.setIcon(null);
        jLabel7.setText("Preview");
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sss = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        cbKelas = new javax.swing.JComboBox();
        cbNamaSiswa = new javax.swing.JComboBox();
        cbJenisPelanggaran = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSanksi = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRiwayat = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTotalPoin = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtFoto = new javax.swing.JTextField();
        btn_pilihfoto = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPoinInput = new javax.swing.JTextField();
        dcTanggal = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();

        sss.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("as");

        jLabel3.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        jLabel3.setText("Pilih Kelas");

        jLabel4.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        jLabel4.setText("Pilih Nama");

        jLabel5.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        jLabel5.setText("Pilih Jenis Pelanggaran");

        jLabel6.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        jLabel6.setText("Sanksi");

        jButton1.setBackground(new java.awt.Color(153, 255, 102));
        jButton1.setFont(new java.awt.Font("Sans Serif Collection", 1, 12)); // NOI18N
        jButton1.setText("Simpan");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_edit.setBackground(new java.awt.Color(110, 203, 246));
        btn_edit.setFont(new java.awt.Font("Sans Serif Collection", 1, 12)); // NOI18N
        btn_edit.setText("Edit");
        btn_edit.setBorder(null);
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_hapus.setBackground(new java.awt.Color(255, 51, 51));
        btn_hapus.setFont(new java.awt.Font("Sans Serif Collection", 1, 12)); // NOI18N
        btn_hapus.setText("Hapus");
        btn_hapus.setBorder(null);
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        cbKelas.setBackground(new java.awt.Color(110, 203, 246));
        cbKelas.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        cbKelas.setBorder(null);
        cbKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKelasActionPerformed(evt);
            }
        });

        cbNamaSiswa.setBackground(new java.awt.Color(110, 203, 246));
        cbNamaSiswa.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        cbNamaSiswa.setBorder(null);
        cbNamaSiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNamaSiswaActionPerformed(evt);
            }
        });

        cbJenisPelanggaran.setBackground(new java.awt.Color(110, 203, 246));
        cbJenisPelanggaran.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        cbJenisPelanggaran.setBorder(null);
        cbJenisPelanggaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJenisPelanggaranActionPerformed(evt);
            }
        });

        txtSanksi.setEditable(false);
        txtSanksi.setBackground(new java.awt.Color(110, 203, 246));
        txtSanksi.setColumns(20);
        txtSanksi.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        txtSanksi.setLineWrap(true);
        txtSanksi.setRows(3);
        txtSanksi.setTabSize(7);
        txtSanksi.setWrapStyleWord(true);
        txtSanksi.setAutoscrolls(false);
        txtSanksi.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(txtSanksi);

        jLabel1.setFont(new java.awt.Font("Sans Serif Collection", 1, 24)); // NOI18N
        jLabel1.setText("Form Poin Pelanggaran");

        tblRiwayat.setBackground(new java.awt.Color(110, 203, 246));
        tblRiwayat.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        tblRiwayat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tanggal", "Kode", "Pelanggaran", "Poin"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRiwayat.setSelectionBackground(new java.awt.Color(110, 203, 246));
        tblRiwayat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRiwayatMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblRiwayat);

        jLabel8.setFont(new java.awt.Font("Sans Serif Collection", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Riwayat Pelanggaran");

        jLabel9.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        jLabel9.setText("Total Poin");

        txtTotalPoin.setEditable(false);
        txtTotalPoin.setBackground(new java.awt.Color(110, 203, 246));
        txtTotalPoin.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        txtTotalPoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalPoinActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        jLabel10.setText("Input Foto");

        txtFoto.setEditable(false);
        txtFoto.setBackground(new java.awt.Color(110, 203, 246));
        txtFoto.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        txtFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFotoActionPerformed(evt);
            }
        });

        btn_pilihfoto.setBackground(new java.awt.Color(110, 203, 246));
        btn_pilihfoto.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        btn_pilihfoto.setText("Pilih File");
        btn_pilihfoto.setBorder(null);
        btn_pilihfoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pilihfotoActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(153, 255, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Preview");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        jLabel11.setText("Poin");

        txtPoinInput.setEditable(false);
        txtPoinInput.setBackground(new java.awt.Color(110, 203, 246));
        txtPoinInput.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        jLabel12.setText("Tanggal Kejadian");

        javax.swing.GroupLayout sssLayout = new javax.swing.GroupLayout(sss);
        sss.setLayout(sssLayout);
        sssLayout.setHorizontalGroup(
            sssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sssLayout.createSequentialGroup()
                .addGap(813, 813, 813)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sssLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(sssLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(sssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(sssLayout.createSequentialGroup()
                        .addGroup(sssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(sssLayout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sssLayout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(32, 32, 32)
                                .addComponent(dcTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addGroup(sssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sssLayout.createSequentialGroup()
                                .addComponent(txtFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_pilihfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(sssLayout.createSequentialGroup()
                        .addGroup(sssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(336, 336, 336)
                        .addGroup(sssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(sssLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtTotalPoin, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(sssLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(49, 49, 49)
                                .addComponent(txtPoinInput, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(sssLayout.createSequentialGroup()
                        .addGroup(sssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(sssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sssLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(sssLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(sssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbJenisPelanggaran, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbNamaSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(12, 12, 12)
                .addGroup(sssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        sssLayout.setVerticalGroup(
            sssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sssLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(sssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sssLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(322, 322, 322)
                        .addComponent(jLabel2))
                    .addGroup(sssLayout.createSequentialGroup()
                        .addGroup(sssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel11)
                            .addComponent(txtPoinInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(sssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbNamaSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtTotalPoin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(sssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbJenisPelanggaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(sssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(sssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dcTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_pilihfoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(sssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10))
                            .addComponent(jLabel12))
                        .addGroup(sssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sssLayout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addGroup(sssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(sssLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sss, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(sss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_pilihfotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pilihfotoActionPerformed
        JFileChooser chooser = new JFileChooser();

        // Hanya file (bukan folder)
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        // Filter hanya gambar
        chooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
                "Gambar (JPG, PNG)", "jpg", "jpeg", "png"
        ));

        int hasil = chooser.showOpenDialog(this);

        if (hasil == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();

            // TAMBAHKAN BARIS INI (PENTING!)
            this.fileFotoDipilih = file;

            txtFoto.setText(file.getAbsolutePath());

            // (Opsional) Fitur Preview Foto
            try {
                javax.swing.ImageIcon icon = new javax.swing.ImageIcon(file.getAbsolutePath());
                // Resize gambar agar muat di label
                java.awt.Image img = icon.getImage().getScaledInstance(jLabel7.getWidth(), jLabel7.getHeight(), java.awt.Image.SCALE_SMOOTH);
                jLabel7.setIcon(new javax.swing.ImageIcon(img));
                jLabel7.setText(""); // Hapus tulisan "Preview"
            } catch (Exception e) {
                //baikan jika error preview
            }
        }
    }//GEN-LAST:event_btn_pilihfotoActionPerformed

    private void txtFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFotoActionPerformed

    private void cbJenisPelanggaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJenisPelanggaranActionPerformed
        if (cbJenisPelanggaran.getSelectedItem() instanceof Pelanggaran) {
            Pelanggaran p = (Pelanggaran) cbJenisPelanggaran.getSelectedItem();

            txtSanksi.setText(p.getSanksi());
            txtPoinInput.setText(String.valueOf(p.getPoin()));
        }
    }//GEN-LAST:event_cbJenisPelanggaranActionPerformed

    private void cbNamaSiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNamaSiswaActionPerformed
        // Pastikan yang dipilih adalah Object Siswa (bukan null)
        if (cbNamaSiswa.getSelectedItem() instanceof Siswa) {
            Siswa s = (Siswa) cbNamaSiswa.getSelectedItem();

            txtTotalPoin.setText(String.valueOf(s.getTotalPoin()));

            HistoriDAO historiDao = new HistoriDAO();
            tblRiwayat.setModel(historiDao.getHistoriTable(s.getIdSiswa()));

            // 2. [PENTING] SEMBUNYIKAN KOLOM ID (Index 0)
            // Agar user tidak melihat angka ID, tapi kode MouseClicked bisa membacanya
            if (tblRiwayat.getColumnModel().getColumnCount() > 0) {
                tblRiwayat.getColumnModel().getColumn(0).setMinWidth(0);
                tblRiwayat.getColumnModel().getColumn(0).setMaxWidth(0);
                tblRiwayat.getColumnModel().getColumn(0).setWidth(0);
            }
        }
    }//GEN-LAST:event_cbNamaSiswaActionPerformed

    private void cbKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKelasActionPerformed
        if (cbKelas.getSelectedItem() == null || cbKelas.getSelectedIndex() == 0) return;

        String kelasTerpilih = cbKelas.getSelectedItem().toString();

        SiswaDAO dao = new SiswaDAO();
        List<Siswa> listSiswa = dao.getSiswaByKelas(kelasTerpilih);

        cbNamaSiswa.removeAllItems();
        for (Siswa s : listSiswa) {
            cbNamaSiswa.addItem(s);
        }
    }//GEN-LAST:event_cbKelasActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        int selectedRow = tblRiwayat.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data di tabel riwayat yang ingin dihapus!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Apakah Anda yakin ingin menghapus pelanggaran ini?\nPoin siswa akan dikurangi kembali.",
                "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                int idHistori = Integer.parseInt(tblRiwayat.getValueAt(selectedRow, 0).toString());

                HistoriDAO hDao = new HistoriDAO();
                SiswaDAO sDao = new SiswaDAO();

                int poinLama = hDao.getPoinLama(idHistori);

                boolean sukses = hDao.deletePelanggaran(idHistori);

                if (sukses) {
                    if (cbNamaSiswa.getSelectedItem() instanceof Siswa) {
                        Siswa s = (Siswa) cbNamaSiswa.getSelectedItem();
                        int poinBaru = s.getTotalPoin() - poinLama;

                        // Jaga agar tidak negatif (optional, tergantung aturan sekolah)
                        if (poinBaru < 0) poinBaru = 0;

                        sDao.updatePoinSiswa(s.getIdSiswa(), poinBaru);
                        txtTotalPoin.setText(String.valueOf(s.getTotalPoin()));
                    }

                    JOptionPane.showMessageDialog(this, "Data dihapus & Poin siswa telah disesuaikan.");

                    // Refresh Tabel & Form
                    cbNamaSiswaActionPerformed(null);
                    resetFormInput();
                }

            } catch (Exception e) {
                System.err.println("Error Hapus: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!(cbNamaSiswa.getSelectedItem() instanceof Siswa)) {
            JOptionPane.showMessageDialog(this, "Pilih Siswa dulu!");
            return;
        }
        if (!(cbJenisPelanggaran.getSelectedItem() instanceof Pelanggaran)) {
            JOptionPane.showMessageDialog(this, "Pilih Jenis Pelanggaran!");
            return;
        }

        if (fileFotoDipilih == null) {
            JOptionPane.showMessageDialog(this, "Harap upload bukti foto!");
            return;
        }

        if (dcTanggal.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Pilih Tanggal Kejadian!");
            return;
        }

        Siswa siswa = (Siswa) cbNamaSiswa.getSelectedItem();
        Pelanggaran pel = (Pelanggaran) cbJenisPelanggaran.getSelectedItem();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String tglStr = sdf.format(dcTanggal.getDate());

        String pathDB = "";
        try {
            String appPath = System.getProperty("user.dir");
            File folder = new File(appPath + File.separator + "bukti_bk");
            if (!folder.exists()) folder.mkdirs();

            String namaFile = siswa.getNis() + "_" + System.currentTimeMillis() + ".jpg";
            Path source = fileFotoDipilih.toPath();
            Path target = Paths.get(folder.getAbsolutePath() + File.separator + namaFile);

            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            pathDB = target.toString();
            txtTotalPoin.setText(String.valueOf(siswa.getTotalPoin()));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal Upload Foto: " + e.getMessage());
            return;
        }

        HistoriDAO hDao = new HistoriDAO();
        SiswaDAO sDao = new SiswaDAO();

        boolean suksesHistori = hDao.insertPelanggaran(
                siswa.getIdSiswa(),
                pel.getKodePelanggaran(),
                pathDB,
                tglStr
        );

        if (suksesHistori) {
            int poinBaru = siswa.getTotalPoin() + pel.getPoin();
            sDao.updatePoinSiswa(siswa.getIdSiswa(), poinBaru);

            JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan! Poin bertambah.");
            cbNamaSiswaActionPerformed(null); // Refresh tabel riwayat
            fileFotoDipilih = null;

            cbNamaSiswaActionPerformed(null);
            fileFotoDipilih = null;
            txtFoto.setText("");
            dcTanggal.setDate(new Date());

            resetFormInput();

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtTotalPoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalPoinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalPoinActionPerformed

    private void tblRiwayatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRiwayatMouseClicked
        int selectedRow = tblRiwayat.getSelectedRow();

        if (selectedRow != -1) {
            try {
                String idStr = tblRiwayat.getValueAt(selectedRow, 0).toString();
                int idHistori = Integer.parseInt(idStr);

                String tglStr = tblRiwayat.getValueAt(selectedRow, 1).toString();
                String kodePel = tblRiwayat.getValueAt(selectedRow, 2).toString();

                try {
                    java.util.Date date = null;
                    if (tglStr.length() > 10) {
                        date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(tglStr);
                    } else {
                        date = new SimpleDateFormat("yyyy-MM-dd").parse(tglStr);
                    }
                    dcTanggal.setDate(date);
                } catch (Exception e) {
                    System.err.println("Gagal parsing tanggal: " + e.getMessage());
                }

                for (int i = 0; i < cbJenisPelanggaran.getItemCount(); i++) {
                    Object item = cbJenisPelanggaran.getItemAt(i);
                    if (item instanceof Pelanggaran) {
                        Pelanggaran p = (Pelanggaran) item;
                        if (p.getKodePelanggaran().equals(kodePel)) {
                            cbJenisPelanggaran.setSelectedIndex(i);
                            break; // Ketemu, set, lalu berhenti looping
                        }
                    }
                }

                HistoriDAO hDao = new HistoriDAO();
                String pathFoto = hDao.getFotoBukti(idHistori); // Menggunakan ID Histori (Akurat)
                txtFoto.setText(pathFoto);

                // --- Preview Logic ---
                if (pathFoto != null && !pathFoto.isEmpty()) {
                    File f = new File(pathFoto);
                    if (f.exists()) {
                        this.fileFotoDipilih = f; // Update variabel global

                        try {
                            javax.swing.ImageIcon icon = new javax.swing.ImageIcon(pathFoto);
                            java.awt.Image img = icon.getImage().getScaledInstance(
                                    jLabel7.getWidth(),
                                    jLabel7.getHeight(),
                                    java.awt.Image.SCALE_SMOOTH
                            );
                            jLabel7.setIcon(new javax.swing.ImageIcon(img));
                            jLabel7.setText(""); // Hapus teks "Preview"
                        } catch (Exception e) {
                            jLabel7.setIcon(null);
                            jLabel7.setText("Gagal Load Gambar");
                        }
                    } else {
                        jLabel7.setIcon(null);
                        jLabel7.setText("File Tidak Ditemukan");
                    }
                } else {
                    jLabel7.setIcon(null);
                    jLabel7.setText("Tidak Ada Foto");
                }

            } catch (Exception e) {
                System.err.println("Error MouseClicked: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_tblRiwayatMouseClicked

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // 1. Validasi Seleksi
        int selectedRow = tblRiwayat.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data riwayat yang ingin diedit!");
            return;
        }

        Siswa siswa = (Siswa) cbNamaSiswa.getSelectedItem();
        Pelanggaran pelBaru = (Pelanggaran) cbJenisPelanggaran.getSelectedItem();

        if (dcTanggal.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Tanggal tidak boleh kosong!");
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String tglStr = sdf.format(dcTanggal.getDate());

        try {
            // Ambil ID Histori
            int idHistori = Integer.parseInt(tblRiwayat.getValueAt(selectedRow, 0).toString());

            HistoriDAO hDao = new HistoriDAO();
            SiswaDAO sDao = new SiswaDAO();

            String pathFinal = txtFoto.getText();

            if (fileFotoDipilih != null) {
                String appPath = System.getProperty("user.dir");
                File folder = new File(appPath + File.separator + "bukti_bk");
                if (!folder.exists()) folder.mkdirs();

                String namaFile = siswa.getNis() + "_" + System.currentTimeMillis() + ".jpg";
                Path source = fileFotoDipilih.toPath();
                Path target = Paths.get(folder.getAbsolutePath() + File.separator + namaFile);
                Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

                pathFinal = target.toString();
            }

            int poinLama = hDao.getPoinLama(idHistori);
            int poinBaruPelanggaran = pelBaru.getPoin();
            int totalPoinSiswaSekarang = siswa.getTotalPoin();
            int totalPoinRevisi = totalPoinSiswaSekarang - poinLama + poinBaruPelanggaran;

            boolean sukses = hDao.updatePelanggaran(idHistori, pelBaru.getKodePelanggaran(), pathFinal, tglStr);
            txtTotalPoin.setText(String.valueOf(siswa.getTotalPoin()));

            if (sukses) {
                sDao.updatePoinSiswa(siswa.getIdSiswa(), totalPoinRevisi);
                JOptionPane.showMessageDialog(this, "Data Berhasil Diupdate!");
                cbNamaSiswaActionPerformed(null);
                resetFormInput();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal Edit: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_editActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_pilihfoto;
    private javax.swing.JComboBox cbJenisPelanggaran;
    private javax.swing.JComboBox cbKelas;
    private javax.swing.JComboBox cbNamaSiswa;
    private com.toedter.calendar.JDateChooser dcTanggal;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel sss;
    private javax.swing.JTable tblRiwayat;
    private javax.swing.JTextField txtFoto;
    private javax.swing.JTextField txtPoinInput;
    private javax.swing.JTextArea txtSanksi;
    private javax.swing.JTextField txtTotalPoin;
    // End of variables declaration//GEN-END:variables
}
