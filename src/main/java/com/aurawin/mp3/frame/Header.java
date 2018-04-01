package com.aurawin.mp3.frame;

import com.aurawin.core.stream.MemoryStream;

public class Header {
    protected String Name;
    protected byte VersionMajor;
    protected byte VersionMinor;
    protected Reader Reader;
    public long StreamStart;
    public  short Length;

    public void Reset();
    public abstract boolean Load(MemoryStream Stream);

    Header(Reader reader){
        Reader  = reader;
    }

    public void Release(){
        Reader = null;
    }
}
