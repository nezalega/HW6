package HW6_3;

import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

public class CalculatorTestListener extends RunListener {
    @Override
    public void testRunFinished(Result result) throws java.lang.Exception {
        System.out.println("This tests work gooooooooood : " + result.getRunCount());
    }
}
