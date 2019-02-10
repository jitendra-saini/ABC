package com.example.abc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
 SharedPreferences sharedPreferences;
 TextView textView,textView1;
 RecyclerView recyclerView,recyclerView2;
    ArrayList<MyDataSet> arrayList =new ArrayList<MyDataSet>();

    /*ArrayList<MyItemDataSet> itemList =new ArrayList<MyItemDataSet>();*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("ABC");
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));



        addData();




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        recyclerView=findViewById(R.id.recyclerView);
        /*LayoutInflater li = LayoutInflater.from(this);
        ConstraintLayout mLayout = (ConstraintLayout) li.inflate(R.layout.recyclerview_resource,null);
        recyclerView2 = mLayout.findViewById(R.id.recyclerView2);
*/

       /* RecyclerView.Adapter adapter1=new Item_Recycler_Adapter(this,itemList);
        recyclerView2.setAdapter(adapter1);
*/





         RecyclerView.Adapter adapter= new Recyclerview_Adapter(this,arrayList);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        textView=navigationView.getHeaderView(0).findViewById(R.id.name);
        textView1=navigationView.getHeaderView(0).findViewById(R.id.username);
        sharedPreferences=getSharedPreferences("User",MODE_PRIVATE);
        textView.setText(sharedPreferences.getString("username",null));
        textView1.setText(sharedPreferences.getString("name",null));


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            // Handle the camera action
        } else if (id == R.id.my_profile) {

        } else if (id == R.id.my_activities) {

        } else if (id == R.id.notification) {

        } else if (id == R.id.contact_us) {

        }else if (id==R.id.question){
            Intent intent =new Intent(this,Question.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void addData(){


      arrayList.add(new MyDataSet(R.drawable.chris_evans,"chris evans","Who is your favourite music artist ?"));
      arrayList.add(new MyDataSet(R.drawable.chris_hemsworth,"chris hemsworth","Who is your favourite actor ?"));
      arrayList.add(new MyDataSet(R.drawable.robert_doweny,"robert doweny jr","Who is your favourite singer ?"));
      arrayList.add(new MyDataSet(R.drawable.thor_k,"thor","Who is your favourite music artist ?"));
      arrayList.add(new MyDataSet(R.drawable.thor_little,"odinson","Who is your favourite music artist ?"));
      arrayList.add(new MyDataSet(R.drawable.arijit_singh,"arijit singh","Who is your favourite music artist ?"));
      arrayList.add(new MyDataSet(R.drawable.chris_evans,"chris evans","Who is your favourite music artist ?"));



    }


}
