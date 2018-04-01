package com.aurawin.mp3.payload;

import com.aurawin.mp3.PictureKind;
import com.aurawin.mp3.TextEncoding;

public class AttachedPicture {
    TextEncoding Encoding;
    String MimeType;
    PictureKind Kind;
    String Description;
    byte[] Data;
}
