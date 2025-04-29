package com.example.fooddude;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;

import com.example.fooddude.R;

public class SplashActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        LottieAnimationView animationView = findViewById(R.id.splashAnimation);
        animationView.setAnimation(R.raw.splash_screen);
        animationView.setRepeatCount(LottieDrawable.INFINITE);
        animationView.playAnimation();

        // Move to next activity after animation
        new Handler().postDelayed(() ->
        {
            startActivity(new Intent(SplashActivity.this, RegisterActivity.class));
            finish();
        }, 12500); // 12.5 seconds
    }
}
