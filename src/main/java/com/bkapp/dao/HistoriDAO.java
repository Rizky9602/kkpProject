package com.bkapp.dao;

import com.bkapp.koneksi.KoneksiDB;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HistoriDAO {
    private Connection conn;

    public HistoriDAO() {
        this.conn = KoneksiDB.getKoneksi();
    }

    // Fungsi Simpan Pelanggaran Baru
    public boolean insertPelanggaran(int idSiswa, String kodePelanggaran, int idUser, String pathFoto) {
        String sql = "INSERT INTO tbl_histori_pelanggaran "
                   + "(id_siswa, kode_pelanggaran, id_user_pencatat, tanggal_kejadian, path_foto_bukti) "
                   + "VALUES (?, ?, ?, NOW(), ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idSiswa);
            ps.setString(2, kodePelanggaran);
            ps.setInt(3, idUser); // ID Guru BK yang login
            ps.setString(4, pathFoto);
            
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Simpan Histori: " + e.getMessage());
            return false;
        }
    }

    // Fungsi Menampilkan Riwayat Siswa Tertentu di Tabel
    public DefaultTableModel getHistoriTable(int idSiswa) {
        // Kolom sesuai desain tabel Anda
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Tanggal");
        model.addColumn("Kode");
        model.addColumn("Pelanggaran");
        model.addColumn("Poin");

        String sql = "SELECT h.tanggal_kejadian, m.kode_pelanggaran, m.nama_pelanggaran, m.poin_pelanggaran "
                   + "FROM tbl_histori_pelanggaran h "
                   + "JOIN tbl_master_pelanggaran m ON h.kode_pelanggaran = m.kode_pelanggaran "
                   + "WHERE h.id_siswa = ? ORDER BY h.tanggal_kejadian DESC";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idSiswa);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                model.addRow(new Object[] {
                    rs.getDate("tanggal_kejadian"), // Bisa di format dd-MM-yyyy jika mau
                    rs.getString("kode_pelanggaran"),
                    rs.getString("nama_pelanggaran"),
                    rs.getInt("poin_pelanggaran")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }
}