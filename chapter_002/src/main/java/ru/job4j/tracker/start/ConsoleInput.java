package ru.job4j.tracker.start;

import java.util.Scanner;

public class ConsoleInput implements Input {

    @Override
    public String ask(String question) {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
