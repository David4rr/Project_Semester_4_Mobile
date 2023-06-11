package com.example.smartlab.Adapter;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartlab.Activity.DaftarBarang2Activity;
import com.example.smartlab.DataBarang;
import com.example.smartlab.DataBarang2;
import com.example.smartlab.DaftarPinjam;
import com.example.smartlab.Adapter.PinjamAdapter;
import com.example.smartlab.Interface.UpdatePinjaman;
import com.example.smartlab.PeminjamanMain;
import com.example.smartlab.R;

import java.util.ArrayList;
import java.util.List;

public class Barang2Adapter extends RecyclerView.Adapter<Barang2Adapter.Barang2ViewHolder> {

    public ArrayList<DataBarang2> dataBarang2List;
    Application activity;
    Context context;
    String txt_Barang, txt_Jumlah;
    UpdatePinjaman updatePinjaman;

    public Barang2Adapter(Context context, ArrayList<DataBarang2> dataBarang2List,  UpdatePinjaman updatePinjaman) {
        this.context = context;
        this.dataBarang2List = dataBarang2List;
        this.updatePinjaman = updatePinjaman;
    }

    // untuk melakukan pencarian dan memperbarui daftar item yang ditampilkan.
    public void setSearchList2(ArrayList<DataBarang2> dataBarang2List){
        this.dataBarang2List = dataBarang2List;
        notifyDataSetChanged();
    }

    // untuk membuat tampilan (view holder) baru untuk setiap item dalam daftar.
    @NonNull
    @Override
    public Barang2ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_barang2, parent, false);
        Barang2ViewHolder barang2ViewHolder = new Barang2ViewHolder(view);
        return barang2ViewHolder;
    }

    //  untuk menghubungkan data dengan tampilan (view) item dalam daftar.
    @Override
    public void onBindViewHolder(@NonNull Barang2Adapter.Barang2ViewHolder holder, int position) {

        DataBarang2 currentItem = dataBarang2List.get(position);
//        holder.img_barang2.setImageResource(currentItem.getDataimg());
        holder.txt_barang2.setText(currentItem.getTitle());
        holder.txt_detail2.setText(currentItem.getContent());
        holder.txt_kategori2.setText(currentItem.getSlug());
        holder.txt_idBarang3.setText(currentItem.getId());
//        holder.txt_deskripsiBarang3.setText(currentItem.getDeskripsiBarang());
        holder.txt_totalBarang2.setText(currentItem.getStok());

        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_Barang = currentItem.getTitle();
                txt_Jumlah = currentItem.getStok();
//                img_barang = currentItem.getId();

                boolean isAlreadyAdded = isItemAlreadyAdded(txt_Barang);

                if (!isAlreadyAdded) {
                    ((UpdatePinjaman) PeminjamanMain.getMyContext()).addItems(txt_Barang, txt_Jumlah);

                    holder.plus.setVisibility(View.INVISIBLE);
                    holder.done.setVisibility(View.VISIBLE);
                }

            }
        });
        boolean isAlreadyAdded = isItemAlreadyAdded(currentItem.getTitle());
        if (isAlreadyAdded) {
            holder.plus.setVisibility(View.INVISIBLE);
            holder.done.setVisibility(View.VISIBLE);
        } else {
            holder.plus.setVisibility(View.VISIBLE);
            holder.done.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return dataBarang2List.size();
    }

    public class Barang2ViewHolder extends RecyclerView.ViewHolder{
        public ImageView plus, done;
        public TextView txt_barang2, txt_detail2, txt_kategori2, txt_idBarang3,  txt_totalBarang2;

        public Barang2ViewHolder(@NonNull View itemView) {
            super(itemView);

//            img_barang2 = itemView.findViewById(R.id.img_barang2);
            txt_barang2 = itemView.findViewById(R.id.txt_barang2);
            txt_detail2 = itemView.findViewById(R.id.txt_detail2);
            txt_kategori2 = itemView.findViewById(R.id.txt_kategori2);
            txt_idBarang3 = itemView.findViewById(R.id.txt_idBarang3);
//            txt_deskripsiBarang3 = itemView.findViewById(R.id.txt_deskripsiBarang3);
            txt_totalBarang2 = itemView.findViewById(R.id.txt_totalBarang2);
            plus = itemView.findViewById(R.id.img_plus);
            done = itemView.findViewById(R.id.img_done);
        }
    }
    private boolean isItemAlreadyAdded(String txt_Barang) {
        for (DaftarPinjam item : ((UpdatePinjaman) PeminjamanMain.getMyContext()).getItems()) {
            if (item.getTxt_Barang().equals(txt_Barang)) {
                return true; // Barang sudah ada dalam daftar pinjaman
            }
        }
        return false; // Barang belum ada dalam daftar pinjaman
    }
}
