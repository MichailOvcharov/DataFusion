import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.omb.entity.FirstObject;
import ru.omb.entity.SecondObject;
import ru.omb.entity.ThirdObject;
import ru.omb.exception.CsvIllegalArgumentException;
import ru.omb.service.MergeService;

import javax.validation.constraints.Null;
import java.util.*;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {TestConfig.class})
public class MergeServiceTest {


    @Autowired
    private MergeService mergeService;

    /**
     * Проверяем, что функция findCSVFile находит 2 файла с расширением csv в каталоге /csvTest/
     * Далее сортируем список по возрастанию и проверяем, что первый файл csvFile1.csv, второй csvFile2.csv
     */
    @Test
    public void findCsvTest() {
        List<String> csvList;
        csvList = mergeService.findCSVFile("/csvTest/");
        Assert.assertNotNull(csvList);
        assertEquals(csvList.size(), 2);
        Collections.sort(csvList);
        assertEquals(csvList.get(0), "csvFile1.csv");
        assertEquals(csvList.get(1), "csvFile2.csv");
    }

    /*
     * Проверка на NullPointerException при передаче null в функцию findCSVFile
     */
    @Test()
    public void findCsvNullPointerExceptionTest() {
        Exception exception = null;
        try {
            mergeService.findCSVFile(null);
        } catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertEquals(NullPointerException.class, exception.getClass());
    }

    /*
     * Проверка получения первого объекта
     */
    @Test()
    public void readDataLineToFirstObjectTest() {
        String dirCsv = "/csvTest/";
        FirstObject firstObject = mergeService.readDataLineToFirstObject(dirCsv);
        assertNotNull(firstObject);
        assertEquals(firstObject.getMark17().intValue(), 12);
        assertEquals(firstObject.getMark23().intValue(), 17);
        assertEquals(firstObject.getMark35().intValue(), 193);
        assertEquals(firstObject.getMarkFV().intValue(), 10);
        assertEquals(firstObject.getMarkFX().intValue(), 14);
        assertEquals(firstObject.getMarkFT().intValue(), 15);
    }

    /*
     * Проверка получения второго объекта
     * проверка значений
     */
    @Test()
    public void readDataLineSecondObjectTest() {
        String dirCsv = "/csvTest/";
        SecondObject secondObjectObject = mergeService.readDataLineToSecondObject(dirCsv);
        assertNotNull(secondObjectObject);
        assertNull(secondObjectObject.getMark01());
        assertEquals(secondObjectObject.getMark17().intValue(), 12);
        assertEquals(secondObjectObject.getMark23().intValue(), 17);
        assertEquals(secondObjectObject.getMark35().intValue(), 193);
        assertEquals(secondObjectObject.getMarkFV().intValue(), 10);
        assertEquals(secondObjectObject.getMarkFX().intValue(), 14);
        assertEquals(secondObjectObject.getMarkFT().intValue(), 15);
    }

    /*
     * Проверка получения третьего объекта
     * и проверка его значений
     */
    @Test()
    public void readDataLineThirdObjectTest() {
        String dirCsv = "/csvTest/";
        ThirdObject thirdObject = mergeService.readDataLineToThirdObject(dirCsv);
        assertNotNull(thirdObject);
        assertTrue(thirdObject.getMark01().isEmpty());
        assertEquals(thirdObject.getMark17().size(), 3);
        assertEquals(thirdObject.getMark17().get(0).intValue(), 10);
        assertEquals(thirdObject.getMark17().get(1).intValue(), 2);
        assertEquals(thirdObject.getMark17().get(2).intValue(), 0);
        assertEquals(thirdObject.getMark23().size(), 2);
        assertEquals(thirdObject.getMark23().get(0).intValue(), 14);
        assertEquals(thirdObject.getMark23().get(1).intValue(), 3);
        assertEquals(thirdObject.getMark35().size(), 2);
        assertEquals(thirdObject.getMark35().get(0).intValue(), 189);
        assertEquals(thirdObject.getMark35().get(1).intValue(), 4);
        assertEquals(thirdObject.getMarkFV().size(), 2);
        assertEquals(thirdObject.getMarkFV().get(0).intValue(), 5);
        assertEquals(thirdObject.getMarkFV().get(1).intValue(), 5);
        assertEquals(thirdObject.getMarkFX().size(), 2);
        assertEquals(thirdObject.getMarkFX().get(0).intValue(), 8);
        assertEquals(thirdObject.getMarkFX().get(1).intValue(), 6);
        assertEquals(thirdObject.getMarkFT().size(), 2);
        assertEquals(thirdObject.getMarkFT().get(0).intValue(), 8);
        assertEquals(thirdObject.getMarkFT().get(1).intValue(), 7);
    }
}
