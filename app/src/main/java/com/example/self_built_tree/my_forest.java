package com.example.self_built_tree;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class my_forest extends AppCompatActivity {

    private ImageView go_back_button;
    private ImageView go_to_lifestage_calc;
    private ImageView go_to_plant_tree;

    private ImageView tesla_tree_image;
    private TextView tesla_tree_text;

    private ImageView barn_image;
    private TextView barn_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_forest);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

//        go_back_button = (ImageView) findViewById(R.id.返回鍵_image);
//        go_back_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(my_forest.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });

        go_to_lifestage_calc = (ImageView) findViewById(R.id.理財試算_image);
        go_to_lifestage_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(my_forest.this, lifestage_calc.class);
                startActivity(intent);
            }
        });

        go_to_plant_tree = (ImageView) findViewById(R.id.建立小樹苗_image);
        go_to_plant_tree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(my_forest.this, page1.class);
                startActivity(intent);
            }
        });

        tesla_tree_image = (ImageView) findViewById(R.id.level5_tree_image);
        tesla_tree_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(my_forest.this, page4.class);
                startActivity(intent);
            }
        });

//        tesla_tree_text = (TextView) findViewById(R.id.特斯拉_text);
//        tesla_tree_text.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(my_forest.this, page4.class);
//                startActivity(intent);
//            }
//        });

        barn_image = (ImageView) findViewById(R.id.管理室_image);
        barn_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(my_forest.this, suggest_dn_cathay_app.class);
                intent.putExtra("next_activity_name", "my_forest");
                startActivity(intent);
            }
        });

        barn_text = (TextView) findViewById(R.id.管理室_text);
        barn_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(my_forest.this, suggest_dn_cathay_app.class);
                intent.putExtra("next_activity_name", "my_forest");
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(my_forest.this,MainActivity.class));
        return super.onOptionsItemSelected(item);
    }
}