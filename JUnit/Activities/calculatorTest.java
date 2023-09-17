package JUNIT;

import Example.calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class calculatorTest {
   private calculator calculator;
    @BeforeEach
    public void setUp() throws Exception {
        calculator = new calculator();
    }
    @Test
    public void addNumbers() {
        calculator cal = new calculator();

        int result= cal.add(10,12);
        System.out.println(result);
    }
}
