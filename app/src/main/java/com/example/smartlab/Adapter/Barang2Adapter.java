package com.example.smartlab.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartlab.DataBarang2;
import com.example.smartlab.R;

import java.util.List;

public class Barang2Adapter extends RecyclerView.Adapter<Barang2Adapter.Barang2ViewHolder> {

    private Context context;
    private List<DataBarang2> dataBarang2List;

    public void setSearchList2(List<DataBarang2> dataBarang2List){
        this.dataBarang2List = dataBarang2List;
        notifyDataSetChanged();
    }

    public Barang2Adapter(Context context, List<DataBarang2> dataBarang2List){
        this.context = context;
        this.dataBarang2List = dataBarang2List;
    }

    @NonNull
    @Override
    public Barang2ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_barang2, parent, false);
        return new Barang2ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Barang2ViewHolder holder, int position) {

        holder.img_barang2.setImageResource(dataBarang2List.get(position).getDataimg());
        holder.txt_barang2.setText(dataBarang2List.get(position).getNamaBarang());
        holder.txt_detail2.setText(dataBarang2List.get(position).getDetailBarang());
        holder.txt_kategori2.setText(dataBarang2List.get(position).getKategori());
        holder.txt_idBarang3.setText(dataBarang2List.get(position).getIdBarang());
        holder.txt_deskripsiBarang3.setText(dataBarang2List.get(position).getDeskripsiBarang());
        holder.txt_totalBarang2.setText(dataBarang2List.get(position).getTotalBarang());
    }

    @Override
    public int getItemCount() {
        return dataBarang2List.size();
    }

    public class Barang2ViewHolder extends RecyclerView.ViewHolder{

        ImageView img_barang2;
        TextView txt_barang2, txt_detail2, txt_kategori2, txt_idBarang3, txt_deskripsiBarang3, txt_totalBarang2;

        public Barang2ViewHolder(@NonNull View itemView) {
            super(itemView);

            img_barang2 = itemView.findViewById(R.id.img_barang2);
            txt_barang2 = itemView.findViewById(R.id.txt_barang2);
            txt_detail2 = itemView.findViewById(R.id.txt_detail2);
            txt_kategori2 = itemView.findViewById(R.id.txt_kategori2);
            txt_idBarang3 = itemView.findViewById(R.id.txt_idBarang3);
            txt_deskripsiBarang3 = itemView.findViewById(R.id.txt_deskripsiBarang3);
            txt_totalBarang2 = itemView.findViewById(R.id.txt_totalBarang2);
        }
    }
}
