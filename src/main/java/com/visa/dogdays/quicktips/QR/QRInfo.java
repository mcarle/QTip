package com.visa.dogdays.quicktips.QR;

/**
 * Created by mcarle on 12/12/15.
 */
public class QRInfo {
    public String firstName;
    public String lastName;
    public String address;
    public String city;
    public String state;
    public String zip;
    public String pan;
    public String expDate;
    public String cvv2;
    public String email;
    public String url;

    public static String toQRURL(){
        return "androidApp://com.visa.dogdays.quicktips?firstName=Drew&lastName=Rich&city=Denver";
    }
}
