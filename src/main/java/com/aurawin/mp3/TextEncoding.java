package com.aurawin.mp3;

public enum TextEncoding {
    ISO8859_1 (0x0),
    UTF16 (0x1),
    UTF16BE (0x2),
    UTF8 (0x3);

    TextEncoding(int value){ Value = value;}
    private final int Value;
    public int getValue(){return Value;}
}
