package com.ananda.absen.menu;

import java.util.Date;
/*
Deskripsi Pengerjaan    : Membuat class Kehadiran
NIM                     : Ananda Marwanaya Putra
Nama                    : 10117157
Kelas                   : IF-4

 */
class Kehadiran {
    public String tanggalKehadiran;
    public String jamMasuk;
    public String jamPulang;
    public String jamTotal;
    public String KeteranganKehadiran;

    public String getTanggalKehadiran() {
        return tanggalKehadiran;
    }

    public void setTanggalKehadiran(String tanggalKehadiran) {
        this.tanggalKehadiran = tanggalKehadiran;
    }

    public String getJamMasuk() {
        return jamMasuk;
    }

    public void setJamMasuk(String jamMasuk) {
        this.jamMasuk = jamMasuk;
    }

    public String getJamPulang() {
        return jamPulang;
    }

    public void setJamPulang(String jamPulang) {
        this.jamPulang = jamPulang;
    }

    public String getJamTotal() {
        return jamTotal;
    }

    public void setJamTotal(String jamTotal) {
        this.jamTotal = jamTotal;
    }

    public String getKeteranganKehadiran() {
        return KeteranganKehadiran;
    }

    public void setKeteranganKehadiran(String keteranganKehadiran) {
        KeteranganKehadiran = keteranganKehadiran;
    }
}
