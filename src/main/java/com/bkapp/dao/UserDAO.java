package com.bkapp.dao;

import com.bkapp.koneksi.KoneksiDB;
import com.bkapp.model.User;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UserDAO {

    private Connection conn;

    public UserDAO() {
        this.conn = KoneksiDB.getKoneksi();
    }

    /**
     * Fungsi untuk Login
     * @param username
     * @param password (password asli, belum di-hash)
     * @return Object User jika berhasil, null jika gagal
     */
    public User login(String username, String password) {
        User user = null;
        String sql = "SELECT * FROM tbl_user WHERE username = ? AND password = ?";

        try {
            String passwordHash = hashMD5(password);

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, passwordHash);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setIdUser(rs.getInt("id_user"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password")); // simpan hash-nya saja
                user.setNamaLengkap(rs.getString("nama_lengkap"));
                user.setRole(rs.getString("role"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Login: " + e.getMessage());
        }

        return user;
    }

    private String hashMD5(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}