package com.bkapp.dao;

import com.bkapp.koneksi.KoneksiDB;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HistoriDAO {
    private Connection conn;

    public HistoriDAO() {
        this.conn = KoneksiDB.getKoneksi();
    }

    // Fungsi Simpan Pelanggaran Baru
    public boolean insertPelanggaran(int idSiswa, String kodePelanggaran, String pathFoto, String tglKejadian) {

        // Perhatikan tanda tanya (?) sekarang ada 5
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

    // Fungsi Menampilkan Riwayat Siswa Tertentu di Tabel
    public DefaultTableModel getHistoriTable(int idSiswa) {
        DefaultTableModel model = new DefaultTableModel();

        // URUTAN KOLOM SANGAT PENTING:
        model.addColumn("ID");          // Index 0 (Akan disembunyikan)
        model.addColumn("Tanggal");     // Index 1
        model.addColumn("Kode");        // Index 2
        model.addColumn("Pelanggaran"); // Index 3
        model.addColumn("Poin");        // Index 4

        // Update Query: Ambil h.id_histori dan gunakan h.kode_pelanggaran untuk join
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
                        rs.getInt("id_histori"),      // Masuk ke Kolom 0
                        rs.getString("tanggal_kejadian"), // Masuk ke Kolom 1 (String biar aman formatnya)
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

    // Method baru yang jauh lebih simpel dan akurat
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

    // 1. Ambil Poin Pelanggaran berdasarkan ID Histori (Penting untuk hitung ulang poin)
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

    // 2. Fungsi Update Data
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

    // 3. Fungsi Hapus Data
    public boolean deletePelanggaran(int idHistori) {
        String sql = "DELETE FROM tbl_histori_pelanggaran WHERE id_histori = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idHistori);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Hapus: " + e.getMessage());
            return false;
        }
    }

}