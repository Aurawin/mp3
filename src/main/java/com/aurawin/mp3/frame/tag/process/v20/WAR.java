package com.aurawin.mp3.frame.tag.process.v20;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.TextEncoding;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fOfficialFileWebpage;

public class WAR extends Processor implements Process {
    @Override
    public boolean process( MemoryStream Stream){
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        Owner.StreamStart=Stream.position();
        Owner.Data=Owner.pldURL;
        Owner.Reader.TagFrame.Kind=fOfficialFileWebpage;
        Owner.pldURL.URL = Stream.readString((int)(Owner.Length-(Stream.position()-Owner.StreamStart)), TextEncoding.Base.toEncoding());

        return true;
    }
    @Override
    public void Reset(){

    }
    public WAR(Payload owner) {
        super("WAR",owner);
    }
}
