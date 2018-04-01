package com.aurawin.mp3.volume;

public enum Adjustment {
    Decrement (0),
    Increment (1);

    private final int Value;
    public int getValue(){return Value;}

    Adjustment(int value) {Value = value;}

}
