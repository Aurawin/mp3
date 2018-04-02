package com.aurawin.mp3.frame.tag;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Header;

public class ID3V20Header extends Header {


    @Override
    public void Reset(){
        super.Reset();

    }
    @Override
    public boolean Load(MemoryStream Stream){
        boolean Loaded = false;
        // Assume that position @ TAG

        Stream.Read(ID,3);
        Stream.Read(Size,3);
        Name=ID;
        Length=Size;
        Loaded=(ID.length()>=3);

        return Loaded;
    }
}
