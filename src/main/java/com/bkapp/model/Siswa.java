package com.bkapp.model;

public class Siswa {
    private int idSiswa;
    private String nis;
    private String namaSiswa;
    private String kelas;
    private int angkatan;
    private int totalPoin;

    public Siswa(){

    }

    public Siswa(int idSiswa, String nis, String namaSiswa, String kelas,int angkatan, int totalPoin) {
        this.idSiswa = idSiswa;
        this.nis = nis;
        this.namaSiswa = namaSiswa;
        this.kelas = kelas;
        this.angkatan = angkatan;
        this.totalPoin = totalPoin;
    }

    public int getIdSiswa() {
        return idSiswa;
    }

    public void setIdSiswa(int idSiswa) {
        this.idSiswa = idSiswa;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getNamaSiswa() {
        return namaSiswa;
    }

    public void setNamaSiswa(String namaSiswa) {
        this.namaSiswa = namaSiswa;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public int getTotalPoin() {
        return totalPoin;
    }

    public void setTotalPoin(int totalPoin) {
        this.totalPoin = totalPoin;
    }

    public int getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(int angkatan) {
        this.angkatan = angkatan;
    }

    @Override
    public String toString() {
        return nis + " - " + namaSiswa;
    }
}
