package com.aurawin.mp3.frame;

import com.aurawin.core.stream.MemoryStream;

public abstract class Header {
    public String ID = "";
    public long Size;
    protected Frame Owner;
    protected String Name;
    protected byte VersionMajor;
    protected byte VersionMinor;
    protected Reader Reader;
    public long StreamStart;
    public  short Length;

    public void Reset(){
        VersionMajor =0;
        VersionMinor =0;
        Length =0;
        Size = 0;
        ID = "";
        StreamStart=0;
    };
    public abstract boolean Load(MemoryStream Stream);
    public Frame getFrame(){ return Owner;};
    Header(Frame owner, Reader reader){
        VersionMajor =0;
        VersionMinor = 0;

        Owner = owner;
        Reader  = reader;
    }

    public void Release(){

        Reader = null;
        Owner = null;

    }
}
