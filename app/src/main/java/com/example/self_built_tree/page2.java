package com.example.self_built_tree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class page2 extends AppCompatActivity {

    Button set_autoInput_btn, confirm_build_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        set_autoInput_btn = (Button) findViewById(R.id.set_autoInput_btn);
        set_autoInput_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // open next page
                Intent intent = new Intent();
                intent.setClass(page2.this, page3_1.class);
                startActivity(intent);

            }
        });

        confirm_build_btn = (Button) findViewById(R.id.confirm_build_btn);
        confirm_build_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // open next page
                Intent intent = new Intent();
                intent.setClass(page2.this, page4.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(page2.this,page1.class));
        return super.onOptionsItemSelected(item);
    }
}