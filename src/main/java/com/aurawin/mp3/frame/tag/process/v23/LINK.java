package com.aurawin.mp3.frame.tag.process.v23;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.TextEncoding;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fGroupIdentificationRegistration;
import static com.aurawin.mp3.frame.Kind.fURL;

public class LINK extends Processor implements Process {
    @Override
    public boolean process( MemoryStream Stream){
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        Owner.StreamStart=Stream.Position;
        Owner.Data=Owner.pldLNK;
        Owner.Reader.TagFrame.Kind=fURL;


        Owner.pldLNK.FrameId=Stream.readWhole(3);
        Owner.pldLNK.URL=Stream.readStringUntil((byte)0, Stream.Position, TextEncoding.Base.toEncoding());
        while ((Owner.Length-(Stream.Position-Owner.StreamStart))>0) {
            String u =Stream.readStringUntil((byte)0, Stream.Position, TextEncoding.Base.toEncoding());
            Owner.pldLNK.List.add(u);
        }
        return true;
    }
    @Override
    public void Reset(){
        Owner.pldLNK.List.clear();
    }
    public LINK(Payload owner) {
        super("LINK",owner);
    }
}
