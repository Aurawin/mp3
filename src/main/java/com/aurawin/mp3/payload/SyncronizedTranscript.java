package com.aurawin.mp3.payload;

import com.aurawin.mp3.SynchronizedText;
import com.aurawin.mp3.TextContentType;
import com.aurawin.mp3.TextEncoding;
import com.aurawin.mp3.TimeStampFormat;

import java.util.ArrayList;

import static com.aurawin.mp3.TextEncoding.UTF8;

public class SyncronizedTranscript {
    public TextEncoding Encoding = UTF8;
    public String Language;
    public TimeStampFormat Format;
    public TextContentType ContentType;
    public String Description;
    public ArrayList<SynchronizedText> List = new ArrayList<>();
}
