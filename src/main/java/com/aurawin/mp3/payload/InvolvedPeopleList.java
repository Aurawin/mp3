package com.aurawin.mp3.payload;

import com.aurawin.mp3.TextEncoding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import static com.aurawin.mp3.TextEncoding.UTF8;

public class InvolvedPeopleList {
    public TextEncoding Encoding = UTF8;
    public ArrayList<InvolvedPerson> People = new ArrayList<>();
}
