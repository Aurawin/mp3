package com.aurawin.mp3.frame.tag;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Frame;

public interface Event {
    boolean Handle(Frame Main, Frame TagFrame, MemoryStream Data);
}
