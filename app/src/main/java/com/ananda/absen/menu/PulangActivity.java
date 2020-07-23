package com.ananda.absen.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.ananda.absen.MainActivity;
import com.ananda.absen.R;
import com.ananda.absen.admin.AdminActivity;
import com.ananda.absen.login.LoginActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
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
    String userId;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseFirestore fStore = FirebaseFirestore.getInstance();

    public static final String mypreference = "masuk";
    public static final String TanggalMasuk = "tanggalKey";
    public static final String JamMasuk  = "jamKey";
    private String jmMasuk;
    private String tmMasuk;
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

        SharedPreferences sharedPreferencesMulai = getSharedPreferences(mypreference, MODE_PRIVATE);
        jmMasuk = sharedPreferencesMulai.getString(JamMasuk, "jamKey");

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
                Toast.makeText(getApplicationContext(),"Berhasil Menghitung",Toast.LENGTH_SHORT).show();

            }
        });
        btnPulang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveDataPulang();
                Intent intent = new Intent(PulangActivity.this, MainActivity.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(),"Berhasil Melakukan Absen Pulang",Toast.LENGTH_SHORT).show();
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
        userId = auth.getCurrentUser().getUid();
        DocumentReference documentReference = fStore.collection("user").document(userId);

        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                SharedPreferences sharedPreferencesMulai = getSharedPreferences(mypreference, MODE_PRIVATE);
                tmMasuk = sharedPreferencesMulai.getString(TanggalMasuk, "tanggalKey");
                jmMasuk = sharedPreferencesMulai.getString(JamMasuk, "jamKey");
                String jp = edtJamPulang.getText().toString();
                String top = edtTotalJam.getText().toString();
                String sp = spinnerKeterangan.getSelectedItem().toString();
                String email = documentSnapshot.getString("email");
                Map<String, Object> kehadiranPeruser = new HashMap<>();

                kehadiranPeruser.put("email", email);
                kehadiranPeruser.put("Tanggal", tmMasuk);
                kehadiranPeruser.put("JamMasuk", jmMasuk);
                kehadiranPeruser.put("JamPulang", jp);
                kehadiranPeruser.put("TotalJam", top);
                kehadiranPeruser.put("Keterangan", sp);

                fStore.collection("Kehadiran").document(userId).set(kehadiranPeruser)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(PulangActivity.this, "Kehadiran Berhasil", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(PulangActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                                Log.d("TAG", e.toString());

                            }
                        });

            }

        });

    }

}