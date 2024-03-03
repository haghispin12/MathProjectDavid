package com.example.mathprojectdavid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class RateActivity extends AppCompatActivity {
    private SeekBar seekBar;

    private Button submit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate1);
        initView();

    }

    public void initView(){
        seekBar = findViewById(R.id.seekbar);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("rate", seekBar.getProgress());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

}