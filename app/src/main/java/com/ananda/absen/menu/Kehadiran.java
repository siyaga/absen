package com.ananda.absen.menu;

import java.util.Date;
/*
Deskripsi Pengerjaan    : Membuat class Kehadiran
NIM                     : Ananda Marwanaya Putra
Nama                    : 10117157
Kelas                   : IF-4

 */
class Kehadiran {
    public String email;
    public String tanggalKehadiran;
    public String jamMasuk;
    public String jamPulang;
    public String jamTotal;
    public String KeteranganKehadiran;

    public Kehadiran(){

    }
    public Kehadiran(String email, String tanggalKehadiran, String jamMasuk, String jamPulang, String jamTotal, String keteranganKehadiran){
    this.email = email;
    this.tanggalKehadiran = tanggalKehadiran;
    this.jamMasuk = jamMasuk;
    this.jamPulang = jamPulang;
    this.jamTotal = jamTotal;
    this.KeteranganKehadiran = KeteranganKehadiran;
    }

    public String getEmail() {
        return email;
    }

    public String getTanggalKehadiran() {
        return tanggalKehadiran;
    }

    public String getJamMasuk() {
        return jamMasuk;
    }

    public String getJamPulang() {
        return jamPulang;
    }

    public String getJamTotal() {
        return jamTotal;
    }

    public String getKeteranganKehadiran() {
        return KeteranganKehadiran;
    }
}
