package by.it.korennaya.jd01_15;
/*Класс TaskA
         Создайте матрицу 6 строк на 4 столбца из целых случайных чисел от -15 до 15 включительно.
         Выведите матрицу в текстовый файл matrix.txt, расположенный в папке задания jd01_15. При выводе для
        каждого числа нужно предусмотреть для него три знакоместа, после чисел – один пробел.
         Прочитайте файл и покажите его в консоли. Класс Scanner использовать нельзя.*/

import by.it._classwork_.jd01_14.Util;

import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA {
    public static final int ROWS = 6;
    public static final int COLUMNS = 4;
    public static final int MAX_NUMBER = 15;
    public static final int MIN_NUMBER = -15;

    public static void main(String[] args) {
        int[][] matrix = createMatrix(ROWS, COLUMNS, MIN_NUMBER, MAX_NUMBER);
        String filename = Util.getPath(TaskA.class, "matrix.txt");
        printMatrix(matrix, filename);
        String text = readFile(filename);
        System.out.println(text);
    }

    private static int[][] createMatrix(int rows, int columns, int minNumber, int maxNumber) {
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = ThreadLocalRandom.current().nextInt(minNumber, maxNumber + 1);
            }
        }
        return matrix;
    }

    private static String readFile(String filename) {
        StringBuilder out = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while (reader.ready()) {
                String line = reader.readLine();
                out.append(line).append('\n');
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return out.toString();
    }

    private static void printMatrix(int[][] matrix, String filename) {
        try (PrintWriter out = new PrintWriter(filename)) {
            for (int[] row : matrix) {
                for (int element : row) {
                    out.printf("%3d ", element);
                }
                out.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}