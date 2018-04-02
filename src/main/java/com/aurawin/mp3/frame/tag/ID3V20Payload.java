package com.aurawin.mp3.frame.tag;

import com.aurawin.core.stream.MemoryStream;
import com.aurawin.mp3.frame.Payload;
import static com.aurawin.mp3.frame.Kind.fBufferSize;

public class ID3V20Payload extends Payload {


    @Override
    public void Reset(){
        super.Reset();
    }

    @Override
    public boolean Load(MemoryStream Stream){
        class B{
            class U{
                class F{
                    void Process(){
                        Data=pldBUF;
                        Reader.ID3V20Tag.Kind=fBufferSize;
                        Stream.Read(pldBUF.Size,3);
                        Stream.Read(pldBUF.Flags,1);
                        Stream.Read(pldBUF.Offset,4);
                        Length=Reader.TagFrame.Header.Length;
                        Handled=true;
                    }
                }
                void Process(){
                    switch (Owner.Header.ID.charAt(2)) {
                        case ("F"):
                            B.U.F.Process();
                            break;
                    }
                }
            }
            void One(){

                switch (Owner.Header.ID.charAt(2)){
                    case ("U"):
                        B.U.Process();
                        break;
                }

            }
        }
        class C{
            private void One(){

            }
        }
        class E{
            private void One(){

            }
        }
        class G{
            private void One(){

            }
        }
        class I{
            private void One(){

            }
        }
        class L{
            private void One(){

            }
        }
        class M{
            private void One(){

            }
        }
        class P{
            private void One(){

            }
        }
        class R{
            private void One(){

            }
        }
        class S{
            private void One(){

            }
        }
        class T{
            private void One(){

            }
        }
        class U{
            private void One(){

            }
        }
        class W{
            private void One(){

            }
        }

        boolean Handled=false;
        switch (Owner.Header.ID.charAt(0)) {
            case ("B"):
                B.One();
                break;
            case ("C"):
                C.One();
                break;
            case ("E"):
                E.One();
                break;
            case ("G"):
                G.One();
                break;

            case ("I"):
                I.One();
                break;
            case ("L"):
                L.One();
                break;
            case ("M"):
                M.One();
                break;
            case ("P"):
                P.One();
                break;
            case ("R"):
                R.One();
                break;
            case ("S"):
                S.One();
                break;
            case ("T"):
                T.One();
                break;
            case ("U"):
                U.One();
                break;
            case ("W"):
                W.One();
                break;
        }
        return Handled;
    }
}
