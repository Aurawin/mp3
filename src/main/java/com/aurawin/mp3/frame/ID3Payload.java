package com.aurawin.mp3.frame;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.tag.process.Processor;
import com.aurawin.mp3.payload.Text;

public class ID3Payload extends Payload {

    private void loadWithNoCallback(MemoryStream Stream){
        boolean bLoopOk=true;

        while ((Reader.StreamPosition<StreamStart+Length) && (Stream.position()<Stream.size())) {
            Reader.TagFrame.Load(Stream);

        }
    }
    private void loadWithCallback(MemoryStream Stream){
        while ( (Stream.position()<StreamStart+Length) && (Stream.position()<Stream.size())) {
            if (Reader.TagFrame.Load(Stream)){

                Reader.OnTagFrame.Handle(Owner,Reader.TagFrame);
            }

        }


    }
    @Override
    public boolean Load(MemoryStream Stream) {
        boolean handled=false;

        Reader.TagFrame.Preload(Stream); // now we get version specific ID3 header extensions
        if (Reader.OnTagFrame!=null) {
            loadWithCallback(Stream);
        } else {
            loadWithNoCallback(Stream);
        }


        return handled;
    }

    ID3Payload(ID3 owner, Reader reader){
        super(owner, reader);
    }
}
