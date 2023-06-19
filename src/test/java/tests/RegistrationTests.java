package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

//    WebDriver wd;
//
//    @BeforeMethod
//    public void init(){
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    }

//    @Test
//    public void registrationPositive(){
//        // open login form
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//
//        // fill login form
//
//        int i = (int)(System.currentTimeMillis()/1000)%3600;
//
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("mb" + i + "@gmail.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Mb12345$");
//
//        // click on button Registration
//        wd.findElement(By.xpath("//button[2]")).click();
//
//        // Assert
//
////        Assert.assertTrue(wd.findElements(By.xpath("//*[.='Sign Out']")).size() > 0);
////        Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);
//        pause(5000);
//        Assert.assertTrue(isElementPresent(By.xpath("//button")));
//    }

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