package com.aurawin.mp3.frame.tag.process.v23;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.TextEncoding;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fPlayCounter;
import static com.aurawin.mp3.frame.Kind.fPrivate;

public class PCNT extends Processor implements Process {
    @Override
    public boolean process( MemoryStream Stream){
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        Owner.StreamStart=Stream.Position;
        Owner.Data=Owner.pldCNT;
        Owner.Reader.TagFrame.Kind=fPlayCounter;
        Owner.pldCNT.Counter=Stream.readWhole((int)(Owner.Length-(Stream.Position-Owner.StreamStart)));

        return true;
    }
    @Override
    public void Reset(){

    }
    public PCNT(Payload owner) {
        super("PCNT",owner);
    }
}
