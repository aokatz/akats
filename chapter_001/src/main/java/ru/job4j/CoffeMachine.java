package ru.job4j;

import java.util.Arrays;

/**
 * Класс кофемашина.
 * @author AKats
 */
public class CoffeMachine {
    /**
     * Сдача наименьшим кол-вом монетам номиналом 1 2 5 10
     * @param value - Сумма с которой нужно сформировать сдачу
     * @param price - Стоимость кофе
     * @return - Массив монет для сдачи
     */
    public int[] changes(int value, int price) {
        int change = value - price;
        int[] res = new int[1];
        int i = 0;
        int[] coins = {10, 5, 2, 1};
        for (int coin : coins
                ) {
            while (change - coin >= 0) {
                if (i >= res.length) {
                    res = Arrays.copyOf(res, res.length + 1);
                }
                res[i++] = coin;
                change -= coin;
            }
            if (change < 0) {
                break;
            }
        }
        return res;
    }
}
