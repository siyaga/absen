package com.ananda.absen.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ananda.absen.R;
/*
Deskripsi Pengerjaan    : Membuat Membuat Activity Pengenalan Aplikasi 2
NIM                     : Ananda Marwanaya Putra
Nama                    : 10117157
Kelas                   : IF-4

 */
public class Pengenalan2Activity extends AppCompatActivity {
    Button btnLanjut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengenalan2);
        btnLanjut = findViewById(R.id.btn_lanjut_2);
        btnLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pengenalan2Activity.this, Pengenalan3Activity.class);
                startActivity(intent);


            }
        });
    }
}
