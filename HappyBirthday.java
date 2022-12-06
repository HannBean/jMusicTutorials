import jm.JMC;
import jm.music.data.*;
import jm.util.*;

public final class HappyBirthday implements JMC{
    public static void main(String[] args) {

        double tempo = 200;

        //create a score
        Score s = new Score("Happy Birthday", tempo);

        //create a new part
        Part piano1 = new Part("Piano", PIANO, 0);

        //create an array to store the notes
        int[] pitchArray1 = {C4,C4,D4,C4,F4,E4,C4,C4,D4,C4,G4,F4,C4,C4,C5,A4,F4,E4,D4,AS4,AS4,A4,F4,G4,F4};

        int[] pitchArray2 = {C4,C4,A3,A3,A3,G3,C4,C4,G3,C4,C4,A3,C4,C4,A4,F4,C4,C4,AS2,D4,D4,C4,A3,C4,A3};

        int[] pitchArray3 = {C4,C4,F3,C4,F2,C3,C4,C4,C3,C3,E3,F3,C4,C4,F3,A4,A2,AS2,D4,AS4,AS4,C3,F4,E3,F3};
        //create an array to store the durations of the notes
        double[] rhythmArray = {QN,QN,HN,HN,HN,WN,QN,QN,HN,HN,HN,WN,QN,QN,HN,HN,HN,HN,WN,QN,QN,HN,HN,HN,WN};

        //create a phrase
        Phrase phr1 = new Phrase(0.0);

        //create a phrase
        Phrase phr2 = phr1.copy();
            phr2.setStartTime(0.0);

        Phrase phr3 = phr1.copy();
            phr3.setStartTime(0.0);

        //put the note and duration arrays inside the phrase
        phr1.addNoteList(pitchArray1, rhythmArray);

        phr2.addNoteList(pitchArray2, rhythmArray);

        phr3.addNoteList(pitchArray3, rhythmArray);

        //add the phrase to the part
        piano1.addPhrase(phr1);
        piano1.addPhrase(phr2);
        piano1.addPhrase(phr3);

        //add the part to the score
        s.addPart(piano1);

        //write the score as a MIDI file to disk
        Write.midi(s,"HappyBirthdayHarmony.mid");
    }
}

