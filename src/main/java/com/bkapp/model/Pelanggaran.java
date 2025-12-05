package com.bkapp.model;

public class Pelanggaran {
    // Kita sesuaikan dengan tabel di screenshot Anda
    private String kodePelanggaran; // Ini sekarang jadi Primary Key
    private String namaPelanggaran;
    private String sanksi;          // Kolom Baru
    private int poin;

    // Constructor Kosong
    public Pelanggaran() {
    }

    // Constructor Lengkap
    public Pelanggaran(String kodePelanggaran, String namaPelanggaran, String sanksi, int poin) {
        this.kodePelanggaran = kodePelanggaran;
        this.namaPelanggaran = namaPelanggaran;
        this.sanksi = sanksi;
        this.poin = poin;
    }

    // Getter dan Setter
    public String getKodePelanggaran() { return kodePelanggaran; }
    public void setKodePelanggaran(String kodePelanggaran) { this.kodePelanggaran = kodePelanggaran; }

    public String getNamaPelanggaran() { return namaPelanggaran; }
    public void setNamaPelanggaran(String namaPelanggaran) { this.namaPelanggaran = namaPelanggaran; }

    public String getSanksi() { return sanksi; }
    public void setSanksi(String sanksi) { this.sanksi = sanksi; }

    public int getPoin() { return poin; }
    public void setPoin(int poin) { this.poin = poin; }
    
    // Untuk tampilan di ComboBox nanti
    @Override
    public String toString() {
        return kodePelanggaran + " - " + namaPelanggaran + " (" + poin + " Poin)";
    }
}