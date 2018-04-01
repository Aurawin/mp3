package com.aurawin.mp3.frame;

import com.aurawin.core.stream.MemoryStream;

public interface Event {
    boolean Handle (Frame frame, MemoryStream Stream);
}
