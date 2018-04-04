package com.aurawin.mp3.frame.tag;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Frame;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.Reader;
import com.aurawin.mp3.frame.tag.process.Processor;
import com.aurawin.mp3.payload.BufferSize;

import static com.aurawin.mp3.frame.Kind.fBufferSize;

public class ID3V20Payload extends Payload {

    public ID3V20Payload(Frame owner, Reader reader) {
        super(owner, reader);
    }

    @Override
    public void Reset() {
        super.Reset();
    }

    @Override
    public boolean Load(MemoryStream Stream) {
        Processor p = Owner.getProcessor(Owner.Header.ID);
        if (p!=null) {
            return p.process(Stream);
        } else {
            return false;
        }
    }
}
