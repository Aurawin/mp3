package com.aurawin.mp3.payload;

import com.aurawin.mp3.volume.EqualizationBand;

import java.util.ArrayList;

public class Equalization {
    public int AdjustmentBits;
    public ArrayList<EqualizationBand> Bands= new ArrayList<>();
}
