package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView mBackgroundSplash = findViewById(R.id.background_splash);

        Glide.with(this)
                .load("https://wallpapercave.com/wp/wp3937417.png")
                .transition(DrawableTransitionOptions.withCrossFade(2000))
                .centerCrop()
                .placeholder((new ColorDrawable(this.getResources().getColor(R.color.purple_200))))
                .into(mBackgroundSplash);
    }
}