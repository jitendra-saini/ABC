package com.example.abc;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Recyclerview_Adapter extends RecyclerView.Adapter<Recyclerview_Adapter.MyViewHolder> {
    Context context;
    ArrayList<MyDataSet> arrayList=new ArrayList<>();
    ArrayList<MyItemDataSet> itemList =new ArrayList<MyItemDataSet>();

    public Recyclerview_Adapter(Context context, ArrayList<MyDataSet> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Recyclerview_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view= LayoutInflater.from(context).inflate(R.layout.recyclerview_resource,viewGroup,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Recyclerview_Adapter.MyViewHolder myViewHolder, int i) {

        myViewHolder.imageView.setImageResource(arrayList.get(i).getProfile_image());
        myViewHolder.textView.setText(arrayList.get(i).getF_name());
        myViewHolder.textView1.setText(arrayList.get(i).getPost_details());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView,textView1;
        RecyclerView recyclerView2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView3);
            textView=itemView.findViewById(R.id.textview33);
            textView1=itemView.findViewById(R.id.textView4);
            recyclerView2=itemView.findViewById(R.id.recyclerView2);

            addItemData();
            RecyclerView.Adapter adapter1=new Item_Recycler_Adapter(context,itemList);
            recyclerView2.setAdapter(adapter1);
            recyclerView2.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

        }

    }


    public void addItemData(){

        itemList.add(new MyItemDataSet(R.drawable.arijit_singh,"Arijit Singh"));
        itemList.add(new MyItemDataSet(R.drawable.nusrat_fateh_ali_khan,"nusrat fateh ali khan"));
        itemList.add(new MyItemDataSet(R.drawable.taylor_swift,"taylor swift"));
        itemList.add(new MyItemDataSet(R.drawable.mohammed_rafi,"mohammed rafi"));
        itemList.add(new MyItemDataSet(R.drawable.altafraja,"altaf raja"));
        itemList.add(new MyItemDataSet(R.drawable.arijit_singh,"Arijit Singh"));



    }
}
