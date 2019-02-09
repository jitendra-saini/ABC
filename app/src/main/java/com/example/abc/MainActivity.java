package com.example.abc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText,editText1;
    TextView textView;
    Button btn;
    SharedPreferences sharedPreferences;
    String username,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.editText);
        editText1=findViewById(R.id.editText2);
        textView=findViewById(R.id.textView3);
        btn=findViewById(R.id.button);
        sharedPreferences=getSharedPreferences("User",MODE_PRIVATE);
        username=sharedPreferences.getString("username",null);
        password=sharedPreferences.getString("password",null);

        Log.e("username_and_password",username+password);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Registration.class);
                startActivity(intent);
            }
        });
          btn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  if(check()==true){

                      Intent intent=new Intent(MainActivity.this,Home.class);
                      startActivity(intent);

                  }
                  else{
                      Toast.makeText(MainActivity.this,"wrong username and password",Toast.LENGTH_LONG).show();
                  }
              }
          });
    }


    public boolean check(){

        if(editText.getText().toString().equals(username)&&editText1.getText().toString().equals(password)){

            return true;

        }
        else
        {

            return false;
        }



    }

}
