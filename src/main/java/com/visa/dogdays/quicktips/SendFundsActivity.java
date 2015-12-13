package com.visa.dogdays.quicktips;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.util.Log;

import com.visa.dogdays.quicktips.visaservice.SendFundsService;

public class SendFundsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_funds);
        ReplaceFont.replaceDefaultFont(this, "DEFAULT", "MYRIADPRO-REGULAR.ttf");


        // register submit button
        Button submitBtn = (Button) findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                submitSendFunds();
            }
        });
    }


    public void submitSendFunds(){
        // get text fields
        String senderName = ((EditText)findViewById(R.id.fundSenderName)).getText().toString();
        String senderEmailAddr = ((EditText)findViewById(R.id.senderEmailAddr)).getText().toString();
        String senderNote = ((EditText)findViewById(R.id.senderNote)).getText().toString();
        String senderPAN = ((EditText)findViewById(R.id.senderPAN)).getText().toString();

        Log.v("submit-funds", senderName);
        Log.v("submit-funds", senderEmailAddr);
        Log.v("submit-funds", senderNote);
        Log.v("submit-funds", senderPAN);

        SendFundsService vdp = new SendFundsService(getApplicationContext());
        vdp.execute();

    }

}


