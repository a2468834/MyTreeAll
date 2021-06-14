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

import com.anychart.APIlib;
import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;

import java.util.ArrayList;
import java.util.List;

public class average extends AppCompatActivity {
    private AnyChartView chart1,chart2;
    private String[] month ={"食物","課業","娛樂","生活必需品"};
    private int[] earning = {500,800,2000,1000};
    private TextView warning;
    private Button Return;
    private String[] month2 ={"食物","課業","娛樂"};
    private int[] earning2 = {500,550,2000};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.average);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        chart1 = findViewById(R.id.chart1);
        APIlib.getInstance().setActiveAnyChartView(chart1);
        Pie pie1 = AnyChart.pie();
        List<DataEntry> dataEntries = new ArrayList<>();
        for (int i = 0;i<month.length;i++)
        {
            dataEntries.add(new ValueDataEntry(month[i],earning[i]));
        }
        pie1.data(dataEntries);
        pie1.title("2020年4月-2021年4月");

        chart1.setChart(pie1);
//        APIlib.getInstance().setActiveAnyChartView(chart1);

        chart2 = findViewById(R.id.chart2);
        APIlib.getInstance().setActiveAnyChartView(chart2);
        Pie pie2 = AnyChart.pie();
        List<DataEntry> dataEntries2 = new ArrayList<>();
        for (int i = 0;i<month2.length;i++)
        {
            dataEntries2.add(new ValueDataEntry(month2[i],earning2[i]));
        }
        pie2.data(dataEntries2);
        pie2.title("2021年5月");
//        APIlib.getInstance().setActiveAnyChartView(chart2);
        chart2.setChart(pie2);


        Return = (Button)findViewById(R.id.btnreturn);
        Return.setOnClickListener(btnReturn);
        warning = (TextView)findViewById(R.id.textView);
        warning.setText("1.生活吃太好囉，可以減少飲食費\n2.這個月課業項目比之前多5%\n3.沒有生活用品開銷");
    }
    public void setupPieChart(){
        Pie pie1 = AnyChart.pie();
        List<DataEntry> dataEntries = new ArrayList<>();
        for (int i = 0;i<month.length;i++)
        {
            dataEntries.add(new ValueDataEntry(month[i],earning[i]));
        }
        pie1.data(dataEntries);
        pie1.title("2020年4月-2021年4月");
        chart1.setChart(pie1);
    }

    public void setupPieChart2(){
        Pie pie = AnyChart.pie();
        Pie pie2 = AnyChart.pie();

        List<DataEntry> dataEntries = new ArrayList<>();
        for (int i = 0;i<month.length;i++)
        {
            dataEntries.add(new ValueDataEntry(month[i],earning[i]));
        }

        List<DataEntry> dataEntries2 = new ArrayList<>();
        for (int i = 0;i<month2.length;i++)
        {
            dataEntries2.add(new ValueDataEntry(month2[i],earning2[i]));
        }

        pie.data(dataEntries);
        pie2.data(dataEntries2);

        pie.title("2020年4月-2021年4月");
        pie2.title("2021年5月");
        chart1.setChart(pie);
        chart2.setChart(pie2);
    }

    private Button.OnClickListener btnReturn = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent it = new Intent();
            it.setClass(average.this, record.class);
            startActivity(it);
            finish();
        }
    };
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(average.this,record.class));
        return super.onOptionsItemSelected(item);
    }


}