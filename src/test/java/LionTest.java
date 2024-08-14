import com.example.Lion;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Predator predator;

    @Test
    public void getKittens() throws Exception {
        // Имитация поведения Predator
        Mockito.when(predator.getKittens()).thenReturn(1);

        // Инициализируем объект Lion с использованием мока
        Lion lion = new Lion("Самка", predator);

        // Проверка корректность возвращаемого значения
        Assert.assertEquals(1, lion.getKittens());
    }

    @Test
    public void getFood() throws Exception {
        // Имитацию для метода eatMeat()
        Mockito.when(predator.eatMeat()).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));

        // Создаем экземпляр тестируемого класса
        Lion lion = new Lion("Самка", predator);

        // Сравниваем результат с ожидаемым списком
        Assert.assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test(expected = Exception.class)
    public void invalidSexTest() throws Exception {
        // Проверяем отображение исключения при некорректном входном параметре
        new Lion("НекорректныйПол", predator);
    }
}