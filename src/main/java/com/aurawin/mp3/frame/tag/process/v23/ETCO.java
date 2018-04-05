package com.aurawin.mp3.frame.tag.process.v23;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.EventItem;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fEncryption;
import static com.aurawin.mp3.frame.Kind.fEventTimingCodes;

public class ETCO extends Processor implements Process {
    @Override
    public boolean process( MemoryStream Stream){
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        Owner.StreamStart=Stream.Position;
        Owner.Data=Owner.pldETC;
        Owner.Reader.TagFrame.Kind=fEventTimingCodes;

        long iStop=Owner.Reader.StreamPosition+Owner.Length;
        Owner.pldETC.Format = Owner.pldETC.Format.fromByte(Stream.readByte());

        while ((Stream.Position<iStop) && (Stream.Position<Stream.Size)) {
            EventItem ei =new EventItem();
            Owner.pldETC.Events.add(ei);
            ei.Kind = ei.Kind.fromInt((int)Stream.readWhole(1));
            ei.Stamp = (int) Stream.readWhole(1);
        }
        Owner.Reader.StreamPosition = Stream.Position;
        return true;
    }

    public ETCO(Payload owner) {
        super("ETCO",owner);
    }
}
