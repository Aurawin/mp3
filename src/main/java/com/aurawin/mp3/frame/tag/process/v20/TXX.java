package com.aurawin.mp3.frame.tag.process.v20;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;


import static com.aurawin.mp3.frame.Kind.fUserDefinedTextInformation;

public class TXX extends  Processor implements Process {
    @Override
    public boolean process( MemoryStream Stream){
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        Owner.StreamStart=Stream.position();
        Owner.Data=Owner.pldTXX;
        Owner.Reader.TagFrame.Kind=fUserDefinedTextInformation;

        Owner.pldTXX.Encoding= Owner.pldText.Encoding.fromByte(Stream.readByte());
        Owner.pldTXX.Description = Stream.readStringUntil((byte)0, Stream.position(), Owner.pldTXX.Encoding.toEncoding());
        Owner.pldTXX.Data = Stream.readString((int)(Owner.Length-(Stream.position()-Owner.StreamStart)), Owner.pldTXX.Encoding.toEncoding());
        return true;
    }
    @Override
    public void Reset(){

    }
    public TXX(Payload owner) {
        super("TXX",owner);
    }
}
