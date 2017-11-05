import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalculatorPageTest {

    private static WebDriver driver;

    @BeforeClass
    public static void start() {
        driver = new ChromeDriver();
        driver.get("C:\\Users\\Home\\Desktop\\GL\\automation\\calc.html");
    }

    @Before
    public void cleanup() {
        driver.findElement(By.cssSelector("input[type='button'][value='C']")).click();
    }

    @Test
    public void addInt(){
        CalculatorPage page = new CalculatorPage(driver);
        String result = page.add(18, 92);
        Assert.assertEquals("110", result);
    }

    @Test
    public void subtractInt(){
        CalculatorPage page = new CalculatorPage(driver);
        Assert.assertEquals("32", page.subtract(85, 53));
    }

    @Test
    public void multiplyInt(){
        CalculatorPage page = new CalculatorPage(driver);
        Assert.assertEquals("1023", page.multiply(93, 11));
    }

    @Test
    public void divideInt(){
        CalculatorPage page = new CalculatorPage(driver);
        Assert.assertEquals("6", page.divide(72, 12));
    }

    @AfterClass
    public static void stop(){
        driver.quit();
    }
}
