package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here

        // tried 37430
        // too high
        int[] arr = new int[256];
       // int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        int[] inputLengths = {199,0,255,136,174,254,227,16,51,85,1,2,22,17,7,192};
        //int[] inputLengths = {3,4,1,5,7,1255};
        int currentPos = 0;
        int skipSize = 0;
        int arrayLength = arr.length;


        for (int i = 0; i < inputLengths.length; i++) {
            int endPos = (currentPos + inputLengths[i]) % arrayLength;
            arr = reverseArray(arr, currentPos, endPos);
            currentPos = (currentPos + inputLengths[i] + skipSize) % arrayLength;
            skipSize++;
            System.out.println(Arrays.toString(arr));
        }

        System.out.println("Multiplication : " + arr[0] * arr[1]);

    }

    private static int[] reverseArray(int[] arr, int currentPos, int endPos) {
        // find the distance between the currentPos and the endPos
        // theres probably a nice mathematical equation for this
        int distance = 0;
        if (currentPos == endPos) {
            distance = arr.length;
        } else {
            for (int i = currentPos; i != endPos; i++) {
                i = i % arr.length;
                if (i == endPos) {
                    break;
                }
                distance++;
            }
        }


        // creating the sub array
        int[] subArr = new int[distance];
        for (int i = 0; i < distance; i++) {
            i = i % arr.length;
            subArr[i] = arr[(i + currentPos) % arr.length];
        }


        // reversing the sub array
        for (int i = 0; i < subArr.length / 2; i++) {
            int leftNum = subArr[i];
            subArr[i] = subArr[subArr.length - 1 - i];
            subArr[subArr.length - 1 - i] = leftNum;
        }


        // plugging the sub array back into the main array
        for(int i =0; i< subArr.length; i++){
            arr[(i+ currentPos) % arr.length] = subArr[i];
        }

        return arr;

    }
}
