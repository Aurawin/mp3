package com.aurawin.mp3.frame;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.tag.ID3V20;
import com.aurawin.mp3.frame.tag.ID3V23;
import com.aurawin.mp3.frame.tag.ID3V30;
import com.aurawin.mp3.frame.tag.ID3V40;
import com.aurawin.mp3.frame.tag.Event;
public class Reader {

    public short FrameCount;

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
    public ID3V20 ID3V20Tag;
    public ID3V23 ID3V23Tag;
    public ID3V30 ID3V30Tag;
    public ID3V40 ID3V40Tag;
    // Generic Frame Pointers
    public  Frame TagFrame;
    public Event OnTagFrame;

    public boolean Load(MemoryStream Stream){
        return ID3Frame.Load(Stream);
    }
    public void Release(){

    }
    public void setTagFrameEvent(Event evt){
        OnTagFrame=evt;
    }
    public Reader(){
        ID3Frame = new com.aurawin.mp3.frame.ID3(Kind.fID3, this);
        ID3V20Tag = new com.aurawin.mp3.frame.tag.ID3V20(this);

    }


}
