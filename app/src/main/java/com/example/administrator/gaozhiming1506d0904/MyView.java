package com.example.administrator.gaozhiming1506d0904;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/9/4 0004.
 */

public class MyView extends View{



    private int roundColor;
    private int roundProgressColor;
    private float roundWidth;
    private float pointWidth;
    private int padding;
    private int digree = 0;

    private Paint paint;

    public MyView(Context context) {
        super(context);
        init(null, 0);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public MyView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        paint = new Paint();
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.RoundProgressBarView, defStyle, 0);
        roundWidth = a.getDimension(R.styleable.RoundProgressBarView_roundWidth,20);
        pointWidth = a.getDimension(R.styleable.RoundProgressBarView_pointWidth,10);
        padding = (int)a.getDimension(R.styleable.RoundProgressBarView_padding,10);
        digree = a.getInt(R.styleable.RoundProgressBarView_digree,0);
        roundColor = a.getColor(R.styleable.RoundProgressBarView_roundColor, Color.RED);
        roundProgressColor = a.getColor(R.styleable.RoundProgressBarView_roundProgressColor,Color.GREEN);
        a.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int centre = getWidth()/2;
        int radius = (int)(centre-roundWidth/2)-padding;
        paint.setColor(roundColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(roundWidth);
        paint.setAntiAlias(true);
        paint.setAlpha(180);
        canvas.drawCircle(centre, centre, radius, paint);

        if (digree > 360)
            digree = 0;
        else if(digree>335)
            digree +=3;
        else if(digree>305)
            digree+=2;
        else if(digree >270)
            digree +=1;
        else if(digree>225)
            digree +=3;
        else if(digree >180)
            digree +=4;
        else if(digree>135 )
            digree +=7;
        else if(digree >90)
            digree +=10;
        else if(digree>45)
            digree +=10;
        else
            digree +=7;
        int x1,y1;
        x1 =(int)(centre+radius*Math.cos(digree*Math.PI/180));
        y1 = (int)(centre+radius*Math.sin(digree*Math.PI/180));
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(roundProgressColor);
        paint.setAlpha(255);
        canvas.drawCircle(x1, y1, roundWidth+pointWidth, paint);
        invalidate();
    }
}
