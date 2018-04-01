package com.aurawin.mp3.frame;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.tag.ID3V20;
import com.aurawin.mp3.frame.tag.ID3V23;
import com.aurawin.mp3.frame.tag.ID3V30;
import com.aurawin.mp3.frame.tag.ID3V40;

public class Reader {

    public short FrameCount;
    protected MemoryStream Refactor;
    public long AggregateLength;
    public long StreamSize;
    public long StreamPosition;

    public short BitRate;
    public short SampleHz;
    public long FrameSizeTotal;
    public short FrameSize;
    public double Duration;

    protected ID3 ID3Frame;
    protected MPEG MPEGFrame;
    // ID3 Tag Frames
    protected ID3V20 ID3V20Tag;
    protected ID3V23 ID3V23Tag;
    protected ID3V30 ID3V30Tag;
    protected ID3V40 ID3V40Tag;
    // Generic Frame Pointers
    protected Frame TagFrame;
    public com.aurawin.mp3.frame.tag.Event OnTagFrame;

    public void LoadAll(MemoryStream Stream);
    public void  LoadFirst(MemoryStream Stream);

    public void Release(){

    }

    Reader(){

    }


}
