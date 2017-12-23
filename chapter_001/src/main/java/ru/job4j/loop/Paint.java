package ru.job4j.loop;

public class Paint {
    public String pyramid(int height) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height - 1; j++) {
                if (j < i) {
                    stringBuilder.append("^");
                } else {
                    stringBuilder.append(" ");
                }
            }
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println((new Paint()).pyramid(5));
    }
}
