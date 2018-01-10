package ru.job4j.tracker.start;

/**
 * Класс автоматического ввода даннах (из массива с ответами)
 * @author AKats
 */
public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String ask(String question) {
        return this.answers[position++];
    }

    @Override
    public int ask(String question, int[] allowedRange) {
        return Integer.valueOf(this.answers[position++]);
    }
}
