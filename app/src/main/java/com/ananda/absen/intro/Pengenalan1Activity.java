package com.ananda.absen.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ananda.absen.login.LoginActivity;
import com.ananda.absen.MainActivity;
import com.ananda.absen.R;
/*
Deskripsi Pengerjaan    : Membuat Membuat Activity Pengenalan Aplikasi 1
NIM                     : Ananda Marwanaya Putra
Nama                    : 10117157
Kelas                   : IF-4

 */
public class Pengenalan1Activity extends AppCompatActivity {
    Button btnLanjut, btnSkip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengenalan1);
        btnLanjut = findViewById(R.id.btn_lanjut_1);
        btnSkip = findViewById(R.id.btn_lewati);


        btnLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pengenalan1Activity.this, Pengenalan2Activity.class);
                startActivity(intent);


            }
        });
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pengenalan1Activity.this, LoginActivity.class);
                startActivity(intent);


            }
        });
    }
}
