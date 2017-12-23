package ru.job4j.loop;

/**
 * @author AKats
 */
public class Paint {
    /**
     * Пирамида в консоли
     * @param height - высота пирамида
     * @return - пирамида в String
     */
    public String pyramid(int height) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height * 2 - 1; j++) {
                if (i >= height - j - 1 && i + height - 1 >= j) {
                    stringBuilder.append("^");
                } else {
                    stringBuilder.append(" ");
                }
            }
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
