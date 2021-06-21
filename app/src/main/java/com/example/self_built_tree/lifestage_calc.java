package com.example.self_built_tree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class lifestage_calc extends AppCompatActivity {

    private ImageView go_back_button;
    private ImageView want_retire_button;
    private ImageView children_education_button;
    private ImageView buy_house_button;
    private ImageView first_one_million_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifestage_calc);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
/*
        go_back_button = (ImageView) findViewById(R.id.返回鍵_image);
        go_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(lifestage_calc.this, my_forest.class);
                startActivity(intent);
            }
        });
*/
        want_retire_button = (ImageView) findViewById(R.id.幸福退休_image);
        want_retire_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(lifestage_calc.this, want_to_retire.class);
                startActivity(intent);
            }
        });

        children_education_button = (ImageView) findViewById(R.id.子女教育_image);
        children_education_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(lifestage_calc.this, children_education_p1.class);
                startActivity(intent);
            }
        });

        buy_house_button = (ImageView) findViewById(R.id.幸福成家_image);
        buy_house_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(lifestage_calc.this, buy_house.class);
                startActivity(intent);
            }
        });

        first_one_million_button = (ImageView) findViewById(R.id.夢想清單_image);
        first_one_million_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(lifestage_calc.this, first_one_million.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(lifestage_calc.this,my_forest.class));
        return super.onOptionsItemSelected(item);
    }
}