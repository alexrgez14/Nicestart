package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        openApp();

        ImageView mBackgroundSplash = findViewById(R.id.background_splash);

        Glide.with(this)
                .load("https://wallpapercave.com/wp/wp3937417.png") // src o url de la imagen
                .transition(DrawableTransitionOptions.withCrossFade(2000)) // Transición, en este caso con crossfade
                .centerCrop() // Centrar la imagen y recortar los bordes
                .diskCacheStrategy(DiskCacheStrategy.ALL) // Almacenar la imagen en caché para que tarde menos en ser cargada a partir del primer intento
                .placeholder((new ColorDrawable(this.getResources().getColor(R.color.purple_200)))) // Añadir un color donde vaya la imagen para manejar lo que pasa en ese espacio hasta que la imagen es cargada
                .into(mBackgroundSplash);
    }

    private void openApp() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Splash.this, Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        }, 7000);
    }
}