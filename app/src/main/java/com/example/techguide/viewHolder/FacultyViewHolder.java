package com.example.techguide.viewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.techguide.R;
import com.example.techguide.interfaces.ItemClickListener;




public class FacultyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ImageView eachImage;

    public TextView eachName, eachDept, eachNumber, eachPost;

    private ItemClickListener itemClickListener;


    public FacultyViewHolder(@NonNull View itemView) {
        super(itemView);

        eachImage = itemView.findViewById(R.id.each_image);

        eachDept = itemView.findViewById(R.id.each_dept);
        eachName = itemView.findViewById(R.id.each_name);
        eachNumber = itemView.findViewById(R.id.each_number);
        eachPost = itemView.findViewById(R.id.each_post);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);

    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
