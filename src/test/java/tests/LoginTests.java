package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

//    WebDriver wd;
//
//    @BeforeMethod
//    public void init(){
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    }

    @BeforeMethod
    public void precondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }

//    @Test
//    public void loginPositiveTest(){
//        // open login form
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//
//        // fill login form
//
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("mb@gmail.com");mb" + i + "@gmail.com
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Mb12345$");
//
//        // click on button Login
//        wd.findElement(By.xpath("//button[1]")).click();
//
//        // Assert
//        pause(3000);
////        Assert.assertTrue(wd.findElements(By.xpath("//*[.='Sign Out']")).size() > 0);
//        Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);
//
//    }

    @Test
    public void loginPositiveTestBase(){
        String email = "mb@gmail.com", password = "Mb12345$";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitLogin();
        app.getUser().pause(3000);
//        Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }

//    @Test
//    public void loginNegativeTestWrongEmail(){
//
//        // open login form
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//
//        // fill login form
//
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("mbgmail.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Mb12345$");
//
//        // click on button Login
//        wd.findElement(By.xpath("//button[1]")).click();
//
//        // Assert
//    }

//    @Test
//    public void loginNegativeTestWrongPassword() {
//        String email = "mb@gmail.com", password = "Mb123455";
//        openLoginForm();
//        fillLoginForm(email, password);
//        submitLogin();
//    }
//    @AfterMethod
//    public void tearDown(){
//
//    }

}