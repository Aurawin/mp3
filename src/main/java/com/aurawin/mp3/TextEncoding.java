package com.aurawin.mp3;

public enum TextEncoding {
    ISO8859_1 (0x0),
    UTF16 (0x1),
    UTF16BE (0x2),
    UTF8 (0x3);
    public static final TextEncoding Base = UTF8;

    TextEncoding(int value){ Value = value;}
    private final int Value;
    public int getValue(){return Value;}
    public TextEncoding fromByte(byte input){

        switch (this){
            case ISO8859_1: return ISO8859_1;
            case UTF8: return UTF8;
            case UTF16: return UTF16;
            case UTF16BE: return UTF16BE;
        }
        return null;
    }
    public String toEncoding(){
        switch(this){
            case ISO8859_1: return "ISO-8859-1";
            case UTF8: return "UTF-8";
            case UTF16: return "UTF-16";
            case UTF16BE: return "UTF-16BE";
        }
        return "UTF-8";
    }
}
