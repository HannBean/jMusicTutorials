import jm.JMC;
import jm.music.data.*;
import jm.midi.*;
import jm.music.tools.*;
import jm.util.*;

public class Chord implements JMC {

    static int cNote = 60;
    static int dNote = 62;
    static int eNote = 64;
    static int fNote = 65;
    static int gNote = 67;
    static int aNote = 69;
    static int bNote = 71;

    //create a new score
    Score chordScore = new Score("Chord");



    public static void main(String[] args) {
        Part dMajor = major(dNote);
        Part gMajor = major(gNote);
        Part cMajor = major(cNote);
        playChord(gMajor);
        playChord(dMajor);
        playChord(dMajor);
        playChord(gMajor);
        playChord(gMajor);
        playChord(cMajor);
        playChord(dMajor);
        playChord(gMajor);
    }
        private static Part major (int startingNote){

            //create a new piano part
            Part p = new Part("piano", PIANO, 0);
            int[] majorChord = new int[3];
            majorChord[0] = startingNote;
            majorChord[1] = startingNote + 4;
            majorChord[2] = startingNote + 7;

            CPhrase chord = new CPhrase();
            chord.addChord(majorChord, C);
            p.addCPhrase(chord);

            System.out.println(majorChord[0]);
            System.out.println(majorChord[1]);
            System.out.println(majorChord[2]);
            return p;
            //write the music to a midi file
            //Write.midi(p, "chord.mid");


        }

    private static void playChord(Part p) {

        Play.midi(p);
    }

    private static Part minor (int startingNote){

        //create a new piano part
        Part p = new Part("piano", PIANO, 0);
        int[] minorChord = new int[3];
        minorChord[0] = startingNote;
        minorChord[1] = startingNote + 3;
        minorChord[2] = startingNote + 7;

        CPhrase chord = new CPhrase();
        chord.addChord(minorChord, C);
        p.addCPhrase(chord);

        System.out.println(minorChord[0]);
        System.out.println(minorChord[1]);
        System.out.println(minorChord[2]);

        //write the music to a midi file
        //Write.midi(p, "chord.mid");
        return p;
    }

}




