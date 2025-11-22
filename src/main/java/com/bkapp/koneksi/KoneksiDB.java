package com.bkapp.koneksi; // (Sesuaikan nama package Anda)

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class KoneksiDB {
    private static Connection koneksi; // Variabel koneksi

    public static Connection getKoneksi() {
        if (koneksi == null) {
            try {
                // 1. Driver MySQL
                String driver = "com.mysql.cj.jdbc.Driver";

                // 2. Alamat Database (Ganti ke localhost)
                // 'db_bimbingan_konseling' adalah nama database Anda
                String url = "jdbc:mysql://localhost:3306/db_bimbingan_konseling";

                // 3. User & Password database lokal Anda
                // (Default XAMPP biasanya 'root' dan password kosong)
                String user = "root";
                String pass = ""; // Kosongkan jika tidak ada password

                // Registrasi driver
                Class.forName(driver);

                // Buat koneksi
                koneksi = DriverManager.getConnection(url, user, pass);

                // (Boleh dihapus jika sudah berhasil)
                // System.out.println("Koneksi Database Berhasil!");

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

    // (Optional) Main method untuk tes koneksi
    public static void main(String[] args) {
        if (getKoneksi() != null) {
            JOptionPane.showMessageDialog(null, "Koneksi ke database lokal berhasil!");
        }
    }
}