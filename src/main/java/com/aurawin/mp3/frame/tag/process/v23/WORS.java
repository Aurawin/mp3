package com.aurawin.mp3.frame.tag.process.v23;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.TextEncoding;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fOfficialAudioSourceWebpage;
import static com.aurawin.mp3.frame.Kind.fOfficialRadioStationWebpage;
import static com.aurawin.mp3.frame.Kind.fRadioStationOwner;

public class WORS extends Processor implements Process {
    @Override
    public boolean process( MemoryStream Stream){
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        Owner.StreamStart=Stream.Position;
        Owner.Data=Owner.pldURL;
        Owner.Reader.TagFrame.Kind=fOfficialRadioStationWebpage;
        Owner.pldURL.URL = Stream.readString((int)(Owner.Length-(Stream.Position-Owner.StreamStart)), TextEncoding.Base.toEncoding());

        return true;
    }
    @Override
    public void Reset(){

    }
    public WORS(Payload owner) {
        super("WORS",owner);
    }
}
