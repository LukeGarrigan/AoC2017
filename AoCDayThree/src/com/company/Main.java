package com.company;

public class Main {

    static int INPUT_VALUE = 277678;
    public static void main(String[] args) {
        // write your code here


        int number = 277678;
        // System.out.println(questionOne(number));
        System.out.println(questionTwo(277678));
    }

    private static int questionOne(int number) {
        int perfectSquare = findClosestOddPerfectSquare(number);
        System.out.println(perfectSquare);

        int[][] spiralArray = createSpiralArray(perfectSquare);
        return calculateManhattanDistance(spiralArray, number);
    }

    private static int questionTwo(int number) {
        int perfectSquare = findClosestOddPerfectSquare(number);
       // System.out.println(perfectSquare);

        int value= createSpiralArrayPartTwo(perfectSquare);
        return value;
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
                    return Math.abs(targetX - xPos) + Math.abs(targetY - yPos);
                }
            }

        }

        return 0;

    }

    private static int createSpiralArrayPartTwo(int perfectSquare) {

        int dimensions = (int) Math.sqrt(perfectSquare);
        int[][] array = new int[dimensions][dimensions];
        int centerCordinates = (int) Math.floor(dimensions / 2);

        int xPos = centerCordinates;
        int yPos = centerCordinates;

        array[xPos][yPos] = 1;
        Direction direction = Direction.RIGHT;

        int count = 0;
        int numberDisplacement = 1;

        for (int i = 1; i < perfectSquare; i++) {
            if (direction == Direction.RIGHT) {
                xPos = xPos + 1;

                int west = 0;
                int northWest = 0;
                int north = 0;
                int northEast = 0;
                if (xPos - 1 >= 0) {
                    west = array[xPos - 1][yPos];
                }

                if (xPos - 1 >= 0 && yPos - 1 >= 0) {
                    northWest = array[xPos - 1][yPos - 1];
                }

                if (yPos - 1 >= 0) {
                    north = array[xPos][yPos - 1];
                }

                if (xPos + 1 < dimensions && yPos - 1 > 0) {
                    northEast = array[xPos + 1][yPos - 1];
                }

                array[xPos][yPos] = west + northWest + north + northEast;
                if(array[xPos][yPos]> INPUT_VALUE){
                    return array[xPos][yPos];
                }
                count++;
                if (count >= numberDisplacement) {
                    direction = Direction.UP;
                    count = 0;
                }
            } else if (direction == Direction.UP) {
                yPos = yPos - 1;

                int south = 0;
                int southWest = 0;
                int west = 0;
                int northWest = 0;

                if (yPos + 1 < dimensions) {
                    south = array[xPos][yPos + 1];
                }

                if (xPos - 1 >= 0 && yPos + 1 < dimensions) {
                    southWest = array[xPos - 1][yPos + 1];
                }

                if (xPos - 1 >= 0) {
                    west = array[xPos - 1][yPos];
                }

                if (xPos - 1 >= 0 && yPos - 1 >= 0) {
                    northWest = array[xPos - 1][yPos - 1];
                }

                array[xPos][yPos] = south + southWest + west + northWest;
                if(array[xPos][yPos]> INPUT_VALUE){
                    return array[xPos][yPos];
                }
                count++;
                if (count >= numberDisplacement) {
                    direction = Direction.LEFT;
                    count = 0;
                    numberDisplacement += 1;
                }
            } else if (direction == Direction.LEFT) {
                xPos = xPos - 1;

                int east = 0;
                int southEast = 0;
                int south = 0;
                int southWest = 0;

                if (xPos + 1 < dimensions) {
                    east = array[xPos + 1][yPos];
                }

                if (xPos + 1 < dimensions && yPos + 1 < dimensions) {
                    southEast = array[xPos + 1][yPos + 1];
                }

                if (yPos + 1 < dimensions) {
                    south = array[xPos][yPos + 1];
                }

                if (xPos - 1 >= 0 && yPos + 1 < dimensions) {
                    southWest = array[xPos - 1][yPos + 1];
                }
                array[xPos][yPos] = east + southEast + south + southWest;
                if(array[xPos][yPos]> INPUT_VALUE){
                    return array[xPos][yPos];
                }
                count++;
                if (count >= numberDisplacement) {
                    direction = Direction.DOWN;
                    count = 0;
                }

            } else if (direction == Direction.DOWN) {
                yPos = yPos + 1;

                int north = 0;
                int northEast = 0;
                int east = 0;
                int southEast = 0;


                if (yPos - 1 >= 0) {
                    north = array[xPos][yPos - 1];
                }

                if (xPos + 1 < dimensions && yPos - 1 >= 0) {
                    northEast = array[xPos + 1][yPos - 1];
                }

                if(xPos +1 < dimensions){
                    east = array[xPos + 1][yPos];
                }

                if(xPos+1 < dimensions && yPos+1 <dimensions){
                    southEast = array[xPos + 1][yPos + 1];
                }

                array[xPos][yPos] = north + northEast + east + southEast;
                if(array[xPos][yPos]> INPUT_VALUE){
                    return array[xPos][yPos];
                }
                count++;
                if (count >= numberDisplacement) {
                    direction = Direction.RIGHT;
                    count = 0;
                    numberDisplacement += 1;
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

        for (int i = 1; i <= perfectSquare; i++) {
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

        for (int i = 1; i < Integer.MAX_VALUE; i = i + 2) {
            if (i * i > n) {
                return i * i;
            }
        }
        return 0;
    }


}
