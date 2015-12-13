package com.visa.dogdays.quicktips;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;



public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ReplaceFont.replaceDefaultFont(this, "DEFAULT", "MYRIADPRO-REGULAR.ttf");

    }

}
