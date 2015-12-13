package com.visa.dogdays.quicktips;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.view.View;


public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ReplaceFont.replaceDefaultFont(this, "DEFAULT", "MYRIADPRO-REGULAR.ttf");

    }

    public void sendMessageMoney(View view)
    {
        Intent i = new Intent(MenuActivity.this, SendFundsActivity.class);
        startActivity(i);
    }

    public void sendMessageCode(View view)
    {
        Intent i = new Intent(MenuActivity.this, QRInfoActivity.class);
        startActivity(i);
    }

}
