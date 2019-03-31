package pl.edu.pwr.student.s235958.ballgame;

import android.os.Handler;


public class BallThread implements Runnable {

    private Handler handler;
    public BallActivity ball;

    public BallThread(Handler h, BallActivity b) {
        handler = h;
        ball = b;


    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        ball.move();
                        ball.invalidate();
                    }
                });

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
