package ru.smak.helloworld;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        System.out.println("Привет, Мир!");
        var scanner = new Scanner(System.in);
        var a = scanner.nextInt();
        var d = scanner.nextDouble();
        var s = scanner.nextLine();
    }
}
