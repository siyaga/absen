package com.ananda.absen.admin;

/*
Deskripsi Pengerjaan    : Membuat class Kehadiran
NIM                     : Ananda Marwanaya Putra
Nama                    : 10117157
Kelas                   : IF-4

 */
public class KehadiranAdmin {
    public String email;
    public String Tanggal;
    public String JamMasuk;
    public String JamPulang;
    public String TotalJam;
    public String Keterangan;

    public KehadiranAdmin() {

    }
    public KehadiranAdmin(String email, String Tanggal,String JamMasuk,String JamPulang, String TotalJam, String Keterangan){
        this.email = email;
        this.Tanggal = Tanggal;
        this.JamMasuk = JamMasuk;
        this.Tanggal = Tanggal;
        this.JamPulang = JamPulang;
        this.Keterangan = Keterangan;
    }

    public String getEmail() {
        return email;
    }

    public String getTanggal() {
        return Tanggal;
    }

    public String getJamMasuk() {
        return JamMasuk;
    }

    public String getJamPulang() {
        return JamPulang;
    }

    public String getTotalJam() {
        return TotalJam;
    }

    public String getKeterangan() {
        return Keterangan;
    }
}
