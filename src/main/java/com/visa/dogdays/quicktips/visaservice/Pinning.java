package com.visa.dogdays.quicktips.visaservice;


import android.content.Context;

import java.io.InputStream;
import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

import com.visa.dogdays.quicktips.R;

public class Pinning {

    Context context;
    public static String TRUST_STORE_PASSWORD = "temp123";
    public static String PRIVATE_KEY_PASSWORD = "temp123";

    public Pinning(Context c) {
        this.context = c;
    }

    public SSLSocketFactory getPinnedCertSslSocketFactory(Context context) {
        try {
            KeyStore trusted = KeyStore.getInstance("BKS");
            InputStream in = context.getResources().openRawResource(R.raw.mytruststore);
            trusted.load(in, TRUST_STORE_PASSWORD.toCharArray());

            SSLContext sslContext = SSLContext.getInstance("TLSv1");

            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(
                    TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(trusted);

            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(trusted, PRIVATE_KEY_PASSWORD.toCharArray());

            sslContext.init(keyManagerFactory.getKeyManagers(), null, null);
            return sslContext.getSocketFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}