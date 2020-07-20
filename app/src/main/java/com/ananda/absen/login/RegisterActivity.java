package com.ananda.absen.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ananda.absen.MainActivity;
import com.ananda.absen.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
/*
Deskripsi Pengerjaan    : Membuat Membuat Activity Registrasi
NIM                     : Ananda Marwanaya Putra
Nama                    : 10117157
Kelas                   : IF-4

 */
public class RegisterActivity extends AppCompatActivity {
    private Button btnRegister;
    private EditText edtEmail,edtPassword;
    private FirebaseAuth auth;
    private ImageView ivBack;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        auth = FirebaseAuth.getInstance();
        edtEmail = findViewById(R.id.edt_email_register);
        edtPassword = findViewById(R.id.edt_password_register);
        btnRegister = findViewById(R.id.btn_daftar);
        ivBack = findViewById(R.id.iv_back);
        progressBar = findViewById(R.id.progressBar);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();


                if(TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(),"Harap Isi email anda!",Toast.LENGTH_SHORT).show();
                            return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(),"Harap Isi password anda!",Toast.LENGTH_SHORT).show();
                            return;
                }
                if(password.length()<6){
                    Toast.makeText(getApplicationContext(),"masukan password minimal 6 karakter!",Toast.LENGTH_SHORT).show();
                            return;
                }
                progressBar.setVisibility(View.VISIBLE);
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(RegisterActivity.this,"Berhasil membuat akun"+ task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                if(!task.isSuccessful()){
                                    Toast.makeText(RegisterActivity.this, "Authentication failed." + task.getException(), Toast.LENGTH_SHORT).show();

                                } else {
                                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
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
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);

    }
}
