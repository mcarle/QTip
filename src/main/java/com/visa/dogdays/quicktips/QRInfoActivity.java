package com.visa.dogdays.quicktips;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.gson.Gson;

import com.visa.dogdays.quicktips.QR.QRInfo;

public class QRInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrinfo);
        ReplaceFont.replaceDefaultFont(this, "DEFAULT", "MYRIADPRO-REGULAR.ttf");

        // register submit button
        Button getQRCodeBtn = (Button)findViewById(R.id.btnQRCode);
        getQRCodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateQRCode();
            }
        });
    }


    public void generateQRCode() {
        // get ui form fields
        QRInfo qrArgs = new QRInfo();
        qrArgs.address = ((EditText)findViewById(R.id.txtAddressQR)).getText().toString();
        qrArgs.city = ((EditText)findViewById(R.id.txtCityQR)).getText().toString();
        qrArgs.cvv2 = ((EditText)findViewById(R.id.txtCVV2QR)).getText().toString();
        qrArgs.email = ((EditText)findViewById(R.id.txtEmailQR)).getText().toString();
        qrArgs.expDate = ((EditText)findViewById(R.id.txtExpDateQR)).getText().toString();
        qrArgs.firstName = ((EditText)findViewById(R.id.txtFirstNameQR)).getText().toString();
        qrArgs.lastName = ((EditText)findViewById(R.id.txtLastNameQR)).getText().toString();
        qrArgs.pan = ((EditText)findViewById(R.id.txtPANQR)).getText().toString();
        qrArgs.state = ((EditText)findViewById((R.id.txtStateQR))).getText().toString();
        qrArgs.zip = ((EditText)findViewById(R.id.txtZipQR)).getText().toString();

        Intent i = new Intent(QRInfoActivity.this, PopulateQRActivity.class);
        // serialize qr args and pass to QR display activity
        Gson gson = new Gson();
        i.putExtra("QR_ARGS", gson.toJson(qrArgs));

        startActivity(i);
    }
}
