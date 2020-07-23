package com.ananda.absen.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ananda.absen.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;
import java.util.List;

/*
Deskripsi Pengerjaan    : Membuat Membuat Activity Kehadiran
NIM                     : Ananda Marwanaya Putra
Nama                    : 10117157
Kelas                   : IF-4

 */
public class KehadiranActivity extends AppCompatActivity {
    private ImageView ivBack;
    private RecyclerView rvKehadiran;
    private FirebaseFirestore fStore;
    String userId;
    private FirebaseAuth auth;
    TextView tvTanggal, tvJamMasuk, tvJamPulang, tvTotalJam, tvKeterangan;

    private KehadiranAdapterFire adapterFire;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kehadiran);
        ivBack = findViewById(R.id.iv_back);
        auth = FirebaseAuth.getInstance();
        fStore= FirebaseFirestore.getInstance();
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        tvTanggal = findViewById(R.id.tv_tanggal_absen);
        tvJamMasuk = findViewById(R.id.tv_jam_masuk);
        tvJamPulang = findViewById(R.id.tv_jam_pulang);
        tvTotalJam = findViewById(R.id.tv_total_jam_absen);
        tvKeterangan = findViewById(R.id.tv_keterangan);


        userId = auth.getCurrentUser().getUid();
        final DocumentReference documentReference = fStore.collection("Kehadiran").document(userId);

        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                String tmMasuk = documentSnapshot.getString("Tanggal");
                String jmMasuk = documentSnapshot.getString("JamMasuk");
                String jmPulang = documentSnapshot.getString("JamPulang");
                String jamtotal = documentSnapshot.getString("TotalJam");
                String keterangan = documentSnapshot.getString("Keterangan");

                tvTanggal.setText(tmMasuk);
                tvJamMasuk.setText(jmMasuk);
                tvJamPulang.setText(jmPulang);
                tvTotalJam.setText(jamtotal);
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