package com.aurawin.mp3.frame.tag.process.v23;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fModifiedBy;
import static com.aurawin.mp3.frame.Kind.fPartOfaSet;

public class TPOS extends Processor implements Process {
    @Override
    public boolean process( MemoryStream Stream){
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        Owner.StreamStart=Stream.position();
        Owner.Data=Owner.pldText;
        Owner.Reader.TagFrame.Kind=fPartOfaSet;

        Owner.pldText.Encoding= Owner.pldText.Encoding.fromByte(Stream.readByte());
        Owner.pldText.Data = Stream.readStringUntil((byte)0, Stream.position(), Owner.pldText.Encoding.toEncoding());

        return true;
    }
    @Override
    public void Reset(){

    }
    public TPOS(Payload owner) {
        super("TPOS",owner);
    }
}
