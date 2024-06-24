package pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests{
    @DataProvider
    public Iterator<Object[]> getLoginData(){
        List<Object[]> loginData = new ArrayList<>();
        loginData.add(new Object[]{"standard_user", "password", false});
        loginData.add(new Object[]{"", "password", false});
        loginData.add(new Object[]{"standard_user", "", false});
        loginData.add(new Object[]{"standard_user", "secret_sauce", true});
        return loginData.iterator();
    }
    @Test(dataProvider = "getLoginData")
    public void testLoginForm(String username, String password, boolean isValidUser){
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        SwagLabs swagLabs = loginPage.clickLoginButton();
        assertTrue(loginPage.isUsernameFieldDisplayed(), "Username field is not displayed on login page");
        assertTrue(loginPage.isPasswordFieldDisplayed(), "Password field is not displayed on login page");
        loginPage.performLogin(username, password);

        if (!isValidUser) {
            if (username.isEmpty()) {
                assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
            } else if (password.isEmpty()) {
                assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");
            } else {
                assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
            }
        } else {
            loginPage.clickLoginButton();
            assertEquals(swagLabs.getTitleText(),"Swag Labs");
        }
    }

}
