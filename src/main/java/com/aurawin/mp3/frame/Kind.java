package com.aurawin.mp3.frame;

public enum Kind {
    fNone ("None"),                                     // 0
    fID3 ("ID3"),                                       // 1
    fID3V20 ("ID3 V2.0"),                               // 2
    fID3V23 ("ID3 V2.3"),                               // 3
    fID3V30 ("ID3 V3.0"),                               // 4
    fID3V40 ("ID3 V4.0"),                               // 5
    fRAW ("Raw"),                                       // 6
    fMPEG ("MPEG"),                                     // 7
    fCommercial("Commercial"),                          // 8
    fCompilation("Compilation"),                        // 9
    fBufferSize("Buffer Size"),                         // 10
    fPlayCounter("Play Counter"),                       // 11
    fComments("Comments"),                              // 12
    fAudioEncryption("Audio Encryption"),               // 13
    fEncryptedMeta("Encrypted Meta Data"),              // 14
    fEventTimingCodes("Event Timing Codes"),                     // 15
    fEqualization ("Equalization"),                         // 16
    fGeneralEncapsulatedObject ("General Encapsulated Object"),            // 17
    fGroupIdentificationRegistration ("Group Identification Registration"),      // 18
    fInvolvedPeople ("Involved People"),                       // 19
    fInvolvedPeopleList ("Involved People List"),                   // 20
    fMusicianCreditsList ("Musician Credit List"),                  // 21
    fMood ("Mood"),                                 // 22
    fLinkedInfo ("Linked Information"),                           // 23
    fMusicCDIdentifier ("Music CD Identifier"),                    // 24
    fMPEGtable ("MPEG Lookup Table"),                            // 25
    fMPEGLocationLookupTable ("MPEG Location Lookup Table"),              // 26
    fOwnership ("Ownership"),                            // 27
    fPositionSynchronization ("Position Synchronization"),              // 28
    fPrivate ("Private"),                              // 29
    fPicture ("Picture"),                              // 30
    fAttachedPicture ("Attached Picture"),                      // 31
    fPopularimeter ("Rating"),                        // 32
    fReverb ("Reverb"),                               // 33
    fVolumeAdj ("Volume Adjustment"),                            // 34
    fSyncedText ("Synchronized Text"),                           // 35
    fSyncedTempo ("Synchronized Tempo"),                          // 36
    fTitle ("Title"),                                // 37
    fBeatsPerMinute ("Beats Per Minute"),                       // 38
    fComposer ("Composer"),                             // 39
    fContentType ("Content Type"),                          // 40
    fCopyrightMessage ("Copyright Message"),                     // 41
    fDate ("Date"),                                 // 42
    fPlaylistDelay ("Playlist Delay"),                        // 43
    fEncodedBy ("Encoded By"),                            // 44
    fFileType ("File Type"),                             // 45
    fFileLicense ("File License"),                          // 46
    fTime ("Time"),                                 // 47
    fInitialKey ("Initial Key"),                           // 48
    fLanguages ("Languages"),                            // 49
    fLength ("Length"),                               // 50
    fMediaType ("Media Type"),                            // 51
    fProducedNotice ("Produced Notice"),                       // 52
    fOriginalArtist ("Original Artist"),                       // 53
    fOriginalfilename ("Original filename"),                     // 54
    fOriginalWriter ("Original Writer"),                       // 55
    fAlbumSortOrder ("Album Sort Order"),                       // 56
    fPerformerSortOrder ("Performer Sort Order"),                   // 57
    fTitleSortOrder ("Title Sort Order"),                       // 58
    fOriginalReleaseYear ("Original Release Year"),                  // 59
    fOriginalReleaseTime ("Original Release Time"),                  // 60
    fOriginalTitle ("Original Title"),                        // 61
    fRadioStationOwner ("Radio Station Owner"),                    // 62
    fLeadArtist ("Lead Artist"),                           // 63
    fAccompaniment ("Accompaniment"),                        // 64
    fConductor ("Conductor"),                            // 65
    fPerformerRefinement ("Performer Refinement"),                  // 66
    fModifiedBy ("Modified By"),                           // 67
    fPartOfaSet ("Part Of a Set"),                           // 68
    fPublisher ("Publisher"),                            // 69
    fISRC ("ISRC"),                                 // 70
    fRecordingDates ("Recording Dates"),                       // 71
    fRecordingTime ("Recording Time"),                        // 72
    fTaggingTime ("Tagging Time"),                          // 73
    fTrackNumber ("Track Number"),                          // 74
    fReleaseTime ("Release Time"),                          // 75
    fSetNumber ("Set Number"),                            // 76
    fSize ("Size"),                                 // 77
    fEncodingTime ("Encoding Time"),                         // 78
    fEncodingParams ("Encoding Params"),                       // 79
    fContentGroupDescription ("Content Group Description"),              // 80
    fTitleDescription ("Title Description"),                     // 81
    fSubTitleDescription ("Subtitle Description"),                  // 82
    fSetSubTitle ("Set Subtitle"),                                           // 83
    fWriter ("Writer"),                                                      // 84
    fUserDefined ("User Defined"),                                           // 85
    fYear ("Year"),                                                          // 86
    fUniqueFileID ("Unique File Identifier"),                                // 87
    fUnSynchronizedTranscription ("Unsynchronized Transcription"),           // 88
    fOfficialFileWebpage ("Official File Webpage"),                          // 89
    fOfficialArtistWebpage ("Official Artist Webpage"),                      // 90
    fOfficialAudioSourceWebpage ("Official Audio Source Webpage"),           // 91
    fCommericalInfo ("Commerical Information"),                              // 92
    fCopyrightInfo ("Copyright Information"),                                // 93
    fPublishersOfficialWebpage ("Publishers Official Webpage"),              // 94
    fStationURL ("Station URL"),                                             // 95
    fURL ("URL"),                                                            // 96
    fUserDefinedURL ("User Defined URL"),                                    // 97
    fPaymentURL ("Payment URL"),                                             // 98
    fUserDefinedTextInformation ("User Defined Text Information"),           // 99
    fTextWriter ("Text Writer"),                                             // 100
    fPodcastKeywords ("Podcast Keywords"),                                   // 101
    fPodcast ("Podcast"),                                                    // 102
    fPodcastDescription ("Podcast Description"),                             // 103
    fPodcastFeed ("Podcast Feed"),                                           // 104
    fPodcastID ("Podcast ID"),                                               // 105
    fEncryption("Encryption");                                               // 106

    Kind(String value){ Value = value;}
    private final String Value;
    public String getValue(){return Value;}


}
