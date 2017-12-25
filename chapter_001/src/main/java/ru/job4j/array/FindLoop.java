package ru.job4j.array;

/**
 * Поиск в массиве перебором
 * @author AKats
 */
public class FindLoop {
    /**
     * Поиск в массиве перебором
     * @param data - массив
     * @param el - элемент, который ищем
     * @return - индекс искомого элемента. если не найден то -1
     */
    public int indexOf(int[] data, int el) {
        int result = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == el) {
                result = i;
                break;
            }
        }
        return result;
    }
}
