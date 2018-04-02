package com.aurawin.mp3.frame.tag.process.V20;

import com.aurawin.mp3.frame.Payload;

public class Processor extends com.aurawin.mp3.frame.tag.process.Processor {
    public Processor(Payload owner) {
        super(owner);
        List.put("BUF",new BUF(owner));
    }
}
