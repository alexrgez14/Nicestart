package com.example.nicestart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Camera;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    FirstFragment firstFragment = new FirstFragment();
    SecondFragment secondFragment = new SecondFragment();
    ThirdFragment thirdFragment = new ThirdFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        loadFragment(firstFragment);
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            if (item.getItemId()==R.id.nicestart) {
                loadFragment(firstFragment);
                return true;
            } else if (item.getItemId()==R.id.secondFragment) {
                loadFragment(secondFragment);
                return true;
            } else if (item.getItemId()==R.id.nopeople) {
                loadFragment(thirdFragment);
                Intent intent = new Intent(MainActivity.this, Nopeople.class);
                startActivity(intent);
                return true;
            }
            return false;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.camera) {
            Toast toast = Toast.makeText(this,"Opening camera", Toast.LENGTH_LONG );
            toast.show();
            return true;
        } else if (id == R.id.heart) {
            final RelativeLayout mLayout = findViewById(R.id.myMainConstraint);
            Snackbar snackbar = Snackbar
                    .make(mLayout, "Added to favourites", Snackbar.LENGTH_LONG)
                    .setAction("UNDO", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Snackbar snackbar1 = Snackbar.make(mLayout, "Action is restored", Snackbar.LENGTH_LONG);
                            snackbar1.show();
                        }
                    });
            snackbar.show();
            return true;
        } else if (id == R.id.action_help) {
            Toast toast = Toast.makeText(this,"Looking for help", Toast.LENGTH_LONG );
            toast.show();
            return true;
        } else if (id == R.id.action_settings) {
            Toast toast = Toast.makeText(this,"Going to settings", Toast.LENGTH_LONG );
            toast.show();
            return true;
        } else if (id == R.id.action_logout) {
            Toast toast = Toast.makeText(this,"Logging out", Toast.LENGTH_LONG );
            toast.show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }
}
