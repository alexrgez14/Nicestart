package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class Nopeople extends AppCompatActivity {

    private WebView myWebView;
    private SwipeRefreshLayout swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nopeople);

        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe); // Cast to the SwipeRefreshLayout class
        swipeLayout.setOnRefreshListener(mOnRefreshListener); // Set listener to swipeLayout
    }

    protected SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            Toast toast0 = Toast.makeText(Nopeople.this, "Hi there! I don't exist :)", Toast.LENGTH_LONG);
            toast0.show();
            swipeLayout.setRefreshing(false); // End the refresh, or else it'll be refreshing forever
        }
    };
}