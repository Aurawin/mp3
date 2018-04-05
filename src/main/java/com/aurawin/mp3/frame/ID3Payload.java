package com.aurawin.mp3.frame;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.tag.process.Processor;
import com.aurawin.mp3.payload.Text;

public class ID3Payload extends Payload {

    private void loadWithNoCallback(MemoryStream Stream){
        boolean bLoopOk=true;

        while (bLoopOk && (Reader.StreamPosition<StreamStart+Length) && (Stream.Position<Stream.Size)) {
            bLoopOk=Reader.TagFrame.Load(Stream);
            if (bLoopOk){
                Reader.StreamPosition=Stream.Position;
            }

        }
    }
    private void loadWithCallback(MemoryStream Stream){
        boolean bLoopOk=true;

        while (bLoopOk && (Reader.StreamPosition<StreamStart+Length) && (Stream.Position<Stream.Size)) {
            bLoopOk=Reader.TagFrame.Load(Stream);
            if (bLoopOk){
                Reader.StreamPosition=Stream.Position;
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
