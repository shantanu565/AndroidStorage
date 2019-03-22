package com.shantanu.example.androidstorage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter<MyHolder> {
    Context c;
    ArrayList<Employee> employees;

    public MyListAdapter(Context c, ArrayList<Employee> employees) {
        this.c = c;
        this.employees = employees;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,null);
        MyHolder holder=new MyHolder(c,v);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        holder.nametxt.setText(employees.get(position).getName());
        holder.posTxt.setText(employees.get(position).getAddress());
        holder.addresstxt.setText(employees.get(position).getAddress());
        holder.idtxt.setText(String.valueOf(employees.get(position).getID()));
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c,"clicked",Toast.LENGTH_SHORT).show();
                DBAdapter db=new DBAdapter(c);
                db.openDB();
                db.deleteItem(employees.get(position));
                employees.remove(position);
                notifyDataSetChanged();
                Toast.makeText(c,"done delete",Toast.LENGTH_SHORT).show();
            }
        });

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                //itemclick
            }
        });

    }

    @Override
    public int getItemCount() {
        return employees.size();
    }



}

