package com.aurawin.mp3.frame.tag.process.V20;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fEncryptedMeta;

public class CRM extends Processor implements Process {

    @Override
    public boolean process(MemoryStream Stream) {
        Owner.Reader.TagFrame.Kind=fEncryptedMeta;
        Owner.Data=Owner.pldCRM;
        Owner.Length=Stream.Position;
        Owner.pldCRM.Owner=Stream.readStringUntil((byte) 0,Stream.Position,"UTF-8");
        Owner.pldCRM.Description=Stream.readStringUntil((byte)0,Stream.Position,"UTF-8");
        Owner.Length=Owner.Reader.TagFrame.Length-(Stream.Position-Owner.Length);
        Owner.pldCRM.Data = Stream.Read((int) Owner.Length);
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        return true;
    }

    public CRM(Payload owner) {
        super("CRM", owner);
    }
}