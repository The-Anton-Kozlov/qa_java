import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
   public class LionParameterizedTest {
    private final String sex;
    private final boolean expectedHasMane;

    public LionParameterizedTest(String sex, boolean expectedHasMane){
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }


@Parameterized.Parameters(name = "{index}: {0},{1}")
     public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
            {"Самец", true},
            {"Самка", false},
    });
}

    @Test
    public void testDoesHaveMane() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        Lion lion = new Lion(mockFeline, sex);
        assertEquals("Проверка наличия гривы", expectedHasMane, lion.doesHaveMane());
    }
}
