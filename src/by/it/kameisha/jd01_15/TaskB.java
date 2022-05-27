package by.it.kameisha.jd01_15;

import by.it.kameisha.jd01_14.Util;

import java.io.*;

public class TaskB {
    public static void main(String[] args) {
        String pathClass = Util.getPath(TaskA.class, TaskB.class.getSimpleName() + ".java");
        String pathTxtFile = Util.getPath(TaskA.class, TaskB.class.getSimpleName() + ".txt");
        printClass(pathClass, pathTxtFile);
        //comment 1
        System.out.println((byte) '*');
        /*
        hnrnrnrnrnrnr
         */
        StringBuilder result = readTxtFile(pathTxtFile);
        System.out.println(result);
    }

    private static StringBuilder readTxtFile(String pathTxtFile) {
        StringBuilder result = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(pathTxtFile))){
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private static void printClass(String pathClass, String pathTxtFile) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(pathClass));
             PrintWriter writer = new PrintWriter(pathTxtFile)) {
            //comment 2
            while (reader.ready()) {
                int first = reader.read();
                if (first != 47) {
                    writer.print((char) first);
                } else {
                    int second = reader.read();
                    if (second == 47) {
                        reader.readLine();
                    } else if (second == 42) {
                        String line = "";
                        while(!line.contains("*/")){
                            line = reader.readLine();
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
