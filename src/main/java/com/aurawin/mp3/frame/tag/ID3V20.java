package com.aurawin.mp3.frame.tag;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Frame;
import com.aurawin.mp3.frame.Reader;
import com.aurawin.mp3.frame.tag.process.Processor;

import java.util.HashMap;

import static com.aurawin.mp3.frame.Kind.fID3V20;

public class ID3V20 extends Frame {
    public boolean Unsynchronized;
    public boolean Compressed;

    public ID3V20(Reader reader){

        super(fID3V20,reader);

        Header  = new ID3V20Header(this,reader);
        Payload = new ID3V20Payload(this,reader);
    }
    @Override
    public void Reset(){
        super.Reset();
    }

    @Override
    public boolean Load(MemoryStream Stream){
        boolean handled = false;
        /*  Assume packets like this... are next
            Unique file identifier  "UFI"
            Frame size              $xx xx xx
            Owner identifier        <textstring> $00
            Identifier              <up to 64 bytes binary data>
        */
        handled=Header.Load(Stream);
        if (handled) {

            Payload.StreamStart=Stream.Position;
            Payload.Length=Header.Length;
            Length=Header.Length;
            handled=Payload.Load(Stream);
            if (handled == false) {
                Stream.Position=Payload.StreamStart + Payload.Length;
            }
        }
        return handled;
    }
    @Override
    public void Preload(MemoryStream Stream){}

}
