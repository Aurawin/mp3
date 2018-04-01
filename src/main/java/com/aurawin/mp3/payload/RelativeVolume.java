package com.aurawin.mp3.payload;

import com.aurawin.mp3.volume.Adjustment;

public class RelativeVolume {
    Adjustment Adjustment;
    byte Description;
    byte[] DeltaRight;
    byte[] DeltaLeft;
    byte[] PeekVolumeRight;
    byte[] PeekVolumeLeft;

}
