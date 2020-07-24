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
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.ananda.absen.MainActivity;
import com.ananda.absen.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

/*
Deskripsi Pengerjaan    : Membuat Membuat Activity Registrasi
NIM                     : Ananda Marwanaya Putra
Nama                    : 10117157
Kelas                   : IF-4

 */
public class RegisterActivity extends AppCompatActivity {
    private Button btnRegister;
    private EditText edtEmail,edtPassword, edtNama;
    private FirebaseAuth auth;
    private ImageView ivBack;
    private Spinner spinnerUserlevel;
    private ProgressBar progressBar;
    FirebaseFirestore fStore;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        auth = FirebaseAuth.getInstance();
        edtEmail = findViewById(R.id.edt_email_register);
        edtNama = findViewById(R.id.edt_nama_register);
        edtPassword = findViewById(R.id.edt_password_register);
        spinnerUserlevel = findViewById(R.id.spinner_daftar);
        btnRegister = findViewById(R.id.btn_daftar);
        ivBack = findViewById(R.id.iv_back);
        progressBar = findViewById(R.id.progressBar);
        fStore = FirebaseFirestore.getInstance();



        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String nama = edtNama.getText().toString().trim();
                final String email = edtEmail.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                final String userlevel = spinnerUserlevel.getSelectedItem().toString().trim();


                if (TextUtils.isEmpty(nama)) {
                    Toast.makeText(getApplicationContext(), "Harap isi nama anda!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Harap isi email anda!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(userlevel)) {
                    Toast.makeText(getApplicationContext(), "Harap isi user anda!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Harap isi password anda!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Masukan password minimal 6 karakter!", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(RegisterActivity.this,"Berhasil membuat akun", Toast.LENGTH_SHORT).show();
                                userId = auth.getCurrentUser().getUid();
                                DocumentReference documentReference = fStore.collection("user").document(userId);
                                Map<String, Object> user = new HashMap<>();
                                user.put("nama",nama);
                                user.put("email",email);
                                user.put("userlevel",userlevel);
                                documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Log.d("TAG", "onSuccess: "+userId);
                                    }
                                });
                                if(!task.isSuccessful()){
                                    Toast.makeText(RegisterActivity.this, "Authentication failed." + task.getException(), Toast.LENGTH_SHORT).show();

                                } else {


                                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });


            }

        });

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);

    }
}
