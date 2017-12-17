package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here

        //1695 wrong

        System.out.println(solveP1(328));
        System.out.println(solveP2(328));
    }


    /**
     *
     *  no need to store the values in this one, we just want to check the last time position 1 would be changed
     *
     * @param numSteps
     * @return
     */
    public static int solveP2(final int numSteps) {
        int val = -1;
        for (int i = 1, pos = 1; i <= 50000000; i++) {
            if ((pos = ((pos + numSteps) % i) + 1) == 1) {
                val = i;
            }
        }

        return val;
    }


    public static int solveP1(final int numSteps) {
        final List<Integer> spinLock = new ArrayList<>();
        spinLock.add(0);

        int pos = 0;
        for (int i = 1; i <= 2017; i++) {
            pos = ((pos + numSteps) % spinLock.size()) + 1;
            spinLock.add(pos, i);
        }

        return spinLock.get(pos + 1);
    }

}

