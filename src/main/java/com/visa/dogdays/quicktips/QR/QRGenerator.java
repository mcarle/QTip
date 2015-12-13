package com.visa.dogdays.quicktips.QR;

import android.widget.ImageView;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import android.net.Uri;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.BarcodeFormat;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.widget.Toast;

public class QRCode {

    private void generateQRCode_general(String data, ImageView img)throws WriterException {
        com.google.zxing.Writer writer = new QRCodeWriter();
        String finaldata = Uri.encode(data, "utf-8");

        BitMatrix bm = writer.encode(finaldata, BarcodeFormat.QR_CODE,150, 150);
        Bitmap ImageBitmap = Bitmap.createBitmap(150, 150,Config.ARGB_8888);

        for (int i = 0; i < 150; i++) {//width
            for (int j = 0; j < 150; j++) {//height
                ImageBitmap.setPixel(i, j, bm.get(i, j) ? Color.BLACK: Color.WHITE);
            }
        }

        if (ImageBitmap != null) {
            qrcode.setImageBitmap(ImageBitmap);
        } else {
            Toast.makeText(getApplicationContext(), "Error generating QR!",
                    Toast.LENGTH_SHORT).show();
        }
    }
}