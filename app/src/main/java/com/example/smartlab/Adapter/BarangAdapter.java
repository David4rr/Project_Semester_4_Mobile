package com.example.smartlab.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartlab.Activity.DetailBarangActivity;
import com.example.smartlab.DataBarang;
import com.example.smartlab.R;

import java.util.List;

public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.BarangViewHolder> {

    private Context context;
    private List<DataBarang> dataBarangList;

    public void setSearchList(List<DataBarang> dataSearchList){
        this.dataBarangList = dataSearchList;
        notifyDataSetChanged();
    }

    public BarangAdapter(Context context, List<DataBarang> dataBarangList){
        this.context = context;
        this.dataBarangList = dataBarangList;
    }

    @NonNull
    @Override
    public BarangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_barang, parent, false);
        return new BarangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BarangViewHolder holder, int position) {

        holder.txt_idBarang2.setText(dataBarangList.get(position).getId());
        holder.txt_barang.setText(dataBarangList.get(position).getTitle());
        holder.txt_detail.setText(dataBarangList.get(position).getContent());
        holder.txt_kategori.setText(dataBarangList.get(position).getSlug());
        holder.txt_deskripsiBarang2.setText(dataBarangList.get(position).getContent());
        holder.txt_totalBarang.setText(dataBarangList.get(position).getStok());

        holder.card_barang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(context, DetailBarangActivity.class);
                intent.putExtra("IdBarang", dataBarangList.get(holder.getAdapterPosition()).getId());
                intent.putExtra("Kategori", dataBarangList.get(holder.getAdapterPosition()).getSlug());
                intent.putExtra("NamaBarang", dataBarangList.get(holder.getAdapterPosition()).getTitle());
                intent.putExtra("DetailBarang", dataBarangList.get(holder.getAdapterPosition()).getSlug());
                intent.putExtra("DeskripsiBarang", dataBarangList.get(holder.getAdapterPosition()).getContent());
                intent.putExtra("Stock", dataBarangList.get(holder.getAdapterPosition()).getStok());
//                intent.putExtra("ImageBarang", dataBarangList.get(holder.getAdapterPosition()).getDataImg());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataBarangList.size();
    }
    public class BarangViewHolder extends RecyclerView.ViewHolder{

//        ImageView img_barang;
        TextView txt_barang, txt_detail, txt_kategori, txt_totalBarang, txt_idBarang2, txt_deskripsiBarang2;
        CardView card_barang;

        public BarangViewHolder(View itemView) {
            super(itemView);

//            img_barang = itemView.findViewById(R.id.img_barang);
            txt_barang = itemView.findViewById(R.id.txt_barang);
            txt_detail = itemView.findViewById(R.id.txt_detail);
            txt_kategori = itemView.findViewById(R.id.txt_kategori);
            txt_totalBarang = itemView.findViewById(R.id.txt_TotalBarang);
            txt_idBarang2 = itemView.findViewById(R.id.txt_idBarang2);
            txt_deskripsiBarang2 = itemView.findViewById(R.id.txt_deskripsiBarang2);
            card_barang = itemView.findViewById(R.id.card_barang);

        }
    }
}


