package com.bkapp.model;

public class Siswa {
    private int idSiswa;
    private String nis;
    private String namaSiswa;
    private String kelas;
    private String tahunAjaran;
    private int totalPoin;

    public Siswa() {
    }

    public Siswa(int idSiswa, String nis, String namaSiswa, String kelas, String tahunAjaran, int totalPoin) {
        this.idSiswa = idSiswa;
        this.nis = nis;
        this.namaSiswa = namaSiswa;
        this.kelas = kelas;
        this.tahunAjaran = tahunAjaran;
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

    public String getTahunAjaran() {
        return tahunAjaran;
    }

    public void setTahunAjaran(String tahunAjaran) {
        this.tahunAjaran = tahunAjaran;
    }

    public int getTotalPoin() {
        return totalPoin;
    }

    public void setTotalPoin(int totalPoin) {
        this.totalPoin = totalPoin;
    }

    @Override
    public String toString() {
        return nis + " - " + namaSiswa;
    }
}