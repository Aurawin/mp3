package com.aurawin.mp3.frame.tag.process.V20;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fTextWriter;
import static com.aurawin.mp3.frame.Kind.fUniqueFileID;

public class UFI extends Processor implements Process {
    @Override
    public boolean process( MemoryStream Stream){
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        Owner.StreamStart=Stream.Position;
        Owner.Data=Owner.pldUFI;
        Owner.Reader.TagFrame.Kind=fUniqueFileID;

        Owner.pldUFI.Owner = Stream.readStringUntil((byte)0, Stream.Position, Owner.pldText.Encoding.toEncoding());
        Owner.pldUFI.Identifier=Stream.Read((int)(Owner.Length-(Stream.Position-Owner.StreamStart)));
        return true;
    }

    public UFI(Payload owner) {
        super("UFI",owner);
    }
}