import jm.JMC;
import jm.music.data.*;
import jm.util.*;

public class Scale implements JMC {
    public static void main(String[] args) {
        //create a new score
        Score scaleScore = new Score("Scale Song");

        //create a new piano part
        Part piano = new Part("piano", PIANO, 0);

        //create a new phrase
        Phrase phr1 = new Phrase();
        //create a phrase
        Phrase phr2 = phr1.copy();
        phr2.setStartTime(0.0);

        //create a variable to store a number of notes
        int num;

        //use pentatonic scale
        int[] pent = HARMONIC_MINOR_SCALE;

        for (short i = 0; i < 20;) {
            num = (int) (Math.random() * 55 + 30);
            for (short j = 0; j < pent.length; j++)
                if (num % 12 == pent[j]) {
                    Note note = new Note(num, Q);
                    phr1.addNote(note);
                    i++;
                }
        }
        for (short i = 0; i < 20;) {
            num = (int) (Math.random() * 55 + 30);
            for (short j = 0; j < pent.length; j++)
                if (num % 12 == pent[j]) {
                    Note note = new Note(num, Q);
                    phr2.addNote(note);
                    i++;
                }
        }



        piano.addPhrase(phr1);
        piano.addPhrase(phr2);

        scaleScore.addPart(piano);

        Write.midi(scaleScore, "scaleMelody.mid");
    }
}

