package ru.job4j.shapes;

/**
 * Класс Paint демонстрирует полиморфизм реализуя паттерн стратегия.
 * @author AKats
 */
public class Paint {
    /**
     * Метод отрисовке фигуры. На вход принимается ссылка типа интерфейс Shape.
     * Средствами динамического связывания вызывается метот draw того типа объекта,
     * на который указывает передаваемая ссылка.
     * @param shape - фигура для отрисовки.
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}
