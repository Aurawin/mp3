package com.aurawin.mp3.frame.tag.process.v23;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.TextEncoding;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fGeneralEncapsulatedObject;
import static com.aurawin.mp3.frame.Kind.fMusicCDIdentifier;

public class MCDI extends Processor implements Process {
    @Override
    public boolean process( MemoryStream Stream){
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        Owner.StreamStart=Stream.Position;
        Owner.Data=Owner.pldMCI;
        Owner.Reader.TagFrame.Kind=fMusicCDIdentifier;

        Owner.pldMCI.TOC=Stream.Read((int)(Owner.Length-(Stream.Position-Owner.StreamStart)));
        return true;
    }
    @Override
    public void Reset(){

    }
    public MCDI(Payload owner) {
        super("MCDI",owner);
    }
}
