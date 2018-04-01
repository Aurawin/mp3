package com.aurawin.mp3.payload;

import com.aurawin.mp3.volume.RightLeftAdjustment;

public class RelativeVolumeAdjustment {
    int BitsUsed;
    RightLeftAdjustment Stereo;
    RightLeftAdjustment Front;
    RightLeftAdjustment Back;
    RightLeftAdjustment Center;
    RightLeftAdjustment Bass;
}
