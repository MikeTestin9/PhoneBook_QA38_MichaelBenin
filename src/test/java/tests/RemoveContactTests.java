package tests;

import models.Contact;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{

    Logger logger = LoggerFactory.getLogger(RemoveContactTests.class);

    @BeforeMethod
    public void precondition(){
        if(!app.getUser().isLogged()){ // ! значит обратное. если незалогинен, то ниже
            String email = "mb@gmail.com", password = "Mb12345$";
            app.getUser().openLoginForm();
            app.getUser().fillLoginForm(email, password);
            app.getUser().submitLogin();
        }
    }

    @Test
    public void removeContactPositive(){
        // создаем переменную темп - добавляем в неё метод подсчёта дивов.
        // надо кликнуть на контакт, если он существует. пока без заморочек - контакт существует.
        // нажимаем на кнопку ремув
        // проверяем, что контакт удалился, считаем ещё раз количество дивов и должно быть минус 1 от темпа


        int tmp = app.getContact().contactCount();

        logger.info("Amount of contacts before removing = " + tmp);

        app.getContact().clickOnTheFirstContactFromTheDiv();
        app.getContact().cklickOnRemoveButton();
        app.getContact().pause(3000);
        app.getContact().refreshPage();
        app.getContact().pause(3000);

        int count = app.getContact().contactCount();
        logger.info("Amount of contacts after removing = " + count);
        Assert.assertEquals(count, tmp-1);

    }
}

