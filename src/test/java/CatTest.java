import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
    public class CatTest {
      private Cat cat;

      @Mock
       private Feline feline;

    @Before
    public void setUp() {
        this.cat = new Cat(feline);
    }
      @Test
        public void getSoundTest() {
          String expected = "Мяу";
          String actual = cat.getSound();
          assertEquals("Кошка не мяукает", expected, actual);

    }

      @Test
       public void getFoodTest() throws Exception {
          List<String> expectedFoodList = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFoodList);
          List<String> actualFoodList = cat.getFood();
          assertEquals("У кошки неправильное питание", expectedFoodList, actualFoodList);
}
}