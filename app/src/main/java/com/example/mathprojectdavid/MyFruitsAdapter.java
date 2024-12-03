package com.example.mathprojectdavid;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyFruitsAdapter extends RecyclerView .Adapter<MyFruitsAdapter.MyViewHolder>{
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvFruitName;
        ImageView ivFruitImg;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            tvFruitName = itemView.findViewById(R.id.tvFruitName);
            ivFruitImg = itemView.findViewById(R.id.ivFruitImg);
        }
        public void bind(final User item, final OneItemClickListener listener){
            ivFruitImg.setText()
        }
    }
}
