package com.aurawin.mp3.frame.tag.process.v20;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.EventItem;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fEventTimingCodes;

public class ETC extends Processor implements Process {

    @Override
    public boolean process(MemoryStream Stream) {
        Owner.Data=Owner.pldETC;
        Owner.Reader.TagFrame.Kind=fEventTimingCodes;
        Owner.Reader.StreamPosition=Stream.Position;
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        long iStop=Owner.Reader.StreamPosition+Owner.Length;
        Owner.pldETC.Format = Owner.pldETC.Format.fromByte(Stream.readByte());

        while (Stream.Position<iStop) {
            EventItem ei =new EventItem();
            Owner.pldETC.Events.add(ei);
            ei.Kind = ei.Kind.fromInt((int)Stream.readWhole(1));
            ei.Stamp = (int) Stream.readWhole(1);
            while (Stream.Position<iStop ) {
                // Do nothing but assume padding
            }
        }
        Owner.Reader.StreamPosition = Stream.Position;
        return true;
    }

    public ETC(Payload owner) {
        super("ETC", owner);
    }
}
