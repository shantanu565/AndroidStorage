package com.shantanu.example.androidstorage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView nametxt,posTxt,addresstxt,idtxt;
    Button btnDelete;
    ItemClickListener itemClickListener;
    Context context;


    public MyHolder(Context context,View itemView) {
        super(itemView);
        this.context=context;

        nametxt= (TextView) itemView.findViewById(R.id.textView1);
        posTxt= (TextView) itemView.findViewById(R.id.textView2);
        addresstxt=(TextView)itemView.findViewById(R.id.textView3);
        idtxt=(TextView)itemView.findViewById(R.id.textView4);
        btnDelete=(Button)itemView.findViewById(R.id.btn_delete);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v,getLayoutPosition());
        Toast.makeText(context,"clicked",Toast.LENGTH_SHORT).show();

    }

    public void setItemClickListener(ItemClickListener ic)
    {
        this.itemClickListener=ic;

    }

}
