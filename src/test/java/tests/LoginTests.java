package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void precondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }

    @Test
    public void loginPositiveTestBase(){
        String email = "mb@gmail.com", password = "Mb12345$";
        app.getUser().openLoginForm();       //open login form
        app.getUser().fillLoginForm(email, password);   //fill login form
        app.getUser().submitLogin();     //click on button Login
        app.getUser().pause(3000);   //pause for 3 seconds
//        Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }


    @Test
    public void loginNegativeTestWrongEmail() {
        String email = "mbgmail.com", password = "Mb12345$";
        app.getUser().openLoginForm();       //open login form
        app.getUser().fillLoginForm(email, password);   //fill login form
        app.getUser().submitLogin();     //click on button Login
        app.getUser().pause(3000);   //pause for 3 seconds
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }
    //надо закрыть выплывающее окно.

    @Test
    public void loginNegativeTestWrongPassword() {
        String email = "mb@gmail.com", password = "Mb123455";
        app.getUser().openLoginForm();       //open login form
        app.getUser().fillLoginForm(email, password);   //fill login form
        app.getUser().submitLogin();     //click on button Login
        app.getUser().pause(3000);   //pause for 3 seconds
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }
    //надо тоже закрыть выплывающее окно.

}