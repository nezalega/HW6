package HW6_3;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(value = Parameterized.class)
public class CalculatorTestMultiple {

    private int a;
    private int b;
    private int expected;

    public CalculatorTestMultiple(int a, int b, int expected) {
        this.a = a;
        this.b = b;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}:multiple({0}*{1})={2}")
    public static Iterable<Object[]> dataForTest() {
        return Arrays.asList(
                new Object[][] {
                        { 2, 1, 2 },
                        { 2, 6, 12 },
                        { 8, 2, 16 },
                }
        );
    }

    @Test
    public void getMultiple() {
        Assert.assertEquals(expected, new Calculator().getMultiple(a,b));
    }


}