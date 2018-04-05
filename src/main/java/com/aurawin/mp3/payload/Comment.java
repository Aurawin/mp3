package com.aurawin.mp3.payload;

import com.aurawin.mp3.TextEncoding;

import static com.aurawin.mp3.TextEncoding.UTF8;

public class Comment {
    public TextEncoding Encoding = UTF8;
    public String Language;
    public String Description;
    public String Text;
}
