package com.aurawin.mp3.frame.tag.process.v23;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;
import com.aurawin.mp3.volume.EqualizationBand;

import static com.aurawin.mp3.frame.Kind.fBeatsPerMinute;
import static com.aurawin.mp3.frame.Kind.fEqualization;
import static com.aurawin.mp3.volume.Adjustment.Decrement;
import static com.aurawin.mp3.volume.Adjustment.Increment;

public class EQUA extends Processor implements Process {
    @Override
    public boolean process( MemoryStream Stream){
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        Owner.StreamStart=Stream.Position;
        Owner.Data=Owner.pldEQU;
        Owner.Reader.TagFrame.Kind=fEqualization;
        Owner.pldEQU.AdjustmentBits=Stream.readByte();
        int hdr = (int) Stream.readWhole(2);

        EqualizationBand eb = new EqualizationBand();
        eb.Direction = ((byte) (hdr  & (1 <<15) >>15))==0 ? Decrement: Increment;
        eb.Frequency = hdr ^ (1 << 15);
        eb.Adjustment=Stream.Read((int)(Owner.Length-(Stream.Position-Owner.StreamStart)));

        return true;
    }
    @Override
    public void Reset(){

    }
    public EQUA(Payload owner) {
        super("EQUA",owner);
    }
}
