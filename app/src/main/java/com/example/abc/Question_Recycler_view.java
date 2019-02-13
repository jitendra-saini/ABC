package com.example.abc;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Question_Recycler_view extends RecyclerView.Adapter<Question_Recycler_view.MyViewHolder> {
    ArrayList<Question_cat> cat = new ArrayList<>();

    public ArrayList<Question_cat> selecteds=new ArrayList<>();
    Question context;
    private final String TAG="Question_Recycler_view";

    public Question_Recycler_view(ArrayList<Question_cat> cat, Question context) {
        this.cat = cat;
        this.context = context;
    }

    @NonNull
    @Override
    public Question_Recycler_view.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.question_resource, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Question_Recycler_view.MyViewHolder myViewHolder, int i) {
        final Question_cat model = cat.get(i);

        myViewHolder.textView.setText(cat.get(i).getCat());


        myViewHolder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // v.setSelected(!v.isSelected());
                model.setSelected(!model.isSelected);


                        myViewHolder.textView.setTextColor(model.isSelected() ?
                                Color.parseColor("#35CEC9" ): Color.parseColor("#000000"));

                        if(model.isSelected){

                            selecteds.add(model);
                            Log.e("j", String.valueOf(selecteds));

                        }
                        else{
                            selecteds.remove(model);
                            Log.e("j", String.valueOf(selecteds));
                        }





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

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView13);
            imageView = itemView.findViewById(R.id.circleImageView2);
            constraintLayout = itemView.findViewById(R.id.layout3);

        }


    }


    public ArrayList<Question_cat> getSelecteds(){


        return selecteds;
    }



}






