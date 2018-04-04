package com.aurawin.mp3.frame.tag.process.V20;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fEncodedBy;
import static com.aurawin.mp3.frame.Kind.fOriginalReleaseYear;

public class TOR extends Processor implements Process {
    @Override
    public boolean process( MemoryStream Stream){
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        Owner.StreamStart=Stream.Position;
        Owner.Data=Owner.pldText;
        Owner.Reader.TagFrame.Kind=fOriginalReleaseYear;

        Owner.pldText.Encoding= Owner.pldText.Encoding.fromByte(Stream.readByte());
        Owner.pldText.Data = Stream.readStringUntil((byte)0, Stream.Position, Owner.pldText.Encoding.toEncoding());

        return true;
    }

    public TOR(Payload owner) {
        super("TOR",owner);
    }
}
