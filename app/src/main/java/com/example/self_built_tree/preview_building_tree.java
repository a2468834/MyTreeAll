package com.example.self_built_tree;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

/*import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;*/

import java.util.ArrayList;

public class preview_building_tree extends AppCompatActivity {

    private TextView test_textview;
    private Bundle intent_bundle;

    private ImageView go_back_button;
    private TextView next_page_button_text;
    private View next_page_button_rectangle;

    // 分頁：機會投資
    private View left_tab_rectangle;
    private TextView left_tab_text;
    // 分頁：現金
    private View middle_tab_rectangle;
    private TextView middle_tab_text;
    // 分頁：保值
    private View right_tab_rectangle;
    private TextView right_tab_text;

    private TextView text_view_1;
    private TextView text_view_2;
    private TextView text_view_3;
    private View rectangle_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_building_tree);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        drawPieChart();

//        go_back_button = (ImageView) findViewById(R.id.返回鍵_image);
//        go_back_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(preview_building_tree.this, lifestage_calc.class);
//                startActivity(intent);
//            }
//        });

        next_page_button_text = (TextView) findViewById(R.id.text_3);
        next_page_button_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(preview_building_tree.this, page1.class);
                startActivity(intent);
            }
        });

        next_page_button_rectangle = (View) findViewById(R.id.rectangle_small);
        next_page_button_rectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(preview_building_tree.this, page1.class);
                startActivity(intent);
            }
        });

        left_tab_rectangle = (View) findViewById(R.id.rectangle_small_機會投資);
        left_tab_rectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rectangle_view = findViewById(R.id.rectangle_large_機會投資);
                text_view_1 = findViewById(R.id.說明_機會投資_text_1);
                text_view_2 = findViewById(R.id.說明_機會投資_text_2);
                text_view_3 = findViewById(R.id.說明_機會投資_text_3);
                rectangle_view.bringToFront();
                text_view_1.bringToFront();
                text_view_2.bringToFront();
                text_view_3.bringToFront();
            }
        });

        left_tab_text = (TextView) findViewById(R.id.機會投資_text);
        left_tab_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rectangle_view = findViewById(R.id.rectangle_large_機會投資);
                text_view_1 = findViewById(R.id.說明_機會投資_text_1);
                text_view_2 = findViewById(R.id.說明_機會投資_text_2);
                text_view_3 = findViewById(R.id.說明_機會投資_text_3);
                rectangle_view.bringToFront();
                text_view_1.bringToFront();
                text_view_2.bringToFront();
                text_view_3.bringToFront();
            }
        });

        middle_tab_rectangle = (View) findViewById(R.id.rectangle_small_現金);
        middle_tab_rectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rectangle_view = findViewById(R.id.rectangle_large_現金);
                text_view_1 = findViewById(R.id.說明_現金_text_1);
                rectangle_view.bringToFront();
                text_view_1.bringToFront();
            }
        });

        middle_tab_text = (TextView) findViewById(R.id.現金_text);
        middle_tab_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rectangle_view = findViewById(R.id.rectangle_large_現金);
                text_view_1 = findViewById(R.id.說明_現金_text_1);
                rectangle_view.bringToFront();
                text_view_1.bringToFront();
            }
        });

        right_tab_rectangle = (View) findViewById(R.id.rectangle_small_保值);
        right_tab_rectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rectangle_view = findViewById(R.id.rectangle_large_保值);
                text_view_1 = findViewById(R.id.說明_保值_text_1);
                text_view_2 = findViewById(R.id.說明_保值_text_2);
                text_view_3 = findViewById(R.id.說明_保值_text_3);
                rectangle_view.bringToFront();
                text_view_1.bringToFront();
                text_view_2.bringToFront();
                text_view_3.bringToFront();
            }
        });

        right_tab_text = (TextView) findViewById(R.id.保值_text);
        right_tab_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rectangle_view = findViewById(R.id.rectangle_large_保值);
                text_view_1 = findViewById(R.id.說明_保值_text_1);
                text_view_2 = findViewById(R.id.說明_保值_text_2);
                text_view_3 = findViewById(R.id.說明_保值_text_3);
                rectangle_view.bringToFront();
                text_view_1.bringToFront();
                text_view_2.bringToFront();
                text_view_3.bringToFront();
            }
        });
/*
        String test_log_str = "";
        intent_bundle = getIntent().getExtras();

        if(intent_bundle != null){
            for(String key : intent_bundle.keySet()){
                test_log_str += intent_bundle.get(key) != null ? intent_bundle.get(key) : "";
                test_log_str += "\n";
            }
        }

        test_textview = (TextView) findViewById(R.id.test_log_text);
        test_textview.setText(test_log_str);
*/
    }

    private void drawPieChart(){
        /*PieChart pie_chart_view;
        pie_chart_view = findViewById(R.id.pie_chart);

        ArrayList<PieEntry> pie_chart_entries = new ArrayList<>();
        pie_chart_entries.add(new PieEntry(55f, "機會投資%"));
        pie_chart_entries.add(new PieEntry(5f, "現金%"));
        pie_chart_entries.add(new PieEntry(35f, "保值%"));

        PieDataSet data_set = new PieDataSet(pie_chart_entries, null);
        data_set.setColors(new int[]{Color.rgb(94, 198, 147), Color.rgb(254, 144, 19), Color.rgb(61, 179, 233)});
        data_set.setValueTextSize(17f);
        data_set.setValueTextColor(Color.BLACK);
        data_set.setValueTypeface(Typeface.DEFAULT_BOLD);
        data_set.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        data_set.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        data_set.setValueLinePart1OffsetPercentage(100f);
        data_set.setValueLinePart1Length(0.6f);
        data_set.setValueLinePart2Length(0.6f);

        Legend chart_legend = pie_chart_view.getLegend();
        chart_legend.setEnabled(false);
        //chart_legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        //chart_legend.setVerticalAlignment(Legend.LegendVerticalAlignment.CENTER);
        //chart_legend.setTextSize(14f);
        //chart_legend.setDrawInside(true);
        //chart_legend.setXEntrySpace(40f);

        pie_chart_view.getDescription().setEnabled(false);
        pie_chart_view.setData(new PieData(data_set));
        pie_chart_view.setDrawHoleEnabled(false);
        //pie_chart_view.setDrawEntryLabels(false);
        pie_chart_view.setEntryLabelColor(Color.BLACK);
        pie_chart_view.setEntryLabelTextSize(14f);
        pie_chart_view.setExtraTopOffset(6f);
        pie_chart_view.setExtraBottomOffset(4f);*/
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(preview_building_tree.this,lifestage_calc.class));
        return super.onOptionsItemSelected(item);
    }
}