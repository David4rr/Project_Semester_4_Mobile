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

import com.example.smartlab.Activity.DetailStatusBarangActivity;
import com.example.smartlab.DataBarang3;
import com.example.smartlab.R;

import java.util.List;

public class Barang3Adapter extends RecyclerView.Adapter<Barang3Adapter.Barang3ViewHolder> {

    private Context context;
    private List<DataBarang3> dataBarang3List;

    public Barang3Adapter(Context context, List<DataBarang3> dataBarang3List){
        this.context = context;
        this.dataBarang3List = dataBarang3List;
    }

    @NonNull
    @Override
    public Barang3Adapter.Barang3ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_barang3, parent, false);
        return new Barang3ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Barang3Adapter.Barang3ViewHolder holder, int position) {

        holder.txt_peminjaman.setText(dataBarang3List.get(position).getPeminjaman());
        holder.txt_tanggal.setText(dataBarang3List.get(position).getTanggal());
        holder.txt_total.setText(dataBarang3List.get(position).getTotal());
        holder.txt_status.setText(dataBarang3List.get(position).getStatus());
        holder.img.setImageResource(dataBarang3List.get(position).getImg());

        holder.cardviewBarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailStatusBarangActivity.class);
                intent.putExtra("Peminjaman", dataBarang3List.get(holder.getAdapterPosition()).getPeminjaman());
                intent.putExtra("Tanggal", dataBarang3List.get(holder.getAdapterPosition()).getTanggal());
                intent.putExtra("Total", dataBarang3List.get(holder.getAdapterPosition()).getTotal());
                intent.putExtra("Status", dataBarang3List.get(holder.getAdapterPosition()).getStatus());

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataBarang3List.size();
    }

    public class Barang3ViewHolder extends RecyclerView.ViewHolder{

        TextView txt_peminjaman, txt_tanggal, txt_total, txt_status;
        ImageView img;
        CardView cardviewBarang;

        public Barang3ViewHolder(View itemView){
            super(itemView);

            txt_peminjaman = itemView.findViewById(R.id.txt_peminjaman);
            txt_tanggal = itemView.findViewById(R.id.txt_tanggal);
            txt_total = itemView.findViewById(R.id.txt_total);
            txt_status = itemView.findViewById(R.id.txt_status);
            img = itemView.findViewById(R.id.img);
            cardviewBarang = itemView.findViewById(R.id.cardviewBarang);
        }
    }
}
