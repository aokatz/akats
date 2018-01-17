package ru.job4j.tracker.start;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Класс ввода даннах из консоли
 * @author AKats
 */
public class ConsoleInput implements Input {

    @Override
    public String ask(String question) {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public int ask(String question, List<Integer> allowedRange) {
        int key = Integer.valueOf(this.ask(question));
        if (allowedRange.stream().anyMatch(i -> i == key)) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range");
        }
    }
}
