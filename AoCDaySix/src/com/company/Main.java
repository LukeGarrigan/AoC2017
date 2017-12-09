package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        Integer[] input = {0, 2, 7, 0};
        Integer[] input2 = {14, 0, 15, 12, 11, 11, 3, 5, 1, 6, 8, 4, 9, 1, 8, 4};

        // find biggest number

        System.out.println(solvePartOne(input));

    }

    private static int solvePartOne(Integer[] input) {
        List<Integer[]> inputs = new ArrayList<>();
        inputs.add(input);

        int count = 1;
        while (true) {
            Integer[] newArray = doMemoryAllocation(input);
            if (inputs.stream().anyMatch(a -> Arrays.equals(a, newArray))) {

                break;
            }
            count++;
            inputs.add(newArray);
            System.out.println(Arrays.toString(input));
            input = newArray.clone();
        }
        return count;
    }

    private static int solvePartTwo(Integer[] input) {
        List<Integer[]> inputs = new ArrayList<>();
        inputs.add(input);

        int count = 1;
        while (true) {
            Integer[] newArray = doMemoryAllocation(input);
            if (inputs.stream().anyMatch(a -> Arrays.equals(a, newArray))) {
                System.out.println(count);
                inputs = new ArrayList<>();
                count =0;
            }
            count++;
            inputs.add(newArray);
            //System.out.println(Arrays.toString(input));
            input = newArray.clone();
        }
    }

    private static Integer[] doMemoryAllocation(Integer[] array) {
        Integer[] input = array.clone();

        Integer biggestNumberPosition = findBiggestNumberPosition(input);
        int biggestNumber = input[biggestNumberPosition];

        input[biggestNumberPosition] = 0;

        int currentPosition = biggestNumberPosition + 1;
        do {
            if (currentPosition >= input.length) {
                currentPosition = 0;
            }

            input[currentPosition] += 1;
            currentPosition++;
            biggestNumber--;
        } while (biggestNumber != 0);

        return input;
    }

    private static int findBiggestNumberPosition(Integer[] input) {
        int biggestPos = 0;
        for (int i = 1; i < input.length; i++) {

            if (input[i] > input[biggestPos]) {
                biggestPos = i;
            }
        }
        return biggestPos;

    }
}
