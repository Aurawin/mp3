package com.aurawin.mp3.frame;

import com.aurawin.core.stream.MemoryStream;

public abstract class Frame {
    String ID;
    protected boolean Preloaded;
    public Header Header;
    public Payload Payload;

    public Kind Kind;
    protected Reader Reader;
    protected long Position;
    protected short Length;

    public long AggregateLength;

    public void Reset(){}

    public abstract void Preload(MemoryStream Stream);
    public abstract boolean Load(MemoryStream Stream );

    Frame (Kind kind, Reader reader){
        Reader = reader;
        Kind = kind;
    }



}
