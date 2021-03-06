package pack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;



public class CompareObjectsTest {

    private static String[] test = {"One", "Two", "Two"};
    private static boolean Result;
    private static List<Object> objects;
    private static final Logger logger = LogManager.getLogger();

    static {
        objects = new ArrayList<>();
        objects.add(new TestObject("One"));
        objects.add(new TestObject("Two"));
        objects.add(new TestObject("Two"));
    }

    public static void CompareObjectsTest() {
        logger.info("Запуск теста класса pack.CompareObjects");
        CompareMassive();
        compareToStringMassive();
        compareHashCodeMassive();
        compareArray();
        compareToStringArray();
        compareHashCodeArray();
    }

    public static void result() {
        if(Result==true)
            logger.info("переменные равны");
        else
            logger.warn("переменные не равны");
    }
    public static void separate() {
        System.out.println("---------------------------------------------------------");
    }

    /**
     * сравнение переменных массива
     */

    public static void CompareMassive() {
        separate();
        logger.info("Сравнение переменных массива");
        separate();
        logger.info("Сравниваем переменную "+test[0]+" с собой");
        Result=CompareObjects.compare(test[0],test[0]); //должно быть true
        result();
        logger.info("Сравниваем переменную "+test[0]+" и переменную "+test[1]);
        Result=CompareObjects.compare(test[0],test[1]); //должно быть false
        result();
        logger.info("Сравниваем переменную "+test[1]+" и переменную "+test[2]);
        Result=CompareObjects.compare(test[1],test[2]);//должно быть true
        result();
        logger.info("Сравниваем переменную "+test[0]+" и переменную "+test[2]);
        Result=CompareObjects.compare(test[0],test[2]);// должно быть false
        result();
        separate();
    }

    public static void compareToStringMassive() {
        logger.info("Построчное сравнение переменных массива");
        separate();
        logger.info("Сравниваем переменную "+test[0]+" с собой");
        Result=CompareObjects.compareToString(test[0],test[0]); //должно быть true
        result();
        logger.info("Сравниваем переменную "+test[0]+" и переменную "+test[1]);
        Result=CompareObjects.compareToString(test[0],test[1]); //должно быть false
        result();
        logger.info("Сравниваем переменную "+test[1]+" и переменную "+test[2]);
        Result=CompareObjects.compareToString(test[1],test[2]);//должно быть true
        result();
        logger.info("Сравниваем переменную "+test[0]+" и переменную "+test[2]);
        Result=CompareObjects.compareToString(test[0],test[2]);// должно быть false
        result();
        separate();
    }

    public static void compareHashCodeMassive() {
        logger.info("Сравнение хэш-кодов переменных массива");
        separate();
        logger.info("Сравниваем переменную "+test[0]+" с собой");
        Result=CompareObjects.compareHashCode(test[0],test[0]); //должно быть true
        result();
        logger.info("Сравниваем переменную "+test[0]+" и переменную "+test[1]);
        Result=CompareObjects.compareHashCode(test[0],test[1]); //должно быть false
        result();
        logger.info("Сравниваем переменную "+test[1]+" и переменную "+test[2]);
        Result=CompareObjects.compareHashCode(test[1],test[2]);//должно быть true
        result();
        logger.info("Сравниваем переменную "+test[0]+" и переменную "+test[2]);
        Result=CompareObjects.compareHashCode(test[0],test[2]);// должно быть false
        result();
        separate();
    }

    /**
     * сравнение объектов ArrayList
     */


    public static void compareArray() {
        logger.info("Сравнение переменных ArrayList");
        separate();
        logger.info("Сравниваем первый объект с значением number='One' с собой");
        Result=CompareObjects.compare(objects.get(0), objects.get(0)); //должно быть true
        result();
        logger.info("Сравниваем первый объект с значением number='One' с вторым объектом с значением number='Two'");
        Result=CompareObjects.compare(objects.get(0), objects.get(1)); //должно быть false
        result();
        logger.info("Сравниваем второй объект с значением number='Two' с третьим объектом с значением number='Two'");
        Result=CompareObjects.compare(objects.get(1), objects.get(2));//должно быть true
        result();
        logger.info("Сравниваем первый объект с значением number='One' с третьим объектом с значением number='Two'");
        Result=CompareObjects.compare(objects.get(0), objects.get(2));// должно быть false
        result();
        separate();
    }

    public static void compareToStringArray() {
        logger.info("Построчное сравнение переменных ArrayList");
        separate();
        logger.info("Сравниваем первый объект с значением number='One' с собой");
        Result = CompareObjects.compareToString(objects.get(0), objects.get(0)); //должно быть true
        result();
        logger.info("Сравниваем первый объект с значением number='One' с вторым объектом с значением number='Two'");
        Result = CompareObjects.compareToString(objects.get(0), objects.get(1)); //должно быть false
        result();
        logger.info("Сравниваем второй объект с значением number='Two' с третьим объектом с значением number='Two'");
        Result = CompareObjects.compareToString(objects.get(1), objects.get(2));//должно быть true
        result();
        //System.out.println(objects.get(1).toString()); //pack.CompareObjectsTest$TestObject@4554617c
        //System.out.println(objects.get(2).toString()); //pack.CompareObjectsTest$TestObject@74a14482
        logger.info("Сравниваем первый объект с значением number='One' с третьим объектом с значением number='Two'");
        Result=CompareObjects.compareToString(objects.get(0), objects.get(2));// должно быть false
        result();
        separate();
    }

    public static void compareHashCodeArray() {
        logger.info("Сравнение хэш-кодов ArrayList");
        separate();
        logger.info("Сравниваем первый объект с значением number='One' с собой");
        Result=CompareObjects.compareHashCode(objects.get(0), objects.get(0)); //должно быть true
        result();
        logger.info("Сравниваем первый объект с значением number='One' с вторым объектом с значением number='Two'");
        Result=CompareObjects.compareHashCode(objects.get(0), objects.get(1)); //должно быть false
        result();
        logger.info("Сравниваем второй объект с значением number='Two' с третьим объектом с значением number='Two'");
        Result=CompareObjects.compareHashCode(objects.get(1), objects.get(2));//должно быть true
        result();
        logger.info("Сравниваем первый объект с значением number='One' с третьим объектом с значением number='Two'");
        Result=CompareObjects.compareHashCode(objects.get(0), objects.get(2));// должно быть false
        result();
        separate();
    }
    private static class TestObject {
        public String number;

        public TestObject(String number) {
            this.number = number;
        }
    }

    /**
     * как я понял при работе с простым массивом или ArrayList без создания объекта и добавлением одного
     * простого элемента все эти методы работают правильно но если появляется объект то методы начинают сравнивать
     * ссылки на объекты и хэш коды а не их содержимое и выводят несоответствие
     */
}
