package com.example.techguide;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.techguide.interfaces.ItemClickListener;

import java.util.List;

public class cardAdapter extends RecyclerView.Adapter<cardAdapter.MyViewHolder>{
    private Context mContext;
    private List<card> cardList;

    public ItemClickListener itemClickListener;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView title, count;
        public ImageView thumbnail, overflow;
        public ItemClickListener itemClickListener;


        public MyViewHolder(View view) {
            super(view);
            title =  view.findViewById(R.id.title);
            count =  view.findViewById(R.id.count);
            thumbnail =  view.findViewById(R.id.thumbnail);
            overflow =  view.findViewById(R.id.overflow);

        }

        public void setItemClickListener(ItemClickListener itemClickListener){
            this.itemClickListener = itemClickListener;
        }



        @Override
        public void onClick(View view){
            itemClickListener.onClick(view, getAdapterPosition(), false);
        }
    }


    public cardAdapter(Context mContext, List<card> cardList, ItemClickListener itemClickListener) {
        this.mContext = mContext;
        this.cardList = cardList;
        this.itemClickListener = itemClickListener;
    }

    public cardAdapter(Context mContext,ItemClickListener listener) {
        this.mContext = mContext;
        this.itemClickListener = listener;
            }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
     //inflating the card
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final card cardAdapter = cardList.get(position);
        holder.title.setText(cardAdapter.getName());
        holder.count.setText(cardAdapter.getNumOfOptions() + " option(s)");

        // loading album cover using Glide library
        Glide.with(mContext).load(cardAdapter.getThumbnail()).into(holder.thumbnail);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(mContext,modified_nav.class);
                mContext.startActivity(intent);
                Toast.makeText(mContext, "Asjbhsjos", Toast.LENGTH_SHORT).show();

            }
        });

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_card, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {

        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_select:
                    mContext.startActivity(new Intent(mContext, modified_nav.class));

                    return true;
                case R.id.action_add_to_favourites:
                    Toast.makeText(mContext, "Added to favourites", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }


}


