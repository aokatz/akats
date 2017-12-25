package ru.job4j;

import java.util.Arrays;

/**
 * Поиск подстроки без String.indexOf и String.contains
 * @author AKats
 */
public class ContainsString {
    /**
     * Поиск подстроки
     * @param origin - строка, в которой ищем
     * @param sub - подстрока, которую ищем
     * @return - true, если строка найдена
     */
    public static boolean contains(String origin, String sub) {
        char[] originArray = origin.toCharArray();
        char[] subArray = sub.toCharArray();
        for (int i = 0; i < originArray.length; i++) {
            //находим первый элемент
            if (originArray[0] != subArray[0]) {
                while (++i < originArray.length && originArray[i] != subArray[0]);
            }
            //нашли первый, посмотрим остальные
            if (i < originArray.length) {
                int j = i + 1;
                int end = j + subArray.length - 1;
                for (int k = 1; j < end && originArray[j] == subArray[k]; j++, k++);

                if (j == end) {
                    //нашли всю строку
                    return true;
                }
            }
        }
        return false;
    }
}
