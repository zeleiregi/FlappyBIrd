package com.example.zeleregi.flappybird;

import java.util.Random;

/**
 * Created by dawars on 1/6/17.
 */

public class Bird {

    float x, y, radius;

    private static final Random random = new Random();

    public Bird(float x, float y) {
        this.x = x;
        this.y = y;

this.radius = random.nextInt(50)+50;

        }

public void setY(float y) {
        this.y = y;
        }

public void setX(float x) {
        this.x = x;
        }
        }
