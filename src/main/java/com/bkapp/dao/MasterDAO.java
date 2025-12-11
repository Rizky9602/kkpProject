package com.bkapp.dao;

import com.bkapp.koneksi.KoneksiDB;
import com.bkapp.model.Pelanggaran;
import com.bkapp.model.Pencapaian;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
    
    public DefaultTableModel getTablePelanggaran() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode");
        model.addColumn("Jenis Pelanggaran");
        model.addColumn("Sanksi");
        model.addColumn("Poin");
        
        String sql = "SELECT * FROM tbl_master_pelanggaran ORDER BY kode_pelanggaran ASC";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                model.addRow(new Object[]{
                    rs.getString("kode_pelanggaran"),
                    rs.getString("nama_pelanggaran"),
                    rs.getString("sanksi"),
                    rs.getInt("poin_pelanggaran")
                });
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return model;
    }

    public boolean insertPelanggaran(String kode, String nama, String sanksi, int poin) {
        String sql = "INSERT INTO tbl_master_pelanggaran VALUES (?, ?, ?, ?)"; // Urutan kolom di DB harus sesuai
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kode); // id/kode (PK)
            ps.setString(2, nama); // nama
            ps.setInt(3, poin);    // poin (Cek urutan kolom di DB Anda! Sesuaikan)
            ps.setString(4, sanksi); // sanksi
            // CATATAN: Cek struktur tabel Anda di phpMyAdmin. 
            // Jika urutannya: id, kode, nama, sanksi, poin -> sesuaikan index ps.set...
            // Kode di atas asumsi: kode, nama, poin, sanksi (atau sesuaikan query INSERT INTO table(col1, col2...) VALUES...)
            
            // Query Aman (Sebutkan kolom):
            String sqlAman = "INSERT INTO tbl_master_pelanggaran (kode_pelanggaran, nama_pelanggaran, sanksi, poin_pelanggaran) VALUES (?, ?, ?, ?)";
            PreparedStatement psAman = conn.prepareStatement(sqlAman);
            psAman.setString(1, kode);
            psAman.setString(2, nama);
            psAman.setString(3, sanksi);
            psAman.setInt(4, poin);
            
            psAman.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Simpan: " + e.getMessage());
            return false;
        }
    }

    // Edit Pelanggaran
    public boolean updatePelanggaran(String kode, String nama, String sanksi, int poin) {
        String sql = "UPDATE tbl_master_pelanggaran SET nama_pelanggaran=?, sanksi=?, poin_pelanggaran=? WHERE kode_pelanggaran=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nama);
            ps.setString(2, sanksi);
            ps.setInt(3, poin);
            ps.setString(4, kode);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) { return false; }
    }

    // Hapus Pelanggaran
    public boolean deletePelanggaran(String kode) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM tbl_master_pelanggaran WHERE kode_pelanggaran=?");
            ps.setString(1, kode);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) { 
            JOptionPane.showMessageDialog(null, "Gagal Hapus (Mungkin data sedang dipakai di riwayat): " + e.getMessage());
            return false; 
        }
    }
    


    // ==========================================
    // BAGIAN 2: PRESTASI / PENCAPAIAN (CRUD)
    // ==========================================

    // Tampil Tabel Prestasi
    public DefaultTableModel getTablePrestasi() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode");
        model.addColumn("Jenis Prestasi");
        model.addColumn("Poin (-)"); // Tidak ada kolom Sanksi
        
        String sql = "SELECT * FROM tbl_master_pencapaian ORDER BY kode_pencapaian ASC";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                model.addRow(new Object[]{
                    rs.getString("kode_pencapaian"),
                    rs.getString("nama_pencapaian"),
                    rs.getInt("poin_pengurang")
                });
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return model;
    }

    // Simpan Prestasi
    public boolean insertPrestasi(String kode, String nama, int poin) {
        String sql = "INSERT INTO tbl_master_pencapaian (kode_pencapaian, nama_pencapaian, poin_pengurang) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kode);
            ps.setString(2, nama);
            ps.setInt(3, poin);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Simpan: " + e.getMessage());
            return false;
        }
    }

    // Edit Prestasi
    public boolean updatePrestasi(String kode, String nama, int poin) {
        String sql = "UPDATE tbl_master_pencapaian SET nama_pencapaian=?, poin_pengurang=? WHERE kode_pencapaian=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nama);
            ps.setInt(2, poin);
            ps.setString(3, kode);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) { return false; }
    }

    // Hapus Prestasi
    public boolean deletePrestasi(String kode) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM tbl_master_pencapaian WHERE kode_pencapaian=?");
            ps.setString(1, kode);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) { 
            JOptionPane.showMessageDialog(null, "Gagal Hapus: " + e.getMessage());
            return false; 
        }
    }
    
    public boolean cekDataPrestasi(String kode){
     String sql = "SELECT COUNT(*) FROM tbl_master_pencapaian  WHERE kode_pencapaian= ?";   
     try{
           PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kode);
            ps.executeQuery();
          JOptionPane.showMessageDialog(null, "Kode Prestasi sudah tersedia");
     return true;
     } catch (SQLException e){
         return false;
     }
    }
    
    public boolean cekDataPelanggaran(String kode){
     String sql = "SELECT COUNT(*) FROM tbl_master_Pelanggaran  WHERE kode_pelanggaran= ?";   
     try{
           PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kode);
            ps.executeQuery();
          JOptionPane.showMessageDialog(null, "Kode Pelanggaran sudah tersedia");
     return true;
     } catch (SQLException e){
         return false;
     }
    }
      
        
}