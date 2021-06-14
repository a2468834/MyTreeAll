package com.example.self_built_tree;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;

import java.util.ArrayList;
import java.util.List;

public class secondpage extends AppCompatActivity {
    private AnyChartView chart;
    private String[] month ={"LIKE","SOSO","DISLIKE"};
    private TextView warning;


    private int[] earning = {500,800,2000};
    private Button Return,feeling,classes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondpage);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        chart = findViewById(R.id.chart);

        Return = (Button)findViewById(R.id.btnreturn);
        Return.setOnClickListener(btnReturn);
        feeling = (Button)findViewById(R.id.feeling);
        feeling.setOnClickListener(btnfeeling);
        classes = (Button)findViewById(R.id.classes);
        classes.setOnClickListener(btnclasses);

        setupPieChart();
        warning = (TextView)findViewById(R.id.warning);
        warning.setText("1.生活吃太好囉\n可以減少飲食費\n2.這個月課業項目比之前多5%");
    }
    public void setupPieChart(){
        Pie pie = AnyChart.pie();
        List<DataEntry> dataEntries = new ArrayList<>();
        for (int i = 0;i<month.length;i++)
        {
            dataEntries.add(new ValueDataEntry(month[i],earning[i]));
        }
        pie.data(dataEntries);
        //pie.title("Earning");
        chart.setChart(pie);
    }

    private Button.OnClickListener btnReturn = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent it = new Intent();
            it.setClass(secondpage.this, record.class);
            startActivity(it);
            finish();
        }
    };
    private Button.OnClickListener btnfeeling = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent it = new Intent();
            it.setClass(secondpage.this, secondpage.class);
            startActivity(it);
            finish();
        }
    };
    private Button.OnClickListener btnclasses = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent it = new Intent();
            it.setClass(secondpage.this, classes.class);
            startActivity(it);
            finish();
        }
    };
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(secondpage.this,record.class));
        return super.onOptionsItemSelected(item);
    }

}