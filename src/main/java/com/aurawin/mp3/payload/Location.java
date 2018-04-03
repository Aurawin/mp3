package com.aurawin.mp3.payload;

import java.util.ArrayList;

public class Location {
    public short MPEGFrames ;
    public int BytesBetween;
    public int MillisecondsBetween;
    public byte BitsForBytesDeviation;
    public byte BitsForFramesDeviation;
    public ArrayList<LocationDeviation>References = new ArrayList<>();
}
