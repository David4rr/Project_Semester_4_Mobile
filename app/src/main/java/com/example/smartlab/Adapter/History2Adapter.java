package com.example.smartlab.Adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartlab.Activity.DetailPeminjamanActivity;
import com.example.smartlab.History2;
import com.example.smartlab.R;

import java.util.List;

public class History2Adapter extends RecyclerView.Adapter<History2Adapter.History2ViewHolder> {

    private Context context;
    private List<History2> dataHistory2List;

    public History2Adapter(Context context, List<History2> dataHistory2List){
        this.context = context;
        this.dataHistory2List = dataHistory2List;
    }

    @NonNull
    @Override
    public History2ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_history2, parent, false);
        return new History2ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull History2ViewHolder holder, int position) {

        holder.txt_peminjaman.setText(dataHistory2List.get(position).getPeminjaman());
        holder.txt_tanggal.setText(dataHistory2List.get(position).getTanggal());
        holder.txt_total.setText(dataHistory2List.get(position).getTotal());
        holder.txt_hari.setText(dataHistory2List.get(position).getHari());
        holder.img.setImageResource(dataHistory2List.get(position).getImg());

        holder.cardviewHistory2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailPeminjamanActivity.class);
                intent.putExtra("Peminjaman", dataHistory2List.get(holder.getAdapterPosition()).getPeminjaman());
                intent.putExtra("Tanggal", dataHistory2List.get(holder.getAdapterPosition()).getTanggal());
                intent.putExtra("Total", dataHistory2List.get(holder.getAdapterPosition()).getTotal());
                intent.putExtra("Hari", dataHistory2List.get(holder.getAdapterPosition()).getHari());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataHistory2List.size();
    }

    public class History2ViewHolder extends RecyclerView.ViewHolder{

        TextView txt_peminjaman, txt_tanggal, txt_total, txt_hari;
        ImageView img;
        CardView cardviewHistory2;

        public History2ViewHolder(View itemView){
            super(itemView);

            txt_peminjaman = itemView.findViewById(R.id.txt_peminjaman);
            txt_tanggal = itemView.findViewById(R.id.txt_tanggal);
            txt_total = itemView.findViewById(R.id.txt_total);
            txt_hari = itemView.findViewById(R.id.txt_hari);
            img = itemView.findViewById(R.id.img);
            cardviewHistory2 = itemView.findViewById(R.id.cardviewHistory2);
        }

    }
}
