package com.aurawin.mp3.frame;

import com.aurawin.core.stream.MemoryStream;

public abstract class Header {
    public String ID = "";
    public long Size;
    public Frame Owner;
    public String Name;
    public byte VersionMajor;
    public byte VersionMinor;
    public  Reader Reader;
    public long StreamStart;
    public  long Length;

    public void Reset(){
        VersionMajor =0;
        VersionMinor =0;
        Length =0;
        Size = 0;
        ID = "";
        StreamStart=0;
    };
    public abstract boolean Load(MemoryStream Stream);

    public Header(Frame owner, Reader reader){
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
