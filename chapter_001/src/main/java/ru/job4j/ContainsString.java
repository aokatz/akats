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
        boolean res = false;
        for (int i = 0; i < originArray.length; i++) {
            if (originArray[i] == subArray[0]) {
                res = true;
                for (int j = 0; j < subArray.length; j++) {
                    if (originArray[i + j] != subArray[j]) {
                        res = false;
                        break;
                    }
                }
            }
            if (res) {
                break;
            }
        }
        return res;
    }
}
