package com.aurawin.mp3.frame.tag.process;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Payload;

import java.util.HashMap;

public abstract class Processor implements Process{
    public String Key;

    public Payload Owner;
    public Processor(String key, Payload owner) {
        Key = key;
        Owner = owner;
    }
    public abstract void Reset();
    public abstract boolean process(MemoryStream Stream);

}
