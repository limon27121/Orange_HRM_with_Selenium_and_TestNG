package TestRunners;

import Pages.LoginPage;
import Pages.PIM_Page;
import Setup.Setup;
import Utlis.Utlis;
import com.github.javafaker.Faker;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;


public class PIM_TestRunner extends Setup {
    LoginPage loginpage;
    @BeforeTest
    public void Do_Login(){
         loginpage=new LoginPage(driver);
         loginpage.doLogin("Admin","admin123");
    }
  @Test
    public void Add_new_employee() throws IOException, ParseException {
        PIM_Page pimpage=new PIM_Page(driver);
        pimpage.Left_menu.get(1).click();
        pimpage.add_button.get(2).click();
        driver.findElement(By.className("oxd-switch-input")).click();
        Faker faker= new Faker();
        String firstname=faker.name().firstName();
        String lastname=faker.name().lastName();
        String username=faker.name().username();
        String password="limon27121";
        pimpage.CreateUser(firstname,lastname,username,password);
        pimpage.add_button.get(1).click();
        WebElement headertitle=driver.findElement(By.xpath("//h6[normalize-space()='Personal Details']"));
        //explicit waiter
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOf(headertitle));
        String headertext=headertitle.getText();
        Assert.assertTrue(headertext.contains("Personal Details"));
        Utlis.saveUser(firstname,lastname,username,password);


    }
}
