package com.example.abc;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Question_Recycler_view extends RecyclerView.Adapter<Question_Recycler_view.MyViewHolder> {
    ArrayList<Question_cat> cat=new ArrayList<>();
    Context context;

    public Question_Recycler_view(ArrayList<Question_cat> cat, Context context) {
        this.cat = cat;
        this.context = context;
    }

    @NonNull
    @Override
    public Question_Recycler_view.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.question_resource,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Question_Recycler_view.MyViewHolder myViewHolder, int i) {



        myViewHolder.textView.setText(cat.get(i).getCat());
        myViewHolder.imageView.setImageResource(cat.get(i).getCat_image());

        myViewHolder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return cat.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView textView;
        ImageView imageView;
        ConstraintLayout constraintLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView13);
            imageView=itemView.findViewById(R.id.circleImageView2);
            constraintLayout=itemView.findViewById(R.id.layout3);
        }
    }
}
