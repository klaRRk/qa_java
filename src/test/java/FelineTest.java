import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void eatMeatTest() throws Exception {
        // Ожидаемый результат
        List<String> expectedDiet = List.of("Животные", "Птицы", "Рыба");

        // Получаем реальный результат
        List<String> actualDiet = feline.eatMeat();

        // Сравниваем ожидаемый и реальный результаты
        Assert.assertEquals(expectedDiet, actualDiet);
    }

    @Test
    public void getFamilyTest() {
        // Проверяем корректность возвращаемого значения для реального объекта
        String result = feline.getFamily();
        String expectedFamily = "Кошачьи";
        Assert.assertEquals(expectedFamily, result);
    }

    @Test
    public void getKittensTest() {

        // Проверяем результат и количество вызовов
        int result = feline.getKittens();
        int expectedKittens = 1;
        Assert.assertEquals(expectedKittens, result);
    }

    @Test
    public void testGetKittens() {
        // Получаем реальный результат
        int actualKittens = feline.getKittens();

        // Предполагаемое значение по умолчанию
        int expectedKittens = 1;

        // Сравниваем ожидаемый и реальный результаты
        Assert.assertEquals(expectedKittens, actualKittens);
    }
}