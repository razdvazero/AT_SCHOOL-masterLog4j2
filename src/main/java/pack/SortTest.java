package pack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class SortTest {

    private static final Logger logger = LogManager.getLogger();

    public static void testSort() {

        logger.info("Запуск теста класса pack.Sort");
        int[] arr1 = new int[] {1, 2, 3, 4, 5};
        int[] arr2 = new int[] {1, 2, 3, 4, 5};
        Sort.reverseSort(arr1);
        logger.info("Исходный массив:");
        String arr2string = Arrays.toString(arr2);
        System.out.println(arr2string);
        logger.info("Отсортированный массив:");
        String arr1string = Arrays.toString(arr1);
        System.out.println(arr1string);
            if (arr1.equals(arr2))
                logger.info("Массивы равны");
            else
                logger.error("Массивы не равны");
    }
}