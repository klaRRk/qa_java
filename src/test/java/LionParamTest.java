import com.example.Lion;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

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
        // Сравнение ожидаемого значения с возвращаемым значением метода doesHaveMane()
        Assert.assertEquals(expectedHasMane, lion.doesHaveMane());
     }
}