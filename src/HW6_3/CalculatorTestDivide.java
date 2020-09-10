package HW6_3;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(value = Parameterized.class)
public class CalculatorTestDivide {
    private int a;
    private int b;
    private int expected;

    public CalculatorTestDivide(int a, int b, int expected) {
        this.a = a;
        this.b = b;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}:divide({0}/{1})={2}")
    public static Iterable<Object[]> dataForTest() {
        return Arrays.asList(
                new Object[][] {
                        { 6, 3, 2 },
                        { 22, 11, 2 },
                        { 8, 2, 4 },
                }
        );
    }

    @Test
    public void getDivide() {
        Assert.assertEquals(expected, new Calculator().getDivide(a,b));
    }
}