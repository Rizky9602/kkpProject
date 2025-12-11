package com.bkapp.dao;

import com.bkapp.koneksi.KoneksiDB;
import com.bkapp.model.Siswa;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class SiswaDAO {
    private Connection conn;

    public SiswaDAO() {
        this.conn = KoneksiDB.getKoneksi();
    }

    // Ambil Data untuk Tabel
    public List<Siswa> getAllSiswa() {
        List<Siswa> listSiswa = new ArrayList<>();
        // Pastikan nama kolom di database sesuai (misal: 'tahun_ajaran')
        String sql = "SELECT * FROM tbl_siswa ORDER BY kelas ASC, nama_siswa ASC";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Siswa s = new Siswa();
                s.setIdSiswa(rs.getInt("id_siswa"));
                s.setNis(rs.getString("nis"));
                s.setNamaSiswa(rs.getString("nama_siswa"));
                s.setKelas(rs.getString("kelas"));
                s.setTahunAjaran(rs.getString("tahun_ajaran")); // Ambil string
                s.setTotalPoin(rs.getInt("total_poin_aktif"));
                listSiswa.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSiswa;
    }

    // Insert Satu Siswa (Manual)
    public boolean insertSiswa(Siswa s) {
        String sql = "INSERT INTO tbl_siswa (nis, nama_siswa, kelas, tahun_ajaran, total_poin_aktif) VALUES (?, ?, ?, ?, 0)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getNis());
            ps.setString(2, s.getNamaSiswa());
            ps.setString(3, s.getKelas());
            ps.setString(4, s.getTahunAjaran());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Simpan: " + e.getMessage());
            return false;
        }
    }

    // Import Batch (Excel)
   public void importSiswaBatch(List<Siswa> listSiswa) {
        // Logika: Jika NIS sudah ada, UPDATE Nama, Kelas, dan Tahun Ajaran.
        // Total Poin TIDAK DI-RESET (tetap pakai poin lama: total_poin_aktif)
        String sql = "INSERT INTO tbl_siswa (nis, nama_siswa, kelas, tahun_ajaran, total_poin_aktif) " +
                     "VALUES (?, ?, ?, ?, 0) " +
                     "ON DUPLICATE KEY UPDATE " +
                     "nama_siswa = VALUES(nama_siswa), " +
                     "kelas = VALUES(kelas), " +
                     "tahun_ajaran = VALUES(tahun_ajaran)";
        
        try {
            conn.setAutoCommit(false); // Mode Transaksi (Cepat)
            PreparedStatement ps = conn.prepareStatement(sql);
            
            for (Siswa s : listSiswa) {
                ps.setString(1, s.getNis());
                ps.setString(2, s.getNamaSiswa());
                ps.setString(3, s.getKelas());
                ps.setString(4, s.getTahunAjaran());
                ps.addBatch();
            }
            
            ps.executeBatch();
            conn.commit();
            conn.setAutoCommit(true);
            
        } catch (SQLException e) {
            try { conn.rollback(); } catch (SQLException ex) {}
            JOptionPane.showMessageDialog(null, "Gagal Import Batch: " + e.getMessage());
        }
    }

    // Update Data Siswa (Tombol Edit)
    public boolean updateSiswa(Siswa s) {
        String sql = "UPDATE tbl_siswa SET nama_siswa=?, kelas=?, tahun_ajaran=? WHERE nis=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getNamaSiswa());
            ps.setString(2, s.getKelas());
            ps.setString(3, s.getTahunAjaran());
            ps.setString(4, s.getNis());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) { return false; }
    }

    // Hapus Siswa
    public boolean deleteSiswa(String nis) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM tbl_siswa WHERE nis=?");
            ps.setString(1, nis);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) { return false; }
    }

    // --- LOGIKA KENAIKAN KELAS OTOMATIS & GANTI TAHUN AJARAN ---
    public boolean prosesKenaikanKelas() {
        try {
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();

            // 1. Hapus Kelas XII (Lulus)
            stmt.executeUpdate("DELETE FROM tbl_siswa WHERE kelas LIKE 'XII %' OR kelas LIKE '12 %'");

            // 2. Naikkan XI -> XII
            stmt.executeUpdate("UPDATE tbl_siswa SET kelas = CONCAT('XII ', SUBSTRING(kelas, 4)) WHERE kelas LIKE 'XI %'");

            // 3. Naikkan X -> XI
            stmt.executeUpdate("UPDATE tbl_siswa SET kelas = CONCAT('XI ', SUBSTRING(kelas, 3)) WHERE kelas LIKE 'X %'");

            // 4. UPDATE TAHUN AJARAN OTOMATIS (Misal: "2025/2026" -> "2026/2027")
            // Logika: Ambil 4 digit kiri + 1, gabung garis miring, ambil 4 digit kanan + 1
            String sqlUpdateTahun = 
                "UPDATE tbl_siswa SET tahun_ajaran = CONCAT(" +
                "   CAST(LEFT(tahun_ajaran, 4) AS UNSIGNED) + 1, " +
                "   '/', " +
                "   CAST(RIGHT(tahun_ajaran, 4) AS UNSIGNED) + 1 " +
                ") WHERE length(tahun_ajaran) = 9"; // Pastikan formatnya benar (length 9)
            
            stmt.executeUpdate(sqlUpdateTahun);

            conn.commit();
            conn.setAutoCommit(true);
            return true;

        } catch (SQLException e) {
            try { conn.rollback(); } catch (Exception ex) {}
            JOptionPane.showMessageDialog(null, "Gagal Kenaikan Kelas: " + e.getMessage());
            return false;
        }
    }
    
    public List<Siswa> getSiswaBermasalah() {
        List<Siswa> listSiswa = new ArrayList<>();
        // Query filter poin >= 50 dan diurutkan dari yang poinnya paling besar
        String sql = "SELECT * FROM tbl_siswa WHERE total_poin_aktif >= 50 ORDER BY total_poin_aktif DESC";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Siswa s = new Siswa();
                s.setNamaSiswa(rs.getString("nama_siswa"));
                s.setKelas(rs.getString("kelas"));
                s.setTotalPoin(rs.getInt("total_poin_aktif"));

                listSiswa.add(s);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Ambil Data Notifikasi: " + e.getMessage());
        }
        return listSiswa;
    }
    
    public List<String> getAllKelas() {
        List<String> listKelas = new ArrayList<>();
        String sql = "SELECT DISTINCT kelas FROM tbl_siswa ORDER BY kelas ASC";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                listKelas.add(rs.getString("kelas"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listKelas;
    }
    
    public List<Siswa> getSiswaByKelas(String kelas) {
        List<Siswa> listSiswa = new ArrayList<>();
        String sql = "SELECT * FROM tbl_siswa WHERE kelas = ? ORDER BY nama_siswa ASC";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kelas);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Siswa s = new Siswa();
                s.setIdSiswa(rs.getInt("id_siswa"));
                s.setNis(rs.getString("nis"));
                s.setNamaSiswa(rs.getString("nama_siswa"));
                s.setKelas(rs.getString("kelas"));
                s.setTotalPoin(rs.getInt("total_poin_aktif"));
                listSiswa.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSiswa;
    }
    
    public boolean updatePoinSiswa(int idSiswa, int poinBaru) {
        // Mencegah poin negatif di level database
        if (poinBaru < 0) {
            poinBaru = 0;
        }

        String sql = "UPDATE tbl_siswa SET total_poin_aktif = ? WHERE id_siswa = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, poinBaru);
            ps.setInt(2, idSiswa);

            int rowUpdated = ps.executeUpdate();
            return rowUpdated > 0; // Mengembalikan true jika sukses update

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Update Poin: " + e.getMessage());
            return false;
        }
    }
}