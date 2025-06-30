import org.junit.Test;
import static  org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void sumTest(){
        Calculator c = new Calculator(2, 3);
        assertEquals(5.0, c.sum(), 0.001);
    }
}
