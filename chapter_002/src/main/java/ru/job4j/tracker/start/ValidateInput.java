package ru.job4j.tracker.start;

import java.util.Arrays;

public class ValidateInput extends ConsoleInput {

    public int ask(String question, int[] allowedRange) {
        boolean invalid = true;
        int result = -1;
        do {
            try {
                result = super.ask(question, allowedRange);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Введите номер существующего пункта меню.");
            } catch (NumberFormatException nfe) {
                System.out.println("Введите значение номера пункта меню");
            }
        } while (invalid);
        return result;
    }
}
