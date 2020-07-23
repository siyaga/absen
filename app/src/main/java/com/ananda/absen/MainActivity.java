package com.ananda.absen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ananda.absen.login.LoginActivity;
import com.ananda.absen.menu.KehadiranActivity;
import com.ananda.absen.menu.MasukActivity;
import com.ananda.absen.menu.PulangActivity;
import com.ananda.absen.menu.TentangActivity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

/*
Deskripsi Pengerjaan    : Membuat Main Activity Sebagai Menu
NIM                     : Ananda Marwanaya Putra
Nama                    : 10117157
Kelas                   : IF-4

 */
public class MainActivity extends AppCompatActivity {
    private FirebaseAuth.AuthStateListener authStateListener;
    private FirebaseAuth auth;
    TextView tvHalo;
    private ImageView ivLogout;
    private LinearLayout linearMasuk, linearPulang, linearKehadiran, linearTentang;
    private FirebaseFirestore fStore;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivLogout = findViewById(R.id.iv_logout);
        auth = FirebaseAuth.getInstance();
        fStore= FirebaseFirestore.getInstance();

        linearMasuk = findViewById(R.id.linear_masuk);
        linearPulang = findViewById(R.id.linear_pulang);
        linearKehadiran = findViewById(R.id.linear_kehadiran);
        linearTentang = findViewById(R.id.linear_tentang);
        tvHalo = findViewById(R.id.tv_halo_user);

        linearMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MasukActivity.class);
                startActivity(intent);
            }
        });
        linearPulang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PulangActivity.class);
                startActivity(intent);
            }
        });
        linearKehadiran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KehadiranActivity.class);
                startActivity(intent);
            }
        });
        linearTentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TentangActivity.class);
                startActivity(intent);
            }
        });

        userId = auth.getCurrentUser().getUid();
        final DocumentReference documentReference = fStore.collection("user").document(userId);

        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                String tmMasuk = documentSnapshot.getString("nama");


                tvHalo.setText("Halo "+tmMasuk);

            }
        });

        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user ==null){
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        ivLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });
    }
    public void signOut() {
        auth.signOut();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(authStateListener != null) {
            auth.removeAuthStateListener(authStateListener);
        }
    }
}
