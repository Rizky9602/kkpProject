package com.bkapp.view;

import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

import com.bkapp.dao.LaporanDAO;
import com.bkapp.dao.SiswaDAO;
import com.bkapp.model.Siswa;

import java.util.List;

public class PanelLaporan extends javax.swing.JPanel {

    public PanelLaporan() {
        initComponents();
        initForm();
    }

    private void initForm() {
        SiswaDAO dao = new SiswaDAO();
        List<String> listKelas = dao.getAllKelas();

        cbPilihKelas.removeAllItems();
        cbPilihKelas.addItem("Semua Kelas");

        for (String k : listKelas) {
            cbPilihKelas.addItem(k);
        }

        cbPilihNama.removeAllItems();
        cbPilihNama.addItem("Semua Siswa");

    }

    private void exportToExcel(DefaultTableModel model, String judulSheet) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Simpan Laporan " + judulSheet);
        chooser.setFileFilter(new FileNameExtensionFilter("Excel File (.xlsx)", "xlsx"));
        chooser.setSelectedFile(new File("Laporan_" + judulSheet.replace(" ", "_") + ".xlsx"));

        int userSelection = chooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = chooser.getSelectedFile();
            if (!fileToSave.getAbsolutePath().endsWith(".xlsx")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".xlsx");
            }

            try (Workbook workbook = new XSSFWorkbook()) {
                Sheet sheet = workbook.createSheet(judulSheet);

                Row headerRow = sheet.createRow(0);
                for (int i = 0; i < model.getColumnCount(); i++) {
                    Cell cell = headerRow.createCell(i);
                    cell.setCellValue(model.getColumnName(i));

                    CellStyle style = workbook.createCellStyle();
                    Font font = workbook.createFont();
                    font.setBold(true);
                    style.setFont(font);
                    cell.setCellStyle(style);
                }

                for (int i = 0; i < model.getRowCount(); i++) {
                    Row row = sheet.createRow(i + 1);
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        Cell cell = row.createCell(j);
                        Object val = model.getValueAt(i, j);
                        cell.setCellValue(val == null ? "" : val.toString());
                    }
                }

                for (int i = 0; i < model.getColumnCount(); i++) {
                    sheet.autoSizeColumn(i);
                }

                try (FileOutputStream out = new FileOutputStream(fileToSave)) {
                    workbook.write(out);
                    JOptionPane.showMessageDialog(this, "Laporan berhasil disimpan!\nLokasi: " + fileToSave.getAbsolutePath());
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gagal Export: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbPilihLaporan = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cbPilihKelas = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbPilihNama = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLaporan = new javax.swing.JTable();
        btnCetak = new javax.swing.JButton();
        dcDari = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dcSampai = new com.toedter.calendar.JDateChooser();
        jButton3 = new javax.swing.JButton();
        btnCek = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        jLabel1.setText("Pilih Laporan");

        jLabel2.setFont(new java.awt.Font("Sans Serif Collection", 1, 24)); // NOI18N
        jLabel2.setText("Form Laporan");

        cbPilihLaporan.setBackground(new java.awt.Color(110, 203, 246));
        cbPilihLaporan.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        cbPilihLaporan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Poin Pelanggaran", "Poin Prestasi" }));
        cbPilihLaporan.setBorder(null);
        cbPilihLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPilihLaporanActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        jLabel3.setText("Pilih Kelas");

        cbPilihKelas.setBackground(new java.awt.Color(110, 203, 246));
        cbPilihKelas.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        cbPilihKelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua Kelas" }));
        cbPilihKelas.setBorder(null);
        cbPilihKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPilihKelasActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        jLabel4.setText("Pilih Nama");

        cbPilihNama.setBackground(new java.awt.Color(110, 203, 246));
        cbPilihNama.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        cbPilihNama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua Siswa" }));
        cbPilihNama.setBorder(null);

        jLabel5.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        jLabel5.setText("Pilih Tanggal");

        tblLaporan.setBackground(new java.awt.Color(110, 203, 246));
        tblLaporan.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        tblLaporan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tanggal", "NIS", "Nama Siswa", "Jenis", "Poin"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLaporan.setShowGrid(false);
        jScrollPane1.setViewportView(tblLaporan);

        btnCetak.setBackground(new java.awt.Color(110, 203, 246));
        btnCetak.setFont(new java.awt.Font("Sans Serif Collection", 1, 14)); // NOI18N
        btnCetak.setText("Cetak");
        btnCetak.setBorder(null);
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        jLabel6.setText("Dari");

        jLabel7.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        jLabel7.setText("Sampai");

        jButton3.setBackground(new java.awt.Color(255, 0, 51));
        jButton3.setFont(new java.awt.Font("Sans Serif Collection", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Reset");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnCek.setBackground(new java.awt.Color(102, 255, 102));
        btnCek.setFont(new java.awt.Font("Sans Serif Collection", 1, 14)); // NOI18N
        btnCek.setText("Cek");
        btnCek.setBorder(null);
        btnCek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(413, 413, 413))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbPilihLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbPilihKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbPilihNama, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dcSampai, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dcDari, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCek, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbPilihLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbPilihKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbPilihNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel7))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(dcDari, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(dcSampai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCek, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        if (dcDari.getDate() == null || dcSampai.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Harap pilih rentang tanggal (Dari & Sampai)!");
            return;
        }

        if (dcSampai.getDate().before(dcDari.getDate())) {
            JOptionPane.showMessageDialog(this, "Format tanggal salah");
            return;
        }

        String jenisLaporan = cbPilihLaporan.getSelectedItem().toString();
        String kelas = cbPilihKelas.getSelectedItem().toString();

        String namaRaw = cbPilihNama.getSelectedItem().toString();
        String namaSiswa = namaRaw;
        if (namaRaw.contains("-")) {
            namaSiswa = namaRaw.split("-")[1].trim();
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tglDari = sdf.format(dcDari.getDate());
        String tglSampai = sdf.format(dcSampai.getDate());

        LaporanDAO dao = new LaporanDAO();
        DefaultTableModel dataModel = dao.getLaporan(jenisLaporan, kelas, namaSiswa, tglDari, tglSampai);

        if (dataModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Data tidak ditemukan pada periode tersebut.");
            return;
        }

        tblLaporan.setModel(dataModel);
        exportToExcel(dataModel, jenisLaporan);
    }//GEN-LAST:event_btnCetakActionPerformed

    private void cbPilihKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPilihKelasActionPerformed
        String kelasTerpilih = (String) cbPilihKelas.getSelectedItem();

        cbPilihNama.removeAllItems();
        cbPilihNama.addItem("Semua Siswa");

        if (kelasTerpilih != null && !kelasTerpilih.equals("Semua Kelas")) {
            SiswaDAO dao = new SiswaDAO();
            List<Siswa> listSiswa = dao.getSiswaByKelas(kelasTerpilih);

            for (Siswa s : listSiswa) {
                cbPilihNama.addItem(s.getNis() + " - " + s.getNamaSiswa());
            }
        }
    }//GEN-LAST:event_cbPilihKelasActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnCekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekActionPerformed
        LaporanDAO dao = new LaporanDAO();
        String jenisLaporan = cbPilihLaporan.getSelectedItem().toString();
        String kelas = cbPilihKelas.getSelectedItem().toString();

        String namaRaw = cbPilihNama.getSelectedItem().toString();
        String namaSiswa = namaRaw;

        if (dcSampai.getDate().before(dcDari.getDate())) {
            JOptionPane.showMessageDialog(this, "Format tanggal salah");
            return;
        }

        if (dcDari.getDate() != null || dcSampai.getDate() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String tglDari = sdf.format(dcDari.getDate());
            String tglSampai = sdf.format(dcSampai.getDate());

            DefaultTableModel dataModel = dao.getLaporan(jenisLaporan, kelas, namaSiswa, tglDari, tglSampai);
            tblLaporan.setModel(dataModel);
        }
    }//GEN-LAST:event_btnCekActionPerformed

    private void cbPilihLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPilihLaporanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPilihLaporanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCek;
    private javax.swing.JButton btnCetak;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JComboBox<String> cbPilihKelas;
    private javax.swing.JComboBox cbPilihLaporan;
    private javax.swing.JComboBox<String> cbPilihNama;
    private com.toedter.calendar.JDateChooser dcDari;
    private com.toedter.calendar.JDateChooser dcSampai;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLaporan;
    // End of variables declaration//GEN-END:variables
}
