package com.example.zeleregi.flappybird;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by dawars on 1/6/17.
 */

public class GameThread extends Thread {

    private static final float RADIUS = 100;
    private final Paint paint = new Paint();
    private static final Random random = new Random();
    float y;
    float x = random.nextInt(500);
    private final SurfaceHolder holder;

    float vel = 10;



    public GameThread(SurfaceHolder holder) {
        this.holder = holder;

        paint.setColor(Color.WHITE);
    }

    @Override
    public void run() {


        while (true) {
            Log.i("TAG", "game thread");

            update();

            Canvas canvas = holder.lockCanvas();

            if (canvas != null) {
                canvas.drawColor(Color.BLUE);
                render(canvas); // rajzolunk
                // befejezzuk a rajzolast es odaadjuk a rendszernek megjelenitesre:
                holder.unlockCanvasAndPost(canvas);
            }

            try {
                Thread.sleep(1000 / 30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //List<> objects = new LinkedList<>();


    private void update() {
        // ne hasznaljunk foreach-et ha torlunk a tombbol!
            y += vel;
    }

    private void render(Canvas canvas) {
            canvas.drawCircle(x, y, RADIUS, paint);

    }

    public void onTouchEvent(MotionEvent event) {

        Log.i("Tag", event.toString());

        y += 20;
    }
}
