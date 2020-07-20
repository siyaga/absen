package com.ananda.absen.login;

import com.google.firebase.database.DatabaseReference;

import java.util.prefs.Preferences;
/*
Deskripsi Pengerjaan    : Membuat Membuat clas user
NIM                     : Ananda Marwanaya Putra
Nama                    : 10117157
Kelas                   : IF-4

 */
public class User {

    public String email;
    public String password;



    public User(){

    }


    public User(String email, String password){

        this.email = email;
        this.password = password;

    }


}
