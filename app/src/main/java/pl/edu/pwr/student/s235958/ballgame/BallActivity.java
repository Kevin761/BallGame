package pl.edu.pwr.student.s235958.ballgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class BallActivity extends View {
    private Paint paint;
    private final int RADIUS = 10;
    private int Vx;
    private int Vy;

    private DisplayMetrics metrics = this.getResources().getDisplayMetrics();
    private int width = metrics.widthPixels;
    private int height = metrics.heightPixels - 300;

    private boolean isGameOver = false;

    private int x = width*15/20;
    private int y = height*15/20;

    private int leftIntSite = getWidth()*3/10;
    private int leftExtSite = getWidth()*2/10;
    private int topSite = getHeight()*2/10;
    private int bottomIntSite = getHeight()*3/10;
    private int bottomExtSite = getHeight()*8/10;
    private int rightIntSite = getWidth()*7/10;
    private int rightExtSite = getWidth()*8/10;
    private int line = getHeight()*15/20;



    public BallActivity (Context etx, AttributeSet attrs){
        super(etx,attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);



    }



    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        canvas.drawCircle(x,y,RADIUS, paint);
    }

   public void move() {
       if (x + RADIUS < leftExtSite|| x + RADIUS > leftIntSite && x + RADIUS > bottomIntSite || x + RADIUS < topSite || x + RADIUS > rightExtSite || x + RADIUS < rightIntSite && x + RADIUS > bottomIntSite || x + RADIUS > bottomExtSite) {
           isGameOver = false;

       }
       if (x + RADIUS > line){
           x = getXPos()*15/20;
           y = getYPos()*15/20;
           isGameOver = true;
       }

   }

    public void resetGame() {
        isGameOver = false;
    }

    public int getXPos() {
        return x;
    }

    public int getYPos() {
        return y;
    }
    public void setVx(int Vx) {
        this.Vx = Vx;
    }

    public void setVy(int Vy) {
        this.Vy = Vy;
    }

    public boolean isGameOver() {
        return isGameOver;
    }
}


