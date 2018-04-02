package com.aurawin.mp3.frame;

import com.aurawin.core.stream.MemoryStream;

public class ID3Payload extends Payload {

    @Override
    public boolean Load(MemoryStream Stream) {
        boolean handled=false;

        return handled;
    }

    ID3Payload(ID3 owner, Reader reader){
        super(owner, reader);

    }
}
