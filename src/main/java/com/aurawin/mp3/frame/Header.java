package com.aurawin.mp3.frame;

import com.aurawin.core.stream.MemoryStream;

public abstract class Header {
    protected Frame Owner;
    protected String Name;
    protected byte VersionMajor;
    protected byte VersionMinor;
    protected Reader Reader;
    public long StreamStart;
    public  short Length;

    public void Reset(){};
    public abstract boolean Load(MemoryStream Stream);
    public Frame getFrame(){ return Owner;};
    Header(Frame owner, Reader reader){
        Owner = owner;
        Reader  = reader;
    }

    public void Release(){
        Reader = null;
    }
}
