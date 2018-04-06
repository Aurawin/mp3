package com.aurawin.mp3.frame.tag.process.v20;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;


import static com.aurawin.mp3.frame.Kind.fSyncedTempo;

public class STC extends Processor implements Process {

    @Override
    public boolean process(MemoryStream Stream) {
        Owner.Reader.TagFrame.Kind=fSyncedTempo;
        Owner.Data=Owner.pldSTC;
        Owner.StreamStart=Stream.Position;
        Owner.Length=Owner.Reader.TagFrame.Length;
        Owner.pldSTC.Format = Owner.pldSTC.Format.fromByte(Stream.readByte());
        Owner.pldSTC.Data=Stream.Read((int)(Owner.Length-(Stream.Position-Owner.StreamStart)));
        return true;
    }
    @Override
    public void Reset(){

    }
    public STC(Payload owner) {
        super("STC", owner);
    }
}