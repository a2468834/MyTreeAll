package com.example.self_built_tree;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Line;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.Anchor;
import com.anychart.enums.MarkerType;
import com.anychart.enums.TooltipPositionMode;
import com.anychart.graphics.vector.Stroke;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class tree_details extends AppCompatActivity {

    // grab data
    TextView input, goal, name, detail_finishDate;
    int autoInput = data.autoInput_amount;
    int goal_amount = data.goal_amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tree_details);

        // go back button
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        name = (TextView) findViewById((R.id.detail_treeName));
        input = (TextView) findViewById((R.id.detail_autoInput));
        goal = (TextView) findViewById((R.id.detail_goal));
        detail_finishDate = (TextView) findViewById((R.id.detail_finishDate));
        name.setText(data.name_tree.toString());
        input.setText( Integer.toString(autoInput));
        goal.setText(Integer.toString(goal_amount));
        detail_finishDate.setText("2021/07");

        // plot chart
        AnyChartView anyChartView = findViewById(R.id.any_chart_view);
        //anyChartView.setProgressBar(findViewById(R.id.progress_bar));

        Cartesian cartesian = AnyChart.line();

        cartesian.animation(true);

        cartesian.padding(10d, 20d, 5d, 20d);

        cartesian.crosshair().enabled(true);
        cartesian.crosshair()
                .yLabel(true)
                // TODO ystroke
                .yStroke((Stroke) null, null, null, (String) null, (String) null);

        cartesian.tooltip().positionMode(TooltipPositionMode.POINT);

        cartesian.title("小樹苗成長曲線");

        cartesian.yAxis(0).title("金額(千元)");
        cartesian.xAxis(0).labels().padding(5d, 5d, 5d, 5d);


        List<DataEntry> seriesData = new ArrayList<>();
        seriesData.add(new CustomDataEntry("1", 1, 1));
        seriesData.add(new CustomDataEntry("2", 1, 2));
        seriesData.add(new CustomDataEntry("3", 1, 3));
        seriesData.add(new CustomDataEntry("4", 1, 4));
        seriesData.add(new CustomDataEntry("5", 0.5, 4.5));
        seriesData.add(new CustomDataEntry("6", 2, 6.5));
        seriesData.add(new CustomDataEntry("7", 1, 7.5));
        seriesData.add(new CustomDataEntry("8", 1, 8.5));
        seriesData.add(new CustomDataEntry("9", 1, 9.5));
        seriesData.add(new CustomDataEntry("10", 3, 12.5));
        seriesData.add(new CustomDataEntry("11", 0, 12.5));
        seriesData.add(new CustomDataEntry("12", 0.5, 13));


        Set set = Set.instantiate();
        set.data(seriesData);
        Mapping series1Mapping = set.mapAs("{ x: 'x', value: 'value' }");
        Mapping series2Mapping = set.mapAs("{ x: 'x', value: 'value2' }");

        Line series1 = cartesian.line(series1Mapping);
        series1.name("當月存入");
        series1.hovered().markers().enabled(true);
        series1.hovered().markers()
                .type(MarkerType.CIRCLE)
                .size(4d);
        series1.tooltip()
                .position("right")
                .anchor(Anchor.LEFT_CENTER)
                .offsetX(5d)
                .offsetY(5d);

        Line series2 = cartesian.line(series2Mapping);
        series2.name("累積存入");
        series2.hovered().markers().enabled(true);
        series2.hovered().markers()
                .type(MarkerType.CIRCLE)
                .size(4d);
        series2.tooltip()
                .position("right")
                .anchor(Anchor.LEFT_CENTER)
                .offsetX(5d)
                .offsetY(5d);


        cartesian.legend().enabled(true);
        cartesian.legend().fontSize(13d);
        cartesian.legend().padding(0d, 0d, 10d, 0d);

        anyChartView.setChart(cartesian);

    }

    private class CustomDataEntry extends ValueDataEntry {
        
        int sum=0;

        CustomDataEntry(String x, Number value, Number value2) {
            super(x, value);
            //sum = sum + value.intValue();
            setValue("value2", value2);
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(tree_details.this,my_forest.class));
        return super.onOptionsItemSelected(item);
    }

}