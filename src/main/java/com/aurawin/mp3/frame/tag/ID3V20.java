package com.aurawin.mp3.frame.tag;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Frame;
import com.aurawin.mp3.frame.Reader;

import static com.aurawin.mp3.frame.Kind.fID3V20;

public class ID3V20 extends Frame {
    public boolean Unsynchronized;
    public boolean Compressed;

    public ID3V20(Reader reader){
        super(fID3V20,reader);
    }
    @Override
    public void Reset(){
        super.Reset();
    }
    @Override
    public boolean Load(MemoryStream Stream){
        boolean handled=false;

        return handled;
    }
    @Override
    public void Preload(MemoryStream Stream){}

}
