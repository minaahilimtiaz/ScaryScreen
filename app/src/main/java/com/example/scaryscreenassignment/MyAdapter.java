package com.example.scaryscreenassignment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<BookInfo> items;
    private int itemLayout;
    public MyAdapter(List<BookInfo> items, int itemLayout) {
        this.items = items;
        this.itemLayout = itemLayout;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new MyViewHolder(v);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if(items != null && holder != null) {
            holder.novel_name.setText(items.get(position).getBook_name());
            holder.author_name.setText(items.get(position).getAuthor_name());

        }
    }
    @Override public int getItemCount() {
        if(items != null) {
            return items.size();
        }
        else{
            return 0;
        }
    }

}
