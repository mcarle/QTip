package com.visa.dogdays.quicktips;

import android.os.Bundle;
import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.widget.ImageView;
import com.google.gson.Gson;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import android.net.Uri;
import com.visa.dogdays.quicktips.QR.QRInfo;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.BarcodeFormat;
import android.graphics.Bitmap.Config;
import android.util.Log;
import android.widget.Toast;

public class PopulateQRActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_populate_qr);

        // get QR args from args
        String qrArgsStr = getIntent().getStringExtra("QR_ARGS");
        QRInfo qrArgs = new Gson().fromJson(qrArgsStr, QRInfo.class);

        // generate and display QRCode
        Toast.makeText(getApplicationContext(), QRInfo.toQRURL(), Toast.LENGTH_LONG).show();
        Log.v("QR URL::::", QRInfo.toQRURL());
        generateQRCode(QRInfo.toQRURL());

    }

    private void generateQRCode(String data){
        com.google.zxing.Writer writer = new QRCodeWriter();
        //String finaldata = Uri.encode(data, "utf-8");
        BitMatrix bm;
        try {
            bm = writer.encode(data, BarcodeFormat.QR_CODE, 150, 150);
        }
        catch (WriterException wex){
            // TODO: Handle exception
            Toast.makeText(getApplicationContext(), "Error generating QR code!",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        Bitmap imageBitmap = Bitmap.createBitmap(150, 150, Config.ARGB_8888);

        for (int i = 0; i < 150; i++) {//width
            for (int j = 0; j < 150; j++) {//height
                imageBitmap.setPixel(i, j, bm.get(i, j) ? Color.BLACK: Color.WHITE);
            }
        }

        if (imageBitmap != null) {
            ImageView qrCodeImg = (ImageView) findViewById(R.id.qrCodeImg);
            qrCodeImg.setImageBitmap(imageBitmap);
            Toast.makeText(getApplicationContext(), "Created bitmap QR!",
                    Toast.LENGTH_SHORT).show();

        } else {
              Toast.makeText(getApplicationContext(), "Error generating QR!",
              Toast.LENGTH_SHORT).show();
        }
    }

}

