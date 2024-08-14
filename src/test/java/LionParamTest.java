import com.example.Lion;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LionParamTest {
    // Поля для хранения параметров конструктора
    String sex;
    boolean expectedHasMane;

    // Конструктор для передачи параметров
    public LionParamTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Mock
    Predator predator;

    // Параметризация для создания набора данных для тестов
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Самка", false},
                {"Самец", true}
        });
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        // Инициализация объекта Lion с параметрами
        Lion lion = new Lion(sex, predator);

        // Создаем мок объект Lion для имитации поведения
        Lion mockedLion = Mockito.mock(Lion.class);
        // Поведение мока в зависимости от пола льва
        if ("Самец".equals(sex)) {
            Mockito.when(mockedLion.doesHaveMane()).thenReturn(true);
        } else if ("Самка".equals(sex)) {
            Mockito.when(mockedLion.doesHaveMane()).thenReturn(false);
        }

        // Сравнение возвращаемого значения метода doesHaveMane() с ожидаемым
        Assert.assertEquals(lion.doesHaveMane(), mockedLion.doesHaveMane());
    }

}
