package com.ananda.absen.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ananda.absen.MainActivity;
import com.ananda.absen.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class MasukActivity extends AppCompatActivity {
    private ImageView ivBack;
    private EditText edtTanggalMasuk, edtHariMasuk, edtjamMasuk;
    private Button btnMasuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk);
        ivBack = findViewById(R.id.iv_back);
        edtTanggalMasuk = findViewById(R.id.edt_tanggal_masuk);
        edtHariMasuk = findViewById(R.id.edt_hari_masuk);
        edtjamMasuk = findViewById(R.id.edt_Jam_masuk);
        btnMasuk = findViewById(R.id.btn_Absen_masuk);

        SimpleDateFormat sdfTanggal = new SimpleDateFormat("yyyy.MM.dd");
        String tanggalMasuk = sdfTanggal.format(new Date());
        edtTanggalMasuk.setText(tanggalMasuk);
        SimpleDateFormat sdfHari = new SimpleDateFormat("EEEE", Locale.ENGLISH);
        TimeZone tz = TimeZone.getTimeZone("Asia/Jakarta");
        System.out.println(tz.getDisplayName(false, TimeZone.SHORT, Locale.ENGLISH));
        String hariMasuk = sdfHari.format(new Date());
        sdfHari.setTimeZone(tz);
        edtHariMasuk.setText(hariMasuk);
        SimpleDateFormat sdfJam = new SimpleDateFormat("HH:mm");
        String jamMasuk = sdfJam.format(new Date());
        edtjamMasuk.setText(jamMasuk);

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MasukActivity.this, MainActivity.class);
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
}