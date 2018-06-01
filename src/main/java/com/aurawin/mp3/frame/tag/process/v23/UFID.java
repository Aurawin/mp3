package com.aurawin.mp3.frame.tag.process.v23;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.TextEncoding;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fUniqueFileID;
import static com.aurawin.mp3.frame.Kind.fYear;

public class UFID extends Processor implements Process {
    @Override
    public boolean process( MemoryStream Stream){
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        Owner.StreamStart=Stream.position();
        Owner.Data=Owner.pldUFI;
        Owner.Reader.TagFrame.Kind=fUniqueFileID;


        Owner.pldUFI.Owner = Stream.readStringUntil((byte)0, Stream.position(), TextEncoding.Base.toEncoding());
        Owner.pldUFI.Identifier=Stream.Read((int)(Owner.Length-(Stream.position()-Owner.StreamStart)));
        return true;
    }
    @Override
    public void Reset(){

    }
    public UFID(Payload owner) {
        super("UFID",owner);
    }
}
