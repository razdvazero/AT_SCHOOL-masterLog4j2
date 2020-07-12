package pack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.HashMap;


public class MapTest {
    static private int fails=0;
    static private HashMap<String, String> map = new HashMap<String, String>();
    private static final Logger logger = LogManager.getLogger();

    public static void testMap() {
        logger.info("Запуск теста класса pack.Map");
        countElementsInMap();
        deleteValueFromMapTest();
    }

    public static void Search(int result){
        if (result>=1)
            logger.info("Совпадений: "+ result);
        else{
            logger.error("Совпадений нет");
            fails++;
        }
    }
    public static void countElementsInMap(){
        CompareObjectsTest.separate();
        int result;
        logger.info("Передаем в HashMap человека Дмитров Алексей");
        result=Map.countElementsInMap("Дмитров","Алексей");
        Search(result);
        logger.info("Передаем в HashMap человека Дмитров Алексей");
        result=Map.countElementsInMap("Дмитров","Алексей");
        Search(result);
        logger.info("Передаем в HashMap человека Ерохин Сергей");
        result=Map.countElementsInMap("Ерохин","Сергей");
        Search(result);
        logger.info("Передаем в HashMap человека Ярмолов Алексей");
        result=Map.countElementsInMap("Ярмолов","Алексей");
        Search(result);
        logger.info("Передаем в HashMap человека Карасев Дмитрий");
        result=Map.countElementsInMap("Карасев","Дмитрий");
        Search(result);
        logger.info("Передаем в HashMap человека Ерохин Сергей");
        result=Map.countElementsInMap("Ерохин","Сергей");
        Search(result);
        logger.info("Передаем в HashMap человека Андреев Андрей");
        result=Map.countElementsInMap("Андреев","Андрей");
        Search(result);
        logger.info("Передаем в HashMap человека Смирнов Владимир");
        result=Map.countElementsInMap("Смирнов","Владимир");
        Search(result);
        logger.info("Передаем в HashMap человека Ерохин Сергей");
        result=Map.countElementsInMap("Ерохин","Сергей");
        Search(result);
        logger.info("Передаем в HashMap человека Андреев Андрей");
        result=Map.countElementsInMap("Андреев","Андрей");
        Search(result);
        logger.warn("Нулевых совпадений во время поиска: "+ fails);
        // убрал пробелы в ключе и значении,ключ в hashmap уникальный, не годится для имен и фамилий с повторами
    }
    public static void Delete(HashMap map,String value){
        CompareObjectsTest.separate();
        int HashMapSize = map.size();
        logger.info("Удаляем значение '"+value+("'"));
        try {
            System.out.println(Map.deleteValueFromMap(map, value)); // возникает concurrent modification exception
        } catch (Exception e) {
            logger.error("Произошла какая то ошибка");
        } finally {
            if (map.size() == HashMapSize - 1) {
                logger.warn("Элемент удален");
            } else
                logger.error("Элемент не удален");{
            }
        }
        CompareObjectsTest.separate();
    }

    public static void HashMap() {
        map.clear();
        map.put("qq", "qq");
        map.put("ww", "aa");
        map.put("ee", "dd");
        map.put("gg", "hh");
    }
    public static void deleteValueFromMapTest() {
        String value1 = "qq";  //выдает ошибку
        String value2 = "aa";  //выдает ошибку
        String value3 = "dd";  //выдает ошибку
        String value4 = "hh";  //все работает

        CompareObjectsTest.separate();
        HashMap();
        logger.info("Имеется следущая HashMap");
        logger.info(map);
        Delete(map,value1);
        HashMap();
        Delete(map,value2);
        HashMap();
        Delete(map,value3);
        HashMap();
        Delete(map,value4);
        //удаляет только последний элемент в таблице

        }
}
