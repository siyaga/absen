package com.ananda.absen.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class MasukActivity extends AppCompatActivity {
    private ImageView ivBack;
    private EditText edtTanggalMasuk, edtHariMasuk, edtjamMasuk;
    private Button btnMasuk,btnIsi;
    private static final String TANGGALMASUK="TanggalMasuk";
    private static final String HARIMASUK="HariMasuk";
    private static final String JAMMASUK="JamMasuk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk);
        ivBack = findViewById(R.id.iv_back);
        edtTanggalMasuk = findViewById(R.id.edt_tanggal_masuk);
        edtHariMasuk = findViewById(R.id.edt_hari_masuk);
        edtjamMasuk = findViewById(R.id.edt_Jam_masuk);
        btnMasuk = findViewById(R.id.btn_Absen_masuk);
        btnIsi = findViewById(R.id.btn_isi_masuk);
      //  btnMasuk.setVisibility(View.INVISIBLE);
        SimpleDateFormat sdfTanggal = new SimpleDateFormat("yyyy.MM.dd");
        final String tanggalMasuk = sdfTanggal.format(new Date());
        Masuk masuk = new Masuk();
        edtTanggalMasuk.setText(tanggalMasuk);
        SimpleDateFormat sdfHari = new SimpleDateFormat("EEEE", Locale.ENGLISH);
        final String hariMasuk = sdfHari.format(new Date());
        edtHariMasuk.setText(hariMasuk);
        SimpleDateFormat sdfJam = new SimpleDateFormat("HH:mm");
        final String jamMasuk = sdfJam.format(new Date());
        edtjamMasuk.setText(jamMasuk);

        /* btnIsi.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) {
                SimpleDateFormat sdfTanggal = new SimpleDateFormat("yyyy.MM.dd");
                final String tanggalMasuk = sdfTanggal.format(new Date());
                edtTanggalMasuk.setText(tanggalMasuk);
                SimpleDateFormat sdfHari = new SimpleDateFormat("EEEE", Locale.ENGLISH);
                final String hariMasuk = sdfHari.format(new Date());
                edtHariMasuk.setText(hariMasuk);
                SimpleDateFormat sdfJam = new SimpleDateFormat("HH:mm");
                final String jamMasuk = sdfJam.format(new Date());
                edtjamMasuk.setText(jamMasuk);
                btnMasuk.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(),"Anda Sudah Mengisi Absen",Toast.LENGTH_SHORT).show();

            }
        });  */


        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MasukActivity.this, PulangActivity.class);
                intent.putExtra(TANGGALMASUK, tanggalMasuk);
                intent.putExtra(HARIMASUK, hariMasuk);
                intent.putExtra(JAMMASUK, jamMasuk);

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
}