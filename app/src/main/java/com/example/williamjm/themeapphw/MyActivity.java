package com.example.williamjm.themeapphw;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;


public class MyActivity extends Activity {

    MediaPlayer topTheme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        topTheme = MediaPlayer.create(MyActivity.this, R.raw.tgintro);
        topTheme.start();
        blinkText();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }
        private void blinkText() {
            // TODO Auto-generated method stub
            final Handler handler = new Handler();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int timeToBlink = 500;    //in ms
                    try {
                        Thread.sleep(timeToBlink);
                    } catch (Exception e) {

                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            TextView txt = (TextView) findViewById(R.id.Header);
                            if (txt.getVisibility() == View.VISIBLE) {
                                txt.setVisibility(View.INVISIBLE);
                            } else {
                                txt.setVisibility(View.VISIBLE);
                            }
                            blinkText();
                        }
                    });
                }
            }).start();
        }

    @Override
    protected void onPause(){
        super.onPause();
        topTheme.release();
        finish();
    }
}






