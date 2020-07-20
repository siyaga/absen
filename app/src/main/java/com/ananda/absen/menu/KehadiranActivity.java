package com.ananda.absen.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ananda.absen.R;

import java.util.ArrayList;
/*
Deskripsi Pengerjaan    : Membuat Membuat Activity Kehadiran
NIM                     : Ananda Marwanaya Putra
Nama                    : 10117157
Kelas                   : IF-4

 */
public class KehadiranActivity extends AppCompatActivity {
    private ImageView ivBack;
    private RecyclerView rvKehadiran;
    private ArrayList<Kehadiran> list = new ArrayList<>();

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
        setContentView(R.layout.activity_kehadiran);
        ivBack = findViewById(R.id.iv_back);
        rvKehadiran = findViewById(R.id.rvkehadiran);
        rvKehadiran.setHasFixedSize(true);

        SharedPreferences sharedPreferencesMulai = getSharedPreferences(mypreference, MODE_PRIVATE);
        SharedPreferences sharedPreferencesPulang = getSharedPreferences(mypreferencePulang, MODE_PRIVATE);
        String tmMasuk = sharedPreferencesMulai.getString(TanggalMasuk, "tanggalKey");
        String jmMasuk = sharedPreferencesMulai.getString(JamMasuk, "jamKey");
        String jmPulang = sharedPreferencesPulang.getString(JamPulang, "jampulangKey");
        String jamtotal = sharedPreferencesPulang.getString(TotalJam, "totaljamKey");
        String keterangan = sharedPreferencesPulang.getString(Keterangan, "keteranganKey");


          Kehadiran kehadiran = new Kehadiran();
            kehadiran.setTanggalKehadiran(tmMasuk);
            kehadiran.setJamMasuk(jmMasuk);
            kehadiran.setJamPulang(jmPulang);
            kehadiran.setJamTotal(jamtotal);
            kehadiran.setKeteranganKehadiran(keterangan);
            list.add(kehadiran);


        showRecyclerList();
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    private void showRecyclerList(){
        rvKehadiran.setLayoutManager(new LinearLayoutManager(this));
        KehadiranAdapter listKehadiranAdapter = new KehadiranAdapter(list);
        rvKehadiran.setAdapter(listKehadiranAdapter);
    }
}