package com.aurawin.mp3.frame.tag.process.v20;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fInvolvedPeople;

public class IPL extends Processor implements Process {

    @Override
    public boolean process(MemoryStream Stream) {
        Owner.pldIPL.Payload.clear();

        Owner.Reader.TagFrame.Kind=fInvolvedPeople;
        Owner.Data=Owner.pldIPL;
        Owner.pldIPL.Encoding=Owner.pldIPL.Encoding.fromByte(Stream.readByte());
        Owner.StreamStart=Stream.Position;
        Owner.Length = Owner.Reader.TagFrame.Header.Length;
        while (Stream.Position<(Owner.StreamStart+Owner.Reader.TagFrame.Header.Length)){
            String p = Stream.readStringUntil((byte)0,Stream.Position,Owner.pldIPL.Encoding.toEncoding());
            String i = Stream.readStringUntil((byte)0,Stream.Position,Owner.pldIPL.Encoding.toEncoding());
            Owner.pldIPL.Payload.put(p,i);
        }

        return true;
    }

    public IPL(Payload owner) {
        super("IPL", owner);
    }
}