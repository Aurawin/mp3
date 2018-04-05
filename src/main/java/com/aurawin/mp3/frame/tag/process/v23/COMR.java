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
        Owner.StreamStart=Stream.Position;
        Owner.pldCOMR.Encoding=Owner.pldCOM.Encoding.fromByte(Stream.readByte());
        Owner.pldCOMR.Price=Stream.readStringUntil(0,Stream.Position,Owner.pldCOMR.Encoding.toEncoding());
        Owner.pldCOMR.Expires=Stream.readStringUntil(0,Stream.Position,Owner.pldCOMR.Encoding.toEncoding());
        Owner.pldCOMR.Contact=Stream.readStringUntil(0,Stream.Position,Owner.pldCOMR.Encoding.toEncoding());
        Owner.pldCOMR.Kind=Owner.pldCOMR.Kind.fromByte(Stream.readByte());
        Owner.pldCOMR.Seller=Stream.readStringUntil(0,Stream.Position,Owner.pldCOMR.Encoding.toEncoding());
        Owner.pldCOMR.Description=Stream.readStringUntil(0,Stream.Position,Owner.pldCOMR.Encoding.toEncoding());
        Owner.pldCOMR.MimeType=Stream.readStringUntil(0,Stream.Position,Owner.pldCOMR.Encoding.toEncoding());
        Owner.pldCOMR.Logo = Stream.Read((int)(Owner.Length-(Stream.Position-Owner.StreamStart)));
        return true;

    }

    public COMR(Payload owner) {
        super("COMR", owner);
    }
}