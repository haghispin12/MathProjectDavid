package com.example.mathprojectdavid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.invoke.MethodHandles;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button Etgar;

    private Button kefel;

    private Button loach;

    private TextView num1;

    private TextView num2;

    private EditText answer;

    private Button check;

    private Button save;

    private Button show;

    private Exercize exercize;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exercize = new Exercize();
        initView();
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

        Etgar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exercize.generateNumEtgar();
                updateView();
            }
        });

        kefel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exercize.generateNumstill20();
                updateView();
            }
        });

        loach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exercize.generateNumloach();
                updateView();
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean b = exercize.checkAnswer(answer.getText().toString());
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

    }



    /**
     * update the text of num 1 and 2
     */
    public void updateView(){
        num1.setText(exercize.getNum3()+"");
        num2.setText(exercize.getNum4()+"");
    }




}