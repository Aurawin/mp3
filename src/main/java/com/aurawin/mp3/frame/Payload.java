package com.aurawin.mp3.frame;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.UniqueFileId;
import com.aurawin.mp3.UnsynchronizedTranscript;
import com.aurawin.mp3.frame.tag.process.Processor;
import com.aurawin.mp3.payload.*;

import java.util.HashMap;

public abstract class Payload {
    public BufferSize pldBUF;
    public PlayCounter pldCNT;
    public Comment pldCOM;
    public Commercial pldCOMR;
    public EncryptedAudio pldCRA;
    public EncryptedMeta pldCRM;
    public EventTiming pldETC;
    public Equalization pldEQU;
    public EncapsulatedObject pldGEO;
    public InvolvedPeopleList pldIPL;
    public LinkedInfo pldLNK;
    public Musicidentifier pldMCI;
    public Location pldMLL;
    public Picture pldPIC;
    public Popularimeter pldPOP;
    public Reverb pldREV;
    public RelativeVolume pldRVA;
    public SyncronizedTranscript pldSLT;
    public Tempo pldSTC;
    public URLUser pldWXX;
    public URL pldURL;
    public UniqueFileId pldUFI;
    public UnsynchronizedTranscript pldULT;
    public Text pldText;
    public TextUser pldTXX;


    public long StreamStart;
    public long Length;
    public Reader Reader;

    public Object Data;
    public Frame Owner;

    public void Reset(){
        StreamStart =0;
        Length =0;
        Data = null;
    };
    public abstract boolean Load(MemoryStream Stream);

    public Payload(Frame owner, Reader reader) {
        Owner = owner;
        Data=null;
        Reader = reader;

        pldBUF= new BufferSize();
        pldCNT = new PlayCounter();
        pldCOM = new Comment();
        pldCOMR = new Commercial();
        pldCRA = new EncryptedAudio();
        pldCRM = new EncryptedMeta();
        pldETC=new EventTiming();
        pldEQU= new Equalization();
        pldGEO=new EncapsulatedObject();
        pldIPL= new InvolvedPeopleList();
        pldLNK=new LinkedInfo();
        pldMCI= new Musicidentifier();
        pldMLL= new Location();
        pldPIC= new Picture();
        pldPOP= new Popularimeter();
        pldREV= new Reverb();
        pldRVA= new RelativeVolume();
        pldSLT= new SyncronizedTranscript();
        pldSTC= new Tempo();
        pldWXX= new URLUser();
        pldURL= new URL();

        pldUFI= new UniqueFileId();
        pldULT = new UnsynchronizedTranscript();
        pldText= new Text();
        pldTXX= new TextUser();
    }

    public void Release(){
        Owner = null;
        Data =null;
        Reader = null;
    }

}
