package com.aurawin.mp3;

public enum TimeStampFormat {
    None((byte)0), Frames((byte)1), Milliseconds((byte)2);

    TimeStampFormat(byte value){ Value = value;}
    private final byte Value;
    public byte getValue(){return Value;}

    public TimeStampFormat fromByte(byte value){
        switch (value){
            case 0 : return  None;
            case 1 : return Frames;
            case 2 : return Milliseconds;
        }
        return null;
    }
}
