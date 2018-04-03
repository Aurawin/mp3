package com.aurawin.mp3;

public enum PictureKind {
    Other (0x0),
    Icon32x32 (0x1),
    IconOther (0x2),
    CoverFront (0x3),
    CoverBack (0x4),
    Leaflet (0x5),
    CoverMedia (0x6),
    LeadArtist (0x7),
    Artist (0x8),
    Conductor (0x9),
    Band (0xA),
    Composer (0xB),
    Writer (0xC),
    RecordingLocation (0xD),
    DuringRecording(0xE),
    DuringPerformance(0xF),
    ScreenShot(0x10),
    Fish (0x11),
    Illustration (0x12),
    ArtistLogo (0x13),
    PublisherLogo (0x14);

    private final int Value;
    public int getValue(){return Value;}
    PictureKind(int value){Value = value;}

    public PictureKind fromByte(byte value){
        switch (value){
            case (0x0): return Other;
            case (0x1): return Icon32x32;
            case (0x2): return IconOther;
            case (0x3): return CoverFront;
            case (0x4): return CoverBack;
            case (0x5): return Leaflet;
            case (0x6): return CoverMedia;
            case (0x7): return LeadArtist;
            case (0x8): return Artist;
            case (0x9): return Conductor;
            case (0xA): return Band;
            case (0xB): return Composer;
            case (0xC): return Writer;
            case (0xD): return RecordingLocation;
            case (0xE): return DuringRecording;
            case (0xf): return DuringPerformance;
            case (0x10): return ScreenShot;
            case (0x11): return Fish;
            case (0x12): return Illustration;
            case (0x13): return ArtistLogo;
            case (0x14): return PublisherLogo;
        }
        return null;
    }
}
