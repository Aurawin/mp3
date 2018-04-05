package com.aurawin.mp3.frame.tag.process.v20;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fGeneralEncapsulatedObject;

public class GEO extends Processor implements Process {

    @Override
    public boolean process(MemoryStream Stream) {
        Owner.Reader.TagFrame.Kind=fGeneralEncapsulatedObject;
        Owner.Data=Owner.pldGEO;
        Owner.Length=Stream.Position;
        Owner.pldGEO.Encoding = Owner.pldGEO.Encoding.fromByte(Stream.readByte());
        Owner.pldGEO.MimeType=Stream.readStringUntil((byte)0, Stream.Position, Owner.pldGEO.Encoding.toEncoding());
        Owner.pldGEO.Filename=Stream.readStringUntil((byte)0, Stream.Position, Owner.pldGEO.Encoding.toEncoding());
        Owner.pldGEO.Description=Stream.readStringUntil((byte)0, Stream.Position,Owner.pldGEO.Encoding.toEncoding());

        Owner.Length=Owner.Reader.TagFrame.Length-(Stream.Position-Owner.Length);
        Owner.pldGEO.Data = Stream.Read((int)Owner.Length);

        return true;
    }

    public GEO(Payload owner) {
        super("GEO", owner);
    }
}