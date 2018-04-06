package com.aurawin.mp3.frame.tag.process.v23;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fMusicCDIdentifier;
import static com.aurawin.mp3.frame.Kind.fOwnership;

public class OWNE extends Processor implements Process {
    @Override
    public boolean process( MemoryStream Stream){
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        Owner.StreamStart=Stream.Position;
        Owner.Data=Owner.pldOWNE;
        Owner.Reader.TagFrame.Kind=fOwnership;

        Owner.pldOWNE.Encoding=Owner.pldPIC.Encoding.fromByte(Stream.readByte());
        Owner.pldOWNE.PricePaid=Stream.readStringUntil((byte)0,Stream.Position,Owner.pldOWNE.Encoding.toEncoding());
        Owner.pldOWNE.Date=Stream.readStringUntil((byte)0,Stream.Position,Owner.pldOWNE.Encoding.toEncoding());
        Owner.pldOWNE.Seller=Stream.readString((int)(Owner.Length-(Stream.Position-Owner.StreamStart)),Owner.pldOWNE.Encoding.toEncoding());

        return true;
    }
    @Override
    public void Reset(){

    }
    public OWNE(Payload owner) {
        super("OWNE",owner);
    }
}
