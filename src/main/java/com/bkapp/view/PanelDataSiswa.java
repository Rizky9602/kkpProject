package com.bkapp.view;

import com.bkapp.dao.SiswaDAO;
import com.bkapp.model.Siswa;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PanelDataSiswa extends javax.swing.JPanel {

    public PanelDataSiswa() {
        initComponents();
        loadTable();
        tblData.setFillsViewportHeight(true); 
    }

    private void loadTable() {
        SiswaDAO dao = new SiswaDAO();
        List<Siswa> list = dao.getAllSiswa();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("NIS");
        model.addColumn("Nama");
        model.addColumn("Kelas");
        model.addColumn("Tahun Ajaran");

        for (Siswa s : list) {
            model.addRow(new Object[]{
                    s.getNis(),
                    s.getNamaSiswa(),
                    s.getKelas(),
                    s.getTahunAjaran()
            });
        }
        tblData.setModel(model);
    }

    private void resetForm() {
        txtNis.setText("");
        txtKelas.setText("");
        txtTahunAjaran.setText("");
        txtNama.setText("");
        txtNis.setEditable(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNis = new javax.swing.JTextField();
        txtKelas = new javax.swing.JTextField();
        txtTahunAjaran = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btn_pilihfile = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnNaikKelas = new javax.swing.JButton();
        txt_siswa = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Sans Serif Collection", 1, 24)); // NOI18N
        jLabel3.setText("Input Data Siswa");

        jLabel4.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        jLabel4.setText("NIS");

        jLabel5.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        jLabel5.setText("Nama");

        jLabel6.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        jLabel6.setText("Kelas");

        jLabel7.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        jLabel7.setText("Tahun Ajaran");

        txtNis.setBackground(new java.awt.Color(110, 203, 246));
        txtNis.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N

        txtKelas.setBackground(new java.awt.Color(110, 203, 246));
        txtKelas.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        txtKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKelasActionPerformed(evt);
            }
        });

        txtTahunAjaran.setBackground(new java.awt.Color(110, 203, 246));
        txtTahunAjaran.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        txtTahunAjaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTahunAjaranActionPerformed(evt);
            }
        });

        txtNama.setBackground(new java.awt.Color(110, 203, 246));
        txtNama.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N

        btnSimpan.setBackground(new java.awt.Color(102, 255, 102));
        btnSimpan.setFont(new java.awt.Font("Sans Serif Collection", 1, 12)); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.setBorder(null);
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(110, 203, 246));
        jButton2.setFont(new java.awt.Font("Sans Serif Collection", 1, 12)); // NOI18N
        jButton2.setText("Edit");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tblData.setAutoCreateRowSorter(true);
        tblData.setBackground(new java.awt.Color(110, 203, 246));
        tblData.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        tblData.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null}
            },
            new String [] {
                "Nis", "Nama", "Kelas", "Tahun Ajaran"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tblData.setShowGrid(false);
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblData);

        jLabel1.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        jLabel1.setText("Impor Data Siswa");

        btn_pilihfile.setBackground(new java.awt.Color(110, 203, 246));
        btn_pilihfile.setFont(new java.awt.Font("Sans Serif Collection", 1, 12)); // NOI18N
        btn_pilihfile.setText("Pilih File");
        btn_pilihfile.setBorder(null);
        btn_pilihfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pilihfileActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 0, 51));
        jButton4.setFont(new java.awt.Font("Sans Serif Collection", 1, 12)); // NOI18N
        jButton4.setText("Hapus");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnNaikKelas.setBackground(new java.awt.Color(110, 203, 246));
        btnNaikKelas.setFont(new java.awt.Font("Sans Serif Collection", 1, 12)); // NOI18N
        btnNaikKelas.setText("Naik Kelas");
        btnNaikKelas.setBorder(null);
        btnNaikKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNaikKelasActionPerformed(evt);
            }
        });

        txt_siswa.setBackground(new java.awt.Color(110, 203, 246));
        txt_siswa.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNis, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(txtKelas)
                            .addComponent(txtTahunAjaran)
                            .addComponent(txtNama)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txt_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_pilihfile, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnNaikKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE))
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNaikKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTahunAjaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btn_pilihfile, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKelasActionPerformed

    private void txtTahunAjaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTahunAjaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTahunAjaranActionPerformed

    private void btn_pilihfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pilihfileActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Pilih File Excel Data Siswa (Semua Sheet)");
        chooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Excel File (.xlsx)", "xlsx"));

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();

            try (FileInputStream fis = new FileInputStream(file);
                 Workbook workbook = new XSSFWorkbook(fis)) {

                List<Siswa> listImport = new ArrayList<>();
                int totalSuccess = 0;

                for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                    Sheet sheet = workbook.getSheetAt(i);
                    System.out.println("Sedang memproses Sheet: " + sheet.getSheetName());

                    for (int r = 1; r <= sheet.getLastRowNum(); r++) {
                        Row row = sheet.getRow(r);
                        if (row == null) continue;

                        try {
                            Cell cTahun = row.getCell(1);
                            String tahun = "";
                            if (cTahun != null) {
                                if (cTahun.getCellType() == CellType.NUMERIC)
                                    tahun = String.valueOf((long) cTahun.getNumericCellValue());
                                else
                                    tahun = cTahun.getStringCellValue();
                            }

                            Cell cKelas = row.getCell(2);
                            String kelas = "";
                            if (cKelas != null) kelas = cKelas.getStringCellValue();

                            Cell cNis = row.getCell(3);
                            String nis = "";
                            if (cNis != null) {
                                if (cNis.getCellType() == CellType.NUMERIC)
                                    nis = String.valueOf((long) cNis.getNumericCellValue());
                                else
                                    nis = cNis.getStringCellValue();
                            }

                            Cell cNama = row.getCell(4);
                            String nama = "";
                            if (cNama != null) nama = cNama.getStringCellValue().toUpperCase();

                            if (!nis.isEmpty() && !nama.isEmpty() && !kelas.isEmpty()) {
                                Siswa s = new Siswa();
                                s.setNis(nis);
                                s.setNamaSiswa(nama);
                                s.setKelas(kelas);
                                s.setTahunAjaran(tahun);

                                listImport.add(s);
                                totalSuccess++;
                            }

                        } catch (Exception ex) {
                            System.err.println("Error baris " + r + " di sheet " + sheet.getSheetName());
                        }
                    }
                }

                if (!listImport.isEmpty()) {
                    SiswaDAO dao = new SiswaDAO();
                    dao.importSiswaBatch(listImport);

                    JOptionPane.showMessageDialog(this,
                            "Import Selesai!\n" +
                                    "Jumlah Sheet: " + workbook.getNumberOfSheets() + "\n" +
                                    "Total Siswa: " + totalSuccess);

                    loadTable();
                } else {
                    JOptionPane.showMessageDialog(this, "File Excel kosong atau format salah!");
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Gagal Import: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_pilihfileActionPerformed

    private void btnNaikKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNaikKelasActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this,
        "PERINGATAN TAHUN AJARAN BARU!\n\n" +
        "1. Siswa kelas XII akan DIHAPUS (Lulus).\n" +
        "2. Kelas naik tingkat (X -> XI, XI -> XII).\n" +
        "3. Tahun Ajaran bertambah.\n" +
        "4. SEMUA POIN PELANGGARAN AKAN DI-RESET KE 0.\n\n" + 
        "Lanjutkan?",
        "Konfirmasi Kenaikan Kelas", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            SiswaDAO dao = new SiswaDAO();
            if (dao.prosesKenaikanKelas()) {
                JOptionPane.showMessageDialog(this, "Proses Selesai!");
                loadTable();
            }

        }
    }//GEN-LAST:event_btnNaikKelasActionPerformed

    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked
        int row = tblData.getSelectedRow();
        btnSimpan.setEnabled(false);
        if (row != -1) {
            txtNis.setText(tblData.getValueAt(row, 0).toString());
            txtNama.setText(tblData.getValueAt(row, 1).toString());
            txtKelas.setText(tblData.getValueAt(row, 2).toString());
            txtTahunAjaran.setText(tblData.getValueAt(row, 3).toString());

            txtNis.setEditable(false);
        }
    }//GEN-LAST:event_tblDataMouseClicked

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if (txtNis.getText().isEmpty() || txtKelas.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "NIS dan Nama wajib diisi!");
            return;
        }

        Siswa s = new Siswa();
        SiswaDAO dao = new SiswaDAO();

        s.setNis(txtNis.getText());
        s.setNamaSiswa(txtNama.getText());
        s.setKelas(txtKelas.getText());
        s.setTahunAjaran(txtTahunAjaran.getText());

        if (dao.cekDataSiswa(txtNis.getText())) {
            JOptionPane.showMessageDialog(null, "Nis Sudah Tersedia");
            return;
        }

        if (dao.insertSiswa(s)) {
            JOptionPane.showMessageDialog(this, "Data Tersimpan");
            loadTable();
            resetForm();
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (txtNis.isEditable()) {
            JOptionPane.showMessageDialog(this, "Pilih data dari tabel dulu!");
            return;
        }

        Siswa s = new Siswa();
        SiswaDAO dao = new SiswaDAO();

        s.setNis(txtNis.getText());
        s.setNamaSiswa(txtNama.getText());
        s.setKelas(txtKelas.getText());
        s.setTahunAjaran(txtTahunAjaran.getText());

        if (dao.updateSiswa(s)) {
            JOptionPane.showMessageDialog(this, "Data Diupdate");
            loadTable();
            resetForm();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (txtNis.isEditable() || txtNis.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data dari tabel dulu!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Hapus siswa ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            SiswaDAO dao = new SiswaDAO();
            if (dao.deleteSiswa(txtNis.getText())) {
                JOptionPane.showMessageDialog(this, "Data Dihapus");
                loadTable();
                resetForm();
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNaikKelas;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btn_pilihfile;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtKelas;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNis;
    private javax.swing.JTextField txtTahunAjaran;
    private javax.swing.JTextField txt_siswa;
    // End of variables declaration//GEN-END:variables
}
