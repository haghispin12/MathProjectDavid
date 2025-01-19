package com.example.mathprojectdavid.MyProject;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mathprojectdavid.R;

import java.util.ArrayList;

public class show_fruits extends AppCompatActivity {

    private RecyclerView rcShowFruits;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show_fruits);
        initView();
        showFruits();


//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }

    public void initView(){
        rcShowFruits = findViewById(R.id.rcShowUsers);
    }

    public void showFruits(){
        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit("banana",R.drawable.banana));
        fruits.add(new Fruit("apple",R.drawable.apple));
        fruits.add(new Fruit("orange",R.drawable.orange));
        fruits.add(new Fruit("grapes",R.drawable.lemon));
        fruits.add(new Fruit("lemon",R.drawable.fru));
        MyFruitsAdapter myFruitsAdapter = new MyFruitsAdapter(fruits, new MyFruitsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Fruit item) {
                Toast.makeText(show_fruits.this, item.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        rcShowFruits.setLayoutManager(new LinearLayoutManager(this));
        rcShowFruits.setAdapter(myFruitsAdapter);
        rcShowFruits.setHasFixedSize(true);
    }

}
