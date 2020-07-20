package com.ananda.absen.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ananda.absen.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class KehadiranAdapter extends RecyclerView.Adapter<KehadiranAdapter.ListViewHolder> {

    private ArrayList<Kehadiran> listKehadiran;

    public KehadiranAdapter(ArrayList<Kehadiran>list){
        this.listKehadiran = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tabel,viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
            Kehadiran kehadiran = listKehadiran.get(position);

      /*      holder.tanggalKehadiran.setText(kehadiran.getTanggalKehadiran());
            holder.jamMasuk.setText(kehadiran.getJamMasuk());
            holder.jamPulang.setText(kehadiran.getJamPulang());
            holder.jamTotal.setText(kehadiran.getJamTotal());
         */   holder.keteranganKehadiran.setText(kehadiran.getKeteranganKehadiran());
    }

    @Override
    public int getItemCount() {
        return listKehadiran.size();
    }

     class ListViewHolder extends RecyclerView.ViewHolder{
        TextView tanggalKehadiran, jamMasuk, jamPulang;
        TextView jamTotal;
        TextView keteranganKehadiran;

        ListViewHolder(View itemView){
            super(itemView);
            tanggalKehadiran = itemView.findViewById(R.id.tv_tanggal_absen);
            jamMasuk = itemView.findViewById(R.id.tv_jam_masuk);
            jamPulang = itemView.findViewById(R.id.tv_jam_pulang);
            jamTotal = itemView.findViewById(R.id.tv_total_jam_absen);
            keteranganKehadiran = itemView.findViewById(R.id.tv_keterangan);

        }
    }
}
