package com.aurawin.mp3.frame.tag;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Frame;
import com.aurawin.mp3.frame.Kind;
import com.aurawin.mp3.frame.Reader;

import static com.aurawin.mp3.frame.Kind.fID3V23;

public class ID3V23 extends Frame {
    public ID3V23( Reader reader){
        super(fID3V23,reader);
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
