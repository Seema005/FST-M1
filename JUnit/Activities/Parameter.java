package JUNIT;

import Example.calculator;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Parameter {
    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3",
            "9,7,16",
            "10,15,25"
    })
    public void addMethodTest(int num1, int num2, int answer) {
        calculator cal = new calculator();
        int result = cal.add(num1, num2);
        System.out.println(num1 + "+" + num2 + "=" + result);
        assertEquals(answer, result);
    }
}
