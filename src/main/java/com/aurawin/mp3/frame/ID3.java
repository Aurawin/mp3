package com.aurawin.mp3.frame;

import com.aurawin.core.stream.MemoryStream;

public class ID3 extends Frame {

    public boolean Load(MemoryStream Stream){
        boolean handled=false;

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

    }
}
