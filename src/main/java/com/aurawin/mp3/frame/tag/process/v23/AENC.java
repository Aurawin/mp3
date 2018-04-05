package com.aurawin.mp3.frame.tag.process.v23;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fAudioEncryption;
import static com.aurawin.mp3.frame.Kind.fPopularimeter;

public class AENC extends Processor implements Process {
    @Override
    public boolean process( MemoryStream Stream){
        Owner.StreamStart=Stream.Position;
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        Owner.pldCRA.Owner=Stream.readStringUntil((byte)0,Stream.Position,"UTF-8");
        Owner.pldCRA.PreviewStart=Stream.readWhole(2);
        Owner.pldCRA.PreviewLength=Stream.readWhole(2);
        Owner.pldCRA.Data=Stream.Read((int)(Owner.Length-(Stream.Position-Owner.StreamStart)));
        Owner.Data=Owner.pldCRA;
        Owner.Reader.TagFrame.Kind=fAudioEncryption;
        return true;
    }

    public AENC(Payload owner) {
        super("AENC",owner);
    }
}
