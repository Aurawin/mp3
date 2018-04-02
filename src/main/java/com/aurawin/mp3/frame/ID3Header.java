package com.aurawin.mp3.frame;

import com.aurawin.core.stream.MemoryStream;

public class ID3Header extends Header {
    protected byte Flags;
    byte [] Size = new byte[4];

    public void Reset(){
        super.Reset();
    }
    @Override
    public boolean Load(MemoryStream Stream){

        boolean handled = false;

        class Version2 {
            void pushVersion2() {
                switch (VersionMinor) {
                    case (0):
                    Reader.TagFrame=Reader.ID3V20Tag;
                    break;
                    case (3):
                    Reader.TagFrame=Reader.ID3V23Tag;
                    break;
                }
            }
        }

        return handled;
    }
    ID3Header(Frame owner, Reader reader){
        super(owner,reader);
    }
}
