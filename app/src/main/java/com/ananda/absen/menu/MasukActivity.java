package com.ananda.absen.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ananda.absen.MainActivity;
import com.ananda.absen.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/*
Deskripsi Pengerjaan    : Membuat Membuat Activity Absen Masuk
NIM                     : Ananda Marwanaya Putra
Nama                    : 10117157
Kelas                   : IF-4

 */
public class MasukActivity extends AppCompatActivity {

    private ImageView ivBack;
    private EditText edtTanggalMasuk, edtHariMasuk, edtjamMasuk;
    private Button btnMasuk,btnIsi;
    public static final String mypreference = "masuk";
    public static final String TanggalMasuk = "tanggalKey";
    public static final String HariMasuk = "hariKey";
    public static final String JamMasuk  = "jamKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk);
        ivBack = findViewById(R.id.iv_back);
        edtTanggalMasuk = findViewById(R.id.edt_tanggal_masuk);
        edtHariMasuk = findViewById(R.id.edt_hari_masuk);
        edtjamMasuk = findViewById(R.id.edt_Jam_masuk);
        btnMasuk = findViewById(R.id.btn_Absen_masuk);
      //  btnMasuk.setVisibility(View.INVISIBLE);
        SimpleDateFormat sdfTanggal = new SimpleDateFormat("yyyy.MM.dd");
        final String tanggalMasuk = sdfTanggal.format(new Date());
        edtTanggalMasuk.setText(tanggalMasuk);
        SimpleDateFormat sdfHari = new SimpleDateFormat("EEEE", Locale.ENGLISH);
        String hariMasuk = sdfHari.format(new Date());
        edtHariMasuk.setText(hariMasuk);
        SimpleDateFormat sdfJam = new SimpleDateFormat("HH:mm");
        final String jamMasuk = sdfJam.format(new Date());
        edtjamMasuk.setText(jamMasuk);





        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    SaveDataMasuk();
                    Intent intent = new Intent(MasukActivity.this, MainActivity.class);
                Toast.makeText(getApplicationContext(),"Absen Masuk Telah Berhasil",Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            }
        });

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    public void SaveDataMasuk() {
        SharedPreferences sharedpreferences = getSharedPreferences(mypreference, MODE_PRIVATE);
        String tm = edtTanggalMasuk.getText().toString();
        String hm = edtHariMasuk.getText().toString();
        String jm = edtjamMasuk.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(TanggalMasuk, tm);
        editor.putString(HariMasuk, hm);
        editor.putString(JamMasuk, jm);
        editor.apply();
    }
}