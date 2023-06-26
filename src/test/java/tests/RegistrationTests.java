package tests;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @Test
    public void registrationPositive(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;

        User user = new User()
                .withEmail("mb" + i + "@gmail.com")
                .withPassword("Mb12345$")
                ;
        app.getUser().openLoginForm();                    //open login form
        app.getUser().fillLoginForm(user);                //fill login form
        app.getUser().submitRegistration();               //click on button Registration
        app.getUser().pause(3000);                  //pause for 3 seconds
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }


    @Test
    public void registrationNegativeWrongEmail(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "mb" + i + "gmail.com", password = "Mb12345$";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitRegistration();
    }
    @Test
    public void registrationNegativeWrongPassword(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "Mb" + i + "@gmail.com", password = "Mb123455";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitRegistration();
    }

    @AfterMethod
    public void tearDown(){

    }

}