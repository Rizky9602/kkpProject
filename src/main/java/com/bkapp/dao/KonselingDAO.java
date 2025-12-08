package com.bkapp.dao;

import com.bkapp.koneksi.KoneksiDB;
import com.bkapp.model.Konseling;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class KonselingDAO {
    private Connection conn;

    public KonselingDAO() {
        this.conn = KoneksiDB.getKoneksi();
    }

    // 1. SIMPAN
    public boolean insertKonseling(Konseling k) {
        String sql = "INSERT INTO tbl_histori_konseling "
                + "(id_siswa, tanggal_konseling, permasalahan, solusi_tindak_lanjut, hasil_konseling) "
                + "VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, k.getIdSiswa());
            ps.setString(2, k.getTanggal());
            ps.setString(3, k.getPermasalahan());
            ps.setString(4, k.getSolusi());
            ps.setString(5, k.getStatus()); // Enum: 'Proses','Selesai','Bimbingan Lanjutan'
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Simpan: " + e.getMessage());
            return false;
        }
    }

    // 2. EDIT
    public boolean updateKonseling(Konseling k) {
        String sql = "UPDATE tbl_histori_konseling SET "
                + "tanggal_konseling=?, permasalahan=?, solusi_tindak_lanjut=?, hasil_konseling=? "
                + "WHERE id_konseling=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, k.getTanggal());
            ps.setString(2, k.getPermasalahan());
            ps.setString(3, k.getSolusi());
            ps.setString(4, k.getStatus());
            ps.setInt(5, k.getIdKonseling());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Update: " + e.getMessage());
            return false;
        }
    }

    // 3. HAPUS
    public boolean deleteKonseling(int idKonseling) {
        String sql = "DELETE FROM tbl_histori_konseling WHERE id_konseling=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idKonseling);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Hapus: " + e.getMessage());
            return false;
        }
    }

    // 4. TAMPIL TABEL
    public DefaultTableModel getTableKonseling(int idSiswa) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID"); // 0: Hidden
        model.addColumn("Tanggal");
        model.addColumn("Permasalahan");
        model.addColumn("Penyelesaian");
        model.addColumn("Status");

        String sql = "SELECT * FROM tbl_histori_konseling WHERE id_siswa = ? ORDER BY tanggal_konseling DESC";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idSiswa);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id_konseling"),
                        rs.getString("tanggal_konseling"),
                        rs.getString("permasalahan"),
                        rs.getString("solusi_tindak_lanjut"),
                        rs.getString("hasil_konseling")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }
}