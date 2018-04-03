package com.aurawin.mp3.frame.tag.process.V20;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fAudioEncryption;

public class CRA extends Processor implements Process {

    @Override
    public boolean process(MemoryStream Stream) {
        Owner.Reader.TagFrame.Kind=fAudioEncryption;
        Owner.Data=Owner.pldCRA;
        Owner.Length=Stream.Position;
        Owner.pldCRA.Owner=Stream.readStringUntil((byte) 0, Stream.Position, "UTF-8");
        Owner.pldCRA.PreviewStart = (short) Stream.readWhole((int) 2);
        Owner.pldCRA.PreviewLength = (short) Stream.readWhole((int)2);
        Owner.Length = Owner.Reader.TagFrame.Header.Length - (Stream.Position - Owner.Length);
        Owner.pldCRA.Data = Stream.Read((int) Owner.Length);
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        return true;
    }

    public CRA(Payload owner) {
        super("CRA", owner);
    }
}