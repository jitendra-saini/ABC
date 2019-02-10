package com.example.abc;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class Question extends AppCompatActivity {

    ArrayList<Question_cat> cat=new ArrayList<Question_cat>();
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("ABC");
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        RecyclerView recyclerView=findViewById(R.id.recyclerView3);
        recyclerView.setLayoutManager(new GridLayoutManager(this,4));
         adapter=new Question_Recycler_view(cat,this);
         recyclerView.setAdapter(adapter);

         cat.add(new Question_cat("science",R.drawable.ic_menu_camera));
         cat.add(new Question_cat("fashion",R.drawable.ic_menu_camera));
         cat.add(new Question_cat("Education",R.drawable.ic_menu_camera));
         cat.add(new Question_cat("Travel",R.drawable.ic_menu_camera));
         cat.add(new Question_cat("History",R.drawable.ic_menu_camera));
         cat.add(new Question_cat("Business",R.drawable.ic_menu_camera));
         cat.add(new Question_cat("politics",R.drawable.ic_menu_camera));
         cat.add(new Question_cat("economic",R.drawable.ic_menu_camera));
         cat.add(new Question_cat("technology",R.drawable.ic_menu_camera));
         cat.add(new Question_cat("language",R.drawable.ic_menu_camera));
         cat.add(new Question_cat("my city",R.drawable.ic_menu_camera));
         cat.add(new Question_cat("my country",R.drawable.ic_menu_camera));
         cat.add(new Question_cat("Health",R.drawable.ic_menu_camera));
         cat.add(new Question_cat("science",R.drawable.ic_menu_camera));
         cat.add(new Question_cat("science",R.drawable.ic_menu_camera));
         cat.add(new Question_cat("science",R.drawable.ic_menu_camera));




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.search_badge) {
            Intent intent =new Intent(this,Next_step.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
