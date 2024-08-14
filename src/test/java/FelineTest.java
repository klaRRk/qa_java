import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Mock
    Feline mockFeline;
    // Поле для хранения реального объекта Feline
    private Feline realFeline;
    // Инициализация Feline
    @Before
    public void setUp() {
        realFeline = new Feline();
    }

    @Test
    public void eatMeatTest() throws Exception {
        // Поведение мока
        Mockito.when(mockFeline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        // Сравниваем результаты реального объекта и мока
        Assert.assertEquals(realFeline.eatMeat(), mockFeline.eatMeat());
    }

    @Test
    public void getFamilyTest() {
        // Проверяем корректность возвращаемого значения для реального объекта
        String result = realFeline.getFamily();
        String expectedFamily = "Кошачьи";
        Assert.assertEquals(expectedFamily, result);
    }

    @Test
    public void getKittensTest() {
        Mockito.when(mockFeline.getKittens()).thenReturn(1);

        // Проверяем результат и количество вызовов
        int result = mockFeline.getKittens();
        Assert.assertEquals(1, result);
        Mockito.verify(mockFeline, times(1)).getKittens();
    }

    @Test
    public void testGetKittens() {
        Mockito.when(mockFeline.getKittens()).thenReturn(1);

        // Проверяем, что реальный объект и мок возвращают одинаковое значение
        Assert.assertEquals(realFeline.getKittens(), mockFeline.getKittens());
    }
}