package com.aurawin.mp3.frame.tag.process.v20;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fMusicCDIdentifier;

public class MCI extends Processor implements Process {

    @Override
    public boolean process(MemoryStream Stream) {
        Owner.Reader.TagFrame.Kind=fMusicCDIdentifier;
        Owner.Data=Owner.pldMCI;
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        Owner.pldMCI.TOC=Stream.Read((int)Owner.Length);
        return true;
    }

    public MCI(Payload owner) {
        super("MCI", owner);
    }
}