package guerbai.chapter3_data_struct;

import static guerbai.util.Print.print;
import static guerbai.util.Print.printMatrix;
import static guerbai.util.Print.printnb;
import static java.lang.System.currentTimeMillis;

public class GraphLetter {

    public static void printByDesign(char[][] design) {
        for (char[] sameLines: design) {
            int sameLineCount = Character.getNumericValue(sameLines[0]);
            for (int lineNumber=0; lineNumber<sameLineCount; lineNumber++) {
                for (int i=1; i<sameLines.length; i=i+2) {
                    for (int time=0; time<Character.getNumericValue(sameLines[i]); time++) {
                        if (sameLines[i+1]=='x') {
                            printnb('X');
                        }
                        if (sameLines[i+1]=='b') {
                            printnb(' ');
                        }
                    }
                }
                printnb('\n');
            }
        }
    }

    public static void main(String[] args) {
        long startAt = currentTimeMillis();

        char[][] design = {
                {'3', '9', 'x'},
                {'6', '3', 'b', '3', 'x', '3', 'b'},
                {'3', '9', 'x'},
        };
        print("Now we print graph: I");
        GraphLetter.printByDesign(design);


        char[][] designH = {
                {'5', '3', 'x', '3', 'b', '3', 'x'},
                {'2', '9', 'x'},
                {'5', '3', 'x', '3', 'b', '3', 'x'},
        };
        print("Now we print graph: H");
        GraphLetter.printByDesign(designH);

        char[][] designZ = {
                {'3', '9', 'x'},
                {'1', '6', 'b', '3', 'x'},
                {'1', '5', 'b', '3', 'x'},
                {'1', '4', 'b', '3', 'x'},
                {'1', '3', 'b', '3', 'x'},
                {'1', '2', 'b', '3', 'x'},
                {'1', '1', 'b', '3', 'x'},
                {'3', '9', 'x'},
        };
        print("Now we print graph: Z");
        GraphLetter.printByDesign(designZ);

        long endAt = currentTimeMillis();
        print("Program cost time: " + (float) (endAt - startAt) / 1000 + 's');
    }
}
