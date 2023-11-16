package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ImageView mHipman = findViewById(R.id.hipman);
        ImageView mLogo = findViewById(R.id.logo);

        Glide.with(this)
                .load(R.drawable.hipman)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(mHipman);

        Glide.with(this)
                .load(R.drawable.ic_thunder)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(mLogo);

        Animation blink = AnimationUtils.loadAnimation(this, R.anim.set_animation1);
        mLogo.startAnimation(blink);
    }

    public void openMain(View v) {
        Intent intent = new Intent(Register.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void openLogin(View v) {
        Intent intent = new Intent(Register.this, Login.class);
        startActivity(intent);
    }
}