package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwagLabs {
    private WebDriver driver;
    private By titleName = By.className("app_logo");
    public SwagLabs(WebDriver driver){
        this.driver=driver;
    }
    public String getTitleText(){
        return driver.findElement(titleName).getText();
    }
}
