package com.aurawin.mp3.volume;

public enum Adjustment {
    Decrement ((byte) 0),
    Increment ((byte) 1);

    private final byte Value;
    public byte getValue(){return Value;}

    Adjustment(byte value) {Value = value;}

}
