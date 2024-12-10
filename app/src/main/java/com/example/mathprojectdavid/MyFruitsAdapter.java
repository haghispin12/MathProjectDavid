//package com.example.mathprojectdavid;
//
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//
//public class MyFruitsAdapter extends RecyclerView .Adapter<MyFruitsAdapter.MyViewHolder>{
//
//    public interface OnItemClickListener{
//        void onItemClick(Fruit item);
//    }
//
//    private ArrayList<Fruit> fruits;
//    private OnItemClickListener
//
//    public static class MyViewHolder extends RecyclerView.ViewHolder{
//        TextView tvFruitName;
//        ImageView ivFruitImg;
//
//        public MyViewHolder(@NonNull View itemView){
//            super(itemView);
//            tvFruitName = itemView.findViewById(R.id.tvFruitName);
//            ivFruitImg = itemView.findViewById(R.id.ivFruitImg);
//        }
//        public void bind(final User item, final OneItemClickListener listener){
//            tvFruitName.setText(item.getName());
//            ivFruitImg.setImageResource(item.getDrawble());
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    listener.onItemClick(item);
//                }
//            });
//        }
//    }
//}
