package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"stepDefinition"},
        features = {"src/test/java/features"}
)
public class runTest {

    @BeforeClass
    public static void before(){
        System.out.println("before -" + System.currentTimeMillis());
    }

    @AfterClass
    public static void after() {
        System.out.println("After - " + System.currentTimeMillis());
    }
}
