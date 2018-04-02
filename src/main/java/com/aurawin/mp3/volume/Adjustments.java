package com.aurawin.mp3.volume;

public class Adjustments {
    Adjustment Adjustment;
    byte[] Delta;
    byte[] PeakVolume;

    public void setByteCount(byte length){
        Delta = new byte[length];
        PeakVolume = new byte[length];
    }
}
