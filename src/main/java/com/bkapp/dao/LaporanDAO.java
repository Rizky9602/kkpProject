package com.bkapp.dao;

import com.bkapp.koneksi.KoneksiDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class LaporanDAO {
    private Connection conn;

    public LaporanDAO() {
        this.conn = KoneksiDB.getKoneksi();
    }
    
    

    // Fungsi Generic untuk mengambil data Laporan
    public DefaultTableModel getLaporan(String jenisLaporan, String kelas, String namaSiswa, String tglDari, String tglSampai) {
        DefaultTableModel model = new DefaultTableModel();
        
        // 1. Tentukan Judul Kolom & Query Dasar sesuai Jenis Laporan
        String sql = "";
        
        if (jenisLaporan.equals("Poin Pelanggaran")) {
            // Setup Kolom Pelanggaran
            model.addColumn("Tanggal");
            model.addColumn("NIS");
            model.addColumn("Nama Siswa");
            model.addColumn("Kelas");
            model.addColumn("Jenis Pelanggaran");
            model.addColumn("Poin");
            
            sql = "SELECT h.tanggal_kejadian as tgl, s.nis, s.nama_siswa, s.kelas, m.nama_pelanggaran as jenis, m.poin_pelanggaran as poin " +
                  "FROM tbl_histori_pelanggaran h " +
                  "JOIN tbl_siswa s ON h.id_siswa = s.id_siswa " +
                  "JOIN tbl_master_pelanggaran m ON h.id_pelanggaran = m.kode_pelanggaran " +
                  "WHERE h.tanggal_kejadian BETWEEN ? AND ? ";
            
        } else if (jenisLaporan.equals("Poin Prestasi")) {
            // Setup Kolom Prestasi
            model.addColumn("Tanggal");
            model.addColumn("NIS");
            model.addColumn("Nama Siswa");
            model.addColumn("Kelas");
            model.addColumn("Jenis Prestasi");
            model.addColumn("Poin (+)");

            // Pastikan tabel histori pencapaian & master pencapaian sudah ada
            sql = "SELECT h.tanggal_pencapaian as tgl, s.nis, s.nama_siswa, s.kelas, m.nama_pencapaian as jenis, m.poin_pengurang as poin " +
                  "FROM tbl_histori_pencapaian h " +
                  "JOIN tbl_siswa s ON h.id_siswa = s.id_siswa " +
                  "JOIN tbl_master_pencapaian m ON h.id_pencapaian = m.kode_pencapaian " +
                  "WHERE h.tanggal_pencapaian BETWEEN ? AND ? ";
        }

        // 2. Tambahkan Filter Dinamis (Kelas & Siswa)
        // Jika user tidak memilih "Semua Kelas", tambahkan filter kelas
        if (!kelas.equalsIgnoreCase("Semua Kelas")) {
            sql += " AND s.kelas = '" + kelas + "' ";
        }
        
        // Jika user tidak memilih "Semua Siswa", tambahkan filter nama
        // (Asumsi dropdown nama mengirimkan format "NIS - Nama", kita ambil NIS-nya atau filter pakai nama)
        // Untuk simpelnya, kita filter pakai nama saja (atau lebih baik pakai ID jika dropdown menyimpan Object Siswa)
        if (!namaSiswa.equalsIgnoreCase("Semua Siswa")) {
             // Kita pecah string "123 - Budi" jika perlu, atau kirim NIS langsung dari form
             // Disini saya pakai LIKE agar aman
             sql += " AND s.nama_siswa LIKE '%" + namaSiswa + "%' ";
        }
        
        sql += " ORDER BY tgl ASC";

        // 3. Eksekusi Query
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tglDari + " 00:00:00"); // Awal hari
            ps.setString(2, tglSampai + " 23:59:59"); // Akhir hari
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                model.addRow(new Object[] {
                    rs.getString("tgl"),
                    rs.getString("nis"),
                    rs.getString("nama_siswa"),
                    rs.getString("kelas"),
                    rs.getString("jenis"), // Pelanggaran atau Prestasi
                    rs.getInt("poin")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return model;
    }
}