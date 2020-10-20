package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class CustomView extends View {
    /*public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置画布背景色
        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();
        ////绘制矩形，内部不填充
        // 抗锯齿
        paint.setAntiAlias(true);
        //画笔颜色
        paint.setColor(Color.RED);
        // 设置填充类型
        paint.setStyle(Paint.Style.STROKE);
        //设置画笔宽度
        paint.setStrokeWidth(5);
        //绘制普通矩形
        canvas.drawRect(10, 10, 100, 100, paint);
        //绘制三角形，内部填充
        Path path = new Path();
        path.moveTo(10, 120);
        path.lineTo(200, 120);
        path.lineTo(100, 200);
        path.close();
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(path, paint);
        //绘制文本
        paint.setTextSize(12);
        paint.setColor(Color.BLUE);
        paint.setStrikeThruText(true);
        canvas.drawText("hello world", 10, 200, paint);
        Path pathText = new Path();
        pathText.addCircle(200, 300, 80, Path.Direction.CCW);
        canvas.drawTextOnPath("Draw the text, with origin at (x,y), using the specified paint, along the specified path.", pathText, 0, 10, paint);
    }*/

    List<Path> listStrokes = new ArrayList<Path>();
    Path pathStroke;
    Bitmap memBMP;
    Paint memPaint;
    Canvas memCanvas;
    boolean mBooleanOnTouch = false;
    //上一个点
    float oldx;
    float oldy;
    float newx;
    float newy;
    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        //每一次落下-抬起之间经过的点为一个笔画
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN://落下
                pathStroke = new Path();
                pathStroke.moveTo(x, y);
                oldx = x;
                oldy = y;
                mBooleanOnTouch = true;
                listStrokes.add(pathStroke);
                break;
            case MotionEvent.ACTION_MOVE://移动
                // Add a quadratic bezier from the last point, approaching control point (x1,y1), and ending at (x2,y2).
                // 在Path结尾添加二次Bezier曲线
                if (mBooleanOnTouch) {
                    //pathStroke.quadTo(oldx, oldy, x, y);
                    newx = x;
                    newy = y;
                    invalidate();
                    drawStrokes();
                }
                break;
            case MotionEvent.ACTION_UP://抬起
                if (mBooleanOnTouch) {
                    pathStroke.quadTo(oldx, oldy, x, y);
                    drawStrokes();
                    invalidate();
                    mBooleanOnTouch = false;//一个笔画已经画完
                }
                break;
        }
        //本View已经处理完了Touch事件，不需要向上传递
        return true;
    }
    void drawStrokes() {
        if (memCanvas == null) {
            //缓冲位图
            memBMP = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            memCanvas = new Canvas(); //缓冲画布
            memCanvas.setBitmap(memBMP); //为画布设置位图，图形实际保存在位图中
            memPaint = new Paint(); //画笔
            memPaint.setAntiAlias(true); //抗锯齿
            memPaint.setColor(Color.RED); //画笔颜色
            memPaint.setStyle(Paint.Style.STROKE); //设置填充类型
            memPaint.setStrokeWidth(5); //设置画笔宽度
        }
        for (Path path : listStrokes) {
            memCanvas.drawPath(path, memPaint);
        }
        invalidate(); //刷新屏幕
    }
    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        if (memBMP != null)
            canvas.drawBitmap(memBMP, 0, 0, paint);
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        canvas.drawLine(oldx,oldy,newx,newy,paint);
    }
    /*public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        //设置画布背景色
        Paint paint=new Paint();
        //绘制矩形，内部不填充
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        canvas.drawRect(10, 10, 100, 100, paint);
        //使用着色器绘制矩形
        Shader shader=new LinearGradient(0,0,50,50,new   int[]{Color.RED,Color.GREEN,Color.BLUE},null, Shader.TileMode.REPEAT);
        paint.setShader(shader);
        canvas.drawRect(10, 110, 200, 200, paint);
        //使用着色器填充矩形
        paint.setStyle(Paint.Style.FILL);
        paint.setShader(shader);
        canvas.drawRect(10, 210, 300, 300, paint);
    }*/
}

