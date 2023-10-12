import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class) // запустили этот класс с Mockito

public class FelineTest {

    @Mock
    Feline feline;

    @Test
    public void timegetFamily() throws Exception {
        feline.getFamily();
        Mockito.verify(feline, times(1)).getFamily();
    }

    @Test
    public void returngetFamily() {
        Feline feline = new Feline();
        String actual = feline.getFamily();
        assertEquals("Кошачьи", actual);
    }

    @Test
    public void returngetKittens() {
        Feline feline = new Feline();
        int actual = feline.getKittens();
        assertEquals(1, actual);
    }

    @Test
    public void getKittensWithKittensCountShouldReturnKittensCount() {
        Feline feline = new Feline();
        int expected = 3;
        int actual = feline.getKittens(expected);
        assertEquals(expected, actual);
    }


    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> expected = feline.eatMeat();
        assertEquals(expected, List.of("Животные", "Птицы", "Рыба"));
    }

}