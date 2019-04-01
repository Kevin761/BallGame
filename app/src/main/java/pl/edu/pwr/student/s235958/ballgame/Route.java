package pl.edu.pwr.student.s235958.ballgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

public class Route extends View {
    Paint route;
    BallActivity ballActivity;



    public Route(Context etx, AttributeSet attrs){
        super(etx,attrs);
        route = new Paint(Paint.ANTI_ALIAS_FLAG);
        route.setColor(Color.RED);


    }
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        drawPoly(canvas, Color.BLACK,
                new Point[]{
                        new Point(getWidth()*7/10, getHeight()*8/10),
                        new Point(getWidth()*8/10, getHeight()*8/10),
                        new Point(getWidth()*8/10, getHeight()*2/10),
                        new Point(getWidth()*2/10, getHeight()*2/10),
                        new Point(getWidth()*2/10, getHeight()*8/10),
                        new Point(getWidth()*3/10, getHeight()*8/10),
                        new Point(getWidth()*3/10, getHeight()*3/10),
                        new Point(getWidth()*7/10, getHeight()*3/10),


                });

        route.setStrokeWidth(15);
        canvas.drawLine(getWidth()*2/10, getHeight()*15/20, getWidth()*3/10, getHeight()*15/20, route);
        route.setStyle(Paint.Style.FILL);


    }

    private void drawPoly(Canvas canvas, int color, Point[] points) {
        // line at minimum...
        if (points.length < 2) {
            return;
        }

        // paint
        Paint polyPaint = new Paint();
        polyPaint.setColor(color);
        polyPaint.setStyle(Paint.Style.FILL);

        // path
        Path polyPath = new Path();
        polyPath.moveTo(points[0].x, points[0].y);
        int i, len;
        len = points.length;
        for (i = 0; i < len; i++) {
            polyPath.lineTo(points[i].x, points[i].y);
        }
        polyPath.lineTo(points[0].x, points[0].y);

        // draw
        canvas.drawPath(polyPath, polyPaint);
    }
}
