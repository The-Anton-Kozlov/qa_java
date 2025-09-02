import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    private Lion lionMale;
    private Lion lionFemale;

    @Before
    public void setUp() throws Exception {
        lionMale = new Lion(feline, "Самец");
        lionFemale = new Lion(feline, "Самка");
    }

    @Test
    public void getKittensTest() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(3);
        int actualKittensCount = lionFemale.getKittens();
        int expectedKittensCount = 3;
        assertEquals("Не правильное количество львят", expectedKittensCount, actualKittensCount);
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        boolean expectedHaveMane = true;
        boolean actualHaveMane = lionMale.doesHaveMane();
        assertEquals("У самца нет гривы", actualHaveMane, expectedHaveMane);
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = lionMale.getFood();
        assertEquals("Лев питается не правильно", expected, actual);
    }

    @Test(expected = Exception.class)
    public void doesHaveManeThrowsExceptionTest() throws Exception {
        try {
            new Lion(feline, "Некорректный пол");
            fail("Должно выйти исключение");
        } catch (IllegalArgumentException e) {
            assertEquals("Некорректный пол", e.getMessage());
        }
    }
}