package com.bkapp.model;

public class Konseling {
    private int idKonseling;
    private int idSiswa;
    private String tanggal;
    private String permasalahan;
    private String solusi;
    private String status;

    public Konseling() {}

    // Getter & Setter
    public int getIdKonseling() { return idKonseling; }
    public void setIdKonseling(int idKonseling) { this.idKonseling = idKonseling; }

    public int getIdSiswa() { return idSiswa; }
    public void setIdSiswa(int idSiswa) { this.idSiswa = idSiswa; }

    public String getTanggal() { return tanggal; }
    public void setTanggal(String tanggal) { this.tanggal = tanggal; }

    public String getPermasalahan() { return permasalahan; }
    public void setPermasalahan(String permasalahan) { this.permasalahan = permasalahan; }

    public String getSolusi() { return solusi; }
    public void setSolusi(String solusi) { this.solusi = solusi; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
