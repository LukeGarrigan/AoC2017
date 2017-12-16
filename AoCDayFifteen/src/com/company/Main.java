package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static long MAX = 5000000;
    static List<Long> aVals = new ArrayList<>();
    static List<Long> bVals = new ArrayList<>();

    public static void main(String[] args) {
        // write your code here


        SetGenerator genA = new SetGenerator(16807, 277);
        SetGenerator genB = new SetGenerator(48271, 349);


        while (aVals.size() < MAX || bVals.size() < MAX) {
            long a = genA.calculateNext();
            long b = genB.calculateNext();

            if (a % 4 == 0) {
                aVals.add(a);
            }

            if (b % 8 == 0) {
                bVals.add(b);
            }
        }

        compareAAndB();

    }

    private static void compareAAndB() {
        int count = 0;
        for (int i = 0; i < MAX; i++) {
            long a = aVals.get(i);
            long b = bVals.get(i);
            a = last16Bits(a);
            b = last16Bits(b);
            if (a == b) {
                count++;
            }
        }
        System.out.println(count);
    }


    private static long last16Bits(long num) {
        String full = Long.toBinaryString(num & 0xffffffffL | 0x100000000L).substring(1);
        String sub = full.substring(16, full.length());

        return Long.parseLong(sub);
    }
}
