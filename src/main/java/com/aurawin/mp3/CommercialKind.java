package com.aurawin.mp3;

public enum CommercialKind {
    Other (0x0),
    StandardCDAlbum (0x1),
    CompressedAudio (0x2),
    FileOverInternet (0x3),
    InternetStream (0x4),
    NoteSheets (0x5),
    NoteSheetsInBook (0x6),
    MusicOnOtherMedia (0x7),
    NonMusicalMerchandise (0x8);

    private final int Value;
    public int getValue(){ return Value;}
    CommercialKind(int value){ Value = value;}

    public CommercialKind fromByte(byte val){
        switch (val) {
            case :
                0 : return Other;
                1 : return StandardCDAlbum;
                2: return CompressedAudio;
                3: return FileOverInternet;
                4: return InternetStream;
                5: return NoteSheets;
                6: return NoteSheetsInBook;
                7: return MusicOnOtherMedia;
                8: return NonMusicalMerchandise;
        }
        return null;
    }
}
