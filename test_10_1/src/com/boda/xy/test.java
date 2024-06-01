package com.boda.xy;

import com.google.Main;

class Animal {
    private String name = "大熊猫";

    private void display() {
        System.out.println("my name is " + this.name);
    }
}

public class test {
    public static void main(String[] args) {
        var a = new Animal();
        //System.out.println("a.name = "+a.name);

    }
}