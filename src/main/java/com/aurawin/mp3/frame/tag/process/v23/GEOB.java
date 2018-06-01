package com.aurawin.mp3.frame.tag.process.v23;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.TextEncoding;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fEncryption;
import static com.aurawin.mp3.frame.Kind.fGeneralEncapsulatedObject;

public class GEOB extends Processor implements Process {
    @Override
    public boolean process( MemoryStream Stream){
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        Owner.StreamStart=Stream.position();
        Owner.Data=Owner.pldGEO;
        Owner.Reader.TagFrame.Kind=fGeneralEncapsulatedObject;

        Owner.pldGEO.Encoding = TextEncoding.Base.fromByte(Stream.readByte());
        Owner.pldGEO.MimeType= Stream.readStringUntil((byte)0, Stream.position(), Owner.pldGEO.Encoding.toEncoding());
        Owner.pldGEO.Filename= Stream.readStringUntil((byte)0, Stream.position(), Owner.pldGEO.Encoding.toEncoding());
        Owner.pldGEO.Description= Stream.readStringUntil((byte)0, Stream.position(), Owner.pldGEO.Encoding.toEncoding());

        Owner.pldGEO.Data=Stream.Read((int)(Owner.Length-(Stream.position()-Owner.StreamStart)));
        return true;
    }
    @Override
    public void Reset(){

    }
    public GEOB(Payload owner) {
        super("GEOB",owner);
    }
}
