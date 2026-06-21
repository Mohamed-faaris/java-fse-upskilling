import org.example.CalculatorTest;
import org.example.EvenCheckerTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        CalculatorTest.class,
        EvenCheckerTest.class
})
public class AllTests {
}