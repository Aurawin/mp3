package com.aurawin.mp3.frame.tag.process.V20;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fLinkedInfo;

public class LNK extends Processor implements Process {

    @Override
    public boolean process(MemoryStream Stream) {
        Owner.Data=Owner.pldLNK;
        Owner.Reader.TagFrame.Kind=fLinkedInfo;
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        Owner.StreamStart=Stream.Position;
        Owner.pldLNK.FrameId=Stream.Read(3);
        Owner.pldLNK.URL=Stream.readStringUntil((byte)0,Stream.Position,"UTF-8");
        while (Stream.Position<(Owner.Length+Owner.StreamStart)) {
            Owner.pldLNK.List.add(Stream.readStringUntil((byte) 0, Stream.Position, "UTF-8"));
        }
        return true;
    }

    public LNK(Payload owner) {
        super("LNK", owner);
    }
}