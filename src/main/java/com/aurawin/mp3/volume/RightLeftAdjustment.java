package com.aurawin.mp3.volume;

public class RightLeftAdjustment {
    Adjustments Right;
    Adjustments Left;

    public void setByteCount(byte length){
        Right.setByteCount(length);
        Left.setByteCount(length);
    }
}
