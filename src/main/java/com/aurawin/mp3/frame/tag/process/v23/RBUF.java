package com.aurawin.mp3.frame.tag.process.v23;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fBufferSize;
import static com.aurawin.mp3.frame.Kind.fPositionSynchronization;

public class RBUF extends Processor implements Process {
    @Override
    public boolean process( MemoryStream Stream){
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        Owner.StreamStart=Stream.Position;
        Owner.Data=Owner.pldBUF;
        Owner.Reader.TagFrame.Kind=fBufferSize;

        Owner.pldBUF.Size=Stream.readWhole(3);
        Owner.pldBUF.Flags=Stream.readByte();
        Owner.pldBUF.Offset=Stream.readWhole(4);

        return true;
    }
    @Override
    public void Reset(){

    }
    public RBUF(Payload owner) {
        super("RBUF",owner);
    }
}
