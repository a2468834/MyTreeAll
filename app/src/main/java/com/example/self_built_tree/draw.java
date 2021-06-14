package com.example.self_built_tree;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class draw extends View {
    private final int paintColor = Color.RED;
    public draw(Context context) {
        super(context);
    }

    public draw(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public draw(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        final Paint paint = new Paint();
        final Paint paint_2 = new Paint();
        final Paint paint_3 = new Paint();

        canvas.drawColor(Color.BLUE);

        paint.setAntiAlias(true);                       //设置画笔为无锯齿
        paint.setColor(Color.GREEN);                    //设置画笔颜色
        canvas.drawColor(Color.WHITE);                  //白色背景
        paint.setStrokeWidth((float) 3.0);              //线宽
        paint.setStyle(Paint.Style.FILL);

        paint_2.setAntiAlias(true);                       //设置画笔为无锯齿
        paint_2.setColor(Color.BLUE);                    //设置画笔颜色
        canvas.drawColor(Color.WHITE);                  //白色背景
        paint_2.setStrokeWidth((float) 3.0);              //线宽
        paint_2.setStyle(Paint.Style.FILL);

        paint_3.setAntiAlias(true);                       //设置画笔为无锯齿
        paint_3.setColor(Color.YELLOW);                    //设置画笔颜色
        canvas.drawColor(Color.WHITE);                  //白色背景
        paint_3.setStrokeWidth((float) 3.0);              //线宽
        paint_3.setStyle(Paint.Style.FILL);
        int x = 0;

        int space = 93;
        int thick = 50;
        int y = thick;
        int eight_1 = 200,seven_1 = 180,six_1= 250,five_1 = 300,four_1 = 280,three_1 = 220;
        int eight_2 = eight_1+250,seven_2 = seven_1+200,six_2= six_1+180,five_2 = five_1+220,four_2 = four_1+200,three_2 = three_1 + 220;
        int eight_3 = eight_2+150,seven_3 = seven_2+220,six_3= six_2+170,five_3 = five_2+80,four_3 = four_2+120,three_3 = three_2 + 160;

        canvas.drawRoundRect(0, x, eight_1, y,20f,20f, paint);
        canvas.drawRoundRect(0, y+space, seven_1, y+space+thick, 20f, 20f, paint);
        canvas.drawRoundRect(0, y+space*2+thick, six_1, y+space*2+thick*2, 20f, 20f, paint);
        canvas.drawRoundRect(0, y+space*3+thick*2, five_1, y+space*3+thick*3, 20f, 20f, paint);
        canvas.drawRoundRect(0, y+space*4+thick*3, four_1, y+space*4+thick*4, 20f, 20f, paint);
        canvas.drawRoundRect(0, y+space*5+thick*4, three_1, y+space*5+thick*5, 20f, 20f, paint);

        canvas.drawRoundRect(eight_1, x, eight_2, y,20f,20f, paint_2);
        canvas.drawRoundRect(seven_1, y+space, seven_2, y+space+thick, 20f, 20f, paint_2);
        canvas.drawRoundRect(six_1, y+space*2+thick, six_2, y+space*2+thick*2, 20f, 20f, paint_2);
        canvas.drawRoundRect(five_1, y+space*3+thick*2, five_2, y+space*3+thick*3, 20f, 20f, paint_2);
        canvas.drawRoundRect(four_1, y+space*4+thick*3, four_2, y+space*4+thick*4, 20f, 20f, paint_2);
        canvas.drawRoundRect(three_1, y+space*5+thick*4, three_2, y+space*5+thick*5, 20f, 20f, paint_2);

        canvas.drawRoundRect(eight_2, x, eight_3, y,20f,20f, paint_3);
        canvas.drawRoundRect(seven_2, y+space, seven_3, y+space+thick, 20f, 20f, paint_3);
        canvas.drawRoundRect(six_2, y+space*2+thick, six_3, y+space*2+thick*2, 20f, 20f, paint_3);
        canvas.drawRoundRect(five_2, y+space*3+thick*2, five_3, y+space*3+thick*3, 20f, 20f, paint_3);
        canvas.drawRoundRect(four_2, y+space*4+thick*3, four_3, y+space*4+thick*4, 20f, 20f, paint_3);
        canvas.drawRoundRect(three_2, y+space*5+thick*4, three_3, y+space*5+thick*5, 20f, 20f, paint_3);


    }

}