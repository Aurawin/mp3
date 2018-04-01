package com.aurawin.mp3;

public enum TextContentType {

    Other (0x0),
    Lyrics (0x1),
    Transcription (0x2),
    Movement (0x3),
    Events (0x4),
    Chord (0x5);

    TextContentType (int value){ Value=value;}
    private final int Value;
    public int getValue(){return Value;}

}
