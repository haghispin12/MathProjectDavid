package com.example.mathprojectdavid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyViewHolder>{

    public interface OnItemClickListener{
        void onItemClick(User item);
    }

    private ArrayList<User> users;
    private OnItemClickListener listener;

    public UsersAdapter (ArrayList<User> users, OnItemClickListener listener){
        this.users = users;
        this.listener = listener;
    }
    @NonNull
    @Override
    public UsersAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position ){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapter.MyViewHolder holder, int position) {
        holder.bind(users.get(position), listener);
    }



    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView namedb;
        TextView scoredb;
        ImageView imagedb;


        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            namedb = itemView.findViewById(R.id.namedb);
            imagedb = itemView.findViewById(R.id.imagedb);
            scoredb = itemView.findViewById(R.id.scoredb);
        }
        public void bind(final User item, final OnItemClickListener listener){
            namedb.setText("user name: "+ item.getName());
            scoredb.setText("user score:" + item.getScore()+" ");
            imagedb.setImageBitmap(item.getBitmap());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}

