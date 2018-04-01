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

}
