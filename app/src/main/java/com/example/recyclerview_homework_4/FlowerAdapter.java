package com.example.recyclerview_homework_4;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recaclerhome4.Model.Flower;

import java.io.Serializable;
import java.util.ArrayList;

public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.FlowerViewHolder> {

    ArrayList<Flower>flowerArrayList;
    FlowerClick flowerClick;

    public FlowerAdapter(ArrayList<Flower> flowerArrayList, FlowerClick flowerClick) {
        this.flowerArrayList = flowerArrayList;
        this.flowerClick = flowerClick;

    }

    @NonNull
    @Override
    public FlowerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FlowerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_flower,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FlowerViewHolder holder, int position) {
        holder.onBind(flowerArrayList.get(position));
        holder.itemView.setOnClickListener(view -> {
            flowerClick.flowerClicked(flowerArrayList.get(position));

            Intent intent = new Intent(view.getContext(),DetailActivity.class);
intent.putExtra("flower", (Serializable) flowerArrayList.get(position));
view.getContext().startActivity(intent);




            intent.putExtra("name",flowerArrayList.get(position).getName());
            intent.putExtra("sum",flowerArrayList.get(position).getSum());
            intent.putExtra("color",flowerArrayList.get(position).getColor());
            intent.putExtra("image",flowerArrayList.get(position).getImage());
            view.getContext().startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return flowerArrayList.size();
    }

    public static class FlowerViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public FlowerViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        public void onBind(Flower flower){
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            imageView.setImageResource(flower.getImage());
            textView.setText(flower.getName());


        }

}

}
