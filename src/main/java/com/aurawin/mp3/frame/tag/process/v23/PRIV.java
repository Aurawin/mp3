package com.aurawin.mp3.frame.tag.process.v23;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.TextEncoding;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fOwnership;
import static com.aurawin.mp3.frame.Kind.fPrivate;

public class PRIV extends Processor implements Process {
    @Override
    public boolean process( MemoryStream Stream){
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        Owner.StreamStart=Stream.position();
        Owner.Data=Owner.pldPRIV;
        Owner.Reader.TagFrame.Kind=fPrivate;

        Owner.pldPRIV.Owner=Stream.readStringUntil((byte)0,Stream.position(),TextEncoding.Base.toEncoding());
        Owner.pldPRIV.Data=Stream.Read((int)(Owner.Length-(Stream.position()-Owner.StreamStart)));

        return true;
    }
    @Override
    public void Reset(){

    }
    public PRIV(Payload owner) {
        super("PRIV",owner);
    }
}
