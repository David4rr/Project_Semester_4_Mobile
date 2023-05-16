package com.example.smartlab.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.smartlab.History;
import com.example.smartlab.R;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    private ArrayList<History> dataList;

    public HistoryAdapter(ArrayList<History> dataList){this.dataList = dataList;}

    @Override
    public HistoryViewHolder onCreateViewHolder(ViewGroup container, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(container.getContext());
        View view = layoutInflater.inflate(R.layout.list_history, container, false);
        return new HistoryViewHolder(view);

    }

    @Override
    public void onBindViewHolder(HistoryViewHolder holder, int position) {
        holder.txt_peminjaman.setText(dataList.get(position).getPeminjaman());
        holder.txt_tanggal.setText(dataList.get(position).getTanggal());
        holder.txt_total.setText(dataList.get(position).getTotal());
        holder.txt_hari.setText(dataList.get(position).getHari());

    }

    @Override
    public int getItemCount() {return (dataList != null) ? dataList.size() : 0;}

    public class HistoryViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_peminjaman;
        private TextView txt_tanggal;
        private TextView txt_total;
        private TextView txt_hari;

        public HistoryViewHolder(View itemView) {
            super(itemView);
            txt_peminjaman = (TextView) itemView.findViewById(R.id.txt_peminjaman);
            txt_tanggal = (TextView) itemView.findViewById(R.id.txt_tanggal);
            txt_total = (TextView) itemView.findViewById(R.id.txt_total);
            txt_hari = (TextView) itemView.findViewById(R.id.txt_hari);
        }
    }
}