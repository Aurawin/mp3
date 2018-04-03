package com.aurawin.mp3.frame.tag;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Frame;
import com.aurawin.mp3.frame.Header;
import com.aurawin.mp3.frame.Reader;
public class ID3V20Header extends Header {


    @Override
    public void Reset(){
        super.Reset();

    }
    @Override
    public boolean Load(MemoryStream Stream){
        boolean Loaded = false;
        // Assume that position @ TAG

        ID = Stream.readString(3, "UTF8");
        Size = Stream.readWhole(3);
        Name=ID;
        Length=(short) Size;
        Loaded=(ID.length()>=3);

        return Loaded;
    }

    public ID3V20Header(Frame owner, Reader reader) {
        super(owner,reader);
    }
}
