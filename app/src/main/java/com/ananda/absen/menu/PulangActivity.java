package com.ananda.absen.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.ananda.absen.MainActivity;
import com.ananda.absen.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/*
Deskripsi Pengerjaan    : Membuat Membuat Activity Absen Pulang
NIM                     : Ananda Marwanaya Putra
Nama                    : 10117157
Kelas                   : IF-4

 */
public class PulangActivity extends AppCompatActivity {
    private ImageView ivBack;
    private EditText edtTanggalPulang, edtHariPulang, edtJamPulang, edtTotalJam;
    private Spinner spinnerKeterangan;
    private Button btnPulang, btnIsiPulang;
    private String tanggalMasuk;
    private String hariMasuk;
    private String jamMasuk;

    public static final String mypreference = "masuk";
    public static final String TanggalMasuk = "tanggalKey";
    public static final String HariMasuk = "hariKey";
    public static final String JamMasuk  = "jamKey";

    public static final String mypreferencePulang = "pulang";
    public static final String TanggalPulang = "tanggalpulangKey";
    public static final String HariPulang = "haripulangKey";
    public static final String JamPulang  = "jampulangKey";
    public static final String TotalJam  = "totaljamKey";
    public static final String Keterangan  = "keteranganKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pulang);
        ivBack = findViewById(R.id.iv_back);


        edtTanggalPulang = findViewById(R.id.edt_tanggal_pulang);
        edtHariPulang = findViewById(R.id.edt_hari_pulang);
        edtJamPulang = findViewById(R.id.edt_jam_pulang);
        edtTotalJam = findViewById(R.id.edt_jam_total);
        spinnerKeterangan = findViewById(R.id.spinner);
        btnPulang = findViewById(R.id.btn_absen_pulang);
        btnPulang.setVisibility(View.INVISIBLE);
        btnIsiPulang = findViewById(R.id.btn_isi_pulang);

        SimpleDateFormat sdfTanggal = new SimpleDateFormat("yyyy.MM.dd");
        final String tanggalPulang = sdfTanggal.format(new Date());
        edtTanggalPulang.setText(tanggalPulang);
        SimpleDateFormat sdfHari = new SimpleDateFormat("EEEE", Locale.ENGLISH);
        final String hariPulang = sdfHari.format(new Date());
        edtHariPulang.setText(hariPulang);
        SharedPreferences sharedPreferences = getSharedPreferences(mypreference, MODE_PRIVATE);
        final String jmMasuk = sharedPreferences.getString(JamMasuk, "jamKey");

        btnIsiPulang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SimpleDateFormat sdfJam = new SimpleDateFormat("HH:mm");
                String jamPulang = edtJamPulang.getText().toString().trim();
                edtJamPulang.setText(jamPulang);

                Date d1= null;
                Date d2= null;

                try {
                    d1 = sdfJam.parse(jmMasuk);
                    d2 = sdfJam.parse(jamPulang);

                    //in milliseconds
                    long diff = d2.getTime() - d1.getTime();
                    long diffMinutes = diff / (60 * 1000) % 60;
                    long diffHours = diff / (60 * 60 * 1000) % 24;
                    String text = (diffHours + ":" + diffMinutes);
                    edtTotalJam.setText(text);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                btnPulang.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(),"Anda Sudah Mengisi Absen",Toast.LENGTH_SHORT).show();

            }
        });
        btnPulang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveDataPulang();
                Intent intent = new Intent(PulangActivity.this, MainActivity.class);
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
    public void SaveDataPulang() {
        SharedPreferences sharedpreferences = getSharedPreferences(mypreferencePulang, MODE_PRIVATE);
        String tp = edtTanggalPulang.getText().toString();
        String hp = edtHariPulang.getText().toString();
        String jp = edtJamPulang.getText().toString();
        String top = edtTotalJam.getText().toString();
        String sp = spinnerKeterangan.getSelectedItem().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(TanggalPulang, tp);
        editor.putString(HariPulang, hp);
        editor.putString(JamPulang, jp);
        editor.putString(TotalJam, top);
        editor.putString(Keterangan, sp);
        editor.apply();
    }

}