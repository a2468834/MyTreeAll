package com.example.self_built_tree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class want_to_retire extends AppCompatActivity {

    private ArrayAdapter<String> adapter;
    private Spinner career_choice;
    private static final String[] career_list = {"你的職業屬性", "勞工", "軍公教", "私立教職", "其他"};
    private Spinner risk_range;
    private static final String[] risk_range_list = {"我可承受的風險範圍", "積極型", "穩健型", "保守型", "我不知道"};

    private ImageView go_back_button;
    private TextView next_page_button_text;
    private View next_page_button_rectangle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_want_retire);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        career_choice = (Spinner) findViewById(R.id.spinner_1);
        adapter = new ArrayAdapter<String>(want_to_retire.this, R.layout.my_spinner_style, career_list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        career_choice.setAdapter(adapter);

        risk_range = (Spinner) findViewById(R.id.spinner_2);
        adapter = new ArrayAdapter<String>(want_to_retire.this, R.layout.my_spinner_style, risk_range_list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        risk_range.setAdapter(adapter);

//        go_back_button = (ImageView) findViewById(R.id.返回鍵_image);
//        go_back_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(want_to_retire.this, lifestage_calc.class);
//                startActivity(intent);
//            }
//        });

        next_page_button_text = (TextView) findViewById(R.id.text_3);
        next_page_button_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object[] inputs = getIntentValues();
                Intent intent = new Intent(want_to_retire.this, preview_building_tree.class);
                intent.putExtra("input_1", (int)inputs[0]);
                intent.putExtra("input_2", (int)inputs[1]);
                intent.putExtra("input_3", (String) inputs[2]);
                intent.putExtra("input_4", (int)inputs[3]);
                intent.putExtra("input_5", (int)inputs[4]);
                intent.putExtra("input_6", (int)inputs[5]);
                intent.putExtra("input_7", (String) inputs[6]);
                intent.putExtra("input_8", (Float) inputs[7]);
                startActivity(intent);
            }
        });

        next_page_button_rectangle = (View) findViewById(R.id.rectangle_small_3);
        next_page_button_rectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object[] inputs = getIntentValues();
                Intent intent = new Intent(want_to_retire.this, preview_building_tree.class);
                intent.putExtra("input_1", (int)inputs[0]);
                intent.putExtra("input_2", (int)inputs[1]);
                intent.putExtra("input_3", (String) inputs[2]);
                intent.putExtra("input_4", (int)inputs[3]);
                intent.putExtra("input_5", (int)inputs[4]);
                intent.putExtra("input_6", (int)inputs[5]);
                intent.putExtra("input_7", (String) inputs[6]);
                intent.putExtra("input_8", (Float) inputs[7]);
                startActivity(intent);
            }
        });
    }

    private Object[] getIntentValues(){
        // 取得：目前年齡
        String input_1_str = ((EditText)findViewById(R.id.input_form_1)).getText().toString();
        int input_1 = Integer.parseInt(input_1_str);

        // 取得：退休年齡
        String input_2_str = ((EditText)findViewById(R.id.input_form_2)).getText().toString();
        int input_2 = Integer.parseInt(input_2_str);

        // 取得：spinner-職業屬性
        String input_3 = ((Spinner)findViewById(R.id.spinner_1)).getSelectedItem().toString();

        // 取得：退休月平均花費
        String input_4_str = ((EditText)findViewById(R.id.input_form_3)).getText().toString();
        int input_4 = Integer.parseInt(input_4_str);

        // 取得：目前已有退休金
        String input_5_str = ((EditText)findViewById(R.id.input_form_4)).getText().toString();
        int input_5 = Integer.parseInt(input_5_str);

        // 取得：每月投資金額
        String input_6_str = ((EditText)findViewById(R.id.input_form_5)).getText().toString();
        int input_6 = Integer.parseInt(input_6_str);

        // 取得：spinner-我可承受的風險範圍
        String input_7 = ((Spinner)findViewById(R.id.spinner_2)).getSelectedItem().toString();

        // 取得：預期報酬率
        String input_8_str = ((EditText)findViewById(R.id.input_form_6)).getText().toString();
        Float input_8 = Float.parseFloat(input_8_str) * 0.01f;

        // Make 預期報酬率 be suitable to 我可承受的風險範圍 and 1%~15%
        if ((input_8 < 0.01f) || (input_8 > 0.15f)){
            if(input_7 == "積極型"){
                input_8 = 0.1f;
            }
            else if(input_7 == "穩健型"){
                input_8 = 0.07f;
            }
            else if(input_7 == "保守型"){
                input_8 = 0.05f;
            }
            else{ // input_7 == "我不知道"
                input_8 = 0.07f;
            }
        }
        final Float input_8_final = input_8;

        return new Object[] { input_1, input_2, input_3, input_4, input_5, input_6, input_7, input_8_final };
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(want_to_retire.this,lifestage_calc.class));
        return super.onOptionsItemSelected(item);
    }
}