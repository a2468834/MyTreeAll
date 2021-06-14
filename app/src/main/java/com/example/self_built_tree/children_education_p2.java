package com.example.self_built_tree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class children_education_p2 extends AppCompatActivity {

    private ArrayAdapter<String> adapter;
    private Spinner children_edu_stage;
    private static final String[] edu_stage_list = {"教育階段", "公立", "私立", "已畢業"};

    private TextView subtitle_textview;
    private Bundle intent_bundle;

    private ImageView go_back_button;
    private TextView button_text;
    private View button_rectangle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_children_education_p2);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        children_edu_stage = (Spinner) findViewById(R.id.spinner_幼兒園);
        adapter = new ArrayAdapter<String>(children_education_p2.this, R.layout.my_spinner_style, edu_stage_list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        children_edu_stage.setAdapter(adapter);

        children_edu_stage = (Spinner) findViewById(R.id.spinner_國小);
        adapter = new ArrayAdapter<String>(children_education_p2.this, R.layout.my_spinner_style, edu_stage_list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        children_edu_stage.setAdapter(adapter);

        children_edu_stage = (Spinner) findViewById(R.id.spinner_國中);
        adapter = new ArrayAdapter<String>(children_education_p2.this, R.layout.my_spinner_style, edu_stage_list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        children_edu_stage.setAdapter(adapter);

        intent_bundle = getIntent().getExtras();
        //你(預計)有 2 位小孩，分別為 ${child_1_age} 歲、${child_2_age} 歲\n系統將自動帶入部分數值，您可以實際情況做修改。
        String subtitle_str = "你(預計)有 2 位小孩，分別為";
        subtitle_str += " " + intent_bundle.get("child_1_age").toString() + " ";
        subtitle_str += "歲、";
        subtitle_str += intent_bundle.get("child_2_age").toString() + " 歲\n系統將自動帶入部分數值，您可以實際情況做修改。";

        subtitle_textview = (TextView) findViewById(R.id.子標題_text);
        subtitle_textview.setText(subtitle_str);

        button_text = (TextView) findViewById(R.id.text_3);
        button_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object[] inputs = getIntentValues();
                Intent intent = new Intent(children_education_p2.this, preview_building_tree.class);
                intent.putExtra("input_1", (String) inputs[0]);
                intent.putExtra("input_2", (int)inputs[1]);
                intent.putExtra("input_3", (int)inputs[2]);
                intent.putExtra("input_4", (String) inputs[3]);
                intent.putExtra("input_5", (int)inputs[4]);
                intent.putExtra("input_6", (int)inputs[5]);
                intent.putExtra("input_7", (String) inputs[6]);
                intent.putExtra("input_8", (int)inputs[7]);
                intent.putExtra("input_9", (int)inputs[8]);
                startActivity(intent);
            }
        });

        button_rectangle = (View) findViewById(R.id.rectangle_small_3);
        button_rectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object[] inputs = getIntentValues();
                Intent intent = new Intent(children_education_p2.this, preview_building_tree.class);
                intent.putExtra("input_1", (String) inputs[0]);
                intent.putExtra("input_2", (int)inputs[1]);
                intent.putExtra("input_3", (int)inputs[2]);
                intent.putExtra("input_4", (String) inputs[3]);
                intent.putExtra("input_5", (int)inputs[4]);
                intent.putExtra("input_6", (int)inputs[5]);
                intent.putExtra("input_7", (String) inputs[6]);
                intent.putExtra("input_8", (int)inputs[7]);
                intent.putExtra("input_9", (int)inputs[8]);
                startActivity(intent);
            }
        });

//        go_back_button = (ImageView) findViewById(R.id.返回鍵_image);
//        go_back_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(children_education_p2.this, children_education_p1.class);
//                startActivity(intent);
//            }
//        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(children_education_p2.this,lifestage_calc.class));
        return super.onOptionsItemSelected(item);
    }

    private Object[] getIntentValues(){
        // 幼兒園
        // 取得：spinner-教育狀態
        String input_1 = ((Spinner)findViewById(R.id.spinner_幼兒園)).getSelectedItem().toString();

        // 取得：就讀人數
        String input_2_str = ((EditText)findViewById(R.id.input_form_幼兒園_1)).getText().toString();
        int input_2 = Integer.parseInt(input_2_str);

        // 取得：預估金額
        String input_3_str = ((EditText)findViewById(R.id.input_form_幼兒園_2)).getText().toString();
        int input_3 = Integer.parseInt(input_3_str);

        // 國小
        // 取得：spinner-教育狀態
        String input_4 = ((Spinner)findViewById(R.id.spinner_國小)).getSelectedItem().toString();

        // 取得：就讀人數
        String input_5_str = ((EditText)findViewById(R.id.input_form_國小_1)).getText().toString();
        int input_5 = Integer.parseInt(input_5_str);

        // 取得：預估金額
        String input_6_str = ((EditText)findViewById(R.id.input_form_國小_2)).getText().toString();
        int input_6 = Integer.parseInt(input_6_str);

        // 國中
        // 取得：spinner-教育狀態
        String input_7 = ((Spinner)findViewById(R.id.spinner_國中)).getSelectedItem().toString();

        // 取得：就讀人數
        String input_8_str = ((EditText)findViewById(R.id.input_form_國中_1)).getText().toString();
        int input_8 = Integer.parseInt(input_8_str);

        // 取得：預估金額
        String input_9_str = ((EditText)findViewById(R.id.input_form_國中_2)).getText().toString();
        int input_9 = Integer.parseInt(input_9_str);

        return new Object[] { input_1, input_2, input_3, input_4, input_5, input_6, input_7, input_8, input_9 };
    }
}