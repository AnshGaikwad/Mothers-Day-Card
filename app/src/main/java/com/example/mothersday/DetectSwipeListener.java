package com.example.mothersday;

import android.media.MediaPlayer;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class DetectSwipeListener extends GestureDetector.SimpleOnGestureListener {

    public static int MIN_SWIPE_DISTANCE_Y = 100;

    public static int MAX_SWIPE_DISTANCE_Y = 1000;

    private MainActivity activity = null;

    public MainActivity getActivity() {
        return activity;
    }

    public void setActivity(MainActivity activity){
        this.activity = activity;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {


        float deltaY = e1.getY() - e2.getY();

        float deltaYAbs = Math.abs(deltaY);


        if(deltaYAbs >= MIN_SWIPE_DISTANCE_Y && deltaY <= MAX_SWIPE_DISTANCE_Y){
            if(deltaY > 0){

                this.activity.CStop();
            }else{
                this.activity.CStart();
            }
        }






        return true;
        //return super.onFling(e1, e2, velocityX, velocityY);
    }



}
