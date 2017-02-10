package com.example.zeleregi.flappybird;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by dawars on 1/5/17.
 */

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private static final float RADIUS = 100;
    private final SurfaceHolder surfaceHolder;

    private final GameThread gameThread;

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);

        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        gameThread = new GameThread(surfaceHolder);

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        gameThread.start(); // nem run!!!

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        gameThread.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
