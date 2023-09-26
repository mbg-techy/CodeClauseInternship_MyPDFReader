package com.example.mypdfreader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        imageView=(ImageView)findViewById(R.id.imageView);
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.welcome_animation);
        imageView.setAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                finish();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        textView=(TextView)findViewById(R.id.textView);
        Animation animation1= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.text_animation);
        textView.setAnimation(animation1);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                finish();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}