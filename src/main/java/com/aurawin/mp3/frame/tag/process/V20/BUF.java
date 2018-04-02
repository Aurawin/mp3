package com.aurawin.mp3.frame.tag.process.V20;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Processor;
import com.aurawin.mp3.frame.tag.process.Process;
import static com.aurawin.mp3.frame.Kind.fBufferSize;

public class BUF extends Processor implements Process{
    @Override
    public boolean process(String Key, MemoryStream Stream){
        Owner.Data = Owner.pldBUF;
        Owner.Reader.ID3V20Tag.Kind = fBufferSize;
        Owner.pldBUF.Size = Stream.readWhole(3);
        Owner.pldBUF.Flags = Stream.readByte();
        Owner.pldBUF.Offset = Stream.readInteger();
        Owner.Length = Owner.Reader.TagFrame.Header.Length;
        return true;
    }

    public BUF(Payload owner) {
        super(owner);
    }
}
