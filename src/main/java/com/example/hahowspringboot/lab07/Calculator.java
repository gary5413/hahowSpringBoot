package com.example.hahowspringboot.lab07;

public class Calculator {

    public int add(int x,int y){
        return  x + y;
    }

    public int divide(int x,int y){
        return  x / y;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = calculator.add(1, 1);
        System.out.println("結果為："+result);
    }
}
