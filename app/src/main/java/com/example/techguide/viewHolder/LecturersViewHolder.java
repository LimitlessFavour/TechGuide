package com.example.techguide.viewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.techguide.R;
import com.example.techguide.interfaces.ItemClickListener;

public class LecturersViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ImageView lecturerImage;
    public TextView lecturerName, lecturerPhone;

    private ItemClickListener itemClickListener;


    public LecturersViewHolder(@NonNull View itemView) {
        super(itemView);

        lecturerImage = itemView.findViewById(R.id.thumbnail);
        lecturerName = itemView.findViewById(R.id.name);
        lecturerPhone = itemView.findViewById(R.id.phone_number);

    }

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }
    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),false);
    }
}
