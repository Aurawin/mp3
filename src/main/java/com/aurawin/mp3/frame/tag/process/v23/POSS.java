package com.aurawin.mp3.frame.tag.process.v23;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.TextEncoding;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fPositionSynchronization;
import static com.aurawin.mp3.frame.Kind.fPrivate;

public class POSS extends Processor implements Process {
    @Override
    public boolean process( MemoryStream Stream){
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        Owner.StreamStart=Stream.Position;
        Owner.Data=Owner.pldPOSS;
        Owner.Reader.TagFrame.Kind=fPositionSynchronization;

        Owner.pldPOSS.TimeStampFormat=Stream.readByte();
        Owner.pldPOSS.Position=Stream.readWhole((int)(Owner.Length-(Stream.Position-Owner.StreamStart)));

        return true;
    }
    @Override
    public void Reset(){

    }
    public POSS(Payload owner) {
        super("POSS",owner);
    }
}
