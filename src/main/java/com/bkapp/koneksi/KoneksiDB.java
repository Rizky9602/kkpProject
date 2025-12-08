package com.bkapp.koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class KoneksiDB {
    private static Connection koneksi;

    public static Connection getKoneksi() {
        if (koneksi == null) {
            try {
                String driver = "com.mysql.cj.jdbc.Driver";

                String url = "jdbc:mysql://localhost:3306/db_bkapp";
                String user = "root";
                String pass = "";

                Class.forName(driver);

                koneksi = DriverManager.getConnection(url, user, pass);

            } catch (ClassNotFoundException | SQLException e) {
                // Tampilkan pesan error jika gagal koneksi
                JOptionPane.showMessageDialog(null,
                        "Error Koneksi Database: " + e.getMessage(),
                        "Koneksi Gagal", JOptionPane.ERROR_MESSAGE);
                System.exit(0); // Hentikan aplikasi jika DB gagal konek
            }
        }
        return koneksi;
    }

    public static void main(String[] args) {
        if (getKoneksi() != null) {
            JOptionPane.showMessageDialog(null, "Koneksi ke database lokal berhasil!");
        }
    }
}