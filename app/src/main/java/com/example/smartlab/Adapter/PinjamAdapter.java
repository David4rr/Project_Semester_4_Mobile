package com.example.smartlab.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartlab.DaftarPinjam;
import com.example.smartlab.Interface.UpdatePinjaman;
import com.example.smartlab.PeminjamanMain;
import com.example.smartlab.R;

import java.util.ArrayList;

public class PinjamAdapter extends RecyclerView.Adapter<PinjamAdapter.PinjamViewHolder> {

    private ArrayList<DaftarPinjam> daftarPinjams;
    Activity activity;

    public PinjamAdapter(Activity activity){
        this.activity = activity;
        daftarPinjams = ((UpdatePinjaman) PeminjamanMain.getMyContext()).getItems();
    }

    @NonNull
    @Override
    public PinjamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pinjam, parent, false);
        PinjamViewHolder pinjamViewHolder = new PinjamViewHolder(view);
        return pinjamViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PinjamViewHolder holder, int position) {
        DaftarPinjam currentItem = daftarPinjams.get(position);
        holder.txt_Barang.setText(currentItem.getTxt_Barang());
        holder.txt_Jumlah.setText(currentItem.getTxt_Jumlah());
    }

    @Override
    public int getItemCount() {
        return daftarPinjams.size();
    }

    public class PinjamViewHolder extends RecyclerView.ViewHolder {

        TextView txt_Barang, txt_Jumlah;
//        ImageView img_barang;

        public PinjamViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_Barang = itemView.findViewById(R.id.txt_Barang);
            txt_Jumlah = itemView.findViewById(R.id.txt_jumlah);
//            img_barang = itemView.findViewById(R.id.img_barang);
        }
    }
}
