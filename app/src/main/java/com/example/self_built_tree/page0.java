package com.example.self_built_tree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class page0 extends AppCompatActivity {

    Button suggestionLink_btn;
    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page0);

        name = (TextView) findViewById((R.id.estimate_tree_title));
        name.setText(data.name_tree.toString()+"小樹苗");

    }
    public void browser1(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.cathaybk.com.tw/cathaybk/personal/investment/fund/fund-information/detail/?a=2&b=MST22-00580030"));
        startActivity(browserIntent);
    }
}