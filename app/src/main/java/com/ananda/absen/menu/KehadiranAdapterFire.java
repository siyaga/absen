package com.ananda.absen.menu;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ananda.absen.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.database.annotations.NotNull;

public class KehadiranAdapterFire extends FirestoreRecyclerAdapter<Kehadiran, KehadiranAdapterFire.KehadiranHolder> {

    public KehadiranAdapterFire(@NotNull FirestoreRecyclerOptions<Kehadiran> options) {
        super(options);

    }

    @Override
    protected void onBindViewHolder(@NotNull KehadiranHolder holder, int i, Kehadiran kehadiran) {

        holder.email.setText(String.valueOf(kehadiran.getEmail()));
        holder.tanggalKehadiran.setText(kehadiran.getTanggalKehadiran());
        holder.jamMasuk.setText(kehadiran.getJamMasuk());
        holder.jamPulang.setText(kehadiran.getJamPulang());
        holder.jamTotal.setText(kehadiran.getJamTotal());
        holder.keteranganKehadiran.setText(kehadiran.getKeteranganKehadiran());

    }

    @NonNull
    @Override
    public KehadiranHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tabel,parent,false);
        return new KehadiranHolder(v);
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    public class KehadiranHolder extends RecyclerView.ViewHolder {
        TextView email, tanggalKehadiran, jamMasuk, jamPulang;
        TextView jamTotal;
        TextView keteranganKehadiran;

        public KehadiranHolder(@NonNull View itemView) {
            super(itemView);
            email = itemView.findViewById(R.id.tv_email);
            tanggalKehadiran = itemView.findViewById(R.id.tv_tanggal_absen);
            jamMasuk = itemView.findViewById(R.id.tv_jam_masuk);
            jamPulang = itemView.findViewById(R.id.tv_jam_pulang);
            jamTotal = itemView.findViewById(R.id.tv_total_jam_absen);
            keteranganKehadiran = itemView.findViewById(R.id.tv_keterangan);

        }
    }
}
