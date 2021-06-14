package com.example.self_built_tree;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class marketing extends AppCompatActivity {

    private Button Return,review;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marketing);
        Return = (Button)findViewById(R.id.data);
        Return.setOnClickListener(btnReturn);

        review = (Button)findViewById(R.id.reviewbtn);
        review.setOnClickListener(btnreview);
    }
    private Button.OnClickListener btnReturn = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent it = new Intent();
            it.setClass(marketing.this, record.class);
            startActivity(it);
            finish();
        }
    };

    private Button.OnClickListener btnreview = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent it = new Intent();
            it.setClass(marketing.this, review.class);
            startActivity(it);
            finish();
        }
    };
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(marketing.this,record.class));
        return super.onOptionsItemSelected(item);
    }


}