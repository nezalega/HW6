package HW6_3;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(value = Parameterized.class)
public class CalculatorTestSum {

    private int a;
    private int b;
    private int expected;

    public CalculatorTestSum(int a, int b, int expected) {
        this.a = a;
        this.b = b;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}:sum({0}+{1})={2}")
    public static Iterable<Object[]> dataForTest() {
        return Arrays.asList(
                new Object[][] {
                        { 6, 3, 9 },
                        { 22, 11, 33 },
                        { 8, 2, 10 },
                }
        );
    }

    @Test
    public void getSum() {
        Assert.assertEquals(expected, new Calculator().getSum(a,b));
    }
}