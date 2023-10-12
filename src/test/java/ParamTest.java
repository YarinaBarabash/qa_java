

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import com.example.Feline;
import com.example.Lion;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ParamTest {
    private final String sex;

    public ParamTest(String sex) {
        this.sex = sex;

    }
    @Parameterized.Parameters(name = "Данные для тестирования")
    public static Object[][] createParametrsOfTest() {
        return new Object[][]{
                {"Мышь"},
                {"Лучик"},
                {"Рыбочка"},
        };
    }

    @Mock
    Feline feline;

    @Test
    public void testForFail(){ //получается, что дублирующий, но не знаю какой лучше
        try {
            Lion lion = new Lion(sex, feline);
        } catch (Exception exception) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
        }
    }
}
