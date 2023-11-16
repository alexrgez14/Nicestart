package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView mGirl = findViewById(R.id.girl);
        ImageView mLogo = findViewById(R.id.logo);

        Glide.with(this)
                .load(R.drawable.girl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(mGirl);

        Glide.with(this)
                .load(R.drawable.ic_thunder)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(mLogo);
    }

    public void openMain(View v) {
        Intent intent = new Intent(Login.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void openRegister(View v) {
        Intent intent = new Intent(Login.this, Register.class);
        startActivity(intent);
    }
}