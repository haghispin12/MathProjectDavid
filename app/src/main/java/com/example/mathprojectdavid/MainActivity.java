package com.example.mathprojectdavid;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.invoke.MethodHandles;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button Etgar;///////

    private Button kefel;

    private Button loach;

    private TextView num1;

    private TextView num2;

    private EditText answer;

    private Button check;

    private Button save;

    private Button show;

    private Button rate;

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    int myrate = result.getData().getIntExtra("rate", -1);
                    Toast.makeText(MainActivity.this, myrate+" ",Toast.LENGTH_LONG).show();
                }
            });

    //private Exercize exercize;

    MainViewModel viewModelMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity1);
        //exercize = new Exercize();
        initView();
        //create object VM
        viewModelMain = new ViewModelProvider(this).get(MainViewModel.class);
        viewModelMain.vnum1.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                num1.setText(integer+"");
            }
        });
        viewModelMain.vnum2.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                num2.setText(integer+"");
            }
        });
        Intent intent = getIntent();
        String UserName = intent.getStringExtra("UserName");
        Toast.makeText(MainActivity.this, "glad you back ;) " + UserName, Toast.LENGTH_LONG).show();
        viewModelMain.updateName(UserName);

    }

    public void initView(){
        Etgar = findViewById(R.id.Etgar);
        kefel = findViewById(R.id.kefel);
        loach = findViewById(R.id.loach);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        answer = findViewById(R.id.answer);
        check = findViewById(R.id.check);
        save = findViewById(R.id.save);
        show = findViewById(R.id.show);
        rate = findViewById(R.id.rate);

        Etgar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call etgar by vm object
                viewModelMain.vEtgar();
                //exercize.generateNumEtgar();
                //updateView();
            }
        });

        kefel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModelMain.vKefel();
                //exercize.generateNumstill20();
                //updateView();
            }
        });

        loach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModelMain.vloach();
                //exercize.generateNumloach();
                //updateView();
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean b = viewModelMain.exercize.checkAnswer(answer.getText().toString());
                if(b)
                    Toast.makeText(MainActivity.this, "success", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_LONG).show();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RateActivity.class);
                activityResultLauncher.launch(intent);
                SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                String s1 = sh.getString("name", "");



            }
        });


    }



    /**
     * update the text of num 1 and 2
     */









}