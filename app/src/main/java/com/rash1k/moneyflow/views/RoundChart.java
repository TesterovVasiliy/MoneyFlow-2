package com.rash1k.moneyflow.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.rash1k.moneyflow.R;

public class RoundChart extends View {
    private static final String LOG_TAG = "myLogRound";
    //    private Random r = new Random();

    private static int MY_DIAMETER;

    RectF rect;
    Paint paint;
    private float current;
    private float plan;
    private int anglePercent;
    private float angleValue;

    public void setAnglePercent(int anglePercent) {
        this.anglePercent = anglePercent;
    }


    public RoundChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        setBackgroundColor(Color.RED);
        //        canvas.drawColor(color)
//        int color = Color.rgb(r.nextInt(256), r.nextInt(256), r.nextInt(256));

        int colorCurrent = 1;
        int colorPlan = 1;
        rect = new RectF(0L, 0L, MY_DIAMETER, MY_DIAMETER);
        paint = new Paint();
        if (current < plan) {
            colorPlan = getResources().getColor(R.color.colorDarkGreen);
            colorCurrent = getResources().getColor(R.color.colorLightGreen);
        } else if (current == plan) {
            colorCurrent = getResources().getColor(R.color.colorDarkGreen);
            colorPlan = getResources().getColor(R.color.colorDarkGreen);
        } else if (current > plan) {
            colorPlan = getResources().getColor(R.color.colorDarkRed);
            colorCurrent = getResources().getColor(R.color.colorLightRed);
        }

        paint.setColor(colorPlan);
        canvas.drawArc(rect, 0L, 360L, true, paint);

        paint.setColor(colorCurrent);

        float angle = current * 360 / plan;

        canvas.drawArc(rect, 270L, angle, true, paint);

        paint.setColor(Color.WHITE);

//        canvas.drawCircle(MY_DIAMETER / 2, MY_DIAMETER / 2, MY_DIAMETER / 3, paint);

        paint.setColor(Color.BLACK);

        paint.setTextSize(MY_DIAMETER / 5);

        setAnglePercent(25);

        float textWidth = (int) paint.measureText(anglePercent + "%");

        Log.d(LOG_TAG, "onDraw: " + textWidth);

        canvas.drawText(anglePercent + "%", (MY_DIAMETER - textWidth) / 2, (MY_DIAMETER / 2) + MY_DIAMETER / 10 - MY_DIAMETER / 55, paint);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        MY_DIAMETER = getMeasuredHeight() / 3;

        setMeasuredDimension(MY_DIAMETER, MY_DIAMETER * 2);

    }

    public void setValues(int plan, int current) {
        this.plan = plan;
        this.current = current;

        angleValue = current * 360 / plan;

        draw(new Canvas());
    }

    public void setValues(int anglePercent) {

        this.anglePercent = anglePercent;
        angleValue = anglePercent * 3.6F;
        draw(new Canvas());
    }


}

