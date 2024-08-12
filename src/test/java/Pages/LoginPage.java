package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {
    @FindBy(name = "username")
    public WebElement Username;
    @FindBy(name = "password")
    public WebElement Password_field;
    @FindBy(css = "[type=submit]")
    public WebElement Submit_button;

    @FindBy(className = "oxd-userdropdown-img")
    public WebElement Image_Button;
    @FindBy(css = "[role=menuitem]")
    public List<WebElement> Logout_Button;
//
//    @FindBy(className = "orangehrm-login-forgot")
//    WebElement elem;


    public LoginPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }

    public void doLogin(String username, String Password){
        Username.sendKeys(username);
        Password_field.sendKeys(Password);
        Submit_button.click();
    }
    public void Logout(){
        Image_Button.click();
        Logout_Button.get(3).click();
    }
}
