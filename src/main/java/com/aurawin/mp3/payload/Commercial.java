package com.aurawin.mp3.payload;

import com.aurawin.mp3.CommercialKind;
import com.aurawin.mp3.TextEncoding;

import static com.aurawin.mp3.CommercialKind.Other;
import static com.aurawin.mp3.TextEncoding.UTF8;

public class Commercial {
    public TextEncoding Encoding = UTF8;
    public String Price;
    public String Expires;
    public String Contact;
    public CommercialKind Kind = Other;
    public String Seller;
    public String Description;
    public String MimeType;

    public byte[] Logo;
}
