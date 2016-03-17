import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class ConsoleUI {
    public static void main(String[] args){
        String RandomText = "";     //String to keep the content of RandomTextFile
        String pairPiece = "[A-Z]{1}[a-z0-9]+[a-z]{1}"; //String os pattern
        /* Reading RandomTextFile and saving its content in RandomText */
        try{
            RandomText = new Scanner(new File("RandomTextFile.txt")).useDelimiter("\\Z").next();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        Pattern myPattern = Pattern.compile(pairPiece);      //Pattern initialization
        Matcher myMatcher = myPattern.matcher(RandomText);  //Matcher initialization
        int counterOfPairs = 0;     //Counter of pairs
        int counterOfPieces = 0;
        /* Show matches */
        while(myMatcher.find()){
            System.out.print("I found " + myMatcher.group());
            if(myMatcher.find()) {
                System.out.println(" + " + myMatcher.group());
                counterOfPairs++;
            }
        }
        /* Show number of matches */
        System.out.println("\n" + counterOfPairs + " pairs in total");
    }
}
