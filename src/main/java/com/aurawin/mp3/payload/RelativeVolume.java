package com.aurawin.mp3.payload;

import com.aurawin.mp3.volume.Adjustment;
import com.aurawin.mp3.volume.Channel;

public class RelativeVolume {
    public Channel Channel;
    public Adjustment Adjustment;
    public byte Description;
    public long DeltaRight;
    public long DeltaLeft;
    public long PeekVolumeRight;
    public long PeekVolumeLeft;

}
