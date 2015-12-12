package com.visa.dogdays.quicktips;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//Set typeface to Myriad
        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "MYRIADPRO-REGULAR.ttf");
        TextView myTextview = (TextView)findViewById(R.id.textViewSplash);
        myTextview.setTypeface(myTypeface);
    }




}
