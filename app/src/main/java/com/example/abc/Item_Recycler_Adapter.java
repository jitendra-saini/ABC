package com.example.abc;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class Item_Recycler_Adapter extends RecyclerView.Adapter<Item_Recycler_Adapter.MyViewHolder> {
    Context context;
    ArrayList<MyItemDataSet> itemList=new ArrayList<>();

    public Item_Recycler_Adapter(Context context, ArrayList<MyItemDataSet> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public Item_Recycler_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_recycler_view,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Item_Recycler_Adapter.MyViewHolder myViewHolder, int i) {


        myViewHolder.textView.setText(itemList.get(i).getArtist_name());
        myViewHolder.constraintLayout.setBackgroundResource(itemList.get(i).getArtist_image());


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        ConstraintLayout constraintLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.artist_name);
            constraintLayout=itemView.findViewById(R.id.layout2);
        }
    }
}
