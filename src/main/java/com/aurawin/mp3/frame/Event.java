package com.aurawin.mp3.frame;

import com.aurawin.core.stream.MemoryStream;

public interface Event {
    void Handle (Frame frame, MemoryStream Stream);
}
