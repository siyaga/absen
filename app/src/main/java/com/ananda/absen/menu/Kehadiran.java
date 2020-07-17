package com.ananda.absen.menu;

import java.util.Date;

class Kehadiran {
    public Date tanggalKehadiran;
    public Date jamMasuk;
    public Date jamPulang;
    public int jamTotal;
    public String KeteranganKehadiran;

    public Date getTanggalKehadiran() {
        return tanggalKehadiran;
    }

    public void setTanggalKehadiran(Date tanggalKehadiran) {
        this.tanggalKehadiran = tanggalKehadiran;
    }

    public Date getJamMasuk() {
        return jamMasuk;
    }

    public void setJamMasuk(Date jamMasuk) {
        this.jamMasuk = jamMasuk;
    }

    public Date getJamPulang() {
        return jamPulang;
    }

    public void setJamPulang(Date jamPulang) {
        this.jamPulang = jamPulang;
    }

    public int getJamTotal() {
        return jamTotal;
    }

    public void setJamTotal(int jamTotal) {
        this.jamTotal = jamTotal;
    }

    public String getKeteranganKehadiran() {
        return KeteranganKehadiran;
    }

    public void setKeteranganKehadiran(String keteranganKehadiran) {
        KeteranganKehadiran = keteranganKehadiran;
    }
}
