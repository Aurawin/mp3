package com.aurawin.mp3.frame;

import com.aurawin.core.stream.MemoryStream;

public class ID3Header extends Header {



    public void Reset(){
        super.Reset();
    }
    @Override
    public boolean Load(MemoryStream Stream){

        boolean handled = false;
        VersionMajor=Stream.readByte();
        VersionMinor=Stream.readByte();
        Flags = Stream.readByte();
        Length = Stream.readWhole(4);
        Reader.TagFrame=null;

        switch (VersionMinor) {
            case (0):
                    Reader.TagFrame=Reader.ID3V20Tag;
                    break;
            case (3):
                    Reader.TagFrame=Reader.ID3V23Tag;
                    break;
        }
        handled=Reader.TagFrame!=null;

        return handled;
    }
    ID3Header(Frame owner, Reader reader){
        super(owner,reader);
    }
}
