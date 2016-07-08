/*
package com.rash1k.moneyflow.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.rash1k.moneyflow.R;

public class RoundChart extends SurfaceView {
    private static final String LOG_TAG = "myLogRound";
    //    private Random r = new Random();

    private static int MY_DIAMETER;
    private SurfaceHolder surfaceHolder;

    RectF rect;
    Paint paint;
    private float current;
    private float plan;
    private int anglePercent;
    private float angleValue;
    Canvas canvas;


    public RoundChart(Context context) {
        super(context);
        init();
    }

    public RoundChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RoundChart(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            Log.d(LOG_TAG, "handleMessage: " + msg.what);

//            drawCircleWithPercent(canvas,35);
        }
    };

    private void init() {

        AnimatePercentThread animatePercentThread = new AnimatePercentThread(35);

        animatePercentThread.start();

        surfaceHolder = getHolder();
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {

            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });

    }

    private void drawCircleWithPercent(Canvas canvas,int what) {
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

//        canvas.drawArc(rect, 270L, angle, true, paint);

        paint.setColor(Color.WHITE);

//        canvas.drawCircle(MY_DIAMETER / 2, MY_DIAMETER / 2, MY_DIAMETER / 3, paint);

        paint.setColor(Color.BLACK);

        paint.setTextSize(MY_DIAMETER / 5);

        setAnglePercent(25);

        float textWidth = (int) paint.measureText(anglePercent + "%");

        Log.d(LOG_TAG, "onDraw: " + textWidth);

        canvas.drawText(anglePercent + "%", (MY_DIAMETER - textWidth) / 2, (MY_DIAMETER / 2) + MY_DIAMETER / 10 - MY_DIAMETER / 55, paint);

    }


    public void setAnglePercent(int anglePercent) {
        this.anglePercent = anglePercent;
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

    public void setValues(int percent) {

        this.anglePercent = anglePercent;
        angleValue = percent * 3.6F;
        draw(new Canvas());
    }

    private class AnimatePercentThread extends Thread {

        private float roundPercent;
        private RectF rectF;
        private Canvas canvas;
        private Paint paint;

        public AnimatePercentThread(float roundPercent) {
            this.roundPercent = roundPercent;
        }

        @Override
        public void run() {
            int currentAngle = 0;

            while (currentAngle < roundPercent) {
                try {
                    Thread.sleep(16);
                    currentAngle++;

//                    handler.sendEmptyMessage(currentAngle);

                    Canvas canvas = getHolder().lockCanvas();

                    if (canvas != null) {
                        drawCircleWithPercent(canvas,35);
                    }

//                    canvas.drawArc(rectF, 270, currentAngle, true, paint);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

*/
