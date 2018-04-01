package com.aurawin.mp3.frame;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.UniqueFileId;
import com.aurawin.mp3.UnsynchronizedTranscript;
import com.aurawin.mp3.payload.*;

public abstract class Payload {
    public BufferSize pldBUF;
    public PlayCounter pldCNT;
    public Comment pldCOM;
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

    protected short StreamStart;
    protected short Length;
    protected Reader Reader;

    public Object Data;

    public void Reset(){};
    public abstract boolean Load(MemoryStream Stream);

    Payload(Reader reader) {
        Reader = reader;
    }

    public void Release(){
        Reader = null;
    }

}
