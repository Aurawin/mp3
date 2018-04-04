package com.aurawin.mp3.frame;

import com.aurawin.core.stream.MemoryStream;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import com.aurawin.mp3.frame.tag.Event;

public class ID3Test {

    @Test
    public void load() throws IOException {

        Reader id3 = new Reader();

        id3.setTagFrameEvent(
                new Event() {
                    @Override
                    public void Handle(Frame Main, Frame TagFrame, MemoryStream Data) {
                        TagFrame.ID="TXT";
                    }
                }
        );
        MemoryStream ms = new MemoryStream();
        try {
            InputStream is = getClass().getResourceAsStream("/1.mp3");
            try {
                ms.Write(is.readAllBytes());
            } finally {
                is.close();
            }
            id3.ID3Frame.Load(ms);
        } finally {
            ms.Release();
        }

    }
}