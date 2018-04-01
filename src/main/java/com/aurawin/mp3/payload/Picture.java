package com.aurawin.mp3.payload;

import com.aurawin.mp3.PictureKind;
import com.aurawin.mp3.TextEncoding;

public class Picture {
    TextEncoding Encoding;
    char [] Format = new char[2];
    PictureKind Kind;
    String Description;
    byte[] Data;
}
