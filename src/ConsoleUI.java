import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class ConsoleUI {
    public static void main(String[] args){
        String RandomText = "";     //String to keep the content of RandomTextFile
        String pair = "[A-Z]{1}[a-z0-9] +[a-z]{1}"; //String os pattern
        /* Reading RandomTextFile and saving its content in RandomText */
        try{
            RandomText = new Scanner(new File("RandomTextFile.txt")).useDelimiter("\\Z").next();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        Pattern myPattern = Pattern.compile(pair);      //Pattern initialization
        Matcher myMatcher = myPattern.matcher(RandomText);  //Matcher initialization
        int counterOfPairs = 0;     //Counter of pairs
        /* Show matches */
        while(myMatcher.find()){
            System.out.println("I found " + myMatcher.group());
            counterOfPairs++;
        }
        /* Show number of matches */
        System.out.println(counterOfPairs + " pairs in total");
    }
}
