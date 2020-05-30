package com.trello.mobile.manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    AppiumDriver driver;
    DesiredCapabilities capabilities;
    //BoardHelper board;
    //TeamHelper team;
    SessionHelper session;
    WelcomePage welcome;
    // ProfileHelper profile;
    String browser;
    Properties properties;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public void init() throws InterruptedException, IOException {
       capabilities = new DesiredCapabilities();
       capabilities.setCapability("platformName", "Android");
       capabilities.setCapability("deviceName", "192.168.232.102:5555");
       capabilities.setCapability("platformVersion", "8.0");
       capabilities.setCapability("automationName", "Appium");
       capabilities.setCapability("appPackage", "com.trello");
       capabilities.setCapability("appActivity", ".home.HomeActivity");

       capabilities.setCapability("app", "C:/Users/Elena/Documents/GitHub/mobileTrelloNew/apk/Trello_new(1).apk");

       driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logger.info("Ready!");
        //wd.manage().window().maximize();

        properties = new Properties();

        String target = System.getProperty("target", "local");
//    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        welcome = new WelcomePage(driver);
        session = new SessionHelper(driver);

//    session.loginAtlasiianAcc(
//            properties.getProperty("web.user"), properties.getProperty("web.pwd"));
        Thread.sleep(5000);

//    board= new BoardHelper(wd);
//    team = new TeamHelper(wd);
//    profile = new ProfileHelper(wd);
    }

    public void stop() {
        driver.quit();
        logger.info("Test finished");
    }

    public SessionHelper getSession() {
        return session;
    }

    public WelcomePage getWelcome() {
        return welcome;
    }

    //  public BoardHelper getBoard() {
//    return board;
//  }
//
//  public TeamHelper getTeam() {
//    return team;
//  }
//
//  public ProfileHelper getProfile() {
//    return profile;
//  }
}