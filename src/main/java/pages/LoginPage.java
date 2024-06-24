package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By  loginButton = By.id("login-button");
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    private WebElement username(){
       return driver.findElement(usernameField);
    }
    private WebElement password(){
        return driver.findElement(passwordField);
    }
    private WebElement loginBtn(){
        return driver.findElement(loginButton);
    }
    public void performLogin(String username, String password) {
        driver.findElement(usernameField).clear();
        driver.findElement(passwordField).clear();

        if (username != null) {
            driver.findElement(usernameField).sendKeys(username);
        }

        if (password != null) {
            driver.findElement(passwordField).sendKeys(password);
        }
    }
    public boolean isUsernameFieldDisplayed() {
        return driver.findElement(usernameField).isDisplayed();
    }
    public boolean isPasswordFieldDisplayed() {
        return driver.findElement(passwordField).isDisplayed();
    }
    public SwagLabs clickLoginButton(){
        driver.findElement(loginButton).click();
        return new SwagLabs(driver);
    }
    public String getErrorMessage(){
        driver.findElement(loginButton).click();
        return driver.findElement(By.xpath("//*[@data-test='error']")).getText();
    }
}
