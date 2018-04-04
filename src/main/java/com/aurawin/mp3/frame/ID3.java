package com.aurawin.mp3.frame;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.tag.process.Processor;

import java.util.ArrayList;
import java.util.HashMap;

public class ID3 extends Frame {

    public boolean Load(MemoryStream Stream){
        boolean handled=false;

        Position=Stream.Position;
        Header.StreamStart=Stream.Find(ID);
        if (Header.StreamStart>-1) {
            // found instance...
            Position+=3;
            Stream.Position=Position;
            handled=Header.Load(Stream);
            if (handled)  {
                loadTagPrcocessor();
                Payload.StreamStart=Stream.Position;
                Payload.Length=Header.Length;
                handled = Payload.Load(Stream);
                if (handled = false) {
                    Stream.Position = Payload.StreamStart + Payload.Length;
                }
            }
        }
        return handled;
    }
    private void loadTagsForVersion20(){
        Processors.clear();
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.BUF(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.CNT(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.COM(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.CRA(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.CRM(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.EQU(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.ETC(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.GEO(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.IPL(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.LNK(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.MCI(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.MLL(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.PIC(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.POP(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.REV(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.RVA(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.SLT(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.STC(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TAL(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TBP(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TCM(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TCO(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TCR(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TDA(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TDY(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TEN(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TFT(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TIM(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TKE(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TLA(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TLE(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TMT(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TOA(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TOF(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TOL(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TOR(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TOT(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TP1(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TP2(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TP3(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TP4(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TPA(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TPB(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TRC(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TRD(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TRK(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TSI(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TSS(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TT1(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TT2(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TT3(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TXT(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TXX(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.TYE(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.UFI(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.ULT(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.URL(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.WAF(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.WAR(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.WAS(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.WCM(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.WCP(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.WPB(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.V20.WXX(Payload));


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
