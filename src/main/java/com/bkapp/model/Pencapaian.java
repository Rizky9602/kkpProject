package com.bkapp.model;

public class Pencapaian {
    private int idPencapaian;
    private String kodePencapaian;
    private String namaPencapaian;
    private int poinPengurang;

    public Pencapaian() {
    }

    public Pencapaian(int idPencapaian, String kodePencapaian, String namaPencapaian, int poinPengurang) {
        this.idPencapaian = idPencapaian;
        this.kodePencapaian = kodePencapaian;
        this.namaPencapaian = namaPencapaian;
        this.poinPengurang = poinPengurang;
    }

    // Getter dan Setter
    public int getIdPencapaian() {
        return idPencapaian;
    }

    public void setIdPencapaian(int idPencapaian) {
        this.idPencapaian = idPencapaian;
    }

    public String getKodePencapaian() {
        return kodePencapaian;
    }

    public void setKodePencapaian(String kodePencapaian) {
        this.kodePencapaian = kodePencapaian;
    }

    public String getNamaPencapaian() {
        return namaPencapaian;
    }

    public void setNamaPencapaian(String namaPencapaian) {
        this.namaPencapaian = namaPencapaian;
    }

    public int getPoinPengurang() {
        return poinPengurang;
    }

    public void setPoinPengurang(int poinPengurang) {
        this.poinPengurang = poinPengurang;
    }

    @Override
    public String toString() {
        return namaPencapaian + " (Kurang " + poinPengurang + " Poin)";
    }
}
