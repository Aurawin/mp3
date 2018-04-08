package com.aurawin.mp3.frame.tag;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Frame;
import com.aurawin.mp3.frame.Reader;
import com.aurawin.mp3.frame.tag.process.v23.WXXX;

import static com.aurawin.mp3.frame.Kind.fID3V23;

public class ID3V23 extends Frame {
    public ID3V23( Reader reader){
        super(fID3V23,reader);
        Header  = new ID3V2Header(this,reader);
        Payload = new ID3V2Payload(this,reader);

        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.AENC(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.APIC(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.COMM(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.COMR(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.ENCR(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.EQUA(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.ETCO(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.GEOB(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.GRID(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.IPLS(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.LINK(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.MCDI(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.MLLT(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.OWNE(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.PCNT(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.POPM(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.POSS(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.PRIV(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.RBUF(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.RVAD(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.RVRB(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.SYLT(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.SYTC(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TALB(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TBPM(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TCOM(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TCON(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TCOP(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TDAT(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TDLY(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TENC(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TEXT(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TFLT(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TIME(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TIT1(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TIT2(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TIT3(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TKEY(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TLAN(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TLEN(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TMED(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TOAL(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TOFN(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TOLY(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TOPE(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TORY(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TOWN(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TPE1(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TPE2(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TPE3(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TPE4(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TPOS(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TPUB(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TRCK(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TRDA(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TRSN(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TRSO(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TSIZ(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TSRC(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TSSE(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TXXX(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.TYER(Payload));

        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.UFID(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.USER(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.USLT(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.WCOM(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.WCOP(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.WOAF(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.WOAR(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.WOAS(Payload));
        Processors.add(new com.aurawin.mp3.frame.tag.process.v23.WORS(Payload));
        Processors.add(new WXXX(Payload));
    }

    @Override
    public boolean Load(MemoryStream Stream){
        boolean Handled = false;



        return Handled;
    }

    @Override
    public void Preload(MemoryStream Stream){

    }
}
