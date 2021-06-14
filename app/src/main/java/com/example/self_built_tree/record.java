package com.example.self_built_tree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class record extends AppCompatActivity {

    private TableLayout  tabActivity02;
    private Button Return,review,average,sell;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Return = (Button)findViewById(R.id.data);
        Return.setOnClickListener(btnReturn);

        sell = (Button)findViewById(R.id.sell);
        sell.setOnClickListener(btnsell);

        average = (Button)findViewById(R.id.average);
        average.setOnClickListener(btnaverage);
        review = (Button)findViewById(R.id.review);
        review.setOnClickListener(btnreview);
        initData();
    }
    private Button.OnClickListener btnReturn = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {


            Intent it = new Intent();
            it.setClass(record.this, secondpage.class);
            Bundle bun = new Bundle();
//            bun.putIntArray("DATA_x", data.x);
//            it.putExtras(bun);
            startActivity(it);
            finish();
        }
    };
    private void initData() {
        String[][] array = {{"信","2021/5/1","食物","漢堡","支","$120"," "},{"載具","2021/5/1","食物","麵食","支","$80"," "},{"手動","2021/5/1","娛樂","唱歌","支","$350"," "}};
        tabActivity02 = findViewById(R.id.tab_activity02);
        tabActivity02.setStretchAllColumns(true);
        for (int row = 0; row<3; row++){
            TableRow tableRow = new TableRow(record.this);
            tableRow.setBackgroundColor(Color.WHITE);
            for (int i = 0; i<7 ;i++){
                TextView textView = new TextView(record.this);
                textView.setText(array[row][i]+"");
//                textView.setBackground(getResources().getDrawable(R.drawable));
                textView.setGravity(Gravity.CENTER);
                tableRow.addView(textView);
            }

            tabActivity02.addView(tableRow,new TableLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.MATCH_PARENT
            ));
        }
    }
    private Button.OnClickListener btnaverage = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {

            Intent it = new Intent();
            it.setClass(record.this, average.class);
            Bundle bun = new Bundle();
//            bun.putIntArray("DATA_x", data.x);
//            it.putExtras(bun);
            startActivity(it);
            finish();
        }
    };
    private Button.OnClickListener btnreview = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {

            Intent it = new Intent();
            it.setClass(record.this, review.class);
//            Bundle bun = new Bundle();
//            bun.putIntArray("DATA_x", data.x);
//            it.putExtras(bun);
            startActivity(it);
            finish();
        }
    };

    private Button.OnClickListener btnsell = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {

            Intent it = new Intent();
            it.setClass(record.this, marketing.class);
//            Bundle bun = new Bundle();
//            bun.putIntArray("DATA_x", data.x);
//            it.putExtras(bun);
            startActivity(it);
            finish();
        }
    };
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(record.this,MainActivity.class));
        return super.onOptionsItemSelected(item);
    }

}