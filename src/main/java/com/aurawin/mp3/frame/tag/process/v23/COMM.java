package com.aurawin.mp3.frame.tag.process.v23;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fComments;

public class COMM extends Processor implements Process {

    @Override
    public boolean process(MemoryStream Stream){
        Owner.Data=Owner.pldCOM;
        Owner.Reader.TagFrame.Kind=fComments;
        Owner.StreamStart=Stream.position();
        Owner.pldCOM.Encoding=Owner.pldCOM.Encoding.fromByte(Stream.readByte());
        Owner.pldCOM.Language=Stream.readString(3,"UTF-8");
        Owner.pldCOM.Description=Stream.readStringUntil((byte) 0,Stream.position(),Owner.pldCOM.Encoding.toEncoding());
        Owner.pldCOM.Text=Stream.readString((int)(Owner.Length-(Stream.position()-Owner.StreamStart)),Owner.pldCOM.Encoding.toEncoding());

        return true;
    }
    @Override
    public void Reset(){

    }
    public COMM(Payload owner) {
        super("COMM", owner);
    }
}