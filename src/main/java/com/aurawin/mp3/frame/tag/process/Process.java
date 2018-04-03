package com.aurawin.mp3.frame.tag.process;

import com.aurawin.core.stream.MemoryStream;

public interface Process {
    boolean process(MemoryStream Stream);
}
