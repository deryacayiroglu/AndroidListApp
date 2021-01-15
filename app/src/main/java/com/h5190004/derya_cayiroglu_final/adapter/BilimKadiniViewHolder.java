package com.h5190004.derya_cayiroglu_final.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190004.derya_cayiroglu_final.R;


public class BilimKadiniViewHolder extends RecyclerView.ViewHolder {

    ImageView imgBilimKadiniLogo;
    TextView txtAdi;
    TextView txtAlani;
    TextView txtDogumTarihi;
    TextView txtOlumTarihi;

    public BilimKadiniViewHolder(@NonNull View itemView, BilimKadiniAdaptor.OnItemClickListener listener) {
        super(itemView);
        imgBilimKadiniLogo = itemView.findViewById(R.id.imgBilimKadiniLogo);
        txtAdi = itemView.findViewById(R.id.txtAdi);
        txtAlani = itemView.findViewById(R.id.txtAlani);
        txtDogumTarihi = itemView.findViewById(R.id.txtDogumTarihi);
        txtOlumTarihi = itemView.findViewById(R.id.txtOlumTarihi);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClik(getAdapterPosition());
            }
        });
    }
}
