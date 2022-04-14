import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
 
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
 
@TestInstance(Lifecycle.PER_CLASS)
public class NewTest {
     
     private WebDriver driver;
     String baseURL, nodeURL1, nodeURL2;
 
@BeforeAll
    public void setUp()  {
        baseURL="https://www.calculator.net";
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("Executing on Chrome");
         
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.navigate().to(baseURL);
            driver.manage().window().maximize();
    }
 
    @Test
    @Tag("positive") 
    public void calculatepercent1() {
        // Click on Math Calculators
        driver.findElement(By.xpath("//a[contains(text(),'Math')]")).click();
        // Click on Percent Calculators
        driver.findElement(
                By.xpath("//a[contains(text(),'Percentage Calculator')]"))
                .click();
        // Enter value 17 in the first number of the percent Calculator
        driver.findElement(By.id("cpar1")).sendKeys("17");
        // Enter value 35 in the second number of the percent Calculator
        driver.findElement(By.id("cpar2")).sendKeys("35");
 
        // Click Calculate Button
        driver.findElement(
                By.xpath("(//input[contains(@value,'Calculate')])[1]")).click();
        // Get the Result Text based on its xpath
        String result = driver.findElement(
                By.xpath(".//*[@id='content']/p[2]/font/b")).getText();
         
        System.out.println(" The Result is " + result);
        Assert.assertEquals("5.95",result);
         
    }
    @Test
    @Tag("negative") 
    public void calculatepercent2() {
        // Click on Math Calculators
        driver.findElement(By.xpath("//a[contains(text(),'Math')]")).click();
        // Click on Percent Calculators
        driver.findElement(
                By.xpath("//a[contains(text(),'Percentage Calculator')]"))
                .click();
        // Enter value 17 in the first number of the percent Calculator
        driver.findElement(By.id("cpar1")).sendKeys("17.1");
        // Enter value 35 in the second number of the percent Calculator
        driver.findElement(By.id("cpar2")).sendKeys("35.1");
 
        // Click Calculate Button
        driver.findElement(
                By.xpath("(//input[contains(@value,'Calculate')])[1]")).click();
        // Get the Result Text based on its xpath
        String result = driver.findElement(
                By.xpath(".//*[@id='content']/p[2]/font/b")).getText();
         
        System.out.println(" The Result is " + result);
        Assert.assertEquals("6",result);
         
    }
 
    @AfterAll
    public void tearDown() {
         driver.quit();
    }
}