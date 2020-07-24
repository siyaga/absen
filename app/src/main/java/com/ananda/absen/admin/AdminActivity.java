package com.ananda.absen.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ananda.absen.MainActivity;
import com.ananda.absen.R;
import com.ananda.absen.login.LoginActivity;
import com.ananda.absen.menu.KehadiranActivity;
import com.ananda.absen.menu.TentangActivity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
/*
Deskripsi Pengerjaan    : Membuat Admin Activity
NIM                     : Ananda Marwanaya Putra
Nama                    : 10117157
Kelas                   : IF-4

 */
public class AdminActivity extends AppCompatActivity {
    private FirebaseAuth.AuthStateListener authStateListener;
    private FirebaseAuth auth;
    private ImageView ivLogout;
    private LinearLayout linearKehadiran, linearTentang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ivLogout = findViewById(R.id.iv_logout);
        auth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_admin);
        linearKehadiran = findViewById(R.id.linear_kehadiran_admin);
        linearTentang = findViewById(R.id.linear_tentang);
        ivLogout = findViewById(R.id.iv_logout);




        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user ==null){
                    Intent intent = new Intent(AdminActivity.this, LoginActivity.class);
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

        linearKehadiran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, KehadiranAdminActivity.class);
                startActivity(intent);
            }
        });
        linearTentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, TentangActivity.class);
                startActivity(intent);
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