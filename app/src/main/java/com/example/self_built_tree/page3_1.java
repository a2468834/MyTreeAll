package com.example.self_built_tree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class page3_1 extends AppCompatActivity {


    EditText autoInput_amount, autoInput_period;
    Button show_prediction_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page3_1);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        autoInput_amount = (EditText)findViewById(R.id.autoInput_amount);
        autoInput_period = (EditText)findViewById(R.id.autoInput_period);


        show_prediction_btn = (Button) findViewById(R.id.show_prediction_btn);
        show_prediction_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // send to data.java
                data.autoInput_amount = Integer.valueOf(autoInput_amount.getText().toString());
                data.period = Integer.valueOf(autoInput_period.getText().toString());

                // open next page
                Intent intent = new Intent();
                intent.setClass(page3_1.this, page3_2.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(page3_1.this,page2.class));
        return super.onOptionsItemSelected(item);
    }
}