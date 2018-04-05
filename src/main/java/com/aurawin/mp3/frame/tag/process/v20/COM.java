package com.aurawin.mp3.frame.tag.process.v20;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Payload;
import com.aurawin.mp3.frame.tag.process.Process;
import com.aurawin.mp3.frame.tag.process.Processor;

import static com.aurawin.mp3.frame.Kind.fComments;

public class COM extends Processor implements Process {

    @Override
    public boolean process(MemoryStream Stream){
        Owner.Data=Owner.pldCOM;
        Owner.Reader.TagFrame.Kind=fComments;
        Owner.StreamStart=Stream.Position;
        Owner.pldCOM.Encoding=Owner.pldCOM.Encoding.fromByte(Stream.readByte());

        switch (Owner.pldCOM.Encoding) {
            case UTF8 : {
                Owner.pldCOM.Language=Stream.readString(3,"UTF-8");
                Owner.pldCOM.Description=Stream.readStringUntil((byte) 0,Stream.Position,"UTF-8");
                int len=(int) ( (Owner.StreamStart+Owner.Length)-Stream.Position);
                Owner.pldCOM.Text=Stream.readString(len,"UTF-8");
                return true;
            }
            case ISO8859_1 : {
                Owner.pldCOM.Language=Stream.readString(3,"ISO-8859-1");
                Owner.pldCOM.Description=Stream.readStringUntil((byte) 0,Stream.Position,"ISO-8859-1");
                int len=(int) ((Owner.StreamStart+Owner.Length)-Stream.Position);
                Owner.pldCOM.Text=Stream.readString(len,"ISO-8859-1");
                return true;

            }
            case UTF16 : {
                Owner.pldCOM.Language=Stream.readString(3,"UTF-16");
                Owner.pldCOM.Description=Stream.readStringUntil((byte) 0,Stream.Position,"UTF-16");
                int len=(int) ((Owner.StreamStart+Owner.Length)-Stream.Position);
                Owner.pldCOM.Text=Stream.readString(len,"UTF-16");
                return true;
            }
            case UTF16BE : {
                Owner.pldCOM.Language=Stream.readString(3,"UTF-16BE");
                Owner.pldCOM.Description=Stream.readStringUntil((byte)0,Stream.Position,"UTF-16BE");
                int len=(int) ((Owner.StreamStart+Owner.Length)-Stream.Position);
                Owner.pldCOM.Text=Stream.readString(len,"UTF-16BE");
                return true;
            }

        }
        return false;

    }

    public COM(Payload owner) {
        super("COM", owner);
    }
}