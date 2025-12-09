package com.bkapp.dao;

import com.bkapp.koneksi.KoneksiDB;
import com.bkapp.model.Pelanggaran;
import com.bkapp.model.Pencapaian;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MasterDAO {
    private Connection conn;

    public MasterDAO() {
        this.conn = KoneksiDB.getKoneksi();
    }

    // Mengambil semua jenis pelanggaran untuk isi ComboBox
    public List<Pelanggaran> getAllPelanggaran() {
        List<Pelanggaran> list = new ArrayList<>();
        String sql = "SELECT * FROM tbl_master_pelanggaran ORDER BY nama_pelanggaran ASC";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Pelanggaran p = new Pelanggaran();
                p.setKodePelanggaran(rs.getString("kode_pelanggaran"));
                p.setNamaPelanggaran(rs.getString("nama_pelanggaran"));
                p.setSanksi(rs.getString("sanksi")); // Ambil sanksi
                p.setPoin(rs.getInt("poin_pelanggaran"));

                list.add(p);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Load Master Pelanggaran: " + e.getMessage());
        }
        return list;
    }
    
    public List<Pencapaian> getAllPrestasi() {
        List<Pencapaian> list = new ArrayList<>();
        String sql = "SELECT * FROM tbl_master_pencapaian ORDER BY nama_pencapaian ASC";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Pencapaian p = new Pencapaian();
                p.setKodePencapaian(rs.getString("kode_pencapaian"));
                p.setNamaPencapaian(rs.getString("nama_pencapaian"));
                p.setPoinPengurang(rs.getInt("poin_pengurang"));

                list.add(p);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Load Master Pengurangan: " + e.getMessage());
        }
        return list;
    }
}