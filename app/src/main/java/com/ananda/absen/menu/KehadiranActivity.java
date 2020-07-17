package com.ananda.absen.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ananda.absen.R;

public class KehadiranActivity extends AppCompatActivity {
    private ImageView ivBack;
    private RecyclerView rvKehadiran;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kehadiran);
        ivBack = findViewById(R.id.iv_back);
        rvKehadiran = findViewById(R.id.)
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}