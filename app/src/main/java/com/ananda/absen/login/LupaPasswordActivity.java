package com.ananda.absen.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ananda.absen.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
/*
Deskripsi Pengerjaan    : Membuat Membuat Activity Lupa Password
NIM                     : Ananda Marwanaya Putra
Nama                    : 10117157
Kelas                   : IF-4

 */
public class LupaPasswordActivity extends AppCompatActivity {
    private EditText edtEmail;
    private Button btnKirim;
    private FirebaseAuth auth;
    private ProgressBar progressBar;
    private ImageView ivBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_password);

        edtEmail = findViewById(R.id.edt_lupa_password_email);
        btnKirim = findViewById(R.id.btn_Lupa_password);
        ivBack = findViewById(R.id.iv_back);
        auth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(getApplication(),"Masukan email yang terdaftar",Toast.LENGTH_LONG).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                auth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(LupaPasswordActivity.this,"Silakan cek email anda untuk mereset password anda",Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(LupaPasswordActivity.this, "Gagal mengirim email!",Toast.LENGTH_SHORT).show();
                                }
                                progressBar.setVisibility(View.GONE);
                            }
                        });
            }
        });
    }
}
