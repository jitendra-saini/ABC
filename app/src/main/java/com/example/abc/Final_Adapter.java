package com.example.abc;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Final_Adapter extends RecyclerView.Adapter<Final_Adapter.MyViewHolder> {
   Context context;
   ArrayList<Question_cat> question_catArrayList=new ArrayList<>();

    public Final_Adapter(Context context, ArrayList<Question_cat> question_catArrayList) {
        this.context = context;
        this.question_catArrayList = question_catArrayList;
    }

    @NonNull
    @Override
    public Final_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.final_recycler_view_resource,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Final_Adapter.MyViewHolder myViewHolder, int i) {

       myViewHolder.textView.setText(question_catArrayList.get(i).getCat());

    }

    @Override
    public int getItemCount() {
        return question_catArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.cat_textView);
        }
    }
}
