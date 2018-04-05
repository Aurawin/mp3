package com.aurawin.mp3.frame.tag.process.v23;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fPicture;

public class APIC extends Processor implements Process {

    @Override
    public boolean process(MemoryStream Stream) {
        Owner.Reader.TagFrame.Kind=fPicture;
        Owner.Data=Owner.pldPIC;
        Owner.StreamStart=Stream.Position;
        Owner.Length=Owner.Reader.TagFrame.Length;
        Owner.pldPIC.Encoding=Owner.pldPIC.Encoding.fromByte(Stream.readByte());
        Owner.pldPIC.Format=Stream.readStringUntil((byte)0,Stream.Position,"UTF-8");
        Owner.pldPIC.Kind=Owner.pldPIC.Kind.fromByte(Stream.readByte());
        Owner.pldPIC.Description=Stream.readStringUntil((byte)0,Stream.Position,Owner.pldPIC.Encoding.toEncoding());
        Owner.pldPIC.Data=Stream.Read((int)(Owner.Length-(Stream.Position-Owner.StreamStart)));

        return true;
    }

    public APIC(Payload owner) {
        super("APIC", owner);
    }
}