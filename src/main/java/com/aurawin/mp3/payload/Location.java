package com.aurawin.mp3.payload;

import java.util.ArrayList;

public class Location {
    byte[] MPEGFrames = new byte[3];
    byte[] BytesBetween = new byte[3];
    byte[] MillisecondsBetween = new byte[3];
    byte BitsForBytesDeviation;
    byte BitsForFramesDeviation;
    ArrayList<LocationDeviation>References = new ArrayList<>();
}
