package ru.job4j.shapes;

/**
 * Класс треугольник. Реализует интерфейс Shape
 * @author AKats
 */
public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("  +  ");
        pic.append(System.lineSeparator());
        pic.append(" +++ ");
        pic.append(System.lineSeparator());
        pic.append("+++++");
        return pic.toString();
    }
}
