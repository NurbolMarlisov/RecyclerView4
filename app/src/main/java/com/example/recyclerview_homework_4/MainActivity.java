package com.example.recyclerview_homework_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FlowerClick {
    RecyclerView recyclerView;
    FlowerAdapter adapter;

    ArrayList <Flower> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        filList();
        initAdapter();

    }


    private void initViews() {
        recyclerView = findViewById(R.id.recaclerView);
    }
    private void filList(){
        arrayList = new ArrayList<>();
        arrayList.add(new Flower("rose",100,"red",R.drawable.img));
        arrayList.add(new Flower("pion",2,"red",R.drawable.img_1));
        arrayList.add(new Flower("astra",23,"red",R.drawable.img_2));
        arrayList.add(new Flower("piono",45,"red",R.drawable.img_3));
        arrayList.add(new Flower("doom",345,"red",R.drawable.img_4));
        arrayList.add(new Flower("crystalis",324,"red",R.drawable.img_5));
    }
    private void initAdapter() {
        adapter = new FlowerAdapter(arrayList,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void flowerClicked(Flower flower) {
        System.out.println("Name ---"+ flower.getName());
        System.out.println(" color " + flower.getColor());
        System.out.println(" sum "+ flower.getSum());
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}