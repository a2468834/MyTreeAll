package com.example.self_built_tree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class suggest_dn_cathay_app extends AppCompatActivity {

    private ImageButton close_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest_dn_cathay_app);

        if(getIntent().getStringExtra("next_activity_name").equals("import_transaction")){
            close_button = (ImageButton) findViewById(R.id.叉叉_image);
            close_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(suggest_dn_cathay_app.this, record.class));
                }
            });
        }
        else{ // getIntent().getStringExtra("next_activity_name") == "my_forest"
            close_button = (ImageButton) findViewById(R.id.叉叉_image);
            close_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(suggest_dn_cathay_app.this, my_forest.class));
                }
            });
        }
    }
}