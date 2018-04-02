package com.aurawin.mp3.frame.tag.process;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Payload;

import java.util.HashMap;

public class Processor implements Process{
    public HashMap<String,Process> List = new HashMap<>();
    public Payload Owner;
    public Processor(Payload owner) {
        Owner = owner;
    }
    @Override
    public boolean process(String Key, MemoryStream Stream){
        Process p = List.get(Key);
        return (p!=null) ? p.process(Key,Stream) : false;
    }

}
