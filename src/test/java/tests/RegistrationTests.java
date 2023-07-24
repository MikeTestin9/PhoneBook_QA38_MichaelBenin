package tests;

import manager.ProviderData;
import manager.TestNgListener;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNgListener.class)

public class RegistrationTests extends TestBase{

    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }
    @Test(groups = {"smoke", "positive", "regress"})
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
    @Test(dataProvider = "userDtoCSV", dataProviderClass = ProviderData.class)
    public void registrationPositiveDTO(User user){

        logger.info("Registration starts with email: " + user.getEmail() + " and password: " + user.getPassword());

        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitRegistration();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }


    @Test(groups = {"regress", "negative"})
    public void registrationNegativeWrongEmail(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "mb" + i + "gmail.com", password = "Mb12345$";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitRegistration();
        Assert.assertTrue(app.getUser().isWrongFormatMessage());
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
    @Test
    public void registrationNegativeWrongPassword(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "Mb" + i + "@gmail.com", password = "Mb123455";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitRegistration();
        Assert.assertTrue(app.getUser().isWrongFormatMessage());
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }

}