package com.aurawin.mp3.frame.tag;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Frame;
import com.aurawin.mp3.frame.Kind;
import com.aurawin.mp3.frame.Reader;

import static com.aurawin.mp3.frame.Kind.fID3V20;
import static com.aurawin.mp3.frame.Kind.fID3V23;

public class ID3V23 extends Frame {
    public ID3V23( Reader reader){
        super(fID3V23,reader);
        Header  = new ID3V20Header(this,reader);
        Payload = new ID3V20Payload(this,reader);
        // todo Processors.add(new com.aurawin.mp3.frame.tag.process.v23.BUFF(Payload));
    }

    @Override
    public boolean Load(MemoryStream Stream){
        boolean Handled = false;



        return Handled;
    }

    @Override
    public void Preload(MemoryStream Stream){

    }
}
