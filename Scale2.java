import jm.JMC;
import jm.music.data.*;
import jm.util.*;

public class Scale2 implements JMC {
    public static void main(String[] args) {

        //create a new score
        Score scaleScore = new Score("Scale Song");

        //create a new piano part
        Part piano = new Part("piano", PIANO, 0);

        //temporary phrase variable
        Phrase temp;

        //create an array to store the phrases
        Phrase[] phrases = new Phrase[2];

        //create a temp variable to store a number of notes
        int num;

        //the number of notes in the phrase
        int noteNum = 10;

        //the scale to be used
        int[] pent = HARMONIC_MINOR_SCALE;


        for (int noOfPhrases = 0; noOfPhrases < phrases.length; noOfPhrases++) {
            System.out.println("noOfPhrases: " + noOfPhrases);
            System.out.println(phrases.length);
            //create a new temporary phrase
            temp = new Phrase();
            for (int notesInPhrase = 0; notesInPhrase < noteNum;) {
                System.out.println("notesInPhrase: " + notesInPhrase);
                for (int p = 0; p < pent.length; p++) {
                    System.out.println("P: " + p);
                    //choose a random number between 55 and 80 to constrain the range notes can be within
                    num = (int) (Math.random() * 55 + 30);
                    //check if the random number matches the number in the scale
                    if (num % 12 == pent[p]) {
                        Note note = new Note(num, Q);
                        temp.addNote(note);
                        phrases[noOfPhrases] = temp;
                        temp.setStartTime(0.0);
                        notesInPhrase++;
                        //stop the loop adding extra notes if more than one correct notes are found in the last round
                        break;
                    }
                }
            }
                System.out.print(phrases[0]);
                System.out.print(phrases[1]);
                System.out.println("_____________________________________________");
            }
            //add the phrases to the part
            piano.addPhrase(phrases[0]);
            piano.addPhrase(phrases[1]);

            //add the part to the score
            scaleScore.addPart(piano);

            //write the music to a midi file
            Write.midi(scaleScore, "advancedScale.mid");
    }
}

