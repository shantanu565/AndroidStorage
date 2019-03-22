package com.shantanu.example.androidstorage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity {
    RecyclerView rv;
    MyListAdapter adapter;
    ArrayList<Employee> employees=new ArrayList<>();
    public static final String MyPREFERENCES = "MyPrefs" ;
    Button btnlogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        btnlogout=(Button)findViewById(R.id.b_logout);

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp2=getSharedPreferences(MyPREFERENCES,MODE_PRIVATE);
                SharedPreferences.Editor ed=sp2.edit();
                ed.clear();
                ed.apply();
                ed.commit();
                Intent intent=new Intent(HomeScreen.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

        rv= (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());
        adapter=new MyListAdapter(this,employees);
        retrieve();


    }
    private void retrieve()
    {
        employees.clear();

        DBAdapter db=new DBAdapter(this);
        db.openDB();

        Cursor c=db.getAllEmployees();
        while (c.moveToNext())
        {
            int id=c.getInt(0);
            String name=c.getString(1);
            String address=c.getString(2);
            String phone=c.getString(3);

            Employee p=new Employee(id,name,address,phone);
            employees.add(p);
        }

        if(!(employees.size()<1))
        {
            rv.setAdapter(adapter);
        }

        db.closeDB();;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.add:
                Intent i=new Intent(HomeScreen.this,AddActivity.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Add your item here",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
