package com.bkapp.dao;

import com.bkapp.koneksi.KoneksiDB;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HistoriPelanggaranDAO {
    private Connection conn;

    public HistoriPelanggaranDAO() {
        this.conn = KoneksiDB.getKoneksi();
    }

    public boolean insertPelanggaran(int idSiswa, String kodePelanggaran, String pathFoto, String tglKejadian) {
        String sql = "INSERT INTO tbl_histori_pelanggaran "
                + "(id_siswa, id_pelanggaran, path_foto_bukti, tanggal_kejadian) "
                + "VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idSiswa);
            ps.setString(2, kodePelanggaran);
            ps.setString(3, pathFoto);
            ps.setString(4, tglKejadian); // Masukkan tanggal di sini

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Simpan Histori: " + e.getMessage());
            return false;
        }
    }

    public DefaultTableModel getHistoriTable(int idSiswa) {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Tanggal");
        model.addColumn("Kode");
        model.addColumn("Pelanggaran");
        model.addColumn("Poin");

        String sql = "SELECT h.id_histori, h.tanggal_kejadian, m.kode_pelanggaran, m.nama_pelanggaran, m.poin_pelanggaran "
                + "FROM tbl_histori_pelanggaran h "
                + "JOIN tbl_master_pelanggaran m ON h.id_pelanggaran = m.kode_pelanggaran "
                + "WHERE h.id_siswa = ? ORDER BY h.tanggal_kejadian DESC";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idSiswa);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id_histori"),
                        rs.getString("tanggal_kejadian"),
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

    public String getFotoBukti(int idHistori) {
        String path = "";
        String sql = "SELECT path_foto_bukti FROM tbl_histori_pelanggaran WHERE id_histori = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idHistori);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                path = rs.getString("path_foto_bukti");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return path;
    }

    public int getPoinLama(int idHistori) {
        int poin = 0;
        String sql = "SELECT m.poin_pelanggaran " +
                "FROM tbl_histori_pelanggaran h " +
                "JOIN tbl_master_pelanggaran m ON h.id_pelanggaran = m.kode_pelanggaran " +
                "WHERE h.id_histori = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idHistori);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                poin = rs.getInt("poin_pelanggaran");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return poin;
    }

    public boolean updatePelanggaran(int idHistori, String kodePelanggaran, String pathFoto, String tglKejadian) {
        String sql = "UPDATE tbl_histori_pelanggaran SET " +
                "id_pelanggaran=?, path_foto_bukti=?, tanggal_kejadian=? " +
                "WHERE id_histori=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kodePelanggaran);
            ps.setString(2, pathFoto);
            ps.setString(3, tglKejadian);
            ps.setInt(4, idHistori);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Update: " + e.getMessage());
            return false;
        }
    }

    public boolean deletePelanggaran(int idHistori) {
        String pathFoto = "";
        String sqlGet = "SELECT path_foto_bukti FROM tbl_histori_pelanggaran WHERE id_histori = ?";
        
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

        String sql = "DELETE FROM tbl_histori_pelanggaran WHERE id_histori = ?";
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


}