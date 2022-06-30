package by.it.korennaya.jd01_14;

import java.io.*;
import java.io.BufferedReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static final String WORD = "[А-Яа-яёЁ]+";
    public static final String PUNCTUATION = "[,:.!?-]+";
    public static final String INPUT_FILE = "Poem.txt";
    public static final String OUTPUT_FILE = "resultTaskB.txt";



    public static void main(String[] args) {
        String inputFilePath = Util.getPath(TaskB.class, INPUT_FILE);
        String outputFilePath = Util.getPath(TaskB.class, OUTPUT_FILE);


        StringBuilder text = getText(inputFilePath);

        int words = countMatches(WORD, text);
        int punctuationMarks = countMatches(PUNCTUATION, text);
        System.out.println("words=" + words + ", punctuation marks=" + punctuationMarks);

        printFile(words, punctuationMarks, outputFilePath);
    }
    private static StringBuilder getText(String inputFilePath) {
        StringBuilder text= new StringBuilder();
        try(BufferedReader bufferedReader = new BufferedReader(
                new FileReader(inputFilePath))){
            while(bufferedReader.ready()){
                text.append(bufferedReader.readLine()).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return text;
    }

    public static int countMatches(String regex, StringBuilder text){
        int count=0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            count++;
        }
        return count;
    }

    private static void printFile(int words, int punctuationMarks, String outputFilePath) {
        try(PrintWriter out = new PrintWriter(outputFilePath)){
            out.println("words="+ words +", punctuation marks="+ punctuationMarks);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
