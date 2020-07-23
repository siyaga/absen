package com.ananda.absen.login;


import java.util.prefs.Preferences;
/*
Deskripsi Pengerjaan    : Membuat Membuat clas user
NIM                     : Ananda Marwanaya Putra
Nama                    : 10117157
Kelas                   : IF-4

 */
public class User {
    public String nama;
    public String email;
    public String userlevel;



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUserlevel() {
        return userlevel;
    }

    public void setUserlevel(String userlevel) {
        this.userlevel = userlevel;
    }

    public User(String nama, String email, String userlevel){

        this.email = email;
        this.nama = nama;
        this.userlevel = userlevel;

    }


}
