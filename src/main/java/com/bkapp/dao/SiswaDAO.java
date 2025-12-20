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
                s.setTahunAjaran(rs.getString("tahun_ajaran")); // Ambil string
                s.setTotalPoin(rs.getInt("total_poin_aktif"));
                listSiswa.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSiswa;
    }

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

    public void importSiswaBatch(List<Siswa> listSiswa) {
        String sql = "INSERT INTO tbl_siswa (nis, nama_siswa, kelas, tahun_ajaran, total_poin_aktif) " +
                "VALUES (?, ?, ?, ?, 0) " +
                "ON DUPLICATE KEY UPDATE " +
                "nama_siswa = VALUES(nama_siswa), " +
                "kelas = VALUES(kelas), " +
                "tahun_ajaran = VALUES(tahun_ajaran)";

        try {
            conn.setAutoCommit(false);
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
            try {
                conn.rollback();
            } catch (SQLException ex) {
            }
            JOptionPane.showMessageDialog(null, "Gagal Import Batch: " + e.getMessage());
        }
    }

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
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean deleteSiswa(String nis) {
        String sqlCari = "SELECT id_siswa FROM tbl_siswa WHERE nis = ?";

        try {
            PreparedStatement psCari = conn.prepareStatement(sqlCari);
            psCari.setString(1, nis);
            ResultSet rs = psCari.executeQuery();

            if (rs.next()) {
                int idSiswa = rs.getInt("id_siswa");
                String sqlHapusPel = "DELETE FROM tbl_histori_pelanggaran WHERE id_siswa = ?";
                PreparedStatement psPel = conn.prepareStatement(sqlHapusPel);
                psPel.setInt(1, idSiswa);
                psPel.executeUpdate();

                String sqlHapusPen = "DELETE FROM tbl_histori_pencapaian WHERE id_siswa = ?";
                PreparedStatement psPen = conn.prepareStatement(sqlHapusPen);
                psPen.setInt(1, idSiswa);
                psPen.executeUpdate();

                String sqlHapusKon = "DELETE FROM tbl_histori_konseling WHERE id_siswa = ?";
                PreparedStatement psKon = conn.prepareStatement(sqlHapusKon);
                psKon.setInt(1, idSiswa);
                psKon.executeUpdate();

                String sqlHapusSiswa = "DELETE FROM tbl_siswa WHERE id_siswa = ?";
                PreparedStatement psSiswa = conn.prepareStatement(sqlHapusSiswa);
                psSiswa.setInt(1, idSiswa);

                psSiswa.executeUpdate();
                return true;
            } else {
                System.out.println("Siswa dengan NIS " + nis + " tidak ditemukan.");
                return false;
            }

        } catch (SQLException e) {
            System.err.println("Gagal Hapus Siswa: " + e.getMessage());
            return false;
        }
    }

  public boolean prosesKenaikanKelas() {
    String sqlCariLulus = "SELECT id_siswa FROM tbl_siswa WHERE kelas LIKE 'XII %' OR kelas LIKE '12 %'";

    Statement stmtCari = null;
    Statement stmtEksekusi = null;
    ResultSet rs = null;

    try {
        conn.setAutoCommit(false); // Mulai Transaksi

        stmtCari = conn.createStatement();
        stmtEksekusi = conn.createStatement();

        stmtEksekusi.executeUpdate("DELETE FROM tbl_histori_pelanggaran"); 
        stmtEksekusi.executeUpdate("DELETE FROM tbl_histori_pencapaian");
        stmtEksekusi.executeUpdate("DELETE FROM tbl_histori_konseling");

        stmtEksekusi.executeUpdate("DELETE FROM tbl_siswa WHERE kelas LIKE 'XII %' OR kelas LIKE '12 %'");
        stmtEksekusi.executeUpdate("UPDATE tbl_siswa SET kelas = CONCAT('XII ', SUBSTRING(kelas, 4)) WHERE kelas LIKE 'XI %'");
        stmtEksekusi.executeUpdate("UPDATE tbl_siswa SET kelas = CONCAT('XI ', SUBSTRING(kelas, 3)) WHERE kelas LIKE 'X %'");

        String sqlUpdateTahun =
                "UPDATE tbl_siswa SET tahun_ajaran = CONCAT(" +
                        "   CAST(LEFT(tahun_ajaran, 4) AS UNSIGNED) + 1, " +
                        "   '/', " +
                        "   CAST(RIGHT(tahun_ajaran, 4) AS UNSIGNED) + 1 " +
                        ") WHERE length(tahun_ajaran) = 9";
        stmtEksekusi.executeUpdate(sqlUpdateTahun);

        stmtEksekusi.executeUpdate("UPDATE tbl_siswa SET total_poin_aktif = 0");

        conn.commit();
        conn.setAutoCommit(true);
        return true;

    } catch (SQLException e) {
        try {
            conn.rollback();
            conn.setAutoCommit(true);
        } catch (SQLException ex) {
        }

        JOptionPane.showMessageDialog(null, "Gagal Proses Kenaikan Kelas: " + e.getMessage());
        e.printStackTrace();
        return false;
    } finally {
        try { if (rs != null) rs.close(); } catch (Exception e) {}
        try { if (stmtCari != null) stmtCari.close(); } catch (Exception e) {}
        try { if (stmtEksekusi != null) stmtEksekusi.close(); } catch (Exception e) {}
    }
}

    public List<Siswa> getSiswaBermasalah() {
        List<Siswa> listSiswa = new ArrayList<>();
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
        if (poinBaru < 0) {
            poinBaru = 0;
        }

        String sql = "UPDATE tbl_siswa SET total_poin_aktif = ? WHERE id_siswa = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, poinBaru);
            ps.setInt(2, idSiswa);

            int rowUpdated = ps.executeUpdate();
            return rowUpdated > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Update Poin: " + e.getMessage());
            return false;
        }
    }

    public boolean cekDataSiswa(String kode) {
        String sql = "SELECT COUNT(*) FROM tbl_siswa  WHERE nis= ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kode);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int jumlah = rs.getInt(1);
                return  jumlah> 0;
            }
            return false;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public int recalculateTotalPoin(int idSiswa) {
        int totalPoin = 0;
        String sqlSum = "SELECT SUM(m.poin_pelanggaran) AS total " +
                        "FROM tbl_histori_pelanggaran h " +
                        "JOIN tbl_master_pelanggaran m ON h.id_pelanggaran = m.kode_pelanggaran " +
                        "WHERE h.id_siswa = ?";
        
        String sqlUpdate = "UPDATE tbl_siswa SET total_poin_aktif = ? WHERE id_siswa = ?";

        try {
            PreparedStatement psSum = conn.prepareStatement(sqlSum);
            psSum.setInt(1, idSiswa);
            ResultSet rs = psSum.executeQuery();
            
            if (rs.next()) {
                totalPoin = rs.getInt("total");
            }

            PreparedStatement psUpdate = conn.prepareStatement(sqlUpdate);
            psUpdate.setInt(1, totalPoin);
            psUpdate.setInt(2, idSiswa);
            psUpdate.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return totalPoin;
    }
}