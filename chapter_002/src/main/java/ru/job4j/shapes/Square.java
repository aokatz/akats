package ru.job4j.shapes;

/**
 * Класс квадрат. Реализует интерфейс Shape
 * @author AKats
 */
public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("++++");
        pic.append(System.lineSeparator());
        pic.append("+  +");
        pic.append(System.lineSeparator());
        pic.append("+  +");
        pic.append(System.lineSeparator());
        pic.append("++++");
        return pic.toString();
    }
}
