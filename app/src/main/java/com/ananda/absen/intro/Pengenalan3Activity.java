package com.ananda.absen.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ananda.absen.login.LoginActivity;
import com.ananda.absen.R;
/*
Deskripsi Pengerjaan    : Membuat Membuat Activity Pengenalan Aplikasi 3
NIM                     : Ananda Marwanaya Putra
Nama                    : 10117157
Kelas                   : IF-4

 */
public class Pengenalan3Activity extends AppCompatActivity {
    Button btnLanjut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengenalan3);
        btnLanjut = findViewById(R.id.btn_lanjut_3);
        btnLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pengenalan3Activity.this, SignUp.class);
                startActivity(intent);
                finish();

            }
        });
    }
}
