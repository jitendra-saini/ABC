package com.example.abc;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

 public class Registration extends AppCompatActivity {
 SharedPreferences.Editor editor;
 CircleImageView circleImageView;
 EditText name,username,password;
 TextView signin,image;
 Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        circleImageView=findViewById(R.id.circleImageView1);
        name=findViewById(R.id.editText3);
        username=findViewById(R.id.editText4);
        password=findViewById(R.id.editText5);
        btn=findViewById(R.id.button2);
        image=findViewById(R.id.textView5);

        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check_permission();
            }
        });
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check_permission();
            }
        });




        editor=getSharedPreferences("User",MODE_PRIVATE).edit();
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               editor.putString("username",username.getText().toString());
               editor.putString("password",password.getText().toString());
               editor.putString("name",name.getText().toString());
               editor.commit();
               Intent intent=new Intent(Registration.this,MainActivity.class);
               startActivity(intent);

           }
       });


    }

    public void check_permission() {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {


                ActivityCompat.requestPermissions(this, new
                        String[]{Manifest.permission.CAMERA}, 1);


         }
         else {

             opencamera();
        }

          }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){

            case 1:{

                //if request is cancelled   the result array are empty
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                                 opencamera();
                }
                else {
                    check_permission();
                }
             return;


              }

             }
         }


        public void opencamera(){

            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent,2);
           }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {


        if (requestCode == 2) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            circleImageView.setImageBitmap(photo);

        }
    }

           /* public void showalert(){

            AlertDialog alertDialog=new AlertDialog.Builder(this).create();
            alertDialog.setTitle("permission required");
            alertDialog.setMessage("Apps needs to access the camera");
            alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Deny", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    finish();
                }
            });
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "allow", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            finish();
                }
            });

        }*/
}
