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
                s.setAngkatan(rs.getInt("angkatan"));
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
}