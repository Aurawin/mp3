package com.aurawin.mp3.payload;

import com.aurawin.mp3.TextEncoding;

import static com.aurawin.mp3.TextEncoding.UTF8;

public class EncapsulatedObject {
    public TextEncoding Encoding = UTF8;
    public String MimeType;
    public String Filename;
    public String Description;
    public byte[] Data;

}
