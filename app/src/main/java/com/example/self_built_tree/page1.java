package com.example.self_built_tree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class page1 extends AppCompatActivity {


    EditText nameInput, initialInput, goalInput;
    Button next_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page1);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        nameInput = (EditText) findViewById((R.id.nameInput));
        initialInput = (EditText) findViewById(R.id.initialInput);
        goalInput = (EditText) findViewById(R.id.goalInput);

        next_btn = (Button) findViewById(R.id.next_btn);
        next_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // get user input and send to data.java
                data.name_tree = nameInput.getText().toString();
                data.initial_amount = Integer.valueOf(initialInput.getText().toString());
                data.goal_amount = Integer.valueOf(goalInput.getText().toString());

                // open next page
                Intent intent = new Intent();
                intent.setClass(page1.this, page2.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(page1.this,my_forest.class));
        return super.onOptionsItemSelected(item);
    }

}