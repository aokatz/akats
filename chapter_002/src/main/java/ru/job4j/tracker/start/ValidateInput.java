package ru.job4j.tracker.start;

/**
 * Класс обертка поверх классов с интерфейсовм Input c валидацией введенных данных.
 */
public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    @Override
    public int ask(String question, int[] allowedRange) {
        boolean invalid = true;
        int result = -1;
        do {
            try {
                result = this.input.ask(question, allowedRange);
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
