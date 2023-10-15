import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Stack;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
   private Feline feline;
    @Test
    public void createLionMale() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean expected = true;
        assertEquals(expected, lion.doesHaveMane());
    }

    @Test
    public void createLionFemale() throws Exception {
        Lion lion = new Lion("Самка", feline);
        boolean expected = false;
        assertEquals(expected, lion.doesHaveMane());
    }

    @Test
    public void createLionRandom() throws Exception {
        try {
            Lion lion = new Lion("random", feline);
        } catch (Exception e) {
            String expected = "Используйте допустимые значения пола животного - самец или самка" ;
            String actual = e.getMessage();
            assertEquals(actual,expected );
        }
    }

    @Test
    public void testgetKittens() throws Exception {
        Lion lion = new Lion("Самка",feline);
        lion.getKittens();
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1,lion.getKittens ());
    }


    @Test
    public void testgetFood() throws Exception {
        Lion lion = new Lion("Самка",feline);
        lion.getFood();
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"),lion.getFood ());
    }
}