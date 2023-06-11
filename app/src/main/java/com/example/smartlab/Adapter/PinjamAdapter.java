package com.example.smartlab.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartlab.DaftarPinjam;
import com.example.smartlab.DataBarang2;
import com.example.smartlab.Interface.UpdatePinjaman;
import com.example.smartlab.PeminjamanMain;
import com.example.smartlab.R;
import com.example.smartlab.SwipeDelete;

import java.util.ArrayList;

public class PinjamAdapter extends RecyclerView.Adapter<PinjamAdapter.PinjamViewHolder> {

    private ArrayList<DaftarPinjam> daftarPinjams;
    Activity activity;
    RecyclerView recyclerView;

    public PinjamAdapter(Activity activity){
        this.activity = activity;
        daftarPinjams = ((UpdatePinjaman) PeminjamanMain.getMyContext()).getItems();
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwipeDelete(this));
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    public void deleteItem(int position) {
        if (position >= 0 && position < daftarPinjams.size()) {
            daftarPinjams.remove(position);
            notifyItemRemoved(position);
        }
    }

    @NonNull
    @Override
    public PinjamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pinjam, parent, false);
        PinjamViewHolder pinjamViewHolder = new PinjamViewHolder(view);
        return pinjamViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PinjamViewHolder holder, @SuppressLint("RecyclerView") int position) {
        DaftarPinjam currentItem = daftarPinjams.get(position);
        holder.txt_Barang.setText(currentItem.getTxt_Barang());
        holder.txt_Jumlah.setText(currentItem.getTxt_Jumlah());

        holder.img_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreaseQuantity(position);
            }
        });

        holder.img_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseQuantity(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return daftarPinjams.size();
    }

    public class PinjamViewHolder extends RecyclerView.ViewHolder {

        TextView txt_Barang, txt_Jumlah;
        ImageView img_minus, img_plus;

        public PinjamViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_Barang = itemView.findViewById(R.id.txt_Barang);
            txt_Jumlah = itemView.findViewById(R.id.txt_jumlah);
            img_minus = itemView.findViewById(R.id.img_minus);
            img_plus = itemView.findViewById(R.id.img_plus);
//            img_barang = itemView.findViewById(R.id.img_barang);
        }
    }
    public void clearItems() {
        // Hapus semua item dalam RecyclerView
        daftarPinjams.clear();
        notifyDataSetChanged();
    }

    public void increaseQuantity(int position) {
        if (position >= 0 && position < daftarPinjams.size()) {
            DaftarPinjam item = daftarPinjams.get(position);
            int quantity = Integer.parseInt(item.getTxt_Jumlah());
            if (quantity < 2) { // Batasi hingga maksimal 2
                quantity++;
                item.setTxt_Jumlah(String.valueOf(quantity));
                notifyItemChanged(position);
            }
        }
    }
    public void decreaseQuantity(int position) {
        if (position >= 0 && position < daftarPinjams.size()) {
            DaftarPinjam item = daftarPinjams.get(position);
            int quantity = Integer.parseInt(item.getTxt_Jumlah());
            if (quantity > 1) {
                quantity--;
                item.setTxt_Jumlah(String.valueOf(quantity));
                notifyItemChanged(position);
            }
        }
    }
}
