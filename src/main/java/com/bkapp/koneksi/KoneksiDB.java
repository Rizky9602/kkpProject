package com.bkapp.koneksi;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import javax.swing.JOptionPane;

public class KoneksiDB {
    private static Connection koneksi;

    public static Connection getKoneksi() {
        if (koneksi == null) {
            try {
                Properties props = new Properties();

                String pathConfig = System.getProperty("user.dir") + File.separator + "config.properties";
                File fileConfig = new File(pathConfig);

                if (fileConfig.exists()) {
                    FileInputStream fis = new FileInputStream(fileConfig);
                    props.load(fis);
                    fis.close();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "File konfigurasi database (config.properties) tidak ditemukan!\n" +
                                    "Pastikan file tersebut ada satu folder dengan aplikasi.",
                            "Error Config", JOptionPane.ERROR_MESSAGE);
                    return null;
                }

                String ipServer = props.getProperty("db.host");
                String port = props.getProperty("db.port");
                String dbName = props.getProperty("db.name");
                String user = props.getProperty("db.user");
                String pass = props.getProperty("db.password");

                String url = "jdbc:mysql://" + "localHost" + ":" + "3306" + "/" + "db_bkapp";

                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                koneksi = DriverManager.getConnection(url, "root", "rizky09");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal Konek Database: " + e.getMessage());
            }
        }
        return koneksi;
    }
}