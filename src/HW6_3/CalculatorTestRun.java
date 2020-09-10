package HW6_3;

import org.junit.runner.JUnitCore;

public class CalculatorTestRun {
    public static void main(String[] args) {
        JUnitCore core = new JUnitCore();
        core.addListener(new CalculatorTestListener());
        core.run(MySuiteClass.class);
    }
}