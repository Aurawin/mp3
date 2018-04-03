package com.aurawin.mp3.frame.tag.process.V20;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fCopyrightInfo;
public class WCP extends Processor implements Process {
    @Override
    public boolean process( MemoryStream Stream){
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        Owner.StreamStart=Stream.Position;
        Owner.Data=Owner.pldWCP;
        Owner.Reader.TagFrame.Kind=fCopyrightInfo;
        Owner.pldWCP.URL = Stream.readString((int)(Owner.Length-(Stream.Position-Owner.StreamStart)), Owner.pldText.Encoding.toEncoding());

        return true;
    }

    public WCP(Payload owner) {
        super("WCP",owner);
    }
}
