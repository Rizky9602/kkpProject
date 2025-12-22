    package com.bkapp.dao;

import com.bkapp.koneksi.KoneksiDB;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HistoriPencapaianDAO {
    private Connection conn;

    public HistoriPencapaianDAO() {
        this.conn = KoneksiDB.getKoneksi();
    }

    public boolean insertPencapaian(int idSiswa, String kode, String path, String tgl, String ket) {
        String sql = "INSERT INTO tbl_histori_pencapaian "
                + "(id_siswa, kode_pencapaian, path_foto_bukti, tanggal_pencapaian, keterangan) "
                + "VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idSiswa);
            ps.setString(2, kode);
            ps.setString(3, path);
            ps.setString(4, tgl);
            ps.setString(5, ket); // Keterangan boleh kosong
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Simpan: " + e.getMessage());
            return false;
        }
    }

    public DefaultTableModel getHistoriTable(int idSiswa) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Tanggal");
        model.addColumn("Kode");
        model.addColumn("Prestasi");
        model.addColumn("Poin (-)");

        String sql = "SELECT h.id_histori, h.tanggal_pencapaian, m.kode_pencapaian, m.nama_pencapaian, m.poin_pengurang, h.keterangan "
                + "FROM tbl_histori_pencapaian h "
                + "JOIN tbl_master_pencapaian m ON h.kode_pencapaian = m.kode_pencapaian "
                + "WHERE h.id_siswa = ? ORDER BY h.tanggal_pencapaian DESC";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idSiswa);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id_histori"),
                        rs.getString("tanggal_pencapaian"),
                        rs.getString("kode_pencapaian"),
                        rs.getString("nama_pencapaian"),
                        rs.getInt("poin_pengurang")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }

    public String[] getDetailPencapaian(int idHistori) {
        String[] hasil = {"", ""};
        String sql = "SELECT path_foto_bukti, keterangan FROM tbl_histori_pencapaian WHERE id_histori = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idHistori);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                hasil[0] = rs.getString("path_foto_bukti");
                hasil[1] = rs.getString("keterangan");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hasil;
    }

    public int getPoinLama(int idHistori) {
        int poin = 0;
        String sql = "SELECT m.poin_pengurang FROM tbl_histori_pencapaian h "
                + "JOIN tbl_master_pencapaian m ON h.kode_pencapaian = m.kode_pencapaian "
                + "WHERE h.id_histori = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idHistori);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) poin = rs.getInt("poin_pengurang");
        } catch (Exception e) {
        }
        return poin;
    }

    public boolean deletePencapaian(int idHistori) {
        String pathFoto = "";
        String sqlGet = "SELECT path_foto_bukti FROM tbl_histori_pencapaian WHERE id_histori = ?";
        
        try {
            PreparedStatement psGet = conn.prepareStatement(sqlGet);
            psGet.setInt(1, idHistori);
            ResultSet rs = psGet.executeQuery();
            if (rs.next()) {
                pathFoto = rs.getString("path_foto_bukti");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "DELETE FROM tbl_histori_pencapaian WHERE id_histori = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idHistori);
            int rows = ps.executeUpdate();

            if (rows > 0 && pathFoto != null && !pathFoto.isEmpty()) {
                try {
                    java.io.File file = new java.io.File(pathFoto);
                    if (file.exists()) {
                        file.delete(); 
                    }
                } catch (Exception ex) {
                    System.err.println("Gagal hapus file fisik: " + ex.getMessage());
                }
            }
            
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Hapus: " + e.getMessage());
            return false;
        }
    }

    public boolean updatePencapaian(int id, String kode, String path, String tgl, String ket) {
        String sql = "UPDATE tbl_histori_pencapaian SET kode_pencapaian=?, path_foto_bukti=?, tanggal_pencapaian=?, keterangan=? WHERE id_histori=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kode);
            ps.setString(2, path);
            ps.setString(3, tgl);
            ps.setString(4, ket);
            ps.setInt(5, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}