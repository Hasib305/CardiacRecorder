package com.example.retrivedata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.MyViewHolder> {

    Context context;
    ArrayList<user>List;

    public myAdapter(Context context, ArrayList<user> list) {
        this.context = context;
        List = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
             user us=List.get(position);
    holder.name.setText(us.getName());
       holder.age.setText(String.valueOf(us.getAge()));
    }

    @Override
    public int getItemCount() {
        return List.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,age;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name =itemView.findViewById(R.id.textname);
            age=itemView.findViewById(R.id.textage);
        }
    }
}
