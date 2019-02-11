package com.example.abc;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Question extends AppCompatActivity {

    ArrayList<Question_cat> cat=new ArrayList<Question_cat>();
    ArrayList<Question_cat> questionCatList;
    RecyclerView.Adapter adapter;
    private final String TAG="Question";


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

        RecyclerView recyclerView = findViewById(R.id.recyclerView3);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        adapter = new Question_Recycler_view(cat, this);


        recyclerView.setAdapter(adapter);


      addData();
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
        if (id == R.id.next) {


            questionCatList=((Question_Recycler_view) adapter).getSelecteds();


            Log.e(TAG, "questionCatList: "+questionCatList );

            Intent intent=new Intent(this,Next_step.class);
            intent.putExtra("BUNDLE",(Serializable)questionCatList);
            startActivity(intent);



        }
        else if(id==android.R.id.home)
        {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void addData(){


        cat.add(new Question_cat("science"));
        cat.add(new Question_cat("fashion"));
        cat.add(new Question_cat("Education"));
        cat.add(new Question_cat("Travel"));
        cat.add(new Question_cat("History"));
        cat.add(new Question_cat("Business"));
        cat.add(new Question_cat("politics"));
        cat.add(new Question_cat("economic"));
        cat.add(new Question_cat("technology"));
        cat.add(new Question_cat("language"));
        cat.add(new Question_cat("my city"));
        cat.add(new Question_cat("my country"));
        cat.add(new Question_cat("Health"));
        cat.add(new Question_cat("science"));


    }



}
