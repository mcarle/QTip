package com.visa.dogdays.quicktips.visaservice;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import android.os.AsyncTask;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by mcarle on 12/12/15.
 */
public class SendFundsService extends AsyncTask<String, Integer, String>{

    private static final String authHeader = "Basic Qzg0NDlJUlRSQlFCVEROUjg2WFgyMVcyY0VlQ0t6cWppcjVRLTFQSWRUdHFzaW5NQTpDeVE4OFI2WHA3N1I3QVVkdmtMY0FrcHg=";
    private static String testPostBody = "{\"systemsTraceAuditNumber\":350420,\"retrievalReferenceNumber\":\"401010350420\",\"localTransactionDateTime\":\"2021-10-26T21:32:52\",\"acquiringBin\":409999,\"acquirerCountryCode\":\"101\",\"senderAccountNumber\":\"1234567890123456\",\"senderCountryCode\":\"USA\",\"transactionCurrencyCode\":\"USD\",\"senderName\":\"John Smith\",\"senderAddress\":\"44 Market St.\",\"senderCity\":\"San Francisco\",\"senderStateCode\":\"CA\",\"recipientName\":\"Adam Smith\",\"recipientPrimaryAccountNumber\":\"4957030420210454\",\"amount\":\"112.00\",\"businessApplicationId\":\"AA\",\"transactionId\":234234322342343,\"merchantCategoryCode\":6012,\"sourceOfFundsCode\":\"03\",\"cardAcceptor\":{\"name\":\"John Smith\",\"terminalId\":\"13655392\",\"idCode\":\"VMT200911026070\",\"address\":{\"state\":\"CA\",\"county\":\"081\",\"country\":\"USA\",\"zipCode\":\"94105\"}},\"feeProgramIndicator\":\"123\"}";
    private static final MediaType JSON = MediaType.parse("application/json");
    private static final String userId = "C8449IRTRBQBTDNR86XX21W2cEeCKzqjir5Q-1PIdTtqsinMA";
    private static final String pwd = "CyQ88R6Xp77R7AUdvkLcAkpx";
    private Context context;

    public SendFundsService(Context context){
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params){
        try {
            Pinning pinning = new Pinning(context);
            OkHttpClient client = new OkHttpClient();

            client.setSslSocketFactory(pinning.getPinnedCertSslSocketFactory(context));
            Request request = new Request.Builder()
                    .url("https://sandbox.api.visa.com/visadirect/fundstransfer/v1/pushfundstransactions/")
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Basic Qzg0NDlJUlRSQlFCVEROUjg2WFgyMVcyY0VlQ0t6cWppcjVRLTFQSWRUdHFzaW5NQTpDeVE4OFI2WHA3N1I3QVVkdmtMY0FrcHg=")
                    .tag("HTTP/1.1")
                    .post(RequestBody.create(JSON, testPostBody))
                    .build();
            Log.v("VDP REQUEST::", request.toString());
            Log.v("VDP REQUEST::", "Basic Qzg0NDlJUlRSQlFCVEROUjg2WFgyMVcyY0VlQ0t6cWppcjVRLTFQSWRUdHFzaW5NQTpDeVE4OFI2WHA3N1I3QVVkdmtMY0FrcHg=");

            for(String header : request.headers().names()){
                Log.v("VDP HEADER::", header);
                Log.v("VALUE::", request.headers().get(header));
            }

            // make call
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();
            for(String respHeader : response.headers().names()){
                Log.v("VDP RESPONSE HEADER::", respHeader);
                Log.v("VDP RESPONSE HEADER::", response.headers().get(respHeader));
            }
            if (responseBody != null)
                Log.v("VDP RESPONSE::", responseBody);

            else
                Log.v("VDP RESPONSE::", "returned null");


        }
        catch(IOException ex){
            if(ex == null)
                Log.v("VDP::","Threw null IOException");
            else
                Log.v("VDP::", ex.toString());
        }
        return "background task completed";
    }

    private String getBasicAuthHeader() {
        return "Basic " + base64Encode(userId + ":" + pwd);
    }

    private String base64Encode(String token){
        Log.v("CREATING AUTH::", token);
        byte[] encodedBytes = Base64.encode(token.getBytes(),Base64.DEFAULT);
        return new String(encodedBytes, Charset.forName("UTF-8"));
    }

}
