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

    public TextContentType fromByte(byte value){
        switch (value){
            case (0x0): return Other;
            case (0x1): return Lyrics;
            case (0x2): return Transcription;
            case (0x3): return Movement;
            case (0x4): return Events;
            case (0x5): return Chord;
        }
        return null;
    }

}
