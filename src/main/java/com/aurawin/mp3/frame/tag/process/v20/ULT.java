package com.aurawin.mp3.frame.tag.process.v20;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fUnSynchronizedTranscription;

public class ULT extends Processor implements Process {
    @Override
    public boolean process( MemoryStream Stream){
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        Owner.StreamStart=Stream.position();
        Owner.Data=Owner.pldULT;
        Owner.Reader.TagFrame.Kind=fUnSynchronizedTranscription;

        Owner.pldULT.Encoding= Owner.pldText.Encoding.fromByte(Stream.readByte());;
        Owner.pldULT.Language= Stream.readString(3,Owner.pldULT.Encoding.toEncoding());
        Owner.pldULT.Description=Stream.readStringUntil((byte)0,Stream.position(),Owner.pldULT.Encoding.toEncoding());
        Owner.pldULT.Text = Stream.readString((int)(Owner.Length-(Stream.position()-Owner.StreamStart)), Owner.pldULT.Encoding.toEncoding());

        return true;
    }
    @Override
    public void Reset(){

    }
    public ULT(Payload owner) {
        super("ULT",owner);
    }
}
