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

public class buy_house extends AppCompatActivity {

    private ArrayAdapter<String> adapter;
    private Spinner house_location;
    private static final String[] location_list = {"想買在哪個縣市呢？", "臺北市", "新北市", "基隆市", "桃園市", "新竹市", "新竹縣", "苗栗縣", "臺中市", "彰化縣", "南投縣", "雲林縣", "嘉義市", "嘉義縣", "臺南市", "高雄市", "屏東縣", "宜蘭縣", "花蓮縣", "臺東縣", "澎湖縣", "連江縣", "金門縣"};
    private Spinner risk_range;
    private static final String[] risk_range_list = {"我可承受的風險範圍", "積極型", "穩健型", "保守型", "我不知道"};

    private ImageView go_back_button;
    private TextView next_page_button_text;
    private View next_page_button_rectangle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_house);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        house_location = (Spinner) findViewById(R.id.spinner_1);
        adapter = new ArrayAdapter<String>(buy_house.this, R.layout.my_spinner_style, location_list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        house_location.setAdapter(adapter);

        risk_range = (Spinner) findViewById(R.id.spinner_2);
        adapter = new ArrayAdapter<String>(buy_house.this, R.layout.my_spinner_style, risk_range_list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        risk_range.setAdapter(adapter);

        next_page_button_text = (TextView) findViewById(R.id.text_3);
        next_page_button_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object[] inputs = getIntentValues();
                Intent intent = new Intent(buy_house.this, preview_building_tree.class);
                intent.putExtra("input_1", (int)inputs[0]);
                intent.putExtra("input_2", (String)inputs[1]);
                intent.putExtra("input_3", (int)inputs[2]);
                intent.putExtra("input_4", (int)inputs[3]);
                intent.putExtra("input_5", (String)inputs[4]);
                intent.putExtra("input_6", (Float)inputs[5]);
                startActivity(intent);
            }
        });

        next_page_button_rectangle = (View) findViewById(R.id.rectangle_small_3);
        next_page_button_rectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object[] inputs = getIntentValues();
                Intent intent = new Intent(buy_house.this, preview_building_tree.class);
                intent.putExtra("input_1", (int)inputs[0]);
                intent.putExtra("input_2", (String)inputs[1]);
                intent.putExtra("input_3", (int)inputs[2]);
                intent.putExtra("input_4", (int)inputs[3]);
                intent.putExtra("input_5", (String)inputs[4]);
                intent.putExtra("input_6", (Float)inputs[5]);
                startActivity(intent);
            }
        });
/*
        go_back_button = (ImageView) findViewById(R.id.返回鍵_image);
        go_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(buy_house.this, lifestage_calc.class);
                startActivity(intent);
            }
        });
*/
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(buy_house.this,lifestage_calc.class));
        return super.onOptionsItemSelected(item);
    }

    private Object[] getIntentValues(){
        // 取得：預計幾年後買屋呢？
        String input_1_str = ((EditText)findViewById(R.id.input_form_1)).getText().toString();
        int input_1 = Integer.parseInt(input_1_str);

        // 取得：spinner-想買在哪個縣市呢？
        String input_2 = ((Spinner)findViewById(R.id.spinner_1)).getSelectedItem().toString();

        // 取得：預估房屋價格？
        String input_3_str = ((EditText)findViewById(R.id.input_form_3)).getText().toString();
        int input_3 = Integer.parseInt(input_3_str);

        // 取得：已有多少自備款？
        String input_4_str = ((EditText)findViewById(R.id.input_form_4)).getText().toString();
        int input_4 = Integer.parseInt(input_4_str);

        // 取得：spinner-我可承受的風險範圍
        String input_5 = ((Spinner)findViewById(R.id.spinner_2)).getSelectedItem().toString();

        // 取得：預期報酬率
        String input_6_str = ((EditText)findViewById(R.id.input_form_5)).getText().toString();
        Float input_6 = Float.parseFloat(input_6_str) * 0.01f;

        // Make 預期報酬率 be suitable to 我可承受的風險範圍 and 1%~15%
        if ((input_6 < 0.01f) || (input_6 > 0.15f)){
            if(input_5 == "積極型"){
                input_6 = 0.1f;
            }
            else if(input_5 == "穩健型"){
                input_6 = 0.07f;
            }
            else if(input_5 == "保守型"){
                input_6 = 0.05f;
            }
            else{ // input_5 == "我不知道"
                input_6 = 0.07f;
            }
        }
        final Float input_6_final = input_6;

        return new Object[] { input_1, input_2, input_3, input_4, input_5, input_6_final };
    }
}