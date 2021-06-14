package com.example.self_built_tree;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class page4 extends AppCompatActivity {


    Button autoInputSetting_btn, input_btn, takeout_btn;
    ImageButton tree_detail_btn;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page4);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        name = (TextView) findViewById((R.id.tree_title));
        name.setText(data.name_tree.toString()+"小樹苗");
        autoInputSetting_btn = (Button) findViewById(R.id.autoInputSetting_btn);
        autoInputSetting_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                // open next page
                Intent intent = new Intent();
                intent.setClass(page4.this, page5_1.class);
                startActivity(intent);

            }
        });

        input_btn = (Button) findViewById(R.id.input_btn);
        input_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                // open next page
                Intent intent = new Intent();
                intent.setClass(page4.this, page5_2.class);
                startActivity(intent);

            }
        });

        takeout_btn = (Button) findViewById(R.id.takeout_btn);
        takeout_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                // open next page
                Intent intent = new Intent();
                intent.setClass(page4.this, page5_3.class);
                startActivity(intent);

            }
        });

        tree_detail_btn = (ImageButton) findViewById(R.id.tree_detail_btn);
        tree_detail_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // open next page
               Intent intent = new Intent();
                intent.setClass(page4.this, tree_details.class);
                startActivity(intent);

            }
        });
    }

    //@Override
    //public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    //    startActivity(new Intent(page1.this,BackActivity.class));
    //    return super.onOptionsItemSelected(item);
    //}
}