package org.Test;

public class TestDemo1 extends Taggit {
    public static void main(String[] args) {
        Animal A = new Animal();
        Animal B = new TestDemo1();
        Animal C = new Taggit();
    }
}

class Animal{
    public Animal(){

    }
}

class Taggit extends Animal{

}