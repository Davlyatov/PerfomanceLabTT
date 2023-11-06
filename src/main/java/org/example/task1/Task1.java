package org.example.task1;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        System.out.println("Input n");
        int n = new Scanner(System.in).nextInt();
        System.out.println("Input m");
        int m = new Scanner(System.in).nextInt();
        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        StringBuilder answer = new StringBuilder();
        int k = 0;
        do {
            answer.append(array[k]);
            k += m - 1;
            if (k >= array.length) {
                k = k - array.length;
            }
        } while (!answer.toString().contains(String.valueOf(array[k])));

        System.out.println(answer);
    }
}
