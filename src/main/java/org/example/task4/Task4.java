package org.example.task4;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) throws IOException {
        System.out.println("Input path of file:");
        Path path = Paths.get(new Scanner(System.in).nextLine());
        int[] nums = getNumbersFromFile(path);
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int num : nums) {
                temp[i] += Math.abs(nums[i] - num);
            }
        }
        System.out.println(Arrays.stream(temp).min().getAsInt());
    }

    private static int[] getNumbersFromFile(Path path) throws IOException {
        Scanner scanner = new Scanner(path);
        StringBuilder s = new StringBuilder();
        while (scanner.hasNextLine()) {
            s.append(scanner.nextLine()).append(" ");
        }
        scanner.close();
        String[] temp = s.toString().split(" ");
        int[] nums = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            nums[i] = Integer.parseInt(temp[i]);
        }
        return nums;
    }
}
