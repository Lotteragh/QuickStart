import org.junit.Test
/**
 * CalcularTest
 */
public class CalculaterTest {
    @Test
    public void evaluatesExpression(){
        Calculator cal = new Calculator();
        int sum = cal.evaluatesExpression("1+2");
        assertEquals(3, sum);
    }
    
}