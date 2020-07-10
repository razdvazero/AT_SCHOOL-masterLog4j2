package pack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class SortTest {

    private static final Logger logger = LogManager.getLogger();

    public static void testSort() {

        System.out.println("Запуск теста класса pack.Sort");
        int[] arr1 = new int[] {1, 2, 3, 4, 5};
        int[] arr2 = new int[] {1, 2, 3, 4, 5};
        Sort.reverseSort(arr1);
            if (arr1.equals(arr2))
                logger.info("Массивы равны");
            else
                logger.error("Массивы не равны");
    }
}