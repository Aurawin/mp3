package com.aurawin.mp3.frame.tag.process.v23;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fComments;
import static com.aurawin.mp3.frame.Kind.fCommericalInfo;

public class COMR extends Processor implements Process {

    @Override
    public boolean process(MemoryStream Stream){
        Owner.Data=Owner.pldCOMR;
        Owner.Reader.TagFrame.Kind=fCommericalInfo;
        Owner.StreamStart=Stream.position();
        Owner.pldCOMR.Encoding=Owner.pldCOM.Encoding.fromByte(Stream.readByte());
        Owner.pldCOMR.Price=Stream.readStringUntil((byte)0,Stream.position(),Owner.pldCOMR.Encoding.toEncoding());
        Owner.pldCOMR.Expires=Stream.readStringUntil((byte)0,Stream.position(),Owner.pldCOMR.Encoding.toEncoding());
        Owner.pldCOMR.Contact=Stream.readStringUntil((byte)0,Stream.position(),Owner.pldCOMR.Encoding.toEncoding());
        Owner.pldCOMR.Kind=Owner.pldCOMR.Kind.fromByte(Stream.readByte());
        Owner.pldCOMR.Seller=Stream.readStringUntil((byte)0,Stream.position(),Owner.pldCOMR.Encoding.toEncoding());
        Owner.pldCOMR.Description=Stream.readStringUntil((byte)0,Stream.position(),Owner.pldCOMR.Encoding.toEncoding());
        Owner.pldCOMR.MimeType=Stream.readStringUntil((byte)0,Stream.position(),Owner.pldCOMR.Encoding.toEncoding());
        Owner.pldCOMR.Logo = Stream.Read((int)(Owner.Length-(Stream.position()-Owner.StreamStart)));
        return true;

    }
    @Override
    public void Reset(){

    }
    public COMR(Payload owner) {
        super("COMR", owner);
    }
}