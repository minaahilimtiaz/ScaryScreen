package com.example.scaryscreenassignment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView novel_name;
    public TextView author_name;


    public MyViewHolder(View view){
        super(view);
        novel_name = (TextView) view.findViewById(R.id.titleinput);
        author_name=(TextView) view.findViewById(R.id.authorinput);



    }





}
