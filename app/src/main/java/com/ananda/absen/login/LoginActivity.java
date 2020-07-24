package com.ananda.absen.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ananda.absen.MainActivity;
import com.ananda.absen.R;
import com.ananda.absen.admin.AdminActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

/*
Deskripsi Pengerjaan    : Membuat Membuat Activity Login
NIM                     : Ananda Marwanaya Putra
Nama                    : 10117157
Kelas                   : IF-4

 */
public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private Button btnLogin, btnDaftar;
    private ProgressBar progressBar;
    private EditText edtEmail, edtPassword;
    private TextView tvLupaPassword;
    FirebaseFirestore fStore;
    String userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Write a message to the database
        auth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        btnLogin = findViewById(R.id.btn_login);
        btnDaftar = findViewById(R.id.btn_login_daftar);
        tvLupaPassword = findViewById(R.id.tv_lupa_password);
        edtEmail = findViewById(R.id.edt_email_login);
        edtPassword = findViewById(R.id.edt_password);
        progressBar = findViewById(R.id.progressBar);



        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        tvLupaPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, LupaPasswordActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginEmail = edtEmail.getText().toString();
                final String loginPassword = edtPassword.getText().toString();

                if(TextUtils.isEmpty(loginEmail)){
                    Toast.makeText(getApplicationContext(),"Masukan Email!",Toast.LENGTH_SHORT).show();
                    return;

                }
                if (TextUtils.isEmpty(loginPassword)){
                    Toast.makeText(getApplicationContext(),"Masukan Password!",Toast.LENGTH_SHORT).show();
                    return;
                }
                    progressBar.setVisibility(View.VISIBLE);
                    auth.signInWithEmailAndPassword(loginEmail, loginPassword)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>(){
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (!task.isSuccessful()) {

                                        if (loginPassword.length() < 6) {
                                            edtPassword.setError(getString(R.string.minimum_password));
                                        } else {
                                            Toast.makeText(LoginActivity.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();

                                        }
                                    } else {
                                        userId = auth.getCurrentUser().getUid();
                                        DocumentReference documentReference = fStore.collection("user").document(userId);

                                        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                            @Override
                                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                               String userLevel = documentSnapshot.getString("userlevel");

                                                if (userLevel.equals("User")) {
                                                    Intent intentResident = new Intent(LoginActivity.this, MainActivity.class);
                                                    intentResident.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                    startActivity(intentResident);
                                                    finish();
                                                } else if (userLevel.equals("Admin")) {
                                                    Intent intentMain = new Intent(LoginActivity.this, AdminActivity.class);
                                                    intentMain.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                    startActivity(intentMain);
                                                    finish();
                                                }

                                            }

                                        });

                                    }
                                }

                            });
                }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}


