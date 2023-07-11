package tests;

import models.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase{

    static Logger logger = LoggerFactory.getLogger(AddNewContactTests.class);

    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        if(!app.getUser().isLogged()){
            String email = "mb@gmail.com", password = "Mb12345$";
            app.getUser().openLoginForm();
            app.getUser().fillLoginForm(email, password);
            app.getUser().submitLogin();
        }
    }

    @Test(invocationCount = 2, groups = {"positive"})
    public static void addNewContactPositive(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;

        Contact contact = Contact.builder()      // так как создаём через ламбок
                .name("Mike_" + i)
                .lastName("Ben")
                .phone("012345678" + i)
                .email("MikeBen" + i + "@gmail.com")
                .address("Tel-Aviv")
                .description("Friend")
                .build();

        logger.info("Phone number is " + contact.getPhone());

        app.getContact().openContactForm();
        app.getContact().fillContactForm(contact);
        app.getContact().submitContactForm();
        app.getContact().pause(3000);

        Assert.assertTrue(app.getContact().isContactCreated(contact));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }
}
