package com.shantanu.example.androidstorage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnSubmit,btnAddData;
    EditText edtUsername,edtPass;
    SharedPreferences sp;
    public static final String MyPREFERENCES = "MyEmployeePrefs" ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsername=(EditText)findViewById(R.id.edt_username);
        edtPass=(EditText)findViewById(R.id.edt_pass);
        int status=checkStatus();
        if (status==1){
            Toast.makeText(this,"success",Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(this,"failed",Toast.LENGTH_SHORT).show();

        }

        btnSubmit=(Button)findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logincheck();
            }
        });
        btnAddData=(Button)findViewById(R.id.btn_sampledata);
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addsampledata();
            }
        });


    }

    public int checkStatus(){
        SharedPreferences sp = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        String name = sp.getString("username", null);

        if (name != null) {
            Toast.makeText(this,name,Toast.LENGTH_SHORT).show();
            edtUsername.setText(name);
            return 1;
        }else {
            Toast.makeText(this,"Status Logout",Toast.LENGTH_SHORT).show();
            edtUsername.setText("");

        }
    return 0;
    }

    public void addsampledata(){
        //add  data here
        DBAdapter db=new DBAdapter(this);
        db.openDB();

        String name="Shayaam";
        String address="noida";
        String phone="3243434324343";
        long result=db.add(name,address,phone);
        Toast.makeText(this,name,Toast.LENGTH_SHORT).show();

        if(result>0)
        {
            Toast.makeText(this,"added",Toast.LENGTH_SHORT).show();

        }else
        {
            //here
        }

        db.closeDB();


    }

    public void logincheck(){
        String username=edtUsername.getText().toString();
        String pass=edtPass.getText().toString();

        if (username.isEmpty() && username.equals("")){
            Toast.makeText(this,"Enter username",Toast.LENGTH_SHORT).show();
            return;
        }
        if (pass.isEmpty() && pass.equals("")){
            Toast.makeText(this,"Enter pass",Toast.LENGTH_SHORT).show();
            return;
        }


        SharedPreferences sp1 = getSharedPreferences(MyPREFERENCES, getApplicationContext().MODE_PRIVATE);

        SharedPreferences.Editor editor = sp1.edit();

        editor.putString("username", username);
        editor.putString("pass",pass);
        editor.commit();
        Toast.makeText(MainActivity.this,username+""+pass,Toast.LENGTH_LONG).show();


        Intent intent=new Intent(this,HomeScreen.class);
        startActivity(intent);

    }

}
