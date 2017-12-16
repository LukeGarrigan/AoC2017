package com.company;

public class SetGenerator {

    private long factor;
    private long value;

    public SetGenerator(long factor, long value){
        this.factor = factor;
        this.value = value;
    }

    public long calculateNext(){
        long val = value * factor;
        value = val % 2147483647;
        return value;
    }





}
