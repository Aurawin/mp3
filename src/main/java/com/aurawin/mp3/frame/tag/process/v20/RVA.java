package com.aurawin.mp3.frame.tag.process.v20;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fVolumeAdj;
import static com.aurawin.mp3.volume.Adjustment.Decrement;
import static com.aurawin.mp3.volume.Adjustment.Increment;
import static com.aurawin.mp3.volume.Channel.Left;
import static com.aurawin.mp3.volume.Channel.Right;

public class RVA extends Processor implements Process {
    @Override
    public boolean process( MemoryStream Stream){
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        Owner.StreamStart=Stream.position();
        Owner.Data=Owner.pldRVA;
        Owner.Reader.TagFrame.Kind=fVolumeAdj;
        byte value=Stream.readByte();

        Owner.pldRVA.Channel=(((value & (1 <<0)) >> 0)==0)? Right : Left;
        Owner.pldRVA.Adjustment=(((value & (1 <<1)) >> 1)==0)? Decrement : Increment;
        Owner.pldRVA.Description=Stream.readByte();

        Owner.pldRVA.DeltaRight = Stream.readWhole((int)Owner.pldRVA.Description/8);
        Owner.pldRVA.DeltaLeft = Stream.readWhole((int) Owner.pldRVA.Description/8);
        Owner.pldRVA.PeekVolumeRight = Stream.readWhole((int) Owner.pldRVA.Description/8);
        Owner.pldRVA.PeekVolumeLeft = Stream.readWhole((int)Owner.pldRVA.Description/8);

        return true;
    }
    @Override
    public void Reset(){

    }
    public RVA(Payload owner) {
        super("RVA",owner);
    }
}
