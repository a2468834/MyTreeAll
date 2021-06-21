package com.example.self_built_tree;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class children_education_p1 extends AppCompatActivity {

    private ImageView go_back_button;
    private View next_page_rectangle;
    private TextView next_page_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_children_education_p1);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
/*
        go_back_button = (ImageView) findViewById(R.id.返回鍵_image);
        go_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(children_education_p1.this, lifestage_calc.class);
                startActivity(intent);
            }
        });
*/
        next_page_rectangle = (View) findViewById(R.id.rectangle_small_3);
        next_page_rectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object[] inputs = getIntentValues();
                Intent intent = new Intent(children_education_p1.this, children_education_p2.class);
                intent.putExtra("child_1_age", (int)inputs[0]);
                intent.putExtra("child_2_age", (int)inputs[1]);
                startActivity(intent);
            }
        });

        next_page_text = (TextView) findViewById(R.id.text_3);
        next_page_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object[] inputs = getIntentValues();
                Intent intent = new Intent(children_education_p1.this, children_education_p2.class);
                intent.putExtra("child_1_age", (int)inputs[0]);
                intent.putExtra("child_2_age", (int)inputs[1]);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(children_education_p1.this,lifestage_calc.class));
        return super.onOptionsItemSelected(item);
    }

    private Object[] getIntentValues(){
        // 取得：第一位小孩年齡
        String child_1_age_str = ((EditText)findViewById(R.id.input_form_3)).getText().toString();
        int child_1_age = Integer.parseInt(child_1_age_str);

        // 取得：第二位小孩年齡
        String child_2_age_str = ((EditText)findViewById(R.id.input_form_4)).getText().toString();
        int child_2_age = Integer.parseInt(child_2_age_str);

        return new Object[] { child_1_age, child_2_age };
    }
}