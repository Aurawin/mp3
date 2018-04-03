package com.aurawin.mp3;

public enum TimeStampKind {
    Padding  (0x0),
    EndOfInitialSilence (0x1),
    IntroStart (0x2),
    MainPartStart (0x3),
    OutroStart (0x4),
    OutroEnd (0x5),
    VerseBegins (0x6),
    RefrainBegins (0x7),
    Interlude (0x8),
    ThemeStart (0x9),
    Variation (0xA),
    KeyChange (0xB),
    TimeChange (0xC),
    UnwantedNoise (0xD),
    UserDefined0 (0xE0),
    UserDefined1 (0xE1),
    UserDefined2 (0xE2),
    UserDefined3 (0xE3),
    UserDefined4 (0xE4),
    UserDefined5 (0xE5),
    UserDefined6 (0xE6),
    UserDefined7 (0xE7),
    UserDefined8 (0xE8),
    UserDefined9 (0xE9),
    UserDefined10 (0xEA),
    UserDefined11 (0xEB),
    UserDefined12 (0xEC),
    UserDefined13 (0xED),
    UserDefined14 (0xEF),
    Reserved0 (0xF0),
    Reserved1 (0xF1),
    Reserved2 (0xF2),
    Reserved3 (0xF3),
    Reserved4 (0xF4),
    Reserved5 (0xF5),
    Reserved6 (0xF6),
    Reserved7 (0xF7),
    Reserved8 (0xF8),
    Reserved9 (0xF9),
    Reserved10 (0xFA),
    Reserved11 (0xFB),
    Reserved12 (0xFC),
    AudioEnd (0xFD),
    AudioFileEnds (0xFE),
    OneByteOfEventsFollows (0xFF);

    TimeStampKind(int value){ Value = value;}
    private final int Value;
    public int getValue(){return Value;}

    public TimeStampKind fromInt(int value){
        switch (value){
            case (0x0) : return Padding;
            case (0x1) : return EndOfInitialSilence;
            case (0x2) : return IntroStart ;
            case (0x3) : return MainPartStart ;
            case (0x4) : return OutroStart;
            case (0x5) : return OutroEnd;
            case (0x6) : return VerseBegins;
            case (0x7) : return RefrainBegins;
            case (0x8) : return Interlude;
            case (0x9) : return ThemeStart;
            case (0xA) : return Variation;
            case (0xB) : return KeyChange;
            case (0xC) : return TimeChange;
            case (0xD) : return UnwantedNoise;
            case (0xE0) : return UserDefined0;
            case (0xE1) : return UserDefined1;
            case (0xE2) : return UserDefined2;
            case (0xE3) : return UserDefined3;
            case (0xE4) : return UserDefined4;
            case (0xE5) : return UserDefined5;
            case (0xE6) : return UserDefined6;
            case (0xE7) : return UserDefined7;
            case (0xE8) : return UserDefined8;
            case (0xE9) : return UserDefined9;
            case (0xEA) : return UserDefined10;
            case (0xEB) : return UserDefined11;
            case (0xEC) : return UserDefined12;
            case (0xED) : return UserDefined13;
            case (0xEF) : return UserDefined14;
            case (0xF0) : return Reserved0;
            case (0xF1) : return Reserved1;
            case (0xF2) : return Reserved2;
            case (0xF3) : return Reserved3;
            case (0xF4) : return Reserved4;
            case (0xF5) : return Reserved5;
            case (0xF6) : return Reserved6;
            case (0xF7) : return Reserved7;
            case (0xF8) : return Reserved8;
            case (0xF9) : return Reserved9;
            case (0xFA) : return Reserved10;
            case (0xFB) : return Reserved11;
            case (0xFC) : return Reserved12;
            case (0xFD) : return AudioEnd ;
            case (0xFE) : return AudioFileEnds;
            case (0xFF) : return OneByteOfEventsFollows;
        }
        return null;
    }
}
