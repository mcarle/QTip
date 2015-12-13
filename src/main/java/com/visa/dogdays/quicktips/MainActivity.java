package com.visa.dogdays.quicktips;

import android.app.Activity;
import android.nfc.Tag;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.URI;

public class MainActivity extends Activity {
    public static final String TAG  = MainActivity.class.getSimpleName();
    private TextView textView;
    private EditText editText;
    private android.net.Uri texturi;

    private TextView emailView;
    private TextView tokenView;
    private TextView fnameView;
    private TextView lnameView;
    private TextView urlView;


    private String email_data;
    private String token_data;
    private String fname_data;
    private String lname_data;
    private String url_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate");
        textView= (TextView) findViewById(R.id.ms_text_view);
        editText= (EditText) findViewById(R.id.ms_edit_text);
        emailView= (TextView) findViewById(R.id.ms_email_view);
        tokenView= (TextView) findViewById(R.id.ms_token_view);
        fnameView= (TextView) findViewById(R.id.ms_fname_view);
        lnameView= (TextView) findViewById(R.id.ms_lname_view);
        urlView= (TextView) findViewById(R.id.ms_url_view);

        email_data="";
        token_data="";
        fname_data="";
        lname_data="";
        url_data="";

        texturi= getIntent().getData();
        if (texturi != null) {


            email_data = texturi.getQueryParameter("email");
            token_data = texturi.getQueryParameter("token");
            fname_data = texturi.getQueryParameter("fname");
            lname_data = texturi.getQueryParameter("lname");
            url_data = texturi.getQueryParameter("url");

            emailView.setText(email_data);
            tokenView.setText(token_data);
            fnameView.setText(fname_data);
            lnameView.setText(lname_data);
            urlView.setText(url_data);


            Log.d(TAG, email_data);
            Log.d(TAG, token_data);
            Log.d(TAG, fname_data);
            Log.d(TAG, lname_data);
            Log.d(TAG, url_data);



        }
        Button helloButton= (Button) findViewById(R.id.ms_hello_btn);
        helloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayHello(v);
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "onStart");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume");



    }
    public void sayHello(View v) {
        String name =editText.getText().toString();
        textView.setText(String.format("Hello, %s !", name));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        /*/noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }
}
