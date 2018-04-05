package com.aurawin.mp3.frame.tag;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Frame;
import com.aurawin.mp3.frame.Reader;
import com.aurawin.mp3.frame.tag.process.Processor;

import java.util.HashMap;

import static com.aurawin.mp3.frame.Kind.fID3V20;

public class ID3V20 extends Frame {
    public boolean Unsynchronized;
    public boolean Compressed;

    public ID3V20(Reader reader){

        super(fID3V20,reader);

        Header  = new ID3V20Header(this,reader);
        Payload = new ID3V20Payload(this,reader);

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
    @Override
    public void Reset(){
        super.Reset();
    }

    @Override
    public boolean Load(MemoryStream Stream){
        boolean handled = false;
        /*  Assume packets like this... are next
            Unique file identifier  "UFI"
            Frame size              $xx xx xx
            Owner identifier        <textstring> $00
            Identifier              <up to 64 bytes binary data>
        */
        handled=Header.Load(Stream);
        if (handled) {
            Payload.StreamStart=Stream.Position;
            Payload.Length=Header.Length;
            Length=Header.Length;
            handled=Payload.Load(Stream);
            Stream.Position=Payload.StreamStart + Payload.Length;
        }
        return handled;
    }
    @Override
    public void Preload(MemoryStream Stream){}

}
