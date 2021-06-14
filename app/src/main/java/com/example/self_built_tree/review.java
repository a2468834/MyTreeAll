package com.example.self_built_tree;

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

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class review extends AppCompatActivity {

    private TableLayout tabActivity03;
    private Button detail;
    private Button Return;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.review);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Return = (Button)findViewById(R.id.data);
        Return.setOnClickListener(btnReturn);

        detail = (Button)findViewById(R.id.detail);
        detail.setOnClickListener(btndetail);
//        initData2();
    }
    private Button.OnClickListener btnReturn = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {

            Intent it = new Intent();
            it.setClass(review.this, record.class);
            startActivity(it);
            finish();
        }
    };
    private Button.OnClickListener btndetail = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent it = new Intent();
            it.setClass(review.this, detail.class);
            startActivity(it);
            finish();
        }
    };
    private void initData2() {
        String[][] array = {{"8月","","",""},{"7月","","",""},{"6月","","",""},
                {"5月","","",""},{"4月","","",""},{"3月","","",""}};

        tabActivity03 = findViewById(R.id.tab_activity03);
        tabActivity03.setStretchAllColumns(true);

        for (int row = 0; row<6; row++){
            TableRow tableRow = new TableRow(review.this);
            tableRow.setBackgroundColor(Color.WHITE);
            for (int i = 0; i<4 ;i++){
                TextView textView = new TextView(review.this);
                textView.setText(array[row][i]+"");
//                textView.setBackground(getResources().getDrawable(R.drawable));
                textView.setGravity(Gravity.CENTER);
                tableRow.addView(textView);
            }

            tabActivity03.addView(tableRow,new TableLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.MATCH_PARENT
            ));
        }
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(review.this,record.class));
        return super.onOptionsItemSelected(item);
    }

}
