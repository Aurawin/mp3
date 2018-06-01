package com.aurawin.mp3.frame.tag.process.v23;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.TextEncoding;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fPlayCounter;
import static com.aurawin.mp3.frame.Kind.fPopularimeter;

public class POPM extends Processor implements Process {
    @Override
    public boolean process( MemoryStream Stream){
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        Owner.StreamStart=Stream.position();
        Owner.Data=Owner.pldPOP;
        Owner.Reader.TagFrame.Kind=fPopularimeter;

        Owner.pldPOP.Email=Stream.readStringUntil((byte)0, Stream.position(), TextEncoding.Base.toEncoding());
        Owner.pldPOP.Rating=Stream.readByte();
        Owner.pldPOP.Counter=Stream.readWhole((int)(Owner.Length-(Stream.position()-Owner.StreamStart)));

        return true;
    }
    @Override
    public void Reset(){

    }
    public POPM(Payload owner) {
        super("POPM",owner);
    }
}
