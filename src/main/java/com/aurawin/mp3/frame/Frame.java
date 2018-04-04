package com.aurawin.mp3.frame;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.tag.process.Processor;

import java.util.ArrayList;

public abstract class Frame {
    public ArrayList<Processor> Processors = new ArrayList<>();

    public String ID;
    public boolean Preloaded;

    public Header Header;
    public Payload Payload;

    public Kind Kind;
    public  Reader Reader;
    public long Position;
    public  long Length;

    public long AggregateLength;

    public void Reset(){
        ID = "";

        Position=0;
        Length=0;
        Preloaded=false;
        AggregateLength=0;

        Header.Reset();
        Payload.Reset();
    }

    public abstract void Preload(MemoryStream Stream);
    public abstract boolean Load(MemoryStream Stream );

    public Frame (Kind kind, Reader reader){
        Reader = reader;
        Kind = kind;
    }

    public Processor getProcessor(String key){
        return Processors.stream().filter(p->p.Key.equalsIgnoreCase(key)).findFirst().orElse(null);
    }
    public void Release(){
        Reader = null;
        if (Header!=null) Header.Release();
        if (Payload!=null) Payload.Release();

        Header = null;
        Payload = null;
    }
}
