package com.aurawin.mp3.frame.tag.process.v20;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Processor;
import com.aurawin.mp3.frame.tag.process.Process;
import static com.aurawin.mp3.frame.Kind.fPlayCounter;

public class CNT extends Processor implements Process {
    @Override
    public boolean process( MemoryStream Stream){
        Owner.Data=Owner.pldCNT;
        Owner.Reader.TagFrame.Kind=fPlayCounter;
        Owner.pldCNT.Counter= Stream.readWhole((int) Owner.Reader.TagFrame.Length);

        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        return true;
    }
    @Override
    public void Reset(){

    }
    public CNT(Payload owner) {
        super("CNT",owner);
    }
}
