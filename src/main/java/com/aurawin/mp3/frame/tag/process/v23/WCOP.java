package com.aurawin.mp3.frame.tag.process.v23;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.TextEncoding;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fCopyrightInfo;
import static com.aurawin.mp3.frame.Kind.fUnSynchronizedTranscription;

public class WCOP extends Processor implements Process {
    @Override
    public boolean process( MemoryStream Stream){
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        Owner.StreamStart=Stream.position();
        Owner.Data=Owner.pldULT;
        Owner.Reader.TagFrame.Kind=fCopyrightInfo;

        Owner.pldURL.URL = Stream.readString((int)(Owner.Length-(Stream.position()-Owner.StreamStart)), TextEncoding.Base.toEncoding());

        return true;
    }
    @Override
    public void Reset(){

    }
    public WCOP(Payload owner) {
        super("WCOP",owner);
    }
}
