package com.mainproject.hotelsweb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private WebView hotelWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hotelWebView = findViewById(R.id.hotelWebView);

        hotelWebView.getSettings().setJavaScriptEnabled(true);
        hotelWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                Toast.makeText(MainActivity.this, "Loading Error", Toast.LENGTH_SHORT).show();
            }
        });

        getSupportActionBar().hide();
        hotelWebView.loadUrl(
"https://www.google.co.in/travel/hotels/Bareilly?q=hotels%20in%20bareilly&hl=en&gl=in&ictx=1&ved=0ahUKEwiIgYz9waDZAhVFL48KHet_DF4QvDEI1AE&hrf=CgUI-FUQACIDSU5SKhYKBwjiDxACGAwSBwjiDxACGA0YASgAkgECIAE"
                 );
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (hotelWebView.canGoBack()) {
                        hotelWebView.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }
}
