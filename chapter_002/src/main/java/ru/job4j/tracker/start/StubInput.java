package ru.job4j.tracker.start;

import java.util.List;

/**
 * Класс автоматического ввода даннах (из массива с ответами)
 * @author AKats
 */
public class StubInput implements Input {
    private List<String> answers;
    private int position = 0;

    public StubInput(List<String> answers) {
        this.answers = answers;
    }

    @Override
    public String ask(String question) {
        return answers.get(position++);
    }

    @Override
    public int ask(String question, List<Integer> allowedRange) {
        return Integer.valueOf(answers.get(position++));
    }
}
