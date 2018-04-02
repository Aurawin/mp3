package com.aurawin.mp3.frame;

import com.aurawin.core.stream.MemoryStream;

public class ID3 extends Frame {

    public boolean Load(MemoryStream Stream){
        boolean handled=false;

        Position=Stream.Position;
        Header.StreamStart=Stream.Find(ID);
        if (Header.StreamStart>-1) {
            // found instance...
            handled=Header.Load(Stream);
            if (handled)  {
                Payload.StreamStart=Stream.Position;
                Payload.Length=Header.Length;
                handled = Payload.Load(Stream);
                if (handled = false) {
                    Stream.Position = Payload.StreamStart + Payload.Length;
                }
            }
        }
        return handled;
    }
    public void Preload(MemoryStream Stream){

    }
    public void Reset(){
        super.Reset();
    }

    ID3(Kind kind, Reader reader) {
        super(kind, reader);
        ID = "ID3";
        Header = new ID3Header(this,reader);
        Payload = new ID3Payload(this,reader);
    }
}
