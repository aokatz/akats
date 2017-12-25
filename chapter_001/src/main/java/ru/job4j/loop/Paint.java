package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * @author AKats
 */
public class Paint {

        public String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < weight; j++) {
                    if (predict.test(i, j)) {
                        stringBuilder.append("^");
                    } else {
                        stringBuilder.append(" ");
                    }
                }
                stringBuilder.append(System.lineSeparator());
            }
            return stringBuilder.toString();
       }
    /**
     * Пирамида в консоли
     * @param height - высота пирамида
     * @return - пирамида в String
     */
       public String pyramid(int height) {
            return this.loopBy(
                    height,
                    2 * height - 1,
                    (i, j) -> i >= height - j - 1 && i + height - 1 >= j);
       }
    }
