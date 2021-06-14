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
import com.anychart.charts.Cartesian;
import com.anychart.charts.LinearGauge;
import com.anychart.charts.Pie;
import com.anychart.core.polar.series.Line;

import java.util.ArrayList;
import java.util.List;

public class classes extends AppCompatActivity {
    private AnyChartView chart,line;
    private String[] month ={"食物","課業","娛樂"};
    private TextView warning;


    private int[] earning = {500,800,2000};
    private Button Return,feeling,classes,average;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.classes);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        chart = findViewById(R.id.chart);

        Return = (Button)findViewById(R.id.btnreturn);
        Return.setOnClickListener(btnReturn);
        feeling = (Button)findViewById(R.id.feeling);
        feeling.setOnClickListener(btnfeeling);
        classes = (Button)findViewById(R.id.classes);
        classes.setOnClickListener(btnclasses);
        average = (Button)findViewById(R.id.average);
        average.setOnClickListener(btnaverage);

        setupPieChart();
        warning = (TextView)findViewById(R.id.warning);
        warning.setText("1.生活吃太好囉，可以減少飲食費\n2.這個月課業項目比之前多5%");
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
            it.setClass(classes.this, record.class);
            startActivity(it);
            finish();
        }
    };
    private Button.OnClickListener btnfeeling = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent it = new Intent();
            it.setClass(classes.this, secondpage.class);
            startActivity(it);
            finish();
        }
    };
    private Button.OnClickListener btnclasses = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent it = new Intent();
            it.setClass(classes.this, classes.class);
            startActivity(it);
            finish();
        }
    };
    private Button.OnClickListener btnaverage = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent it = new Intent();
            it.setClass(classes.this, average.class);
            startActivity(it);
            finish();
        }
    };
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(classes.this,record.class));
        return super.onOptionsItemSelected(item);
    }

}
