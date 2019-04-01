package pl.edu.pwr.student.s235958.ballgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Toast;

import org.w3c.dom.Text;

public class BallActivity extends View {
    private Paint paint;
    private final int RADIUS = 40;
    public int Vx;
    public int Vy;

    private DisplayMetrics metrics = this.getResources().getDisplayMetrics();
    private int width = metrics.widthPixels;
    private int height = metrics.heightPixels;

    private boolean isGameOver = false;

    private int xPos = width*15/20;
    private int yPos = height*22/30;






    public BallActivity (Context etx, AttributeSet attrs){
        super(etx,attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);

    }



    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        canvas.drawCircle(xPos, yPos,RADIUS, paint);
    }

   public void move() {

       xPos -= Vx;
       yPos += Vy;

       if(xPos + RADIUS < width*2/10){  //top ext site
           resetGame();
           xPos = width*15/20;
           yPos = height*22/30;
       }
       if(xPos - RADIUS > width*8/10){   //bottom ext site
           resetGame();
           xPos = width*15/20;
           yPos = height*22/30;
       }
       if(yPos + RADIUS > height*8/10){  //right ext site
           resetGame();
           xPos = width*15/20;
           yPos = height*22/30;
       }
       if(yPos + RADIUS < height*2/10) {  //left ext site
           resetGame();
           xPos = width * 15 / 20;
           yPos = height * 22 / 30;
       }
       if(xPos - RADIUS > width*3/10 && yPos + RADIUS > height*3/10 && xPos + RADIUS < width*7/10){   //bottom && left && right int site
           resetGame();
           xPos = width*15/20;
           yPos = height*22/30;
       }



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
    public void resetGame() {
        isGameOver = false;
    }
}


