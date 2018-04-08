package com.aurawin.mp3.frame.tag.process.v23;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.TextEncoding;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fCopyrightInfo;
import static com.aurawin.mp3.frame.Kind.fOfficialAudioSourceWebpage;

public class WOAF extends Processor implements Process {
    @Override
    public boolean process( MemoryStream Stream){
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        Owner.StreamStart=Stream.Position;
        Owner.Data=Owner.pldURL;
        Owner.Reader.TagFrame.Kind=fOfficialAudioSourceWebpage;
        Owner.pldURL.URL = Stream.readString((int)(Owner.Length-(Stream.Position-Owner.StreamStart)), TextEncoding.Base.toEncoding());

        return true;
    }
    @Override
    public void Reset(){

    }
    public WOAF(Payload owner) {
        super("WOAF",owner);
    }
}