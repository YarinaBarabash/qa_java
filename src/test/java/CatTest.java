import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Assert;
import java.util.List;


import static org.junit.Assert.assertEquals;



@RunWith(MockitoJUnitRunner.class) // запустили этот класс с Mockito

 public class CatTest {
    private Cat cat;
    @Mock // создали мок
    Feline feline;


    @Test
    public void returngetSound() {
        cat = new Cat(feline);
       String actual = cat.getSound();
        assertEquals("Мяу", actual);
    }

    @Test
    public void testGetFood() throws Exception{
        cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = cat.getFood();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), actual);
    }
}

