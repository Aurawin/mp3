package com.aurawin.mp3.volume;

public enum Channel {
    Right ((byte)0),
    Left ((byte)1);

    private byte Value;
    Channel(byte value){
        Value=value;
    }
    public byte getValue(){return Value;}
    public Channel fromByte(byte value){
        switch (value) {
            case 0: return Right;
            case 1: return Left;
        }
        return null;
    }
}
