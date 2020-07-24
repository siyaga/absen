package com.ananda.absen.admin;

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

public class KehadiranAdminAdapterFire extends FirestoreRecyclerAdapter<KehadiranAdmin, KehadiranAdminAdapterFire.KehadiranHolder> {

    public KehadiranAdminAdapterFire(@NotNull FirestoreRecyclerOptions<KehadiranAdmin> options) {
        super(options);

    }

    @Override
    protected void onBindViewHolder(@NotNull KehadiranHolder holder, int i, KehadiranAdmin kehadiran) {

        holder.JamMasuk.setText(kehadiran.getJamMasuk());
        holder.JamPulang.setText(kehadiran.getJamPulang());
        holder.Keterangan.setText(kehadiran.getKeterangan());
        holder.Tanggal.setText(kehadiran.getTanggal());
        holder.TotalJam.setText(kehadiran.getTotalJam());
        holder.email.setText(kehadiran.getEmail());

    }

    @NonNull
    @Override
    public KehadiranHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tabel_admin,parent,false);
        return new KehadiranHolder(v);
    }

     class KehadiranHolder extends RecyclerView.ViewHolder {
        TextView email, Tanggal, JamMasuk, JamPulang;
        TextView TotalJam;
        TextView Keterangan;

        public KehadiranHolder(@NonNull View itemView) {
            super(itemView);
            email = itemView.findViewById(R.id.tv_email);
            Tanggal = itemView.findViewById(R.id.tv_tanggal_absen);
            JamMasuk = itemView.findViewById(R.id.tv_jam_pulang);
            JamPulang = itemView.findViewById(R.id.tv_jam_pulang);
            TotalJam = itemView.findViewById(R.id.tv_total_jam_absen);
            Keterangan = itemView.findViewById(R.id.tv_keterangan);
        }
    }
}
