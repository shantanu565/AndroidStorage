package com.shantanu.example.androidstorage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    EditText textName,textAddress,textPhone;
    Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        textName=(EditText) findViewById(R.id.edt_addName);
        textAddress=(EditText) findViewById(R.id.edt_addAddress);
        textPhone=(EditText) findViewById(R.id.edt_addPhone);
        buttonAdd=(Button)findViewById(R.id.btn_Add);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBAdapter db=new DBAdapter(AddActivity.this);
                db.openDB();

                String name=textName.getText().toString();
                String address=textAddress.getText().toString();
                String phone=textPhone.getText().toString();


                if (name.isEmpty() && name.equals("")){
                    Toast.makeText(AddActivity.this,"Enter username",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (address.isEmpty() && address.equals("")){
                    Toast.makeText(AddActivity.this,"Enter address",Toast.LENGTH_SHORT).show();
                    return;
                }
             if (phone.isEmpty() && phone.equals("")){
                 Toast.makeText(AddActivity.this,"Enter phone",Toast.LENGTH_SHORT).show();
                 return;
             }

                long result=db.add(name,address,phone);
                Toast.makeText(AddActivity.this,name,Toast.LENGTH_SHORT).show();

                if(result>0)
                {
                    Toast.makeText(AddActivity.this,"added from new activity",Toast.LENGTH_SHORT).show();

                     textName.setText("");
                     textAddress.setText("");
                     textPhone.setText("");
                }else
                {
                    Toast.makeText(AddActivity.this,"Failed Operation",Toast.LENGTH_SHORT).show();

                }

                db.closeDB();
                Intent i2=new Intent(AddActivity.this,HomeScreen.class);
                startActivity(i2);
            }
        });
    }
}
