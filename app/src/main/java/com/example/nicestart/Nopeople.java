package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class Nopeople extends AppCompatActivity {

    private WebView myWebView;
    private SwipeRefreshLayout swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nopeople);

        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe); // Cast para definir el SwipeRefreshLayout
        swipeLayout.setOnRefreshListener(mOnRefreshListener); // Agregar un listener a swipeLayout

        myWebView = (WebView) findViewById(R.id.vistaweb); // Cast para definir el WebView
        WebSettings webSettings = myWebView.getSettings(); // Declarar un WebSettings para atribuir propiedades al WebView
        webSettings.setLoadWithOverviewMode(true); // Opciones para cargar la página ajustada al tamaño de la pantalla
        webSettings.setUseWideViewPort(true);
        myWebView.loadUrl("https://thispersondoesnotexist.com");

        // casting a la vista a la que aplicamos un menu contextual
        // y la registramos
        WebView mycontext = (WebView) findViewById(R.id.vistaweb);
        registerForContextMenu(mycontext);
    }

    protected SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            Toast toast0 = Toast.makeText(Nopeople.this, "Hi there! I don't exist :)", Toast.LENGTH_LONG);
            toast0.show();
            myWebView.reload(); // Recargar el WebView
            swipeLayout.setRefreshing(false); // End the refresh, or else it'll be refreshing forever
        }
    };

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.item1) {
            Toast toast = Toast.makeText(this, "Image copied successfully", Toast.LENGTH_LONG);
            toast.show();
            return true;
        } else if (item.getItemId() == R.id.item2) {
            Toast toast2 = Toast.makeText(this, "Image downloaded", Toast.LENGTH_LONG);
            toast2.show();
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }
}