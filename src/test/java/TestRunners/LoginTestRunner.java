package TestRunners;

import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import Setup.Setup;

public class LoginTestRunner extends Setup {
    LoginPage loginpage;

@Test(priority = 1)
   public void login_with_wrong_credentials() throws InterruptedException {
       loginpage=new LoginPage(driver);
       loginpage.doLogin("limon","limon27121");
       Thread.sleep(100);
       WebElement elem= driver.findElement(By.className("oxd-alert-content--error"));
       String text= elem.getText();
       Assert.assertEquals(text,"Invalid credentials");

   }

    @Test(priority = 2)
    public void doLogin(){
        loginpage= new LoginPage(driver);
        loginpage.doLogin("Admin","admin123");
        boolean show=loginpage.Image_Button.isDisplayed();
        Assert.assertTrue(show);
    }
  @Test(priority = 3)
    public void Logout() throws InterruptedException {
        loginpage= new LoginPage(driver);
        loginpage.Logout();
//        Thread.sleep(300);
//        WebElement elem =driver.findElement(By.className(".orangehrm-login-forgot"));
//        String show=elem.getText();
//        Assert.assertEquals(show,"Forgot your password? ");

    }

}
