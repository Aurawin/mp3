package com.aurawin.mp3.frame.tag;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Frame;
import com.aurawin.mp3.frame.Reader;
import com.aurawin.mp3.frame.Kind;

import static com.aurawin.mp3.frame.Kind.fID3V30;

public class ID3V30 extends Frame {
    public ID3V30(Reader reader){
        super(fID3V30,reader);
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
