package com.example.mothersday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    AnimationDrawable cardAnimation;
    MediaPlayer player;

    private ImageView card;

    private GestureDetectorCompat gestureDetectorCompat = null;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        card = (ImageView) findViewById(R.id.imageView);
        card.setBackgroundResource(R.drawable.mycard);
        cardAnimation = (AnimationDrawable) card.getBackground();

        DetectSwipeListener gestureListener = new DetectSwipeListener();
        gestureListener.setActivity(this);
        gestureDetectorCompat = new GestureDetectorCompat(this, gestureListener);

    }

    public void CStart()
    {
        if(cardAnimation.isRunning())
        {
            cardAnimation.stop();
        }
        cardAnimation.start();
        player = MediaPlayer.create(this, R.raw.maa);

        if(player != null)
        {
            player.pause();
            player.setLooping(false);
            player.stop();
            player.release();
            player.reset();
        }

        player.start();
        player.setLooping(true);
    }

    public void CStop()
    {
        if(cardAnimation.isRunning())
        {
            cardAnimation.stop();
        }

        if(player != null)
        {
            player.pause();
            player.setLooping(false);
            player.stop();
            player.release();
            player.reset();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        gestureDetectorCompat.onTouchEvent(event);
        return true;
    }
}
