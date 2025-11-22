package com.bkapp.model;

public class Pelanggaran {
    private int idPelanggaran;
    private String kodePelanggaran;
    private String namaPelanggaran;
    private int poin;

    public Pelanggaran() {
    }

    public Pelanggaran(int idPelanggaran, String kodePelanggaran, String namaPelanggaran, int poin) {
        this.idPelanggaran = idPelanggaran;
        this.kodePelanggaran = kodePelanggaran;
        this.namaPelanggaran = namaPelanggaran;
        this.poin = poin;
    }

    // Getter dan Setter
    public int getIdPelanggaran() { return idPelanggaran; }
    public void setIdPelanggaran(int idPelanggaran) { this.idPelanggaran = idPelanggaran; }

    public String getKodePelanggaran() { return kodePelanggaran; }
    public void setKodePelanggaran(String kodePelanggaran) { this.kodePelanggaran = kodePelanggaran; }

    public String getNamaPelanggaran() { return namaPelanggaran; }
    public void setNamaPelanggaran(String namaPelanggaran) { this.namaPelanggaran = namaPelanggaran; }

    public int getPoin() { return poin; }
    public void setPoin(int poin) { this.poin = poin; }

    @Override
    public String toString() {
        return namaPelanggaran + " (" + poin + " Poin)";
    }
}
