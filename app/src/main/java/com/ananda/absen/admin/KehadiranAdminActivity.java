package com.ananda.absen.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ananda.absen.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
/*
Deskripsi Pengerjaan    : Membuat class Kehadiran user Admin
NIM                     : Ananda Marwanaya Putra
Nama                    : 10117157
Kelas                   : IF-4

 */
public class KehadiranAdminActivity extends AppCompatActivity {
    private FirebaseFirestore firebaseFirestore;
    ImageView ivBack;
    TextView tvEmail, tvTanggal, tvTotal, tvKeterangan;
    private FirebaseFirestore fStore;
    String userId;
    private FirebaseAuth auth;

    /*
    private FirebaseAuth auth = FirebaseAuth.getInstance();;
    private FirebaseFirestore fStore = FirebaseFirestore.getInstance();
    String userId;
    private CollectionReference kehadiranRef = fStore.collection("Kehadiran");
    private KehadiranAdminAdapterFire adapter;
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kehadiran_admin);

        ivBack = findViewById(R.id.iv_back);
        auth = FirebaseAuth.getInstance();
        fStore= FirebaseFirestore.getInstance();
        tvEmail = findViewById(R.id.tv_email);
        tvTanggal = findViewById(R.id.tv_tanggal_absen);
        tvTotal = findViewById(R.id.tv_total_jam_absen);
        tvKeterangan = findViewById(R.id.tv_keterangan);

        userId = auth.getCurrentUser().getUid();
        final DocumentReference documentReference = fStore.collection("Kehadiran").document(userId);

        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                String email = documentSnapshot.getString("email");
                String tmMasuk = documentSnapshot.getString("Tanggal");
                String jamtotal = documentSnapshot.getString("TotalJam");
                String keterangan = documentSnapshot.getString("Keterangan");

                tvEmail.setText(email);
                tvTanggal.setText(tmMasuk);
                tvTotal.setText(jamtotal);
                tvKeterangan.setText(keterangan);




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