package com.aurawin.mp3.payload;

import com.aurawin.mp3.SynchronizedText;
import com.aurawin.mp3.TextContentType;
import com.aurawin.mp3.TextEncoding;
import com.aurawin.mp3.TimeStampFormat;

import java.util.ArrayList;

public class SyncronizedTranscript {
    TextEncoding Encoding;
    String Language;
    TimeStampFormat Format;
    TextContentType ContentType;
    String Description;
    ArrayList<SynchronizedText> List = new ArrayList<>();
}
