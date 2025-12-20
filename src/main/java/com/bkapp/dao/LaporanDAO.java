package com.bkapp.dao;

import com.bkapp.koneksi.KoneksiDB;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class LaporanDAO {
    private Connection conn;

    public LaporanDAO() {
        this.conn = KoneksiDB.getKoneksi();
    }

    public DefaultTableModel getLaporan(String jenisLaporan, String kelas, String namaSiswa, String tglDari, String tglSampai) {
        DefaultTableModel model = new DefaultTableModel();
        String sql = "";

        if (jenisLaporan.equals("Poin Pelanggaran")) {
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
            model.addColumn("Tanggal");
            model.addColumn("NIS");
            model.addColumn("Nama Siswa");
            model.addColumn("Kelas");
            model.addColumn("Jenis Prestasi");
            model.addColumn("Poin (+)");

            sql = "SELECT h.tanggal_pencapaian as tgl, s.nis, s.nama_siswa, s.kelas, m.nama_pencapaian as jenis, m.poin_pengurang as poin " +
                  "FROM tbl_histori_pencapaian h " +
                  "JOIN tbl_siswa s ON h.id_siswa = s.id_siswa " +
                  "JOIN tbl_master_pencapaian m ON h.kode_pencapaian = m.kode_pencapaian " + // <-- PERBAIKAN UTAMA
                  "WHERE h.tanggal_pencapaian BETWEEN ? AND ? ";
        }

        if (!kelas.equalsIgnoreCase("Semua Kelas")) {
            sql += " AND s.kelas = '" + kelas + "' ";
        }
        if (!namaSiswa.equalsIgnoreCase("Semua Siswa")) {
            sql += " AND s.nama_siswa LIKE '%" + namaSiswa + "%' ";
        }
        
        sql += " ORDER BY tgl ASC";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tglDari + " 00:00:00");
            ps.setString(2, tglSampai + " 23:59:59");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("tgl"),
                    rs.getString("nis"),
                    rs.getString("nama_siswa"),
                    rs.getString("kelas"),
                    rs.getString("jenis"),
                    rs.getInt("poin")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error SQL: " + e.getMessage()); 
        }

        return model;
    }
}