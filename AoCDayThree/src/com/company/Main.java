package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here


        int number = 277678;
        System.out.println(questionOne(number));
    }

    private static int questionOne(int number) {
        int perfectSquare = findClosestOddPerfectSquare(number);
        System.out.println(perfectSquare);

        int[][] spiralArray = createSpiralArray(perfectSquare);
        return calculateManhattanDistance(spiralArray, number);
    }

    private static int calculateManhattanDistance(int[][] spiralArray, int number) {

        int xPos = 0;
        int yPos = 0;

        int targetX = (int) Math.floor(spiralArray.length / 2);
        int targetY = targetX;

        for (int i = 0; i < spiralArray.length; i++) {
            for (int j = 0; j < spiralArray.length; j++) {

                if (spiralArray[i][j] == number) {
                    xPos = i;
                    yPos = j;
                    return Math.abs(targetX-xPos)+Math.abs(targetY-yPos);
                }
            }

        }

        return 0;

    }

    


    private static int[][] createSpiralArray(int perfectSquare) {

        int dimensions = (int) Math.sqrt(perfectSquare);
        int[][] array = new int[dimensions][dimensions];
        int centerCordinates = (int) Math.floor(dimensions / 2);

        int xPos = centerCordinates;
        int yPos = centerCordinates;

        array[xPos][yPos] = 1;
        Direction direction = Direction.RIGHT;

        int count = 0;
        int numberDisplacement = 1;

        for (int i = 2; i <= perfectSquare; i++) {
            if (direction == Direction.RIGHT) {
                xPos = xPos + 1;
                array[xPos][yPos] = i;
                count++;
                if (count >= numberDisplacement) {
                    direction = Direction.UP;
                    count = 0;
                }
            } else if (direction == Direction.UP) {
                yPos = yPos - 1;
                array[xPos][yPos] = i;
                count++;
                if (count >= numberDisplacement) {
                    direction = Direction.LEFT;
                    count = 0;
                    numberDisplacement += 1;
                }
            } else if (direction == Direction.LEFT) {
                xPos = xPos - 1;
                array[xPos][yPos] = i;
                count++;
                if (count >= numberDisplacement) {
                    direction = Direction.DOWN;
                    count = 0;
                }

            } else if (direction == Direction.DOWN) {
                yPos = yPos + 1;
                array[xPos][yPos] = i;
                count++;
                if (count >= numberDisplacement) {
                    direction = Direction.RIGHT;
                    count = 0;
                    numberDisplacement += 1;
                }
            }


        }
        return array;

    }


    public enum Direction {
        RIGHT,
        UP,
        LEFT,
        DOWN;
    }

    private static int findClosestOddPerfectSquare(int n) {

        for(int i=1; i<Integer.MAX_VALUE;i=i+2){
            if(i*i > n){
                return i*i;
            }
        }
        return 0;
    }




}
