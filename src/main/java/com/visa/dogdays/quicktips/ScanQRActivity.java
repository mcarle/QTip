package com.visa.dogdays.quicktips;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;


public class ScanQRActivity extends AppCompatActivity {

    private Button scan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_qr);

        scan= (Button)findViewById(R.id.qrScanner);

        scan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent("com.google.zxing.client.android.SCAN");
                intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(intent, 0);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {

                String contents = intent.getStringExtra("SCAN_RESULT");
                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");

                // Handle successful scan
                Intent i =  new Intent(ScanQRActivity.this, SendFundsActivity.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), contents, Toast.LENGTH_LONG);

            } else if (resultCode == RESULT_CANCELED) {
                // Handle cancel
                Log.i("App","Scan unsuccessful");
            }
        }
    }


}
