package com.aurawin.mp3.frame;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.tag.process.Processor;

import java.util.ArrayList;
import java.util.HashMap;

public class ID3 extends Frame {

    public boolean Load(MemoryStream Stream){
        boolean handled=false;
        Stream.position(0);
        while (Stream.position()<Stream.size()) {
            Position = Stream.position();
            Header.StreamStart = Stream.Find(ID,Position);
            if (Header.StreamStart > -1) {
                // found instance...
                Position += 3;
                Stream.position(Position);
                handled = Header.Load(Stream);
                if (handled) {
                    loadTagPrcocessor();
                    Payload.StreamStart = Stream.position();
                    Payload.Length = Header.Length;
                    handled = Payload.Load(Stream);
                    if (handled == false) {
                        Stream.position(Header.StreamStart + Header.Length);
                    }
                }
            } else{
                Stream.position(Stream.size());
            }
        }
        return handled;
    }
    private void loadTagsForVersion20(){
        Processors.clear();
    }
    private void loadTagPrcoessorMajor2(){
        switch (Header.VersionMinor){
            case (0): loadTagsForVersion20();
        }
    }
    private void loadTagProcessorMajor3(){

    }
    private void loadTagProcessorMajor4(){

    }
    private void loadTagPrcocessor(){
        switch (Header.VersionMajor){
            case (2):
                loadTagPrcoessorMajor2();
                break;
            case (3) :
                loadTagProcessorMajor3();
                break;
            case (4) :
                loadTagProcessorMajor4();
                break;
        }

    }
    public void Preload(MemoryStream Stream){

    }
    public void Reset(){
        super.Reset();
    }

    ID3(Kind kind, Reader reader) {
        super(kind, reader);
        ID = "ID3";
        Header = new ID3Header(this,reader);
        Payload = new ID3Payload(this,reader);

    }
}
