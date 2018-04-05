package com.aurawin.mp3.frame;

import com.aurawin.core.stream.MemoryStream;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import com.aurawin.mp3.frame.tag.Event;
import static com.aurawin.mp3.frame.Kind.fTitleDescription;

public class ID3Test {

    @Test
    public void loadFile1() throws IOException {

        Reader id3 = new Reader();

        id3.setTagFrameEvent(
                new Event() {
                    @Override
                    public void Handle(Frame Main, Frame TagFrame) {
                        switch(TagFrame.Kind){
                            case fTitle:
                                System.out.println(TagFrame.Payload.pldText.Data);
                                assert(TagFrame.Payload.pldText.Data.equals("Summer 2009"));
                                break;
                            case fTitleDescription :
                                System.out.println(TagFrame.Payload.pldText.Data);
                                assert(TagFrame.Payload.pldText.Data.equals("Emanual"));
                                break;
                            case fLeadArtist:
                                System.out.println(TagFrame.Payload.pldText.Data);
                                assert(TagFrame.Payload.pldText.Data.equals("VBS"));
                                break;
                            case fTrackNumber:
                                System.out.println(TagFrame.Payload.pldText.Data);
                                assert(TagFrame.Payload.pldText.Data.equals("3/4"));
                                break;
                            case fYear:
                                System.out.println(TagFrame.Payload.pldText.Data);
                                assert(TagFrame.Payload.pldText.Data.equals("2005"));
                                break;
                            case fContentType:
                                System.out.println(TagFrame.Payload.pldText.Data);
                                assert(TagFrame.Payload.pldText.Data.equals("Christian"));
                                break;
                            case fComments:
                                System.out.println(TagFrame.Payload.pldCOM.Description);
                                TagFrame.Payload.pldCOM.Description="iTunPGAP";
                                TagFrame.Payload.pldCOM.Language="eng";
                                TagFrame.Payload.pldCOM.Text="0";
                                break;
                            case fEncodedBy:
                                System.out.println(TagFrame.Payload.pldText.Data);
                                assert(TagFrame.Payload.pldText.Data.equalsIgnoreCase("iTunes 11.0.4.4"));
                                break;
                            case fUniqueFileID:
                                System.out.println(TagFrame.Payload.pldText.Data);
                                assert(TagFrame.Payload.pldUFI.Owner.equals("http://www.cddb.com/id3/taginfo1.html"));
                                break;

                        }
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