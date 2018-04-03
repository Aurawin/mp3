package com.aurawin.mp3.frame.tag.process.V20;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.SynchronizedText;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fSyncedText;

public class SLT extends Processor implements Process {

    @Override
    public boolean process(MemoryStream Stream) {
        Owner.Reader.TagFrame.Kind=fSyncedText;
        Owner.Data=Owner.pldSLT;
        Owner.StreamStart=Stream.Position;
        Owner.Length=Owner.Reader.TagFrame.Length;

        Owner.pldSLT.Encoding=Owner.pldSLT.Encoding.fromByte(Stream.readByte());
        Owner.pldSLT.Language=Stream.readString(3,"UTF-8");
        Owner.pldSLT.Format=Owner.pldSLT.Format.fromByte(Stream.readByte());
        Owner.pldSLT.ContentType = Owner.pldSLT.ContentType.fromByte(Stream.readByte());
        Owner.pldSLT.Description=Stream.readStringUntil((byte)0,Stream.Position,Owner.pldSLT.Encoding.toEncoding());

        while (Stream.Position< Owner.Length-(Stream.Position-Owner.StreamStart)){
            SynchronizedText l = new SynchronizedText();
            l.Text=Stream.readStringUntil((byte)0,Stream.Position,Owner.pldSLT.Encoding.toEncoding());
            l.Stamp=Stream.readByte();
            Owner.pldSLT.List.add(l);
        }
        Owner.pldPIC.Data=Stream.Read((int)(Owner.Length-(Stream.Position-Owner.StreamStart)));

        return true;
    }

    public SLT(Payload owner) {
        super("SLT", owner);
    }
}