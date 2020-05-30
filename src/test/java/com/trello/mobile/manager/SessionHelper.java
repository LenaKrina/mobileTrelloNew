package com.trello.mobile.manager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SessionHelper  extends  HelperBase{
    public SessionHelper(AppiumDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        initLogin();
        fillLoginForm(email, password);
        confirmLogin();
    }

    public void confirmLogin() {
        click(By.id("com.trello:id/authenticate"));
    }

    public void fillLoginForm(String userEmail, String password) {
        typeEmail(userEmail);
        type(By.id("com.trello:id/password']"), password);
    }

    private void typeEmail(String userEmail) {
        type(By.xpath("//*[@resource-id='com.trello:id/user']"), userEmail);

    }

    public void initLogin() {
       click(By.id("log_in_button"));

    }
}
