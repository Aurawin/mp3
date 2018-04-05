package com.aurawin.mp3.payload;

import com.aurawin.mp3.PictureKind;
import com.aurawin.mp3.TextEncoding;

import static com.aurawin.mp3.TextEncoding.UTF8;

public class AttachedPicture {
    public TextEncoding Encoding = UTF8;
    public String MimeType;
    public PictureKind Kind;
    public String Description;
    public byte[] Data;
}
