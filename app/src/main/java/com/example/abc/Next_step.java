package com.example.abc;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.Serializable;

import java.util.ArrayList;

public class Next_step extends AppCompatActivity {
 ArrayList<Question_cat> C=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_step);
        String TAG="Next_step";

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("ABC");
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        //Intent intent = getIntent();

       ArrayList<Question_cat> myList = (ArrayList<Question_cat>) getIntent().getSerializableExtra("BUNDLE");

        RecyclerView recyclerView=findViewById(R.id.finalRecyclerview);
        RecyclerView.Adapter adapter1=new Final_Adapter(this, myList);
        recyclerView.setAdapter(adapter1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        Log.e(TAG, String.valueOf(myList));

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
            Toast.makeText(this,"Sent Successfully ",Toast.LENGTH_SHORT).show();
            Intent intent =new Intent(this,Home.class);
            startActivity(intent);
        }  else if(id==android.R.id.home)
        {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }

        return super.onOptionsItemSelected(item);




    }
}
