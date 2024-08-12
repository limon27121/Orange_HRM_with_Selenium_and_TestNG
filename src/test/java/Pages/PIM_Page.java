package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PIM_Page {
    @FindBy(className = "oxd-main-menu-item")
    public List<WebElement> Left_menu;
    @FindBy(className = "oxd-button--medium")
    public List <WebElement> add_button;
    @FindBy(className = "oxd-input")
    public List<WebElement>text_field;




    public PIM_Page(WebDriver driver){

        PageFactory.initElements(driver,this);
    }

    public void CreateUser(String firstname,String lastname,String username,String password){
        text_field.get(1).sendKeys(firstname);
        text_field.get(3).sendKeys(lastname);
        text_field.get(5).sendKeys(username);
        text_field.get(6).sendKeys(password);
        text_field.get(7).sendKeys(password);

    }
}
