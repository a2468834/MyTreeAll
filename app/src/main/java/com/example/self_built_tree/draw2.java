package com.example.self_built_tree;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class draw2 extends View {

    public draw2(Context context) {
        super(context);
    }

    public draw2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public draw2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        final Paint paint = new Paint();
        final Paint paint_2 = new Paint();
        final Paint paint_3 = new Paint();
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
        int space = 30;
        int thick = 100;
        int weight = 50;
        int y = thick;
        int dislike = 200,soso = 450,like= 650;


        canvas.drawRoundRect(x, x, weight, dislike,20f,20f, paint);

        canvas.drawRoundRect(x, dislike+space, weight, dislike+space+soso,20f,20f, paint_2);

        canvas.drawRoundRect(x, dislike+space*2+soso, weight, dislike+space*2+soso+like,20f,20f, paint_3);



    }

}