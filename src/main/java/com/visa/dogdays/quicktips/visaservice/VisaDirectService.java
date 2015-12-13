package com.visa.dogdays.quicktips.visaservice;

/**
 * Created by mcarle on 12/12/15.
 */
public class VisaDirectService {

    private String userId;
    private String  pwd;
    private String keyStorePath;
    private String keyStorePwd;
    private String privateKeyPwd;

    public VisaDirectService(String userId, String pwd, String keyStorePath,
                             String keyStorePwd, String privateKeyPwd){
        this.userId = userId;
        this.pwd = pwd;
        this.keyStorePath = keyStorePath;
        this.keyStorePwd = keyStorePwd;
        this.privateKeyPwd = privateKeyPwd;

    }

    public void sendFundsTransferRequest(){
        //OkHttpClient client = new OkHttpClient();
    }

}
