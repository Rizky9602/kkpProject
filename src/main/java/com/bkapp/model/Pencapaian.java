package com.bkapp.model;

public class Pencapaian {
    private String kodePencapaian;
    private String namaPencapaian;
    private int poinPengurang;
    

    public Pencapaian() {
    }

    public Pencapaian(int idPencapaian, String kodePencapaian, String namaPencapaian, int poinPengurang) {
        this.kodePencapaian = kodePencapaian;
        this.namaPencapaian = namaPencapaian;
        this.poinPengurang = poinPengurang;
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
