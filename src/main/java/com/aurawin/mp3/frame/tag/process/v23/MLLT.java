package com.aurawin.mp3.frame.tag.process.v23;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;
import com.aurawin.mp3.payload.LocationDeviation;

import static com.aurawin.mp3.frame.Kind.fMPEGLocationLookupTable;
import static com.aurawin.mp3.frame.Kind.fMPEGtable;
import static com.aurawin.mp3.frame.Kind.fMusicCDIdentifier;

public class MLLT extends Processor implements Process {
    @Override
    public boolean process( MemoryStream Stream){
        Owner.Data=Owner.pldMLL;
        Owner.Reader.TagFrame.Kind=fMPEGtable;
        Owner.pldMLL.MPEGFrames=(short)Stream.readWhole((int)2);
        Owner.pldMLL.BytesBetween=(int) Stream.readWhole((int)3);
        Owner.pldMLL.MillisecondsBetween=(int) Stream.readWhole((int)3);
        Owner.pldMLL.BitsForBytesDeviation=Stream.readByte();
        Owner.pldMLL.BitsForFramesDeviation=Stream.readByte();
        for (int iLcv=0; iLcv<Owner.pldMLL.MPEGFrames; iLcv++){
            LocationDeviation d = new LocationDeviation();
            d.Bytes=Stream.readWhole( (int) Owner.pldMLL.BitsForBytesDeviation/8);
            d.Milliseconds=Stream.readWhole((int) Owner.pldMLL.BitsForFramesDeviation/8);
            Owner.pldMLL.References.add(d);
        }
        Owner.Length = Owner.Reader.TagFrame.Header.Length;
        return true;
    }
    @Override
    public void Reset(){
        Owner.pldMLL.References.clear();
    }
    public MLLT(Payload owner) {
        super("MLLT",owner);
    }
}
