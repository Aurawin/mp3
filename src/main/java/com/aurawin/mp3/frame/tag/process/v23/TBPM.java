package com.aurawin.mp3.frame.tag.process.v23;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fBeatsPerMinute;
import static com.aurawin.mp3.frame.Kind.fTitle;

public class TBPM extends Processor implements Process {
    @Override
    public boolean process( MemoryStream Stream){
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        Owner.StreamStart=Stream.position();
        Owner.Data=Owner.pldText;
        Owner.Reader.TagFrame.Kind=fBeatsPerMinute;

        Owner.pldText.Encoding= Owner.pldText.Encoding.fromByte(Stream.readByte());
        Owner.pldText.Data = Stream.readStringUntil((byte)0, Stream.position(), Owner.pldText.Encoding.toEncoding());

        return true;
    }
    @Override
    public void Reset(){

    }
    public TBPM(Payload owner) {
        super("TBPM",owner);
    }
}
