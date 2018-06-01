package com.aurawin.mp3.frame.tag.process.v23;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.TextEncoding;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;
import com.aurawin.mp3.payload.InvolvedPerson;

import static com.aurawin.mp3.frame.Kind.fGroupIdentificationRegistration;
import static com.aurawin.mp3.frame.Kind.fInvolvedPeopleList;

public class IPLS extends Processor implements Process {
    @Override
    public boolean process( MemoryStream Stream){
        Owner.Length=Owner.Reader.TagFrame.Header.Length;
        Owner.StreamStart=Stream.position();
        Owner.Data=Owner.pldIPL;
        Owner.Reader.TagFrame.Kind=fInvolvedPeopleList;

        Owner.pldIPL.Encoding = TextEncoding.Base.fromByte(Stream.readByte());

        while ((Owner.Length-(Stream.position()-Owner.StreamStart))>0){
            InvolvedPerson p = new InvolvedPerson();
            p.Involvement=Stream.readStringUntil((byte)0, Stream.position(), Owner.pldIPL.Encoding.toEncoding());
            p.Name=Stream.readStringUntil((byte)0, Stream.position(), Owner.pldIPL.Encoding.toEncoding());
            Owner.pldIPL.People.add(p);
        }

        return true;
    }
    @Override
    public void Reset(){
        Owner.pldIPL.People.clear();
    }
    public IPLS(Payload owner) {
        super("IPLS",owner);
    }
}
