package com.aurawin.mp3.frame.tag.process.V20;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fOfficialFileWebpage;

public class WPB extends Processor implements Process {
    @Override
    public boolean process( MemoryStream Stream){
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        Owner.StreamStart=Stream.Position;
        Owner.Data=Owner.pldWPB;
        Owner.Reader.TagFrame.Kind=fOfficialFileWebpage;
        Owner.pldWPB.URL = Stream.readString((int)(Owner.Length-(Stream.Position-Owner.StreamStart)), Owner.pldText.Encoding.toEncoding());

        return true;
    }

    public WPB(Payload owner) {
        super("WPB",owner);
    }
}
