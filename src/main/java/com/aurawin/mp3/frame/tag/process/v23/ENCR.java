package com.aurawin.mp3.frame.tag.process.v23;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.TextEncoding;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fBeatsPerMinute;
import static com.aurawin.mp3.frame.Kind.fEncryption;

public class ENCR extends Processor implements Process {
    @Override
    public boolean process( MemoryStream Stream){
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        Owner.StreamStart=Stream.Position;
        Owner.Data=Owner.pldENCR;
        Owner.Reader.TagFrame.Kind=fEncryption;

        Owner.pldENCR.Owner = Stream.readStringUntil((byte)0, Stream.Position, TextEncoding.Base.toEncoding());
        Owner.pldENCR.Method= Stream.readByte();
        Owner.pldENCR.Data=Stream.Read((int)(Owner.Length-(Stream.Position-Owner.StreamStart)));
        return true;
    }
    @Override
    public void Reset(){

    }
    public ENCR(Payload owner) {
        super("ENCR",owner);
    }
}
