package org.example.task2;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) throws IOException {
        System.out.println("Input path of file1");
        Path filePath1 = Paths.get(new Scanner(System.in).nextLine());
        System.out.println("Input path of file2");
        Path filePath2 = Paths.get(new Scanner(System.in).nextLine());

        float[] circleCoordinatesAndRadius = getCircleCoordinatesAndRadius(filePath1);
        float[][] dotsCoordinates = getDotsCoordinates(filePath2);
        float radius = circleCoordinatesAndRadius[2];

        for (float[] dotsCoordinate : dotsCoordinates) {
            float dotX = dotsCoordinate[0] - circleCoordinatesAndRadius[0];
            float dotY = dotsCoordinate[1] - circleCoordinatesAndRadius[1];
            float temp = (float) Math.sqrt(Math.pow(dotX, 2) + Math.pow(dotY, 2));

            if (radius == temp)
                System.out.println(dotsCoordinate[0] + " " + dotsCoordinate[1] + " is " + 0);
            else if (radius > temp)
                System.out.println(dotsCoordinate[0] + " " + dotsCoordinate[1] + " is " + 1);
            else
                System.out.println(dotsCoordinate[0] + " " + dotsCoordinate[1] + " is " + 2);
        }
    }

    private static float[][] getDotsCoordinates(Path filePath) throws IOException {
        String[] temp = readFromFile(filePath).split(" ");
        float[][] dots = new float[temp.length / 2][2];
        for (int i = 0; i < dots.length; i++) {
            for (int j = 0; j < dots[i].length; j++) {
                dots[i][j] = Float.parseFloat(temp[j + i * 2]);
            }
        }
        return dots;
    }


    private static float[] getCircleCoordinatesAndRadius(Path filePath) throws IOException {
        String[] temp = readFromFile(filePath).split(" ");
        float[] coordinates = new float[temp.length];
        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i] = Float.parseFloat(temp[i]);
        }

        return coordinates;
    }

    private static String readFromFile(Path filePath) throws IOException {
        Scanner scanner = new Scanner(filePath);
        StringBuilder s = new StringBuilder();
        while (scanner.hasNextLine()) {
            s.append(scanner.nextLine()).append(" ");
        }
        scanner.close();
        return s.toString();
    }
}
