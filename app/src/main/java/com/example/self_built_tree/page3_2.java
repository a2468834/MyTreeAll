package com.example.self_built_tree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class page3_2 extends AppCompatActivity {

    Button predict_again_btn, confirm_build_btn;
    TextView cal_result;
    int initial3_2, period3_2, goal3_2, input3_2, result3_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page3_2);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        period3_2 = data.period;
        goal3_2 = data.goal_amount;
        input3_2 = data.autoInput_amount;
        initial3_2 = data.initial_amount;

        result3_2 = (goal3_2 - initial3_2)/input3_2*period3_2;

        cal_result = (TextView) findViewById(R.id.predicted_result_text);
        cal_result.setText("小樹苗需要" + Integer.toString(result3_2) + "個月\n開花結果");
        predict_again_btn = (Button) findViewById(R.id.predict_again_btn);
        predict_again_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                // open next page
                Intent intent = new Intent();
                intent.setClass(page3_2.this, page3_1.class);
                startActivity(intent);

            }
        });

        confirm_build_btn = (Button) findViewById(R.id.confirm_build_btn);
        confirm_build_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                // open next page
                Intent intent = new Intent();
                intent.setClass(page3_2.this, page4.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(page3_2.this,page3_1.class));
        return super.onOptionsItemSelected(item);
    }
}