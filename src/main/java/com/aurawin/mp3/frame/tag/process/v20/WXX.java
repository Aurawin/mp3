package com.aurawin.mp3.frame.tag.process.v20;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.TextEncoding;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fUserDefinedURL;

public class WXX extends Processor implements Process {
    @Override
    public boolean process( MemoryStream Stream){
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        Owner.StreamStart=Stream.Position;
        Owner.Data=Owner.pldWXX;
        Owner.Reader.TagFrame.Kind=fUserDefinedURL;

        Owner.pldWXX.Encoding= TextEncoding.Base.fromByte(Stream.readByte());
        Owner.pldWXX.Description=Stream.readStringUntil((byte)0,Stream.Position,Owner.pldWXX.Encoding.toEncoding());
        Owner.pldWXX.URL = Stream.readString((int)(Owner.Length-(Stream.Position-Owner.StreamStart)), Owner.pldWXX.Encoding.toEncoding());

        return true;
    }
    @Override
    public void Reset(){

    }
    public WXX(Payload owner) {
        super("WXXX",owner);
    }
}
