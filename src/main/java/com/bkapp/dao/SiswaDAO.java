package com.bkapp.dao;

import com.bkapp.koneksi.KoneksiDB;
import com.bkapp.model.Siswa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class SiswaDAO {

    private Connection conn;

    public SiswaDAO() {
        this.conn = KoneksiDB.getKoneksi();
    }

    public List<Siswa> getAllSiswa() {
        List<Siswa> listSiswa = new ArrayList<>();
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
                s.setAngkatan(rs.getInt("tahun_ajaran"));
                s.setTotalPoin(rs.getInt("total_poin_aktif"));

                listSiswa.add(s);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Ambil Data Siswa: " + e.getMessage());
        }
        return listSiswa;
    }

    public Siswa getSiswaByNIS(String nis) {
        Siswa s = null;
        String sql = "SELECT * FROM tbl_siswa WHERE nis = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nis);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                s = new Siswa();
                s.setIdSiswa(rs.getInt("id_siswa"));
                s.setNis(rs.getString("nis"));
                s.setNamaSiswa(rs.getString("nama_siswa"));
                s.setKelas(rs.getString("kelas"));
                s.setAngkatan(rs.getInt("angkatan"));
                s.setTotalPoin(rs.getInt("total_poin_aktif"));
            }
        } catch (SQLException e) {
            System.err.println("Error getSiswaByNIS: " + e.getMessage());
        }
        return s;
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

    // 1. Ambil daftar KELAS saja (Distinct) untuk Dropdown pertama
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

    // 2. Ambil Siswa berdasarkan KELAS yang dipilih
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
    
    public void importSiswaBatch(List<Siswa> listSiswa) {
        String sql = "INSERT INTO tbl_siswa (nis, nama_siswa, kelas, angkatan, total_poin_aktif) " +
                     "VALUES (?, ?, ?, ?, 0) " +
                     "ON DUPLICATE KEY UPDATE " +
                     "nama_siswa = VALUES(nama_siswa), " +
                     "kelas = VALUES(kelas)"; 
        
        try {
            conn.setAutoCommit(false); // Transaksi biar cepat
            PreparedStatement ps = conn.prepareStatement(sql);
            
            for (Siswa s : listSiswa) {
                ps.setString(1, s.getNis());
                ps.setString(2, s.getNamaSiswa());
                ps.setString(3, s.getKelas());
                ps.setInt(4, s.getAngkatan());
                ps.addBatch();
            }
            
            ps.executeBatch();
            conn.commit();
            conn.setAutoCommit(true);
            
        } catch (SQLException e) {
            try { conn.rollback(); } catch (SQLException ex) {}
            JOptionPane.showMessageDialog(null, "Gagal Import: " + e.getMessage());
        }
    }
    
    public boolean prosesKenaikanKelas() {      
        String sqlHapusLulus = "DELETE FROM tbl_siswa WHERE kelas LIKE 'XII %' OR kelas LIKE '12 %'";
        
        // Update XI -> XII
        String sqlNaikKe12 = "UPDATE tbl_siswa SET kelas = CONCAT('XII ', SUBSTRING(kelas, 4)) " +
                             "WHERE kelas LIKE 'XI %'";
                             
        // Update X -> XI
        String sqlNaikKe11 = "UPDATE tbl_siswa SET kelas = CONCAT('XI ', SUBSTRING(kelas, 3)) " +
                             "WHERE kelas LIKE 'X %'";

        try {
            conn.setAutoCommit(false); // Matikan auto-save agar atomik
            
            Statement stmt = conn.createStatement();
            
            // Langkah 1: Hapus Kelas 12
            int lulus = stmt.executeUpdate(sqlHapusLulus);
            System.out.println(lulus + " siswa kelas XII dihapus (Lulus).");
            
            // Langkah 2: Naikkan Kelas 11 -> 12
            int naik12 = stmt.executeUpdate(sqlNaikKe12);
            System.out.println(naik12 + " siswa naik ke kelas XII.");
            
            // Langkah 3: Naikkan Kelas 10 -> 11
            int naik11 = stmt.executeUpdate(sqlNaikKe11);
            System.out.println(naik11 + " siswa naik ke kelas XI.");
            
            conn.commit(); // Simpan perubahan
            conn.setAutoCommit(true);
            return true;
            
        } catch (SQLException e) {
            try { conn.rollback(); } catch (SQLException ex) {}
            JOptionPane.showMessageDialog(null, "Gagal Proses Kenaikan Kelas: " + e.getMessage());
            return false;
        }
    }
    
    public boolean deleteSiswa(String nis) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM tbl_siswa WHERE nis = ?");
            ps.setString(1, nis);
            ps.executeUpdate();
            return true;
        } catch(Exception e) { return false; }
    }
}