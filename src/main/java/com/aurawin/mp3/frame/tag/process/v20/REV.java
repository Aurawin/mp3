package com.aurawin.mp3.frame.tag.process.v20;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fReverb;

public class REV extends Processor implements Process {
    @Override
    public boolean process( MemoryStream Stream){
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        Owner.StreamStart=Stream.Position;
        Owner.Data=Owner.pldREV;
        Owner.Reader.TagFrame.Kind=fReverb;

        Owner.pldREV.Left=(short)Stream.readWhole((int)2);
        Owner.pldREV.Right=(short)Stream.readWhole((int)2);
        Owner.pldREV.BouncesLeft=Stream.readByte();
        Owner.pldREV.BouncesRight=Stream.readByte();
        Owner.pldREV.FeedbackLeftToLeft=Stream.readByte();
        Owner.pldREV.FeedbackLeftToRight=Stream.readByte();
        Owner.pldREV.FeedbackRightToRight=Stream.readByte();
        Owner.pldREV.FeedbackRightToLeft=Stream.readByte();
        Owner.pldREV.PremixLeftToRight=Stream.readByte();
        Owner.pldREV.PremixRightToLeft=Stream.readByte();


        return true;
    }
    @Override
    public void Reset(){

    }
    public REV(Payload owner) {
        super("REV",owner);
    }
}
