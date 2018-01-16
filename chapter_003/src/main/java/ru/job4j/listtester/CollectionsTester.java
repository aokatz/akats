package ru.job4j.listtester;

import java.nio.charset.Charset;
import java.util.*;


/**
 * Тестирование коллекций
 */
public class CollectionsTester {
    private Collection<String> testCollection;
    private int testAmount;

    /**
     * Генерирование рандомной строки
     *
     * @param targetStringLength - длина строки
     * @return - строка
     */
    private static String generateRandomString(int targetStringLength) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString;
    }

    /**
     * Добавление элементов в коллекцию с замером времени
     *
     * @param collection - коллекция для добавления
     * @param amount     - количество строк для вставки
     * @return - количество затраченых на добавление наносекунд
     */
    public static long add(Collection<String> collection, int amount) {
        long res = 0;
        long begin = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            collection.add(generateRandomString(5));
        }
        res = System.nanoTime() - begin;
        return res;
    }

    /**
     * Удаление элементов коллекции с замером времени
     *
     * @param collection - коллекция для удаления
     * @param amount     - количество элементов для удаления
     * @return - количество затраченых на удаление наносекунд
     */
    public static long delete(Collection<String> collection, int amount) {
        long res = 0;
        long begin = System.nanoTime();
        while (amount > 0) {
            if (collection.iterator().hasNext()) {
                collection.remove(collection.iterator().next());
            }
            amount--;
        }
        res = System.nanoTime() - begin;
        return res;
    }

    public static void main(String[] args) {
        List<String> testArrayList = new ArrayList<>();
        List<String> testLinkedList = new LinkedList<>();
        Set<String> tetTreeSet = new TreeSet<>();
        int amountToPut = 50000;
        int amountToDelete = 20000;
        System.out.printf("Вставка %s элементов в LinkedList за %s миллисекунд%n", amountToPut, (float) add(testLinkedList, amountToPut) / 1000000);
        System.out.printf("Вставка %s элементов в ArrayList  за %s миллисекунд%n", amountToPut, (float) add(testArrayList, amountToPut) / 1000000);
        System.out.printf("Вставка %s элементов в TreeSet    за %s миллисекунд%n", amountToPut, (float) add(tetTreeSet, amountToPut) / 1000000);
        System.out.printf("Удаление %s элементов из LinkedList за %s миллисекунд%n", amountToDelete, (float) delete(testLinkedList, amountToDelete) / 1000000);
        System.out.printf("Удаление %s элементов из ArrayList  за %s миллисекунд%n", amountToDelete, (float) delete(testArrayList, amountToDelete) / 1000000);
        System.out.printf("Удаление %s элементов из TreeSet    за %s миллисекунд%n", amountToDelete, (float) delete(tetTreeSet, amountToDelete) / 1000000);
    }
}
